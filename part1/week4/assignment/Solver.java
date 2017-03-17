import edu.princeton.cs.algs4.MinPQ;
import java.util.Iterator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Solver {

    private Node solution;

    private static class Node implements Comparable<Node> {
        private Board board;
        private int moves;
        private Node prev;

        public Node(Board board, Node prev, int moves) {
            this.board = board;
            this.prev = prev;
            this.moves = moves;
        }

        public int compareTo(Node other) {
            return board.manhattan() + moves - other.board.manhattan() - other.moves;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        if (initial == null) {
            throw new NullPointerException();
        }

        boolean turnOriginal = true;

        Node original = new Node(initial, null, 0);

        Node twin = new Node(initial.twin(), null, 0);

        List<Board> processedOriginal = new ArrayList<Board>();

        List<Board> processedTwin = new ArrayList<Board>();

        MinPQ<Node> queueOriginal = new MinPQ<Node>();

        MinPQ<Node> queueTwin = new MinPQ<Node>();

        queueOriginal.insert(original);

        queueTwin.insert(twin);

        while (!queueOriginal.isEmpty() && !queueTwin.isEmpty()) {

            if (turnOriginal) {
                turnOriginal = false;
                Node min = queueOriginal.delMin();

                processedOriginal.add(min.board);

                if (min.board.isGoal()) {
                    solution = min;
                    break;
                }

                Iterator<Board> neighbors = min.board.neighbors().iterator();

                while (neighbors.hasNext()) {
                    Board neighbor = neighbors.next();

                    if (!processedOriginal.contains(neighbor)) {
                        Node node = new Node(neighbor, min, min.moves + 1);

                        queueOriginal.insert(node);

                    }
                }
            } else {
                turnOriginal = true;
                Node min = queueTwin.delMin();

                processedTwin.add(min.board);

                if (min.board.isGoal()) {
                    break;
                }

                Iterator<Board> neighbors = min.board.neighbors().iterator();

                while (neighbors.hasNext()) {
                    Board neighbor = neighbors.next();

                    if (!processedTwin.contains(neighbor)) {
                        Node node = new Node(neighbor, null, min.moves + 1);

                        queueTwin.insert(node);

                    }
                }
            }

        }

    }
    // is the initial board solvable?
    public boolean isSolvable() {
        return solution != null;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        }

        return solution.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }

        Deque<Board> stack = new LinkedList<Board>();

        Node node = solution;

        while (node != null) {
            stack.push(node.board);
            node = node.prev;
        }

        return stack;
    }
}