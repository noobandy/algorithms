import edu.princeton.cs.algs4.Point2D;

public class KdTreeTest {
    // unit testing of the methods (optional)
    public static void main(String[] args) {
        KdTree kdTree = new KdTree();
        Point2D[] points = new Point2D[] {new Point2D(0.7, 0.2),
                    new Point2D(0.7, 0.2),
                    new Point2D(0.5, 0.4),
                    new Point2D(0.7, 0.2),
                    new Point2D(0.2, 0.3),
                    new Point2D(0.4, 0.7),
                    new Point2D(0.9, 0.6),
                    new Point2D(0.4, 0.8)
        };


        System.out.format("is %s empty%n", kdTree.isEmpty() ? "" : "not");
        System.out.format("size %d%n", kdTree.size());
        System.out.format("%s contains (%f, %f)%n", kdTree.contains(points[0]) ? "" : "not", points[0].x(), points[0].y());

        for (Point2D point : points) {
            kdTree.insert(point);
            System.out.format("is %s empty%n", kdTree.isEmpty() ? "" : "not");
            System.out.format("size %d%n", kdTree.size());
            System.out.format("%s contains (%f, %f)%n", kdTree.contains(point) ? "" : "not", point.x(), point.y());
        }

    }
}