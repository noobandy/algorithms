
import java.io.*;
import java.util.*;

class TestClass {

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

    public static void main(String args[] ) throws Exception {
        long start = System.nanoTime();
        Reader r = new Reader(System.in);
        PrintWriter w = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = r.nextInt();
        int Q = r.nextInt();
        
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = r.nextInt();
        }
        
        for(int i = 0; i < Q; i++) {
            int cmd = r.nextInt();
            switch(cmd) {
                case 0:
                    r.nextInt();
                    int row = r.nextInt();
                    if(nums[row - 1] == 0) {
                        w.println("EVEN");
                    } else {
                        w.println("ODD");
                    }
                    break;
                case 1:
                    int x = r.nextInt();
                    if(nums[x - 1] == 0) {
                        nums[x - 1] = 1;
                    } else {
                        nums[x - 1] = 0;
                    }
                    break;
                default:
                    break;
            }
        }
        
        r.close();
       
        long end = System.nanoTime();

        w.println("time taken "+ (end - start) / 1000000000);

         w.close();
    }
}
