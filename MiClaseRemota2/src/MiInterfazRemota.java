import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MiInterfazRemota extends Remote {
    long miMetodo1(Long[] array) throws RemoteException;
    void methodReturn() throws RemoteException;
}
