    import java.util.*;
    import java.io.*;
     
    class NDivTree {
        public static void main(String args[] ) throws Exception {
            
            Reader r = new Reader(System.in);
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            
            int N = r.nextInt();

            DiGraph g = new DiGraph(N);

            for(int i = 0; i < (N - 1); i++) {
                int v = r.nextInt();
                int w = r.nextInt();

                g.addEdge(v - 1, w - 1);
            }

            DFS dfs = new DFS(g);
            
           
            r.close();
            pw.close();
        }
        
        private static class DFS {
            
            private int[] edgeTo;
            private boolean[] marked;
            
            public DFS(DiGraph g) {
                edgeTo = new int[g.V()];
                for(int i = 0; i < g.V(); i++) {
                    edgeTo[i] = i;
                }
                
                marked = new boolean[g.V()];
                
                for(int i = 0; i < g.V(); i++) {
                    if(!marked[i]) {
                        edgeTo[i] = i;
                        _dfs(g, i);
                    }
                }

                System.out.println(Arrays.toString(marked));
                System.out.println(Arrays.toString(edgeTo));
            }
            
            private void _dfs(DiGraph g, int v) {
                
                for(int w : g.edges(v)) {
                    if(!marked[w]) {
                        edgeTo[w] = v;
                        _dfs(g, w);
                    }
                }
                    
                marked[v] = true;
            }
        }
        private static class DiGraph {
            private List<Integer>[] adjecencyList;
            private int V;
            private int E;
            
            
            public DiGraph(int V) {
                this.V = V;
                adjecencyList = (List<Integer>[]) new ArrayList[V];
                
                for(int i = 0; i < V; i++) {
                    adjecencyList[i] = new ArrayList<Integer>();
                }
            }
            
            public int V() {
                return V;
            }
            
            public int E() {
                return E;
            }
            
            public void addEdge(int v, int w) {
                adjecencyList[v].add(w);
            }
            
            public Iterable<Integer> edges(int v) {
                return adjecencyList[v];
            }
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