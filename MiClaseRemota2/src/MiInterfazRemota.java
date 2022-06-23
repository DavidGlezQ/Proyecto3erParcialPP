import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MiInterfazRemota extends Remote {
    long miMetodo1(ArrayList array) throws RemoteException;
    void methodReturn() throws RemoteException;
}
