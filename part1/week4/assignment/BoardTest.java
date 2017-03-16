import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class BoardTest {


    public static void main(String[] args) {
        Board board = new Board(new int[][] {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        Board goal = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});

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