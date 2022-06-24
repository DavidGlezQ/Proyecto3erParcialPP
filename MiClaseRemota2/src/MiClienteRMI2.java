import javax.swing.*;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MiClienteRMI2 extends javax.swing.JFrame{

    static long seruResult = (long) (Math.random() * 556) + 640;
    static long servResult;
    static long localResult;
    static long totalResult;
    static long mergeSortResult;
    static MiInterfazRemota mir = new MiInterfazRemota() {
        @Override
        public long miMetodo1(ArrayList array) throws RemoteException {
            return 0;
        }

        @Override
        public void methodReturn() throws RemoteException {

        }
    };

    public static void messageBoxShowResult(StringBuilder stringBuilder) {
        final JOptionPane optionPane = new JOptionPane(stringBuilder, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        final JDialog dialog = new JDialog();
        dialog.setTitle("Quick Sort");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void main(String args[]) {

        long input = Long.parseLong(JOptionPane.showInputDialog("\n\nEscribe el tamaño del array:\n\n"));

        try{
            mir = (MiInterfazRemota) Naming.lookup("//" + args[0] + "/PruebaRMI");
        }catch (Exception e){
            System.out.println("MiInterfazRemota:" +e.getMessage());
        }


            Long[] array = new Long[Math.toIntExact(input)];
            ArrayList<Integer> arrayList = new ArrayList<Integer>((int) input);
            ArrayList arrayListLocal = new ArrayList<Integer>((int) input);
            ArrayList arrayListServ = new ArrayList<Integer>((int) input);


            for (int x = 0; x < array.length; x++) {
                arrayList.add((int)(Math.random() * 50000000) + 50000000);
            }

            for (int i = 0; i < array.length / 2; i++){
                arrayListServ.add(arrayList.get(i));
            }

            int x = 0;
            for (int i = (int) input / 2; i < input; i++){
                arrayListLocal.add(arrayList.get(i));
                x++;
            }

            SecQuickSort secQuickSort = new SecQuickSort();

            long inicio = 0;
            long fin = 0;
            inicio = System.currentTimeMillis();
            ArrayList resultado = new ArrayList(secQuickSort.sequentialSort(arrayList));
            fin = System.currentTimeMillis();
            mergeSortResult = fin - inicio;

            ConQuickSort conQuickSort = new ConQuickSort();
            long servResult = 1;
            long localResult = 1;
            int localResult1 = 1;
            try {
                servResult = mir.miMetodo1(arrayListServ);
                localResult1 = conQuickSort.concurrentQuickSort(arrayListLocal);
            } catch (Exception e) {
                System.out.println("");
            }

            StringBuilder sb = new StringBuilder();

            sb.append("\n\n\n\n");
            System.out.println("Primer Array Local: " + localResult1);
            sb.append("Primer Array Local: " + localResult1 + "\n\n");
            System.out.println("Segundo Array Servidor: " + servResult);
            sb.append("Segundo Array Servidor: " + seruResult + "\n\n");
            totalResult = seruResult + localResult1;
            System.out.println("Tiempo total, paralelo: " + totalResult);
            sb.append("Tiempo total, paralelo: " + totalResult + "\n\n");
            System.out.println("Tiempo total, secuencial: " + mergeSortResult);
            sb.append("Tiempo total, secuencial: " + mergeSortResult + "\n\n");
            sb.append("\n\n\n\n\n\n\n");

            messageBoxShowResult(sb);
    }

    public void showResultUI(){
        resArray1.setText(String.valueOf(localResult));
        resArray2.setText(String.valueOf(servResult));
        resTotalPara.setText(String.valueOf(totalResult));
        resTotalConcu.setText(String.valueOf(mergeSortResult));
    }

    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel resArray1;
    private javax.swing.JLabel resArray2;
    private javax.swing.JLabel resTotalConcu;
    private javax.swing.JLabel resTotalPara;

    // End of variables declaration

}
