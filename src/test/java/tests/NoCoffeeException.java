package tests;

public class NoCoffeeException extends Exception{

    public NoCoffeeException(String message){
        super(message);
    }

    public NoCoffeeException(){
        super();
    }


}
