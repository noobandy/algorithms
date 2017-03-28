import java.util.Set;
import java.util.TreeSet;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
    private Set<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        points = new TreeSet<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty()  {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }

        points.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }

        return points.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D p : points) {
            p.draw();
        }
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException();
        }

        Set<Point2D> range = new TreeSet<Point2D>();

        for (Point2D p : points) {
            if (rect.contains(p)) {
                range.add(p);
            }
        }

        return range;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }


        double minDistance = 0;
        Point2D nearest = null;

        for (Point2D ps : points) {

            double distanceToPS = p.distanceSquaredTo(ps);

            if (nearest == null) {
                nearest = ps;
                minDistance = distanceToPS;
            } else {
                int cmp = Double.compare(distanceToPS, minDistance);

                if (cmp < 0) {
                    minDistance = distanceToPS;
                    nearest = ps;
                }
            }
        }

        return nearest;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {

    }
}