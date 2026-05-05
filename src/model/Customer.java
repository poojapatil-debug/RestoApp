package model;


public class Customer {
    private int id1;
    private String name;
    private String phone;

    public Customer(int id1, String name, String phone) {
        this.id1 = id1;
        this.name = name;
        this.phone = phone;
    }

    public int getid() { return id1; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return id1 + " | " + name + " | " + phone;
    }
}
