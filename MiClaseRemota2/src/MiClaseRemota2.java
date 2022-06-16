import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.activation.*;
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
    public long miMetodo1(Integer[] array) throws RemoteException { // Aqui resolver la matriz
        MergeSortForkJoin mergeSortForkJoin = new MergeSortForkJoin();
        //MergeSort mergeSort = new MergeSort();

        /*inicio = System.currentTimeMillis();
        mergeSort.mergeSort(array, 0, array.length - 1);
        fin = System.currentTimeMillis();
        System.out.println("Ordenamiento de manera secuencial:"+(fin-inicio) + " ms");
        //stringBuilder.append("Ordenamiento de manera secuencial:"+(fin-inicio) + " ms" + "\n");*/

        long inicio = 0;
        long fin = 0;

        inicio = System.currentTimeMillis();
        mergeSortForkJoin.sort(array);
        fin = System.currentTimeMillis();
        result = fin - inicio;
        System.out.println("Ordenamiento de manera paralela:"+(fin-inicio) + " ms");

        //stringBuilder.append("Ordenamiento de manera paralela:"+(fin-inicio) + " ms");

        return result;

        /*MergeSortForkJoin mergeSortForkJoin = new MergeSortForkJoin();
        MergeSort mergeSort = new MergeSort();

        Integer[] matrizA = new Integer[10];
        Integer[] matrizB = new Integer[10];

        Integer[] a2 = new Integer[10];

        System.out.println("Array orignal");
        for (int x = 0; x < matrizA.length; x++) {
            matrizA[x] = (int) (Math.random() * 10);
            matrizB[x] = (int) (Math.random() * 10);
            System.out.println(matrizA[x]);
            System.out.println(matrizB[x]);
        }

        System.out.println("MatrizA, primera mitad");
        for (int i = 0; i < matrizA.length / 2; i++){
            System.out.println(matrizA[i]);
        }

        System.out.println("MatrizA, segunda mitad");
        for (int i = 5; i < 10; i++){
            System.out.println(matrizA[i]);
        }

        System.out.println("MatrizB, primera mitad");
        for (int i = 0; i < matrizB.length / 2; i++){
            System.out.println(matrizB[i]);
        }

        System.out.println("MatrizB, segunda mitad");
        for (int i = 5; i < 10; i++){
            System.out.println(matrizB[i]);
        }

        long inicio = 0;
        long fin = 0;
        inicio = System.currentTimeMillis();
        mergeSort.mergeSort(matrizA, 0, matrizA.length - 1);
        fin = System.currentTimeMillis();
        //System.out.println("Ordenamiento de manera secuencial:"+(fin-inicio) + " ms");

        stringBuilder.append("Ordenamiento de manera secuencial:"+(fin-inicio) + " ms" + "\n");

        inicio = 0;
        fin = 0;
        inicio = System.currentTimeMillis();
        mergeSortForkJoin.sort(a2);
        fin = System.currentTimeMillis();
        //System.out.println("Ordenamiento de manera paralela:"+(fin-inicio) + " ms");*/
        //System.out.println("Estoy en mi metodo 1");
    }

    @Override
    public void methodReturn() throws RemoteException {
        System.out.println("Texto de retorno");
    }
}
