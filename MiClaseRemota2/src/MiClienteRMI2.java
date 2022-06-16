import java.rmi.Naming;

public class MiClienteRMI2 extends javax.swing.JFrame{

    private static Integer arrayTotalSize = 0;

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
        jLabel14 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        tfSize = new javax.swing.JTextField();

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

        jLabel14.setText("Tamaño del array:");

        btnStart.setText("Iniciar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        tfSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSizeActionPerformed(evt);
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
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel14)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(resTotalPara, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(2, 2, 2)
                                                                                .addComponent(resArray1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(resArray2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(resTotalConcu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
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
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(resTotalPara))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(resTotalConcu))
                                                .addGap(40, 40, 40))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnStart)
                                                .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String args[] = new String[0];
        arrayTotalSize = Integer.valueOf(tfSize.getText());
        runMain(args);
    }

    private void tfSizeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiClienteRMI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiClienteRMI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiClienteRMI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiClienteRMI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiClienteRMI2().setVisible(true);
            }
        });
    }

    public void runMain(String[] args){
        try {
            MiInterfazRemota mir = (MiInterfazRemota) Naming.lookup("//" + args[0] + "/PruebaRMI");
            // TODO aqui crear los arrays y pasarlos como parametros
            Integer[] array = new Integer[arrayTotalSize];
            Integer[] arrayMergeSort = new Integer[arrayTotalSize];
            Integer[] arrayServ = new Integer[arrayTotalSize / 2];
            Integer[] arrayLocal = new Integer[arrayTotalSize /2 ];

            for (int x = 0; x < array.length; x++) {
                array[x] = (int) (Math.random() * 50) - 50;
                arrayMergeSort[x] = (int) (Math.random() * 50) - 50;
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
            for (int i = arrayTotalSize / 2; i < arrayTotalSize; i++){
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
    private javax.swing.JTextField tfSize;
    // End of variables declaration

}
