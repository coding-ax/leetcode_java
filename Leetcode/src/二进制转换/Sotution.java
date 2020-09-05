package 二进制转换;

public class Sotution {
    public String printBin(double num) {
        StringBuilder s = new StringBuilder();
        s.append("0.");
        while(s.length()<=32){
            double count = num*2;
            if(count>=1.0){
                s.append("1");
                num -= 1.0;
            }
            else{
                s.append("0");
            }
            System.out.println(s);
            if(num==0) return s.toString();
        }
        return "ERROR";
    }
}
