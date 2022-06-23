import java.util.ArrayList;
import java.util.ArrayList;

public class SecQuickSort {
    
    public static ArrayList sequentialSort(ArrayList tempList){
        if (tempList.size() > 1){
            int pivot = (int)tempList.get(0);
            tempList.remove(0);
            ArrayList minor = new ArrayList(quickSortMinor(tempList, pivot));
            ArrayList mayor = new ArrayList(quickSortMayor(tempList, pivot));
            tempList.clear();
            sequentialSort(minor);
            sequentialSort(mayor);
            tempList.addAll(minor);
            tempList.add(pivot);
            tempList.addAll(mayor);
            return tempList;
        }
        return tempList;
    }
    
    public static ArrayList quickSortMinor (ArrayList list, int pivot){
        ArrayList minorList = new ArrayList();
        int contador = 0;
            for (int i = 0; i < list.size(); i++){
                if ((int)list.get(i)<pivot){
                    minorList.add(list.get(i));
                }
            }
        return minorList;
    }
    
    public static ArrayList quickSortMayor (ArrayList list, int pivot){
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
