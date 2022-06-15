import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiInterfazRemota extends Remote {
    StringBuilder miMetodo1(Integer[] array) throws RemoteException;
}
