import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            while (true) {
                String personToFind = JOptionPane.showInputDialog("Type a name or phone number to find person by");
                FileMan file = new FileMan();
                Object[] customer = file.readFromFile("./files/customers.txt", personToFind);
                String text = customer[0] + "\n" + customer[1].toString();
                if ((int) customer[2] >= 1) text += "\nMembership expired by " + ((int) customer[2] - 1) + " years!";
                JOptionPane.showMessageDialog(null, text);
                int res = JOptionPane.showConfirmDialog(null, "Would you like to record this person as attended today?");
                if (res == JOptionPane.YES_OPTION) {
                    file.writeToFile("./files/" + customer[0] + ".txt", customer[0].toString() + "\n" + LocalDate.now() + "\n");
                }
                break;
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
