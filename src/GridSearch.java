public class GridSearch {
    static int R, C;

    // For searching in all 4 direction
    static int[] x = { -1, 0, 0, 1 };
    static int[] y = { 0, -1, 1, 0 };

    static boolean search2D(char[][] grid, int row,
                            int col, String word) {
        // If first character of word
        // doesn't match with
        // given starting point in grid.

        //If first leetr of the word does not match with the starting point.
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // Search word in all 8 directions
        // starting from (row, col)

        // Searching the word in all 4 directions.
        for (int dir = 0; dir < 4; dir++) {
            // Initialize starting point
            // for current direction
            int k, rd = row + x[dir], cd = col + y[dir];

            // First character is already checked,
            // match remaining characters
            for (k = 1; k < len; k++) {
                // If out of bound break
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;

                // If not matched, break
                if (grid[rd][cd] != word.charAt(k))
                    break;

                // Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }

            // If all character matched,
            // then value of must
            // be equal to length of word
            if (k == len)
                return true;
        }
        return false;
    }


    static void patternSearch(
            char[][] grid,
            String words)
    {
        // Consider every point as starting
        // point and search given word

        //Searching for the word by considering every point as a starting point.
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (search2D(grid, row, col, words))
                    System.out.println(
                            "pattern found at " + row + ", " + col);
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        R = 3;
        C = 13;
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };

        System.out.println();
        patternSearch(grid, "DEK");
    }
}
