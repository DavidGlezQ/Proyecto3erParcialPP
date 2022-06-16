import java.rmi.Naming;

public class MiClienteRMI2 {

    private static final Integer arrayTotalSize = 10000000;
    private static final Integer arrayServLocalTotalSize = 5000000;

    public static void main(String[] args) {
        try {
            MiInterfazRemota mir = (MiInterfazRemota) Naming.lookup("//" + args[0] + "/PruebaRMI");
            // TODO aqui crear los arrays y pasarlos como parametros
            Integer[] array = new Integer[arrayTotalSize];
            Integer[] arrayMergeSort = new Integer[arrayTotalSize];
            Integer[] arrayServ = new Integer[arrayServLocalTotalSize];
            Integer[] arrayLocal = new Integer[arrayServLocalTotalSize];

            for (int x = 0; x < array.length; x++) {
                array[x] = (int) (Math.random() * 50000000) - 50000000;
                arrayMergeSort[x] = (int) (Math.random() * 50000000) - 50000000;
                //System.out.println(array[x]);
            }

            //System.out.println("MatrizA, primera mitad");
            for (int i = 0; i < array.length / 2; i++){
                //System.out.println(array[i]);
                arrayServ[i] = array[i];
                //System.out.println(arrayServ[i]);
            }

            //System.out.println("MatrizA, segunda mitad");
            int x = 0;
            for (int i = arrayServLocalTotalSize; i < arrayTotalSize; i++){
                arrayLocal[x] = array[i];
                x++;
                //System.out.println(array[i]);
            }

            //System.out.println("MatrizA");
            for (int i = 0; i < arrayLocal.length; i++){
                //array[i] = array[i];
                //System.out.println(arrayLocal[i]);
            }

            MergeSort mergeSort = new MergeSort();

            long inicio = 0;
            long fin = 0;
            inicio = System.currentTimeMillis();
            mergeSort.mergeSort(array, 0, array.length - 1);
            fin = System.currentTimeMillis();
            long mergeSortResult = fin - inicio;
            //System.out.println("Ordenamiento de manera secuencial:"+(fin-inicio) + " ms");
            //stringBuilder.append("Ordenamiento de manera secuencial:"+(fin-inicio) + " ms" + "\n");

            MergeSortForkJoin mergeSortForkJoin = new MergeSortForkJoin();

            long servResult = mir.miMetodo1(arrayServ);
            long localResult = mergeSortForkJoin.sortLong(arrayLocal);
            // resultado del array local
            System.out.println("Resultado primera mitad del array: " + localResult);
            // resultado del array enviado
            System.out.println("Resultado segunda mitad del array: " + servResult);
            long totalResult = servResult + localResult;
            System.out.println("Tiempo total, paralelo: " + totalResult);
            System.out.println("Tiempo total, secuencial: " + mergeSortResult);
        } catch (Exception e){
            System.out.println("Error, no encuentro: " + e.getMessage());
        }
    }
}
