package techlab.spring.exceptions;

public class ProductNoFoundException extends RuntimeException {
    public ProductNoFoundException(String message) {
        super(message);
    }
}
