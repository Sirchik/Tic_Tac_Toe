/**
 * Created with IntelliJ IDEA.
 * User: scorp
 * Date: 21.07.13
 * Time: 22:12
 * To change this template use File | Settings | File Templates.
 */
public class CellNotFreeException extends  Exception {
    public CellNotFreeException()
    {
        super();
    }
    public CellNotFreeException(String message)
    {
        super(message);
    }
}
