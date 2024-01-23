package es.com.inditex.ecommerce.comun.exception;

public class TechnicalException extends  RuntimeException{
    private static  final long serialVersionUID = 1L;

    public TechnicalException(String message){
        super(message);
    }

    public TechnicalException(String message,Exception e){
        super(message,e);
    }
}
