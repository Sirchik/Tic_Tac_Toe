package grid;

public class CellNotFreeException extends  Exception {
    public CellNotFreeException() {
        super();
    }
    public CellNotFreeException(String message) {
        super(message);
    }
}
