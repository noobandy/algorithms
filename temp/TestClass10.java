import java.io.*;
import java.util.*;


class TestClass {
    
    private static int[][] matrix(int[] nums) {
        int[][] matrix = new int[nums.length][nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j] = nums[i] ^ nums[j];
            }
        }
        
        return matrix;
    }
    
    private static long summation(int[][] matrix, int x1, int y1, int x2, int y2) {
        long sum = 0;
        
        for(int i = x1 - 1; i < x2; i++) {
            for(int j = y1 - 1; j < y2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    
     private static long summation(int[] nums, int x1, int y1, int x2, int y2) {
        long sum = 0;
        
        for(int i = x1 - 1; i < x2; i++) {
            for(int j = y1 - 1; j < y2; j++) {
                sum += (nums[i] ^ nums[j]);
            }
        }
        return sum;
    }
    
    public static void main(String args[] ) throws Exception {
        long start = System.nanoTime();
        Reader r = new Reader(System.in);
        PrintWriter w = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = r.nextInt();
        int[] nums = new int[N]; 
        for (int i = 0; i < N; i++) {
            nums[i] = r.nextInt();
        }
        
        // int[][] matrix = matrix(nums);
        
        // nums = null;
        
        int Q = r.nextInt();
        
        for(int i = 0; i < Q; i++){
            int x1 = r.nextInt();
            int y1 = r.nextInt();
            int x2 = r.nextInt();
            int y2 = r.nextInt();
            
            w.println(summation(nums, x1, y1, x2, y2));
        }
        
        r.close();
        long end = System.nanoTime();
        w.println("time taken "+ (end - start) / 1000000000);
        w.close();
    }


    private static class Reader {

        private BufferedInputStream bis;

        private byte[] buf;

        private int available;

        private int read;

        public Reader(InputStream is) {
            bis = new BufferedInputStream(is);
            buf = new byte[8092];
        }

        public void close() throws IOException {
            bis.close();
        }

        private int next() throws IOException {
            if (available == read) {
                available = bis.read(buf);
                read = 0;
            }

            if (available == -1) {
                return -1;
            }

            return buf[read++];

        }

        private boolean isWhiteSpace(int c) {

            return c == ' ' || c == '\n' || c == '\t' || c == '\r';
        }

        public int nextInt() throws IOException {
            int c = next();

            while (isWhiteSpace(c)) {
                c = next();
            }

            if (c == -1) {
                throw new InputMismatchException();
            }

            int num = 0;
            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = next();
            }

            if (c == -1) {
                throw new InputMismatchException();
            }

            do {
                num = num * 10 + (c - '0');

                c = next();
            }
            while (c != -1 && !isWhiteSpace(c));

            return sign * num;
        }
    }
}
