import java.rmi.Naming;

public class MiClienteRMI2 {
    public static void main(String[] args) {
        try {
            MiInterfazRemota mir = (MiInterfazRemota) Naming.lookup("//" + args[0] + "/PruebaRMI");
            // TODO aqui crear los arrays y pasarlos como parametros
            Integer[] array = new Integer[10];
            Integer[] arrayServ = new Integer[5];
            Integer[] arrayLocal = new Integer[5];

            for (int x = 0; x < array.length; x++) {
                array[x] = (int) (Math.random() * 5) - 5;
                System.out.println(array[x]);
            }

            System.out.println("MatrizA, primera mitad");
            for (int i = 0; i < array.length / 2; i++){
                //System.out.println(array[i]);
                arrayServ[i] = array[i];
                System.out.println(arrayServ[i]);
            }

            System.out.println("MatrizA, segunda mitad");
            int x = 0;
            for (int i = 5; i < 10; i++){
                arrayLocal[x] = array[i];
                x++;
                System.out.println(array[i]);
            }

            System.out.println("MatrizA");
            for (int i = 0; i < arrayLocal.length; i++){
                //array[i] = array[i];
                System.out.println(arrayLocal[i]);
            }


            StringBuilder i = mir.miMetodo1(arrayServ);
            System.out.println(mir.miMetodo1(arrayLocal));
            System.out.println(i);
        } catch (Exception e){
            System.out.println("Error, no encuentro: " + e.getMessage());
        }
    }
}
