package model;


public class Customer {
    private int id;
    private String fullname;
    private String phone;

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.fullname = name;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return fullname; }
    public String getPhone() { return phone; }

    public void setName(String name) { this.fullname = name; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone;
    }
}
