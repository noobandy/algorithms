import java.util.Deque;
import java.util.LinkedList;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {

    private static final class Node {
        private Point2D point;
        private Node left;
        private Node right;

        public Node(Point2D point) {
            this.point = point;
        }
    }

    private Node root;
    private int size;

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty()  {
        return size() == 0;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }

        if (!contains(p)) {
            root = insert(root, new Node(p), true);
            size++;
        }
    }


    private Node insert(Node parent, Node node, boolean x) {
        if (parent == null) {
            return node;
        }

        if (x) {
            int cmp = Double.compare(node.point.x(), parent.point.x());
            if (cmp <= 0) {
                parent.left = insert(parent.left, node, !x);
            } else {
                parent.right = insert(parent.right, node, !x);
            }
        } else {
            int cmp = Double.compare(node.point.y(), parent.point.y());

            if (cmp <= 0) {
                parent.left = insert(parent.left, node, !x);
            } else {
                parent.right = insert(parent.right, node, !x);
            }
        }

        return parent;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }

        return contains(root, p, true) != null;
    }

    private Node contains(Node node, Point2D point, boolean x) {
        if (node == null) {
            return node;
        }

        if (x) {
            int cmp = Double.compare(point.x(), node.point.x());
            if (cmp < 0) {
                return contains(node.left, point, !x);
            } else if (cmp > 0) {
                return contains(node.right, point, !x);
            } else {
                if (node.point.equals(point)) {
                    return node;
                } else {
                    return contains(node.left, point, !x);
                }
            }
        } else {
            int cmp = Double.compare(point.y(), node.point.y());

            if (cmp < 0) {
                return contains(node.left, point, !x);
            } else if (cmp > 0) {
                return contains(node.right, point, !x);
            } else {
                if (node.point.equals(point)) {
                    return node;
                } else {
                    return contains(node.left, point, !x);
                }
            }
        }
    }

    // draw all points to standard draw
    public void draw() {
        draw(root);
    }

    private void draw(Node node) {
        if (node != null) {
            draw(node.left);
            node.point.draw();
            draw(node.right);
        }
    }

    private void points(Node node, Deque<Point2D> points) {
        if (node != null) {
            points(node.left, points);
            points.addLast(node.point);
            points(node.right, points);
        }
    }


    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException();
        }
        Deque<Point2D> points = new LinkedList<Point2D>();

        points(root, points);

        Deque<Point2D> range = new LinkedList<Point2D>();

        for (Point2D point : points) {
            if (rect.contains(point)) {
                range.push(point);
            }
        }
        return range;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }

        Deque<Point2D> points = new LinkedList<Point2D>();

        points(root, points);

        double minDistance = 0;
        Point2D nearest = null;

        for (Point2D point : points) {

            double distance = p.distanceSquaredTo(point);

            if (nearest == null) {
                nearest = point;
                minDistance = distance;
            } else {
                int cmp = Double.compare(distance, minDistance);

                if (cmp < 0) {
                    minDistance = distance;
                    nearest = point;
                }
            }
        }

        return nearest;
    }
}