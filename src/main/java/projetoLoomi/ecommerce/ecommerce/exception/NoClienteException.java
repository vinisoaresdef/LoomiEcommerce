package projetoLoomi.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class NoClienteException extends RuntimeException {
    public NoClienteException() {
        super("O pedido deve estar associado a um cliente.");
    }

    public NoClienteException(String message) {
        super(message);
    }

    public NoClienteException(String message, Throwable cause) {
        super(message, cause);
    }
}
