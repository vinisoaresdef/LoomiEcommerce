package projetoLoomi.ecommerce.ecommerce.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoLoomi.ecommerce.ecommerce.api.config.TokenService;
import projetoLoomi.ecommerce.ecommerce.domain.entity.AuthenticationDTO;
import projetoLoomi.ecommerce.ecommerce.domain.entity.LoginResponseDTO;
import projetoLoomi.ecommerce.ecommerce.domain.entity.RegisterDTO;
import projetoLoomi.ecommerce.ecommerce.domain.entity.Usuario;
import projetoLoomi.ecommerce.ecommerce.domain.repository.UsuarioRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        //esse IF procura se já existe um nome registrado no banco de dados, se existir, ele lança um badRequest()
        if(this.repository.findByNome(data.nome()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario newUser = new Usuario(data.nome(), encryptedPassword, data.tipo());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}