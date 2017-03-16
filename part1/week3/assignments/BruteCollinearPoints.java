import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class BruteCollinearPoints {
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }

        Point[] pointsCopy = new Point[points.length];
        
        System.arraycopy(points, 0, pointsCopy, 0, points.length);

        points = pointsCopy;

        Arrays.sort(points);

        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException();
            }
        }
        List<LineSegment> lines = new ArrayList<>();

        for (int i = 0; i < points.length - 3; i++) {
            Point p = points[i];
            Comparator<Point> slopeOrder = p.slopeOrder();

            for (int j = i + 1; j < points.length - 2; j++) {
                Point q = points[j];

                for (int m = j + 1; m < points.length - 1; m++) {
                    
                    
                    Point r = points[m];
                    
                    if (slopeOrder.compare(q, r) == 0) {
                        for (int n = m + 1; n < points.length; n++) {
                            Point s = points[n];
                            
                            if (slopeOrder.compare(q, s) == 0) {
                                LineSegment line = new LineSegment(p, s);
                                lines.add(line);
                            }
                        }
                    }
                }
            }
        }
        segments = lines.toArray(new LineSegment[lines.size()]);
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments.clone();
    }
}


