import pieces.*;
import matrix.*;

public class ChessGame {
   public static void main(String[] args) throws Exception {
      
      char[] whitePieces = new char[] {
         'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P',
         'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'
         };
         
      char[] blackPieces = new char[] {
         'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P',
         'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'
         };     
     
      Matrix asdf = new Matrix();
      asdf.populateBoard(whitePieces, blackPieces);
      System.out.println(asdf);
   }
}