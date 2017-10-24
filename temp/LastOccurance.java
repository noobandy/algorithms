    import java.util.*;
    import java.io.*;
     
    class LastOccurance {
        public static void main(String args[] ) throws Exception {
            
            Reader r = new Reader(System.in);
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            
            int T = r.nextInt();
            
            for(int i = 0; i < T; i++) {
                int N = r.nextInt();
                int[] map = new int[1000000];
                
                for(int j = 1; j <= N; j++) {
                    map[r.nextInt()] = j;
                }
                
                int Q = r.nextInt();
                
                for(int j = 0; j < Q; j++) {
                    int key = r.nextInt();
                    int rank = -1;
                    
                    if(key >= 1 && key <= 1000000 && map[key] > 0) {
                        rank = map[key];
                    }
                    
                    pw.format("%d%n", rank);
                }
            }
            
           
            r.close();
            pw.close();
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