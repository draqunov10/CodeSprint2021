import java.util.*;

public class lk_ProblemB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        input = new Scanner(System.in);

        String[] peeps = new String[p];
        for(int i = 0; i < p; i++){
            peeps[i] = input.nextLine();
        }

        int files = 0, count = 0;
        for(int i  = 0; i < p; i++){
            for(int j = 0; j < 9; j+=2){
                if(peeps[i].charAt(j) == '1') count++;
            }
            if(count >= 3) files++;
            count = 0;
        }
        System.out.println(files);
    }
}
