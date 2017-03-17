import edu.princeton.cs.algs4.MinPQ;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Solver {

    private Deque<Board> steps;

    private static class Node implements Comparable<Node> {
        private Board board;
        private int moves;
        private Node prev;

        public Node(Board board, Node prev) {
            this.board = board;
            this.prev = prev;
            if (prev != null) {
                moves = prev.moves + 1;
            }
        }

        public int compareTo(Node other) {
            return (board.manhattan() + moves) - (other.board.manhattan() + other.moves);
        }

    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {

        if (initial == null) {
            throw new NullPointerException();
        }

        Set<String> closed = new HashSet<String>();

        MinPQ<Node> fringe = new MinPQ<Node>();

        fringe.insert(new Node(initial, null));
        fringe.insert(new Node(initial.twin(), null));


        while (!fringe.isEmpty()) {

            Node min = fringe.delMin();

            closed.add(min.board.toString());

            if (min.board.isGoal()) {
                Deque<Board> result = new LinkedList<Board>();
                while (min != null) {
                    result.push(min.board);
                    min = min.prev;
                }

                if (result.peek().equals(initial)) {
                    steps = result;
                }

                break;
            }

            for (Board board : min.board.neighbors()) {
                if (!closed.contains(board.toString())) {
                    fringe.insert(new Node(board, min));
                }
            }

        }

    }
// is the initial board solvable?
    public boolean isSolvable() {
        return steps != null;
    }

// min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        }

        return steps.size() - 1;
    }

// sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }

        return steps;
    }
}