import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Board {

    private int[][] blocks;
    private int hamming;
    private int manhattan;
    private int i0;
    private int j0;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = Board.copyBlocks(blocks);

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {

                if (blocks[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                }

                if (blocks[i][j] != 0 && blocks[i][j] != ((i * blocks.length) + j + 1)) {
                    hamming += 1;
                    int destI = (blocks[i][j] - 1) / blocks.length;
                    int destJ = (blocks[i][j] - 1) % blocks.length;

                    manhattan += (Math.abs(i - destI) + Math.abs(j - destJ));
                }
            }
        }
    }

    // board dimension n
    public int dimension() {
        return blocks.length;
    }

    private static int[][] copyBlocks(int[][] blocks) {
        int[][] copyBlocks = new int[blocks.length][];

        for (int i = 0; i < blocks.length; i++) {
            copyBlocks[i] = Arrays.copyOf(blocks[i], blocks[i].length);
        }

        return copyBlocks;
    }

    private void swap(int[][] nums, int i, int j, int i1, int j1) {
        int tmp = nums[i][j];
        nums[i][j] = nums[i1][j1];
        nums[i1][j1] = tmp;
    }

    // number of blocks out of place
    public int hamming()  {
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming == 0;
    }
    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[][] blocksCopy = Board.copyBlocks(blocks);
        int x = (i0 + 1) % blocks.length;

        swap(blocksCopy, x, 0, x, 1);

        return new Board(blocksCopy);
    }
    // does this board equal y?
    public boolean equals(Object y)  {
        if (y == null) {
            return false;
        }

        if (this == y) {
            return true;
        }

        if (y.getClass().equals(this.getClass())) {
            Board o = (Board) y;
            if (this.dimension() == o.dimension()) {
                for (int i = 0; i < blocks.length; i++) {
                    for (int j = 0; j < blocks.length; j++) {
                        if (blocks[i][j] != o.blocks[i][j]) {
                            return false;
                        }
                    }
                }
                return true;
            }

        }
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Deque<Board> queue = new LinkedList<Board>();

        if (i0 - 1 >= 0) {
            int i1 = i0 - 1;
            int j1 = j0;

            int[][] blocksCopy = Board.copyBlocks(blocks);
            swap(blocksCopy, i0, j0, i1, j1);

            queue.add(new Board(blocksCopy));
        }

        if (i0 + 1 < blocks.length) {
            int i1 = i0 + 1;
            int j1 = j0;

            int[][] blocksCopy = Board.copyBlocks(blocks);
            swap(blocksCopy, i0, j0, i1, j1);

            queue.add(new Board(blocksCopy));
        }

        if (j0 - 1 >= 0) {
            int i1 = i0;
            int j1 = j0 - 1;

            int[][] blocksCopy = Board.copyBlocks(blocks);
            swap(blocksCopy, i0, j0, i1, j1);

            queue.add(new Board(blocksCopy));
        }

        if (j0 + 1 < blocks.length) {
            int i1 = i0;
            int j1 = j0 + 1;

            int[][] blocksCopy = Board.copyBlocks(blocks);
            swap(blocksCopy, i0, j0, i1, j1);

            queue.add(new Board(blocksCopy));
        }

        return queue;
    }

// string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(blocks.length + "\n");
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }


}