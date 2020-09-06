package 周赛;

public class disange {
    public int minCost(String s, int[] cost) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        // 定义sb
        StringBuilder sb = new StringBuilder(s);
        char prev = sb.charAt(0);
        int prevCost = cost[0];
        for (int i = 0; i < sb.length(); i++) {
            // 与前一个重合，对比修改前一个
            if(prev==sb.charAt(i)){
                System.out.println(prev);
                System.out.println(sb.charAt(i));
                if(prevCost<cost[i]){
                    sb.deleteCharAt(i-1);
                    count +=prevCost;
                }
                else{
                    sb.deleteCharAt(i);
                    count += cost[i];
                }
                i--;
                // 修改prev
                prev = sb.charAt(i);
                prevCost = cost[i];
            }

        }
        System.out.println(sb.toString());
        return count;
    }
}
