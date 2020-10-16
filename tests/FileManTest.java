import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unfinished tests, I could ofc implement em, but meh...
public class FileManTest {
    public FileMan inputFile = new FileMan();
    public FileMan outputFile = new FileMan();

    @Test
    public final void searchFileTest() {
        //assertNotNull(inputFile.searchFile("Fritjoff Flacon"));
        //assertNotNull(inputFile.searchFile("7605021234"));
        //assertNotNull(inputFile.searchFile("2010-04-07"));
    }

    @Test
    public final void writeToFileTest() {
        //outputFile.writeToFile("Fritjoff Flacon");
        //assertEquals("Result", m1 * m2, outputFile.writeToFile("Testo"));
    }

}
