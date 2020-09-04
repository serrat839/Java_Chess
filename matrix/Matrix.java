package matrix;

public class Matrix {
   private final int boardDimensions = 8;
   
   private MatrixNode root;
   
   public MatrixNode asdf() {
      return root;
   }
   
   public Matrix(char[] white, char[] black) {
      this();
   }
   
   public Matrix() {
      
      if (boardDimensions >= 2) {
         root = new MatrixNode(0, 0);
         MatrixNode curr = root;
         for (int i = 1; i < boardDimensions; i++) {
            curr.east = new MatrixNode(0, i);
            curr.east.west = curr;
            curr = curr.east;
         }
         completeMatrix();    
      }  
   }
   
   private void completeMatrix() {
      MatrixNode prevLegHome = root;
      for (int i = 1; i < boardDimensions; i++) {
         prevLegHome.south = new MatrixNode(i, 0);
         prevLegHome.south.north = prevLegHome;
         MatrixNode curLegHome = prevLegHome.south;
         
         MatrixNode curLeg = curLegHome;
         MatrixNode prevLegNext = prevLegHome.east;
         
         for (int j = 1; j < boardDimensions; j++) {
            curLeg.east = new MatrixNode(i, j);
            curLeg.east.west = curLegHome;
            curLeg = curLeg.east;
            curLeg.north = prevLegNext;
            curLeg.north.south = curLeg;
         }
         prevLegHome = prevLegHome.south;
      }
   }
   
   public void populateBoard(char[] white, char[] black) throws Exception {
      int whiteRows = white.length / boardDimensions + ((white.length % boardDimensions != 0) ? 1 : 0);
      int blackRows = black.length / boardDimensions + ((black.length % boardDimensions != 0) ? 1 : 0);
      
      if (whiteRows + blackRows > boardDimensions) {
         throw new Exception("TOO MANY PIECES");
      }
      
      MatrixNode curr = root;
      MatrixNode vert = root;
      
      System.out.println("total rows: " +  (whiteRows + blackRows));
      for (int i = white.length - 1; i >= 0; i--) {
         curr.occupier = white[i];
         if (curr.east != null) {
            curr = curr.east;
         } else {
            vert = vert.south;
            curr = vert;
         }
      }
      
      for (int i = 0; i < boardDimensions - blackRows - whiteRows; i++) {
         vert = vert.south;
      }
      curr = vert;
      for (int i = 0 ; i < black.length; i++) {
         curr.occupier = black[i];
         if (curr.east != null) {
            curr = curr.east;
         } else {
            vert = vert.south;
            curr = vert;
         }
      }
   }
   
   public String toString() {
      String returnable = "";
      MatrixNode currRow = root;
      while (currRow != null) {
         MatrixNode currCol = currRow;
         while (currCol != null) {
            returnable += currCol.toString() + " ";
            currCol = currCol.east;
         }
         returnable += "\n";
         currRow = currRow.south;
      }   
      return returnable;
   }
   
   
   public class MatrixNode {
      public int rank;
      public int column;
      public char occupier;
      
      public MatrixNode north;
      public MatrixNode south;
      public MatrixNode east;
      public MatrixNode west;
      
      public MatrixNode(int rank, int column) {
         this(rank, column, '*');
      }
      
      public MatrixNode(int rank, int column, char occupier) {
         this.rank = rank;
         this.column = column;
         this.occupier = occupier;
      }
      
      public String toString() {
         return "" + rank + occupier + column;
      }
   }
}