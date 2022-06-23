
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author giselcarpinteiro
 */
public class ConQuickSort {
    public int concurrentQuickSort(ArrayList lista){
        int inicio = 0;
        int fin = 0;
        int result = 0;
        inicio = (int) System.currentTimeMillis();
        ForkJoinPool fJP = new ForkJoinPool();
        fJP.invoke(new QuickSortTask(lista));
        fin = (int) System.currentTimeMillis();
        result = fin - inicio;
        return result;
    }
    
    private class QuickSortTask extends RecursiveAction{
        private final ArrayList list;
        private final int pivote;

        public QuickSortTask(ArrayList list) {
            this.list = list;
            this.pivote = 0;
        }
        
        @Override
        protected void compute(){
            if (list.size() > 1){
                int pivot = (int)list.get(0);
                list.remove(0);
                ArrayList minor = new ArrayList(quickSortMinor(list, pivot));
                ArrayList mayor = new ArrayList(quickSortMayor(list, pivot));
                list.clear();
                QuickSortTask minorList = new QuickSortTask(minor);
                QuickSortTask mayorList = new QuickSortTask(mayor);
                invokeAll(minorList,mayorList);              
                list.addAll(minor);
                list.add(pivot);
                list.addAll(mayor);
                return;
            }
        return;
        }
        
        public ArrayList quickSortMinor (ArrayList list, int pivot){
            ArrayList minorList = new ArrayList();
            int contador = 0;
                for (int i = 0; i < list.size(); i++){
                    if ((int)list.get(i)<pivot){
                        minorList.add(list.get(i));
                    }
                }
            return minorList;
        }

        public ArrayList quickSortMayor(ArrayList list, int pivot){
            ArrayList mayorList = new ArrayList();
            int contador = 0;
                for (int i = 0; i < list.size(); i++){
                    if ((int)list.get(i)>=pivot){
                        mayorList.add(list.get(i));
                    }
                }
            return mayorList;
        }
        
    }
}
