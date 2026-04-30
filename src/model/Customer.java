package model;


public class Customer {
    private int id;
    private String fullname;
    private String phoneNumber;

    public Customer(int id, String name, String phoneNumber) {
        this.id = id;
        this.fullname = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() { return id; }
    public String getName() { return fullname; }
    public String getphoneNumber() { return phoneNumber; }

    public void setName(String name) { this.fullname = name; }
    public void setphoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phoneNumber;
    }
    
}
