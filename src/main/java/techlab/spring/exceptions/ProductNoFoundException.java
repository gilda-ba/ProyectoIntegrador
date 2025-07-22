package techlab.spring.exceptions;

public class ProductNoFoundException extends RuntimeException {
    public ProductNoFoundException(String searchTerm) {
        super(String.format("No se encontro ningun producto. Se busco usando el siguiente termino %s ", searchTerm));
    }
}
