import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            while (true) {
                //Ask user for name
                String personToFind = JOptionPane.showInputDialog("Type a name or phone number to find person by");
                //Instantiate the file manager class
                FileMan file = new FileMan();
                //Read out file and get the data we need
                Object[] customer = file.readFromFile("./files/customers.txt", personToFind);
                //Construct message
                String text = customer[0] + "\n" + customer[1].toString();
                //Construct expiry warning
                if ((int) customer[2] >= 1) text += "\nMembership expired by " + ((int) customer[2] - 1) + " years!";
                //Ask if user d like to log customer attendance
                JOptionPane.showMessageDialog(null, text);
                int res = JOptionPane.showConfirmDialog(null, "Would you like to record this person as attended today?");
                if (res == JOptionPane.YES_OPTION) { //If YES, write to our file titled just like the customer
                    file.writeToFile("./files/" + customer[0] + ".txt", customer[0].toString() + "\n" + LocalDate.now() + "\n");
                }
                break; //Break the while loop if execution ever reaches here :)
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
