import static org.junit.Assert.*;
import org.junit.Test;

public class ChessPanelTest {

    @Test
    public void testGetInstance() {
        ChessPanel instance1 = ChessPanel.getInstance();
        ChessPanel instance2 = ChessPanel.getInstance();
        assertSame(instance1, instance2); // se espera que las dos instancias sean iguales
    }

    @Test
    public void testGetGameLog() {
        ChessPanel instance = ChessPanel.getInstance();
        ChessGameLog gameLog = instance.getGameLog();
        assertNotNull(gameLog); // se espera que el objeto no sea nulo
    }

    @Test
    public void testGetGameBoard() {
        ChessPanel instance = ChessPanel.getInstance();
        ChessGameBoard gameBoard = instance.getGameBoard();
        assertNotNull(gameBoard); // se espera que el objeto no sea nulo
    }

    @Test
    public void testGetGameEngine() {
        ChessPanel instance = ChessPanel.getInstance();
        ChessGameEngine gameEngine = instance.getGameEngine();
        assertNotNull(gameEngine); // se espera que el objeto no sea nulo
    }

    @Test
    public void testGetGraveyard() {
        ChessPanel instance = ChessPanel.getInstance();
        ChessGraveyard playerOneGraveyard = instance.getGraveyard(1);
        ChessGraveyard playerTwoGraveyard = instance.getGraveyard(2);
        assertNull(instance.getGraveyard(0)); // se espera que el objeto sea nulo
        assertNotNull(playerOneGraveyard); // se espera que el objeto no sea nulo
        assertNotNull(playerTwoGraveyard); // se espera que el objeto no sea nulo
        assertNotSame(playerOneGraveyard, playerTwoGraveyard); // se espera que los objetos no sean iguales
    }
}
