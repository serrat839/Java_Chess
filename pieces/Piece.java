package pieces;
public class Piece {
   int rank;
   int column;
   // 0 = no move
   int firstMove;
   char pieceType;

   public Piece(char notation, int rank, int column) {
      if (notation == 0) {
         pieceType = 'p';
      } else {
         pieceType = notation;
      }
      System.out.println(pieceType);
   }

   public String toString() {
      return Integer.toString(firstMove);
   }
   
   public boolean hasMoved() {
      return firstMove > 0;
   }
}