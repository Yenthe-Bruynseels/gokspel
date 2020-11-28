package model.database;

public class Dbexception extends RuntimeException {

    public Dbexception(){
        super();
    }
    public Dbexception(String message, Throwable exception) {
        super(message, exception);
    }

    public Dbexception(String message) {
        super(message);
    }

    public Dbexception(Throwable exception) {
        super(exception);
    }
}
