package projetoLoomi.ecommerce.ecommerce.domain.entity;

public enum Tipo {

    ADMIN("admin"),
    CLIENTE("cliente");

    private String tipo;

    Tipo (String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
