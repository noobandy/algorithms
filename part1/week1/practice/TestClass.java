/* IMPORTANT: Multiple classes and nested static classes are supported */

//import for Scanner and other utility  classes
import java.util.*;

class TestClass {
    private static class NinjaWorld {
        private Set<Integer> zetsu;
        private Set<Integer> raikage;
        
        public NinjaWorld() {
            zetsu = new HashSet<Integer>();
            raikage = new HashSet<Integer>();
        }
        
        public void enemies(Integer ninjaOne, Integer ninjaTwo) {
            if(zetsu.contains(ninjaOne)) {
                raikage.add(ninjaTwo);
            } else if(raikage.contains(ninjaOne)){
                zetsu.add(ninjaTwo);
            } else if(zetsu.contains(ninjaTwo)){
                 raikage.add(ninjaOne);
            } else if(raikage.contains(ninjaTwo)) {
                zetsu.add(ninjaOne);
            } else {
                  zetsu.add(ninjaOne);
                  raikage.add(ninjaTwo);
            }
        }
        
        public int maximum() {
           return Math.max(raikage.size(), zetsu.size());
        }
    } 
    public static void main(String args[] ) throws Exception {
       
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            NinjaWorld nw = new NinjaWorld();
            
            for(int j = 0; j < N; j++) {
                int ninjaOne = s.nextInt();
                int ninjaTwo = s.nextInt();
                
                nw.enemies(ninjaOne, ninjaTwo);
            }
            
            System.out.println(nw.maximum());
        }
        
    }
}
