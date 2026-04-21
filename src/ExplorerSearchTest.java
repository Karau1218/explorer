import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
     @Test
    public void testReachableArea_simpleGrid() {
        int[][] island = {
            {0, 1},
            {1, 1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(4, actual);
    }

    @Test
    public void testReachableArea_blockedTerrain() {
        int[][] island = {
            {0, 2, 1},
            {1, 3, 1},
            {1, 1, 1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(7, actual);
    }

    @Test
    public void testReachableArea_surroundedStart() {
        int[][] island = {
            {2, 2, 2},
            {2, 0, 2},
            {2, 2, 2}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_singleCell() {
        int[][] island = {
            {0}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_fullOpenGrid() {
        int[][] island = {
            {0, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(9, actual);
    }
    
}
