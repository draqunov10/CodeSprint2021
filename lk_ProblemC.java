import java.util.*;

public class lk_ProblemC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int S = input.nextInt();
        int N = input.nextInt();
        String[] G = new String[N];

        for (int i = 0; i < N; i++) {
            G[i] = input.next();
        }

        int rest = 0, stamina = S, voidBlock = 0;
        Outer:
        for(int i = 0; i < G.length; i++){
            if(G[i].charAt(G[i].length()-1) == '0') {
                System.out.println("IMPOSSIBLE JUMP"+"\n"+(i+1));
                break;
            }
            for(int j = 0; j < G[i].length(); j++){
                if(j != G[i].length()-1 && G[i].charAt(j+1) == '0'){
                    j = j+1;
                    while(G[i].charAt(j) == '0'){
                        voidBlock++;
                        if(G[i].charAt(j+1) == '1') break;
                        j++;
                    }

                    if(stamina - voidBlock > 0) stamina -= voidBlock;
                    else if(stamina - voidBlock == 0){
                        rest++;
                        stamina = S;
                    }
                    else{
                        if(S < voidBlock){
                            System.out.println("IMPOSSIBLE JUMP"+"\n"+(i+1));
                            break Outer;
                        }
                        rest++;
                        stamina = S;
                        stamina -= voidBlock;
                    }
                    voidBlock = 0;
                }
            }
            if (i == G.length-1) System.out.println(rest);
        }
    }
}