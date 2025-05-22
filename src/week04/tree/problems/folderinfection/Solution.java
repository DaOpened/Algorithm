// 트리 - 감염된 폴더1
package week04.tree.problems.folderinfection;
import java.util.*;

public class Solution {

    Map<String, List<String>> tree = new HashMap<>();

    public String solution(String[][] folders, String p, String q) {
        String answer = "root";
        List<String> parentp = new ArrayList<>();
        List<String> parentq = new ArrayList<>();

        // tree 생성
        for(String[] folder : folders) {
            String parent = folder[0];
            String child = folder[1];

            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }

        // DFS 이용하여 조상을 리스트에 저장
        dfs(parentp, "root", p);
        dfs(parentq, "root", q);

        // 공통 조상 찾기
        int len = Math.min(parentq.size(), parentp.size());
        for(int i = 0; i < len; i++) {
            if(parentq.contains(parentp.get(i))) {
                answer = parentp.get(i);
                break;
            }
        }
        return answer;
    }

    // 각 폴더의 조상 저장
    public boolean dfs(List<String> parentList, String node, String p ) {
       if(node.equals(p)) {
           parentList.add(node);
           return true;
       }

       for(String child : tree.getOrDefault(node, new ArrayList<>())) {
           if(dfs(parentList, child, p)){
               parentList.add(node);
               return true;
           }
       }
       return false;
    }
}
