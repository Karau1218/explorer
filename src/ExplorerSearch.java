import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        // return -1; 

        // find the starting point, then track the visited cells to avoid looping
        int[] start = startLocation(island); 
        boolean[][] visited = new boolean[island.length][island[0].length];
        return explore(start, island, visited);
    }

    /**
     * Recursively explores all reachable cells using DFS.
     * Returns the total number of reachable cells from this position.
     */
    private static int explore(int[] loc, int[][] island, boolean[][] visited) {
        int r = loc[0];
        int c = loc[1];

        // Stop exploring this path if invalid grid position, already visitied or 
        // - Cell is water (2) or mountain (3), which are not walkable
      
        if (r < 0 || c < 0 || r >= island.length || c >= island[0].length ||
            visited[r][c] || island[r][c] == 2 || island[r][c] == 3) {
            return 0;
        }

        visited[r][c] = true;

        int count = 1;

        // Explore valid neighboring cells
        for (int[] move : possibleMoves(island, loc)) {
            count += explore(move, island, visited);
        }
        return count;
    }

    
    //  Returns all possible moves (up, down, left, right)
    
    public static List<int[]> possibleMoves(int[][] island, int[] loc) {
        int r = loc[0];
        int c = loc[1];

        List<int[]> moves = new ArrayList<>();

        // UP
        if (r - 1 >= 0) {
            moves.add(new int[]{r - 1, c});
        }

        // DOWN
        if (r + 1 < island.length) {
            moves.add(new int[]{r + 1, c});
        }

        // LEFT
        if (c - 1 >= 0) {
            moves.add(new int[]{r, c - 1});
        }

        // RIGHT
        if (c + 1 < island[0].length) {
            moves.add(new int[]{r, c + 1});
        }

        return moves;
    }

 
    //   Finds the starting location (cell with value 0)
    //  and retuns the location in row and column
    //   if not, throws an exception when not found
     
    public static int[] startLocation(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[0].length; c++) {
                if (island[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }

        throw new IllegalArgumentException("Start not found");
    }
}

