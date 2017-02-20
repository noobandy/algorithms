public class Percolation {
   private int n;
   // create n-by-n grid, with all sites blocked
   public Percolation(int n) {
      super();
      if (n <= 0) {
         throw new IllegalArgumentException("illeagl value of n");
      }
   }

   private void validateRange(int row, int col) {
      if (row < 1 || row > n || col < 1 || col > n) {
         throw new IndexOutOfBoundsException();
      }
   }
   // open site (row, col) if it is not open already
   public void open(int row, int col) {
      validateRange(row, col);
   }
   // is site (row, col) open?
   public boolean isOpen(int row, int col) {
      validateRange(row, col);
      return false;
   }
   // is site (row, col) full?
   public boolean isFull(int row, int col) {
      validateRange(row, col);
      return false;
   }
   // number of open sites
   public int numberOfOpenSites() {
      return 0;
   }
   // does the system percolate?
   public boolean percolates() {
      return false;
   }
}