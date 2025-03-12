package controller;

import model.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactManagement {
    private Map<Integer, Contact> contactsList = new HashMap<>();
    private int countID = 0;

    public void addContact(Contact contact) {
        contact.setId(++countID);
        contactsList.put(contact.getId(), contact);
        if (contactsList.containsKey(countID)) {
            System.out.println("Add contact successful" );
        }
    }

    public void deleteContact(int id) {
        contactsList.remove(id);
        if (!contactsList.containsKey(id)) {
            System.out.println("Delete contact successful");
        }
    }

    public void displayAll() {
        System.out.println("--------------------------------Display all Contact---------------------------------------");
        System.out.printf("%-5s %-30s %-15s %-15s %-10s %-20s %-12s%n",
                "ID", "Full Name", "First Name", "Last Name", "Group", "Address", "Phone");
        System.out.println("------------------------------------------------------------------------------------------");

        for (Contact contact : contactsList.values()) {
            System.out.println(contact);
        }
    }


    public Map<Integer, Contact> getContactsList() {
        return contactsList;
    }
}
