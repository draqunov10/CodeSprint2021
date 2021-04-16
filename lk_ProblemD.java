import java.util.*;

public class lk_ProblemD {
    static int moonCount = 0, lowX = 1001, highY = -1, highX = -1001;
    static int[] startingCoord = {0, 0};
    static int[] endingCoord = {0, 0};
    static int[][] coordinates;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input = new Scanner(System.in);

        //SET UP ALL COORDINATES
        String[][] toString = new String[N][2];
        coordinates = new int[N+1][2];
        for(int i = 0; i < N; i++){
            String s = input.nextLine();
            toString[i] = s.split(" ");
            coordinates[i][0] = Integer.parseInt(toString[i][0]);
            coordinates[i][1] = Integer.parseInt(toString[i][1]);
        }
        coordinates[N][0] = 0;
        coordinates[N][1] = 0;

        //SET UP ALL LOWEST AND HIGHEST
        for(int i = 0; i < N+1; i++){
            if(coordinates[i][0] < lowX) lowX = coordinates[i][0];
            if(coordinates[i][0] > highX) highX = coordinates[i][0];
            if(coordinates[i][1] > highY) highY = coordinates[i][1];
        }

        //CHECK IF THERE IS NEGATIVE Y
        for(int i = 0; i < N; i++) {
            if(coordinates[i][1] < 0){
                System.out.print("RADAR ERROR");
                System.exit(0);
            }
        }
        //From start to lower left
        for(int x = 1; x >= lowX; x--){
            endingCoord[0] = x;
            managePoints();
        }
        //From lower left to higher left
        for(int y = 1; y <= highY; y++){
            endingCoord[1] = y;
            managePoints();
        }
        //From higher left to higher right
        for(int x = lowX+1; x <= highX; x++){
            endingCoord[0] = x;
            managePoints();
        }
        //From higher right to lower right
        for (int y = highY-1; y >= 0; y--){
            endingCoord[1] = y;
            managePoints();
        }
        //From lower right to start
        for (int x = highX-1; x >= 1; x--){
            endingCoord[0] = x;
            managePoints();
        }
        System.out.println(moonCount);
    }

    public static void managePoints(){
        for (int[] coord: coordinates){
            if(!Arrays.equals(coord, startingCoord) && connected(startingCoord, endingCoord, coord) && withinRange(startingCoord, endingCoord, coord)){
                startingCoord = coord.clone();
                moonCount++;
            }
        }
    }

    public static boolean connected(int[] start, int[] end, int[] coord){
        float m = (float)(end[1] - start[1]) / (float)(end[0] - start[0]);
        float left = coord[1] - end[1];
        float right = m * (float)(coord[0] - end[0]);
        return left == right;
    }

    public static boolean withinRange(int[] start, int[] end, int[] coord){
        int lowestX = Math.min(start[0], end[0]);
        int highestX = Math.max(start[0], end[0]);
        boolean xPart = coord[0] >= lowestX && coord[0] <= highestX;
        int lowest = Math.min(start[1], end[1]);
        int highest = Math.max(start[1], end[1]);
        boolean yPart =  coord[1] >= lowest && coord[1] <= highest;
        return  yPart && xPart;
    }
}