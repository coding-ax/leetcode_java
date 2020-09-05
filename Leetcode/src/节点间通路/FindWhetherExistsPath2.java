package 节点间通路;

import java.util.ArrayList;
import java.util.Stack;

class FindWhetherExistsPath2 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(start);
        for(int[] g:graph){
            if(set.contains(g[0])){
                set.add(g[1]);
            }
        }
        return set.contains(target);
    }
}