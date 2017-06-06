import java.io.*;

public class Reader {
        private BufferedReader br;
        private String[] tokens;
        private int nextToken;

        public Reader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public void close() throws Exception {
            br.close();
        }

        public String next() throws Exception {
            if(tokens == null || nextToken >= tokens.length) {
                tokens = nextLine().split(" ");
                nextToken = 0;
            }

            return tokens[nextToken++];
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        private String nextLine() throws Exception {
            return br.readLine();
        } 
    }