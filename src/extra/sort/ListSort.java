package extra.sort;

import java.util.*;

public class ListSort {
    public static void order (List<Integer> list) {
        // 1.
        list.sort(Comparator.naturalOrder()); // 오름차순
        list.sort(Comparator.reverseOrder()); // 내림차순

        // 2.
        Collections.sort(list); // 오름차순
        Collections.sort(list, Collections.reverseOrder()); // 내림차순
    }

}
