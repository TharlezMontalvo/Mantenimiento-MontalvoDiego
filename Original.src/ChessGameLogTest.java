
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Date;

public class ChessGameLogTest {
    @Test
    public void testAddToLog() {
        ChessGameLog log = ChessGameLog.create();
        log.addToLog("Test log message");
        String expected = new Date() + " - Test log message";
        String actual = log.getLastLog();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testClearLog() {
        ChessGameLog log = ChessGameLog.create();
        log.addToLog("Test log entry");
        log.clearLog();
        String lastLog = log.getLastLog();
        assertEquals("", lastLog);
    }  
}