import java.util.Iterator;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Board {

    private int[][] blocks;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.blocks = blocks;
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
        int hd = 0;

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] != 0 && blocks[i][j] != ( (i * blocks.length) + j + 1)) {
                    hd += 1;
                }
            }
        }

        return hd;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int md = 0;

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {
                if (blocks[i][j] != 0 && blocks[i][j] != ( (i * blocks.length) + j + 1)) {
                    int destI = (blocks[i][j] - 1) / blocks.length;
                    int destJ = (blocks[i][j] - 1) % blocks.length;

                    md += (Math.abs(i - destI) + Math.abs(j - destJ));
                }
            }
        }

        return md;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if ((blocks[i][j] != ( (i * blocks.length) + j + 1)) && (i != blocks.length - 1) && (j != blocks.length - 1)) {
                    return false;
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
        if (this == y) {
            return true;
        }

        if (y instanceof Board) {
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

        class Neighbores implements Iterable<Board> {

            public Iterator<Board> iterator() {
                return new NeighboreIterator();
            }

            class NeighboreIterator implements Iterator<Board> {
                private boolean moveL;
                private boolean moveR;
                private boolean moveT;
                private boolean moveB;

                private int i0;
                private int j0;

                public NeighboreIterator() {
                    for (int i = 0; i < blocks.length; i++) {

                        for (int j = 0; j < blocks.length; j++) {

                            if (blocks[i][j] == 0) {
                                i0 = i;
                                j0 = j;

                                if (i - 1 >= 0) {
                                    moveB = true;
                                }

                                if (i + 1 < blocks.length) {
                                    moveT = true;
                                }

                                if (j - 1 >= 0) {
                                    moveR = true;
                                }

                                if (j + 1 < blocks.length) {
                                    moveL = true;
                                }
                            }
                        }
                    }
                }

                public boolean hasNext() {
                    return moveL || moveR || moveT || moveB;
                }

                public Board next() {

                    if (moveL) {
                        moveL = false;
                        int i = i0;
                        int j = j0 + 1;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i][j];
                        blocksCopy[i][j] = tmp;

                        return new Board(blocksCopy);
                    }

                    if (moveR) {
                        moveR = false;

                        int i = i0;
                        int j = j0 - 1;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i][j];
                        blocksCopy[i][j] = tmp;

                        return new Board(blocksCopy);
                    }

                    if (moveT) {
                        moveT = false;

                        int i = i0 + 1;
                        int j = j0;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i][j];
                        blocksCopy[i][j] = tmp;

                        return new Board(blocksCopy);
                    }

                    if (moveB) {
                        moveB = false;

                        int i = i0 - 1;
                        int j = j0;

                        int[][] blocksCopy = copyBlocks();
                        int tmp = blocksCopy[i0][j0];
                        blocksCopy[i0][j0] = blocksCopy[i][j];
                        blocksCopy[i][j] = tmp;

                        return new Board(blocksCopy);
                    }

                    return null;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
        }
        return new Neighbores();
    }


    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks.length; j++) {
                b.append(blocks[i][j]);
                if (j != blocks.length - 1) {
                    b.append(" ");
                }
            }

            if (i != blocks.length - 1) {
                b.append('\n');
            }
        }
        return b.toString();
    }

    public static void main(String[] args) {
        Board board = new Board(new int[][] {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        Board goal = new Board(new int[][] {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}});

        System.out.format("board : %n%s%n", board.toString());
        System.out.format("board's twin : %n%s%n", board.twin().toString());
        System.out.format("board dimension: %d%n", board.dimension());
        System.out.format("board hamming : %d%n", board.hamming());
        System.out.format("board manhattan : %d%n", board.manhattan());
        System.out.format("board is %s goal%n", board.isGoal() ? "" : "not");
        System.out.format("board is %s equals goal%n", board.equals(goal) ? "" : "not");

        System.out.println("neighbors of board");

        Iterator<Board> iterator = board.neighbors().iterator();
        while (iterator.hasNext()) {
            System.out.format("board : %n%s%n", iterator.next().toString());
        }
        System.out.format("goal : %n%s%n", goal.toString());
        System.out.format("goal's twin : %n%s%n", goal.twin().toString());
        System.out.format("goal dimension: %d%n", goal.dimension());
        System.out.format("goal hamming : %d%n", goal.hamming());
        System.out.format("goal manhattan : %d%n", goal.manhattan());
        System.out.format("goal is %s goal%n", goal.isGoal() ? "" : "not");
        System.out.format("goal is %s equals board%n", goal.equals(board) ? "" : "not");

        Board otherBoard = new Board(new int[][] {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}});
        /*
                System.out.format("otherBoard : %n%s%n", board.toString());

                System.out.println("neighbors of other board");

                Iterator<Board> otherIterator = otherBoard.neighbors().iterator();
                while (otherIterator.hasNext()) {
                    System.out.format("board : %n%s%n", otherIterator.next().toString());
                }
        */
        Queue<Board> queue = new LinkedList<Board>();
        Queue<Board> previous = new LinkedList<Board>();

        queue.add(otherBoard);

        while (!queue.isEmpty()) {
            Board nextBoard = queue.remove();
            previous.add(nextBoard);

            System.out.println(nextBoard);

            if (nextBoard.isGoal()) {
                break;
            }

            Iterator<Board> neighbors = nextBoard.neighbors().iterator();

            while (neighbors.hasNext()) {
                Board neighbor = neighbors.next();
                if (!previous.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

    }
}