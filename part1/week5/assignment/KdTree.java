import java.util.Deque;
import java.util.LinkedList;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {

    private static final class Node {
        private Point2D p;
        private Node l;
        private Node r;

        public Node(Point2D p) {
            this.p = p;
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
            size++;
            if (root == null) {
                root = new Node(p);
            }

            Node cur = root;
            Node prev = null;
            boolean x = true;

            while (cur != null) {
                if (x) {
                    x = false;
                    prev = cur;

                    int cmp = Double.compare(p.x(), cur.p.x());

                    if (cmp <= 0) {
                        cur = cur.l;
                    } else {
                        cur = cur.r;
                    }
                } else {
                    x = true;
                    prev = cur;
                    int cmp = Double.compare(p.y(), cur.p.y());

                    if (cmp <= 0) {
                        cur = cur.l;
                    } else {
                        cur = cur.r;
                    }
                }
            }

            Node node = new Node(p);

            if (!x) {
                int cmp = Double.compare(p.x(), prev.p.x());

                if (cmp <= 0) {
                    prev.l = node;
                } else {
                    prev.r = node;
                }
            } else {

                int cmp = Double.compare(p.y(), prev.p.y());

                if (cmp <= 0) {
                    prev.l = node;
                } else {
                    prev.r = node;
                }
            }
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }

        Node cur = root;
        boolean x = true;

        while (cur != null) {
            if (cur.p.equals(p)) {
                return true;
            }

            if (x) {
                x = false;
                int cmp = Double.compare(p.x(), cur.p.x());

                if (cmp <= 0) {
                    cur = cur.l;
                } else {
                    cur = cur.r;
                }
            } else {
                x = true;
                int cmp = Double.compare(p.y(), cur.p.y());

                if (cmp <= 0) {
                    cur = cur.l;
                } else {
                    cur = cur.r;
                }
            }
        }

        return false;
    }

    // draw all points to standard draw
    public void draw() {
        drawRec(root);
    }

    private void drawRec(Node node) {
        if (node != null) {
            drawRec(node.l);
            node.p.draw();
            drawRec(node.r);
        }
    }

    private Iterable<Point2D> iterable(Node node, Deque<Point2D> stack) {
        if (node != null) {
            iterable(node.l, stack);
            stack.push(node.p);
            iterable(node.r, stack);
        }

        return stack;
    }


    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException();
        }
        Deque<Point2D> range = new LinkedList<Point2D>();
        for (Point2D p : iterable(root, new LinkedList<Point2D>())) {
            if (rect.contains(p)) {
                range.push(p);
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

        for (Point2D ps : iterable(root, new LinkedList<Point2D>())) {

            if (!p.equals(ps)) {

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
        }

        return nearest;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {

    }
}