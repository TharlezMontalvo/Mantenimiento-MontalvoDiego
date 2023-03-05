
import org.junit.Test;
import org.junit.Assert;

public class ChessMenuBarTest {
    
    @Test
    public void testAboutHandler() {
        ChessMenuBar menuBar = new ChessMenuBar();
        menuBar.aboutHandler();
        // La siguiente línea es solo para comprobar que el método se ejecuta sin excepciones
        Assert.assertTrue(true);
    }
    
    
    @Test
    public void testExitHandler() {
        ChessMenuBar menuBar = new ChessMenuBar();
        menuBar.exitHandler();
        // La siguiente línea es solo para comprobar que el método se ejecuta sin excepciones
        Assert.assertTrue(true);
    }
    
}
