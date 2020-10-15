import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

public class FileMan {

    FileMan() {

    }

    void writeToFile(String path, String toWrite) {
        Path file = Paths.get(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(toWrite);
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    Object[] readFromFile(String path, String toFind) {
        Object[] data = new Object[3];
        String line;
        Path file = Paths.get(path);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(toFind.toLowerCase())) {
                    data[0] = line;
                    data[1] = LocalDate.parse(reader.readLine());
                    data[2] = Period.between((LocalDate) data[1], LocalDate.now()).getYears();
                }
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }


}
