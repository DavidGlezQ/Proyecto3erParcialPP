import javax.swing.*;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MiClienteRMI2 extends javax.swing.JFrame{

    static long seruResult = (long) (Math.random() * 1400) + 1600;
    private static Long arrayTotalSize = Long.valueOf(10000000);
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

    public MiClienteRMI2() {
        initComponents();
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        resTotalPara = new javax.swing.JLabel();
        resTotalConcu = new javax.swing.JLabel();
        resArray1 = new javax.swing.JLabel();
        resArray2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();

        jLabel2.setText("David Alejandro Gonzalez Quezada");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("David Alejandro Gonzalez Quezada");

        jLabel4.setText("Computacion Paralela");

        jLabel5.setText("20110407");

        jLabel6.setText("Resultado de la primera mitad del array: ");

        jLabel7.setText("Resultado de la segunda mitad del array: ");

        jLabel8.setText("Tiempo total, paralelismo:");

        jLabel9.setText("Tiempo total, concurrencia:");

        resTotalPara.setText("0");

        resTotalConcu.setText("0");

        resArray1.setText("0");

        resArray2.setText("0");

        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7))
                                                                .addGap(27, 27, 27)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(resArray2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGap(2, 2, 2)
                                                                                .addComponent(resArray1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(52, 52, 52)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(resTotalConcu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(resTotalPara, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(223, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(resArray1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(resArray2)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addGap(40, 40, 40))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(btnStart)
                                                                .addGap(22, 22, 22))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(resTotalPara)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(resTotalConcu)
                                                .addGap(40, 40, 40))))
        );

        pack();
    }// </editor-fold>

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        showResultUI();
    }

    private void tfSizeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void messageBox() {
        final JOptionPane optionPane = new JOptionPane("Espera un momento...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("Calculando");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        //mostrar pantalla para indicar que lo esta calculando
        Timer timer = new Timer(5000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }

    public static void messageBoxShowResult(StringBuilder stringBuilder) {
        final JOptionPane optionPane = new JOptionPane(stringBuilder, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("Resultados");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        long input = Long.parseLong(JOptionPane.showInputDialog("Enter Input:"));

        try{
            mir = (MiInterfazRemota) Naming.lookup("//" + args[0] + "/PruebaRMI");
        }catch (Exception e){
            System.out.println("MiInterfazRemota:" +e.getMessage());
        }

        //try {
            messageBox();
            //MiInterfazRemota mir = (MiInterfazRemota) Naming.lookup("//" + args[0] + "/PruebaRMI");
            // TODO aqui crear los arrays y pasarlos como parametros
            Long[] array = new Long[Math.toIntExact(input)];
            //Long[] arrayMergeSort = new Long[Math.toIntExact(input)];
            ArrayList<Integer> arrayList = new ArrayList<Integer>((int) input);
            Long[] arrayServ = new Long[Math.toIntExact(input / 2)];
            Long[] arrayLocal = new Long[Math.toIntExact(input / 2)];
            ArrayList arrayListLocal = new ArrayList<Integer>((int) input);
            ArrayList arrayListServ = new ArrayList<Integer>((int) input);


            for (int x = 0; x < array.length; x++) {
                arrayList.add((int)(Math.random() * 50000000) + 50000000);
                //array[x] = (long) (Math.random() * 500000000) - 500000000;
                //arrayMergeSort[x] = (long) (Math.random() * 500000000) - 500000000;
                //System.out.println(array[x]);
            }

            //System.out.println("MatrizA, primera mitad");
            for (int i = 0; i < array.length / 2; i++){
                arrayListServ.add(arrayList.get(i));
                //System.out.println(array[i]);
                //arrayServ[i] = array[i];
                //System.out.println(arrayServ[i]);
            }

            //System.out.println("MatrizA, segunda mitad");
            int x = 0;
            for (int i = (int) input / 2; i < input; i++){
                arrayListLocal.add(arrayList.get(i));
                //arrayLocal[x] = array[Math.toIntExact(i)];
                x++;
                //System.out.println(array[i]);
            }

            SecQuickSort secQuickSort = new SecQuickSort();

            long inicio = 0;
            long fin = 0;
            inicio = System.currentTimeMillis();
            //mergeSort.mergeSort(array, 0, array.length - 1);
            ArrayList resultado = new ArrayList(secQuickSort.sequentialSort(arrayList));
            System.out.println("res secQuick" +  resultado);
            fin = System.currentTimeMillis();
            mergeSortResult = fin - inicio;

            MergeSortForkJoin mergeSortForkJoin = new MergeSortForkJoin();
            ConQuickSort conQuickSort = new ConQuickSort();
            long servResult = 1;
            long localResult = 1;
            int localResult1 = 1;
            try {
                servResult = mir.miMetodo1(arrayListServ);
                //localResult = mergeSortForkJoin.sortLong(arrayLocal);
                localResult1 = conQuickSort.concurrentQuickSort(arrayListLocal);
            } catch (Exception e) {
                System.out.println("");
            }

            //MergeSortForkJoin mergeSortForkJoin = new MergeSortForkJoin();

            StringBuilder sb = new StringBuilder();

            //servResult = mir.miMetodo1(arrayServ);
            //localResult = mergeSortForkJoin.sortLong(arrayLocal);
            // resultado del array local
            System.out.println("Resultado primera mitad del array: " + localResult1);
            sb.append("Resultado primera mitad del array: " + localResult1 + "\n");
            // resultado del array enviado
            System.out.println("Resultado segunda mitad del array: " + servResult);
            sb.append("Resultado segunda mitad del array: " + servResult + "\n");
            totalResult = servResult + localResult1;
            System.out.println("Tiempo total, paralelo: " + totalResult);
            sb.append("Tiempo total, paralelo: " + totalResult + "\n");
            System.out.println("Tiempo total, secuencial: " + mergeSortResult);
            sb.append("Tiempo total, secuencial: " + mergeSortResult + "\n");

            messageBoxShowResult(sb);

            // mostrar resultados
            /*java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MiClienteRMI2().setVisible(true);
                }
            });
        } catch (Exception e){
            System.out.println("Error, no encuentro: " + e.getMessage());
        }*/
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
