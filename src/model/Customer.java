package model;


public class Customer {
    private int id1;
    private String name;
    private String phone;
    private int id;
    private String fullname;
    private String phone11;

    public Customer(int id1, String name, String phone) {
        this.id1 = id1;
        this.name = name;
        this.phone = phone;
    public Customer(int id, String name, String phone11) {
        this.id = id;
        this.fullname = name;
        this.phone11 = phone11;
    }

    public int getid() { return id1; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getId() { return id; }
    public String getName() { return fullname; }
    public String getphone11() { return phone11; }

    public void setName(String name) { this.fullname = name; }
    public void setphone11(String phone11) { this.phone11 = phone11; }

    @Override
    public String toString() {
        return id1 + " | " + name + " | " + phone;
        return id + " | " + name + " | " + phone11;
    }
}
