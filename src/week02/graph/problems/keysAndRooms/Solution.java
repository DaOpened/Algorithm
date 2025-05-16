package week02.graph.problems.keysAndRooms;

import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        final int N = rooms.size();
        boolean[] visited = new boolean[N];

        dfs(rooms, visited, 0);

        for(boolean room : visited) {
            if(!room)
                return false;
        }

        return true;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int curRoom) {
        visited[curRoom] = true;

        for(int nextRoom : rooms.get(curRoom)) {
            if(!visited[nextRoom]) {
                dfs(rooms, visited, nextRoom);
            }
        }
    }
}