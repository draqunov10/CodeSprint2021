import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lk_ProblemF {
    static char[] tracks = {'-','+','|'};
    static List<ArrayList<String>> inputs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < testCase; i++){
            String temp = input.nextLine();
            String[] tempSplit = temp.split(" ");
            String[] grid = new String[Integer.parseInt(tempSplit[0])];
            for(int j = 0; j < grid.length; j++) grid[j] = input.nextLine();
            for(int j = 0; j < grid.length; j++){
                Column:
                for(int k = 0; k < grid.length; k++){
                    for(char track: tracks){
                        if(grid[j].charAt(k) == track) continue Column;
                    }
                    boolean flag = false;
                    if(k+1 != grid.length){
                        for(char track: tracks){
                            if (grid[j].charAt(k + 1) == track) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(flag){
                        for(int cH = k+1; cH < grid.length; cH++){
                            if(grid[j].charAt(cH) == tracks[2]) break;
                            if(grid[j].charAt(cH) != tracks[0] && grid[j].charAt(cH) != tracks[1]) {
//                                String toAdd = String.valueOf(grid[j].charAt(k));
//                                toAdd += grid[j].charAt(cH);
                                int x = grid[j].charAt(k);
                                int y = grid[j].charAt(cH);
                                String toAdd = (char)Math.min(x,y) + String.valueOf((char)Math.max(x,y));
                                list.add(toAdd);
                                break;
                            }
                        }
                        flag = false;
                    }
                    if(j+1 != grid.length){
                        for(char track: tracks){
                            if (grid[j + 1].charAt(k) == track) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(flag){
                        for(int cV = j+1; cV < grid.length; cV++){
                            if(grid[cV].charAt(k) == tracks[0]) break;
                            if(grid[cV].charAt(k) != tracks[1] && grid[cV].charAt(k) != tracks[2]) {
                                int x = grid[j].charAt(k);
                                int y = grid[cV].charAt(k);
                                String toAdd = (char)Math.min(x,y) + String.valueOf((char)Math.max(x,y));
                                list.add(toAdd);
                                break;
                            }
                        }
                    }
                }
            }
            ArrayList<String> tempp = (ArrayList<String>) list.clone();
            list.clear();
            inputs.add(tempp);
        }
        for(List<String> wan: inputs){
            if(wan.size() == 0) {
                System.out.println(0 + "\n" + "NO TRAINS FOR TODAY");
                break;
            }
            System.out.println(wan.size());
            for(String s: wan) System.out.print(s + " ");
            System.out.println();
        }
    }
}
