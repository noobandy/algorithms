import java.util.*;
import java.io.*;

class TestClass {
    
    private static class Trie {
        
        private static class TrieNode {
            TrieNode[] children;
            int weight;
            
            public TrieNode() {
                children = new TrieNode[26];
                weight = -1;
            }
        }
        
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        private int indexForChar(char c) {
            return c - 97;
        }
        
        public void addWord(String word, int weight) {
            TrieNode cur = root;
            
            for(int i = 0; i < word.length(); i++) {
                if(weight > cur.weight) {
                    cur.weight = weight;
                }
                char c = word.charAt(i);
                
                int index = indexForChar(c);
                
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                
                cur = cur.children[index];
            }
            
            if(weight > cur.weight) {
                cur.weight = weight;
            }
        }
        
        public int bestMatchWeight(String query) {
            TrieNode cur = root;
            
            for(int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                int index = indexForChar(c);
                
                if(cur.children[index] == null) {
                    return -1;
                }
                
                cur = cur.children[index];
                
            }
            
            return cur.weight;
        }
        
        private int _bestMatchWeight(TrieNode trieNode) {
            int maxWeight = trieNode.weight;
            
            for(int i = 0; i < 26; i++) {
                if(trieNode.children[i] != null) {
                    int maxWeightNew = _bestMatchWeight(trieNode.children[i]);
                    if(maxWeightNew > maxWeight) {
                        maxWeight = maxWeightNew;
                    }
                }
            }
            
            return maxWeight;
        }
    }
    
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        String line = br.readLine();
        
        String[] tokens = line.split(" ");
        
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        
        
        Trie trie = new Trie();
        
        for(int i = 0; i < N; i++) {
            line = br.readLine();
            tokens = line.split(" ");
            
            trie.addWord(tokens[0], Integer.parseInt(tokens[1]));
        }
        
        for(int i = 0; i < Q; i++) {
            pw.println(trie.bestMatchWeight(br.readLine()));
        }
        
        br.close();
        pw.close();
        
    }
}
