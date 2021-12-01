public class NearestExit {
    public static void main(String []args){
        char[][] maze = {{'+','.','+','.','.','+','.','.','+','.','.','.','+','+','.','.','.','.','+','.'},
                {'.','+','+','.','+','.','.','.','+','+','+','.','+','.','.','+','.','+','+','.'},
                {'+','.','.','.','.','+','.','.','.','.','.','.','.','.','+','.','.','+','+','.'},
                {'.','.','.','+','+','.','.','.','+','.','+','.','.','+','.','.','+','.','.','.'},
                {'+','.','.','.','.','.','+','.','.','+','.','.','+','+','.','+','+','.','.','.'},
                {'.','+','.','.','.','.','+','.','+','.','.','.','.','.','.','+','.','+','+','+'},
                {'.','.','.','+','.','.','+','.','+','+','.','+','.','.','.','.','.','+','.','.'},
                {'.','.','.','.','.','+','+','+','.','.','.','+','.','+','+','+','+','.','.','.'},
                {'.','.','+','.','.','+','.','+','.','.','+','.','.','.','.','.','.','.','+','.'},
                {'.','.','.','.','.','.','+','.','+','.','.','.','+','.','+','.','.','.','+','.'},
                {'.','+','.','+','.','.','+','.','+','.','.','+','.','+','.','.','.','.','.','+'},
                {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'+','+','+','+','.','.','+','.','.','.','+','.','.','+','+','+','.','.','.','.'},
                {'.','.','+','+','.','+','.','.','.','.','.','+','+','.','.','+','.','.','.','.'},
                {'.','.','.','+','.','.','.','.','.','.','.','+','.','.','.','.','+','.','.','.'},
                {'.','+','+','.','.','+','.','.','.','.','+','+','.','+','+','.','.','.','+','.'},
                {'+','.','.','.','.','.','+','.','.','.','.','+','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','+','.','.','.','+','.','.','+','.','.','.','.','.','.','.','.'}};
        int[] entrance = {17, 15};
        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int[] minDis = new int[3];
        minDis[0] = Integer.MAX_VALUE;
        minDis[1]  = entrance[0];
        minDis[2]  = entrance[1];
        int[][] visited = new int[maze.length][maze[0].length];
        nearestExitHelper(maze, entrance[0], entrance[1] , minDis, 0, visited);
        return minDis[0] == Integer.MAX_VALUE ? -1:  minDis[0];
    }

    public static void nearestExitHelper(char[][] maze, int i, int j, int[] minDis, int steps, int[][] visited){
        if(i <= 0 || i >= maze.length - 1 || j <= 0 || j >= maze[0].length - 1) {
            if(i == minDis[1] && j == minDis[2] && visited[i][j] != -1) {
                minDis[0] = Integer.MAX_VALUE;
                visited[i][j] = -1;
                //return;
            } else {
                System.out.println("i value:" + i);
                System.out.println("j value:" + j);
                minDis[0] = Math.min(minDis[0], steps);
            }
        }
        visited[i][j-1] = -1;
        if((i-1) >=0 && maze[i-1][j] != '+' && visited[i-1][j] != -1) {
            visited[i-1][j] = -1;
            nearestExitHelper(maze,i-1, j, minDis, steps+1, visited);
            //visited[i-1][j] = 0;
           // steps--;
        }

        if((i+1) <= maze.length - 1 && maze[i+1][j] != '+' && visited[i+1][j] != -1) {
            visited[i+1][j] = -1;
            nearestExitHelper(maze,i+1, j, minDis, steps+1, visited);
          // visited[i+1][j] = 0;
            //steps--;
        }

        if((j+1) <= maze[0].length - 1 && maze[i][j+1] != '+' && visited[i][j+1] != -1) {
            visited[i][j+1] = -1;
            nearestExitHelper(maze,i, j+1, minDis, steps+1, visited);
           // visited[i][j+1] = 0;
            //steps--;
        }

        if((j-1) >=0 && maze[i][j-1] != '+' && visited[i][j-1] != -1) {
            visited[i][j-1] = -1;
            nearestExitHelper(maze,i, j-1, minDis, steps+1, visited);
           // visited[i][j-1] = 0;
            //steps--;
        }
        visited[i][j-1] = 0;
    }
}
