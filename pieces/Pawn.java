package pieces;

public class Pawn extends Piece {
   public Pawn() {
      super('P',1,1);
   }
   
   public Pawn(int rank, int column) {
      super('P', rank, column);
   }
   
}