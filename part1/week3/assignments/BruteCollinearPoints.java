public class BruteCollinearPoints {

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		if(points == null) {
			throw new NullPointerException();
		}

		for(int i = 0; i < points.length; i++) {
			if(points[i] == null) {
				throw new NullPointerException();
			}
		}
	}
	// the number of line segments
	public int numberOfSegments() {
		return 0;
	}
	// the line segments
	public LineSegment[] segments() {
		return null;
	}

}