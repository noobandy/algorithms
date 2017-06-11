import java.util.*;
import java.io.*;

class TestClass {
    private static class BT {
        private static class Node {
            int value;
            Node left;
            Node right;
        }
        
        private Node root;
        
        public BT() {
            
        }
        
        public void insert(String path, int value) {
            if(path == null) {
                root = new Node();
                root.value = value;
            } else {
              Node parent = root;
              for(int i = 0; i < path.length() - 1; i++) {
                  if(path.charAt(i) == 'L') {
                      parent = parent.left;
                  } else {
                      parent = parent.right;
                  }
              }
            
              Node node = new Node();
              node.value = value;
              
              if(path.charAt(path.length() - 1) == 'L') {
                  parent.left = node;
              } else {
                  parent.right = node;
              }
            }
        }
        private int leftLeaf(Node left) {
            int nodes = 0;
            
            while(left != null) {
                nodes++;
                if(left.left != null) {
                    left = left.left;
                } else {
                    left = left.right;
                }
            }
            
            return nodes;
        }
        private int rightLeaf(Node right) {
            int nodes = 0;
            
            while(right != null) {
                nodes++;
                if(right.right != null) {
                    right = right.right;
                } else {
                    right = right.left;
                }
            }
            
            return nodes;
        }
        
        public int diameter() {
            int result = 1;
            int leftResult = leftLeaf(root.left);
            int rightResult = rightLeaf(root.right);
            return result + leftResult + rightResult;
        }
        
    }
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
       
       String line = br.readLine();
       String[] tokens = line.split(" ");
       int N = Integer.parseInt(tokens[0]);
       int root = Integer.parseInt(tokens[1]);
       BT bt = new BT();
       bt.insert(null, root);
       
       for(int i = 0; i < N - 1; i++) {
           String path = br.readLine();
           line = br.readLine();
           tokens = line.split(" ");
           int value = Integer.parseInt(tokens[0]);
           bt.insert(path, value);
       }
       
       pw.println(bt.diameter());
       
       br.close();
       pw.close();
    }
}
