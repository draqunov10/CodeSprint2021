import java.util.*;

public class lk_ProblemA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char c = input.next().charAt(0);

        for(int i = 0; i < (n*2)-1; i++){
            for(int j = 0; j < (n*2)-1; j++){
                if(Math.abs(i-j) == n-1 || Math.abs(i+j) == n-1 || i+j == 3*(n-1)) System.out.print(c);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }
}
