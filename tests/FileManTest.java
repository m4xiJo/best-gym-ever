import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileManTest {
    public FileMan fileManager = new FileMan("./files/customers.txt");

    @Test
    public final void searchFileTest() {
        assertNotNull(fileManager.searchFile("Fritjoff Flacon"));
        assertNotNull(fileManager.searchFile("7605021234"));
        assertNotNull(fileManager.searchFile("2010-04-07"));
    }

    @Test
    public final void writeToFileTest() {
        //assertTrue(fileManager.writeToFile("Fritjoff Flacon"));
        //assertTrue(fileManager.writeToFile("Fritjoff Flacon"));
        //assertTrue(fileManager.writeToFile("Fritjoff Flacon"));
    }

}
