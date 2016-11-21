package uk.co.codeecho.gdx.forge.component.builder;

public class ComponentBuilderException extends RuntimeException{

    public ComponentBuilderException(String message) {
        super(message);
    }

    public ComponentBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentBuilderException(Throwable cause) {
        super(cause);
    }

}
