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
        //Try catch with resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(toWrite); //Write to file (in appending mode)
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    Object[] readFromFile(String path, String toFind) {
        Object[] data = new Object[3]; // Create object to atora our data
        String line; //Temporary line
        Path file = Paths.get(path); //Path builder
        try (BufferedReader reader = Files.newBufferedReader(file)) { //Try catch with resources
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(toFind.toLowerCase())) {
                    data[0] = line; //Store the line to object
                    data[1] = LocalDate.parse(reader.readLine());//Store the next line to object
                    // Calculate time difference between timestamps
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
