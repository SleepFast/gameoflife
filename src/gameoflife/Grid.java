package gameoflife;

public class Grid {
    int width, height;
    public boolean[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = Math.random() <= .1;
            }
        }
    }

    public int getNeighborCount(final int x, final int y) {
        int i = x - 1;
        int j = y - 1;
        int maxi = x + 1;
        int maxj = y + 1;

        int neighbor = 0;

        if (x == 0) {
            i = 0;
        }

        if (y == 0) {
            j = 0;
        }

        if (maxi > (width - 1)) {
            maxi = x;
        }

        if (maxj > (height - 1)) {
            maxj = y;
        }

        for (; i <= maxi; i++) {
            for (int k = j; k <= maxj; k++) {
                if (x == i && y == k) {
                    continue;
                }

                if (grid[i][k]) {
                    neighbor++;
                }
            } 
        }

        return neighbor;
    }

    public boolean liveOrDie(int pouet, boolean cell) {
        if (cell) {
            if (pouet < 2 || pouet >= 4) {
                return false;
            } 
            
            return true;
        } else {
            if (pouet == 3) {
                return true;
            }
            
            return false;
        }
    }
}
