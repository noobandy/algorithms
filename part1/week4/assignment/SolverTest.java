import java.util.Iterator;

public class SolverTest {
	public static void main(String[] args) {
		Board initial = new Board(new int[][] {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}});

		Solver solver = new Solver(initial);

		System.out.println(solver.isSolvable());

		System.out.println(solver.moves());

		Iterator<Board> iterator = solver.solution().iterator();

		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		/*Board initial = new Board(new int[][] {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}});

		Solver solver = new Solver(initial);

		System.out.println(solver.isSolvable());

		System.out.println(solver.moves());

		Iterator<Board> iterator = solver.solution().iterator();

		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/



	}
}