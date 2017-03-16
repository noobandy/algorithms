import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPointsTest {
	/**
	 * Unit tests the Point data type.
	 */
	public static void main(String[] args) {


		// read the N points from a file
		In in = new In(args[0]);
		int N = in.readInt();
		Point[] points = new Point[N];

		for (int i = 0; i < N; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}


		// draw the points
		StdDraw.show(0);
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);

		BruteCollinearPoints bfs = new BruteCollinearPoints(points);
		LineSegment[] test = bfs.segments();
		for (int i = 0; i < test.length; i++) {
			test[i].draw();
			StdDraw.show();
			StdOut.println(test[i].toString());
		}
		StdDraw.show();
	}
}