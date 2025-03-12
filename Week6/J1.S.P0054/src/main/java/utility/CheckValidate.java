package utility;

import model.Contact;

import java.util.Map;

public class CheckValidate {
    public boolean checkMenu(int choice) {
        if (choice > 0 && choice <= 4)
            return true;
        else {
            System.err.println("Error: Please enter a number between 1 and 4!");
            return false;
        }
    }

    public boolean isIdExist(int id, Map<Integer, Contact> contactsList) {
        if (!contactsList.containsKey(id)) {
            System.err.println("No found contact");
            return false;
        }
        return true;
    }

    public boolean checkPhone(String phoneNumber) {
        if (!phoneNumber.matches("^(\\d{10}|\\d{3}[-. ]\\d{3}[-. ]\\d{4}(?: (?:x|ext)\\d{4})?)$")) {
            System.out.println("Note: A phone number only has the following format:\n" +
                    " 1234567890\n" +
                    " 123-456-7890\n" +
                    " 123-456-7890 x1234\n" +
                    " 123-456-7890 ext1234\n" +
                    " 123.456.7890\n" +
                    " 123 456 7890\n");
            return false;
        }
        return true;
    }
}
