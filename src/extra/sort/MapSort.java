package extra.sort;

import java.util.*;
public class MapSort {
    public static void sortByKey(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> listasc = new ArrayList<>(map.entrySet());
        listasc.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getKey));

        List<Map.Entry<Integer, Integer>> listdesc = new ArrayList<>(map.entrySet());
        listdesc.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getKey).reversed());

        for(Map.Entry<Integer, Integer> entry : listasc) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void sortByValue(Map<Integer, Integer> map) {

        List<Map.Entry<Integer, Integer>> listasc = new ArrayList<>(map.entrySet());
        listasc.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue));

        List<Map.Entry<Integer, Integer>> listdesc = new ArrayList<>(map.entrySet());
        listdesc.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed());

        for(Map.Entry<Integer, Integer> entry : listasc) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
