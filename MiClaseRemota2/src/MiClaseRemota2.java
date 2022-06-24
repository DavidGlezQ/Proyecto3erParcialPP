import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.activation.*;
import java.util.ArrayList;
import java.util.Properties;

public class MiClaseRemota2 extends Activatable implements MiInterfazRemota{

    private long result = 0;

    public MiClaseRemota2(ActivationID a, MarshalledObject m) throws RemoteException{
        super(a, 0);
    }

    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            Properties p = new Properties();
            p.put("java.security.policy", "policy.txt");
            ActivationGroupDesc.CommandEnvironment ace = null;
            ActivationGroupDesc ejemplo = new ActivationGroupDesc(p, ace);
            ActivationGroupID agi = ActivationGroup.getSystem().registerGroup(ejemplo);

            MarshalledObject m = null;

            ActivationDesc desc = new ActivationDesc(agi, "MiClaseRemota2", "", m);
            MiInterfazRemota mir = (MiInterfazRemota) Activatable.register(desc);

            Naming.rebind("//" + InetAddress.getLocalHost().getHostAddress() + ":" + args[0] + "/PruebaRMI", mir);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (UnknownGroupException e) {
            throw new RuntimeException(e);
        } catch (ActivationException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public long miMetodo1(ArrayList array) throws RemoteException {
        ConQuickSort conQuickSort = new ConQuickSort();
        long inicio = 0;
        long fin = 0;

        inicio = System.currentTimeMillis();
        conQuickSort.concurrentQuickSort(array);
        fin = System.currentTimeMillis();
        result = fin - inicio;
        System.out.println("Ordenamiento de manera paralela:"+(fin-inicio) + " ms");

        //stringBuilder.append("Ordenamiento de manera paralela:"+(fin-inicio) + " ms");

        return result;
    }

    @Override
    public void methodReturn() throws RemoteException {
        System.out.println("Texto de retorno");
    }
}
