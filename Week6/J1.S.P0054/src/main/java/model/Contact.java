package model;

public class Contact {
    private int id;
    private String fullName;
    private String lastName;
    private String firstName;
    private String group;
    private String address;
    private String phone;

    public Contact(String firstName, String lastName, String group, String address, String phone) {
        this.fullName = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-30s %-15s %-15s %-10s %-20s %-12s",
                id, fullName, firstName, lastName, group, address, phone);
    }

}
