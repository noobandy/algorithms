import java.util.Iterator;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Board {

    private int[][] blocks;
    private int hamming;
    private int manhattan;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = blocks;

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] != 0 && blocks[i][j] != ( (i * blocks.length) + j + 1)) {
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

    private int[][] copyBlocks() {
        int[][] copyBlocks = new int[blocks.length][];

        for (int i = 0; i < blocks.length; i++) {
            copyBlocks[i] = Arrays.copyOf(blocks[i], blocks[i].length);
        }

        return copyBlocks;
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
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] != ( (i * blocks.length) + j + 1)) {
                    return (i == (blocks.length - 1)) && (j == (blocks.length - 1));
                }
            }
        }

        return true;
    }
    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {
                if (i != j && blocks[i][j] != 0 && blocks[j][i] != 0) {
                    int[][] blocksCopy = copyBlocks();
                    int tmp = blocksCopy[i][j];
                    blocksCopy[i][j] = blocksCopy[j][i];
                    blocksCopy[j][i] = tmp;

                    return new Board(blocksCopy);
                }
            }
        }

        return null;
    }
    // does this board equal y?
    public boolean equals(Object y)  {
        if (y == null) {
            return false;
        }

        if (this == y) {
            return true;
        }

        if (y.getClass().equals(Board.class)) {
            Board o = (Board) y;
            for (int i = 0; i < blocks.length; i++) {
                for (int j = 0; j < blocks.length; j++) {
                    if (blocks[i][j] != o.blocks[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Deque<Board> queue = new LinkedList<Board>();

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {

                if (blocks[i][j] == 0) {
                    int i0 = i;
                    int j0 = j;

                    if (i - 1 >= 0) {
                        int i1 = i0 - 1;
                        int j1 = j0;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i1][j1];
                        blocksCopy[i1][j1] = tmp;

                        queue.add(new Board(blocksCopy));
                    }

                    if (i + 1 < blocks.length) {
                        int i1 = i0 + 1;
                        int j1 = j0;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i1][j1];
                        blocksCopy[i1][j1] = tmp;

                        queue.add(new Board(blocksCopy));
                    }

                    if (j - 1 >= 0) {
                        int i1 = i0;
                        int j1 = j0 - 1;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i1][j1];
                        blocksCopy[i1][j1] = tmp;

                        queue.add(new Board(blocksCopy));
                    }

                    if (j + 1 < blocks.length) {
                        int i1 = i0;
                        int j1 = j0 + 1;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i1][j1];
                        blocksCopy[i1][j1] = tmp;

                        queue.add(new Board(blocksCopy));
                    }

                    return queue;
                }
            }
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