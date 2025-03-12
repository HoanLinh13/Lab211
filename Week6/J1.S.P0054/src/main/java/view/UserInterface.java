package view;

import controller.ContactManagement;
import model.Contact;
import utility.CheckValidate;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    ContactManagement cm = new ContactManagement();
    CheckValidate validate = new CheckValidate();

    private int menu(){
        int choice = 0;
        System.out.println("======== Contact program ========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        validate.checkMenu(choice);
        return choice;
    }

    public void start(){
            while(true){
                    switch(menu()){
                        case 1:
                            System.out.print("Enter first name: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Enter last name: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Enter group: ");
                            String group = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            String phone;
                            do {
                                System.out.print("Enter phone: ");
                                phone = scanner.nextLine();
                            }while (!validate.checkPhone(phone));

                            Contact contact = new Contact(firstName, lastName, group, address, phone);
                            cm.addContact(contact);

                            break;
                        case 2:
                            cm.displayAll();

                            break;
                        case 3:
                            boolean isValid = false;
                            while (!isValid) {
                                try {
                                    System.out.print("Enter id: ");
                                    int id = Integer.parseInt(scanner.nextLine().trim());
                                    if(validate.isIdExist(id, cm.getContactsList())){
                                        cm.deleteContact(id);
                                    }
                                    isValid = true;
                                } catch (NumberFormatException e) {
                                    System.err.println("ID is digit");
                                }
                            }

                            break;
                        case 4:
                            System.exit(0);
                    }
            }

    }
}
