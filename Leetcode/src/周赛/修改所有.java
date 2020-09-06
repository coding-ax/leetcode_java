package 周赛;

public class 修改所有 {
    public String modifyString(String s) {
        if (s.length() == 0) {
            return s;
        }

        // 定义sb
        StringBuilder sb = new StringBuilder(s);
        char prev = sb.charAt(0);
        char next = sb.charAt(0);
        for (int i = 0; i < sb.length(); i++) {
            // 边界处理 修改next
            if (i == sb.length() - 1) {
                next = ' ';
            } else {
                next = sb.charAt(i + 1);
            }
            if (s.charAt(i) == '?') {
                char config;
                for (char c = 'a'; c <= 'z'; c++) {
                    if(c!=prev&&c!=next){
                        config = c;
                        break;
                    }
                }
                sb.setCharAt(i,config);
            }
            // 修改prev
            prev = sb.charAt(i);
        }
        return sb.toString();
    }
}
