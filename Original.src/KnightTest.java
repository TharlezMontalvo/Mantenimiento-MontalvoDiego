import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class KnightTest {
    private ChessGameBoard board;
    private Knight knight;
    
    @Before
    public void setUp() {
        board = new ChessGameBoard();
        knight = new Knight(board, 3, 3, ChessGamePiece.WHITE);
    }
    
    @Test
    public void testCalculatePossibleMoves() {
        ArrayList<String> possibleMoves = knight.calculatePossibleMoves(board);
        assertTrue(possibleMoves.contains("1,4"));
        assertTrue(possibleMoves.contains("1,2"));
        assertTrue(possibleMoves.contains("2,5"));
        assertTrue(possibleMoves.contains("2,1"));
        assertTrue(possibleMoves.contains("4,5"));
        assertTrue(possibleMoves.contains("4,1"));
        assertTrue(possibleMoves.contains("5,4"));
        assertTrue(possibleMoves.contains("5,2"));
    }
    
}
