import edu.princeton.cs.algs4.MinPQ;
import java.util.Iterator;
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
			return board.hamming() + moves - other.board.hamming() - other.moves;
		}
	}

	// find a solution to the initial board (using the A* algorithm)
	public Solver(Board initial) {

		if (initial == null) {
			throw new NullPointerException();
		}

		Node start = new Node(initial, null, 0);

		MinPQ<Node> queue = new MinPQ<Node>();

		List<Board> previous = new ArrayList<Board>();


		queue.insert(start);

		while (!queue.isEmpty()) {

			Node min = queue.delMin();

			if (min.board.isGoal()) {
				solution = min;
				break;
			}

			Iterator<Board> neighbors = min.board.neighbors().iterator();

			while (neighbors.hasNext()) {
				Board neighbor = neighbors.next();
				if (!previous.contains(neighbor)) {
					Node node = new Node(neighbor, min, min.moves + 1);

					queue.insert(node);
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

		class SolutionIterable implements Iterable<Board> {

			public Iterator iterator() {
				return new SolutionIterator();
			}

			class SolutionIterator implements Iterator<Board> {
				private Board[] boards;
				private int position;

				public SolutionIterator() {
					boards = new Board[moves() + 1];
					position = 0;
					Node node = solution;
					int i = boards.length - 1;

					while (node != null) {
						boards[i--] = node.board;
						node = node.prev;
					}
				}

				public boolean hasNext() {
					return position < boards.length;
				}

				public Board next() {
					Board board = boards[position];
					boards[position] = null;
					position++;
					return board;
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			}
		}

		return new SolutionIterable();
	}
}