package 插入;

public class Sotution {
    public int reverseBits(int num) {
        String str = Integer.toBinaryString(num);
        System.out.println(str);
        // 标记最长
        int maxLength = 0;
        // 标记为添加后的启示长度
        int startLength = 0;
        int currentLength = 0;
        // 标记添加一次
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                // 为1
                currentLength++;
                // 添加过了flag
                if (!flag) {
                    startLength++;
                }
            } else {
                // 遇到0了 那么就得判断是否添加了
                // 没有改为0
                if (!flag) {
                    // 长度增加
                    currentLength++;
                    // start修改为0,开始进行循环
                    startLength = 0;
                    flag = true;
                }
                // 已经改过了
                else {
                    // 重置 并重新进行判断
                    currentLength = startLength + 1;
                    startLength = 0;
                }
            }
            // 更新长度
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        if(!flag){
            maxLength++;
        }
        return maxLength;
    }
}
