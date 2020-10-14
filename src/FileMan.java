import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMan {
    protected File textFile;
    protected Scanner scanFile;
    protected FileWriter writeFile;
    protected StringBuilder textBuffer;

    FileMan(String path) {
        try {
            this.textFile = new File(path);
            this.scanFile = new Scanner(textFile);
            this.writeFile = new FileWriter(textFile);
            this.textBuffer = new StringBuilder();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    void writeToFile(String toWrite) {
        try {
            if (this.textFile.createNewFile()) System.out.println("File created: " + this.textFile.getName());
            else System.out.println("File already exists.");
            this.writeFile.write(toWrite);
            this.writeFile.close();
        } catch(IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    String searchFile(String toFind) {
        this.textBuffer.setLength(0);
        String result = "";

        try {
            while (this.scanFile.hasNextLine()) {
                String textLine = this.scanFile.nextLine();
                this.textBuffer.append(textLine + "\n");
            }
            this.scanFile.close();

            String group1 = "(" + toFind + ".*)";
            String group2 = "([^\\n]+" + toFind + ")";
            String group3 = "(.*\\n" + toFind + ")";
            String regex = group1;
            Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
            Matcher matcher = pattern.matcher(this.textBuffer);

            if (matcher.find()) {
                System.out.println("Found value:\n" + matcher.group(0));
                System.out.println("Found value: " + matcher.group(1));
                System.out.println("Found value: " + matcher.group(2));
            } else {
                System.out.println("NO MATCH");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "null";
    }
}
