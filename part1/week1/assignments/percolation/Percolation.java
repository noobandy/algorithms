import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

   private int virtualSiteTop;
   private int virtualSiteBottom;
   private boolean[][] sites;
   private WeightedQuickUnionUF uf;
   private int openSites;
   private int n;

   // create n-by-n grid, with all sites blocked
   public Percolation(int n) {
      super();
      if (n <= 0) {
         throw new IllegalArgumentException("illeagl value of n");
      }
      this.n = n;

      sites = new boolean[n][n];

      uf = new WeightedQuickUnionUF((n * n) + 2);

      virtualSiteTop = 0;

      virtualSiteBottom = (n * n) + 1;

      openSites = 0;
      
      //connect top row sites with virtual top
      for (int j = 1; j <= n; j++) {
         uf.union(virtualSiteTop, siteToObject(1, j, n));
      }

      //connect bottom row sites with virtual bottom
      for (int j = 1; j <= n; j++) {
         uf.union(virtualSiteBottom, siteToObject(n, j, n));
      }
   }

   private int siteToObject(int row, int col, int n) {
      return ((row - 1) * n) + col;
   }

   private void validateRange(int row, int col) {
      if (row < 1 || row > n || col < 1 || col > n) {
         throw new IndexOutOfBoundsException();
      }
   }

   // open site (row, col) if it is not open already
   public void open(int row, int col) {
      validateRange(row, col);

      if (!isOpen(row, col)) {
         //open site
         openSites++;

         sites[row - 1][col - 1] = true;

         int topRow = row - 1;
         int bottomRow = row + 1;
         int leftColumn = col - 1;
         int rightColumn = col + 1;

         int sourceSite = siteToObject(row, col, n);
         //is top open
         if (topRow >= 1 && sites[topRow - 1][col - 1]) {
            uf.union(sourceSite, siteToObject(topRow, col, n));
         }

         //is bottom open
         if (bottomRow <= n && sites[bottomRow - 1][col - 1]) {
            uf.union(sourceSite, siteToObject(bottomRow, col, n));
         }
         //is left open
         if (leftColumn >= 1 && sites[row - 1][leftColumn - 1]) {
            uf.union(sourceSite, siteToObject(row, leftColumn, n));
         }
         //is right open
         if (rightColumn <= n && sites[row - 1][rightColumn - 1]) {
            uf.union(sourceSite, siteToObject(row, rightColumn, n));
         }
      }
   }
   // is site (row, col) open?
   public boolean isOpen(int row, int col) {
      validateRange(row, col);

      return sites[row - 1][col - 1];
   }
   // is site (row, col) full?
   public boolean isFull(int row, int col) {
      validateRange(row, col);
      return isOpen(row, col) && uf.connected(siteToObject(row, col, n), virtualSiteTop);
   }
   // number of open sites
   public int numberOfOpenSites() {
      return openSites;
   }
   // does the system percolate?
   public boolean percolates() {
      return uf.connected(virtualSiteTop, virtualSiteBottom);
   }
}