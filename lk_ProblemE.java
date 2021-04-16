import java.util.*;

public class lk_ProblemE {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input = new Scanner(System.in);
        String[][] inputs = new String[t][];
        for(int i = 0; i < t; i++){
            String s = input.nextLine();
            inputs[i] = s.split(" ");
        }
        for(String[] line: inputs){
            int x = toNum(line[0]);
            int y = toNum(line[1]);
            int mid = (x+y)/2;
            System.out.println(toStr(mid));
        }
    }

    public static int toNum(String s){
        int count = 0;
        for(int i = s.length()-1; i >= 0; --i){
            int current = s.length() - 1 - i;
            count += Math.pow(26, current) * ((int)s.charAt(i)-96);
        }
        return count;
    }

    public static String toStr(int n){
        String s = "";
        while(true){
            if(n < 26) {
                s = (char)((n%26)+96) + s;
                break;
            }
            s = (char)((n%26)+96) + s;
            n /= 26;

        }
        return s;
    }
}