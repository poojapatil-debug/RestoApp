package model;


public class Customer {
    private int id;
    private String fullname;
    private String phone11;

    public Customer(int id, String name, String phone11) {
        this.id = id;
        this.fullname = name;
        this.phone11 = phone11;
    }

    public int getId() { return id; }
    public String getName() { return fullname; }
    public String getphone11() { return phone11; }

    public void setName(String name) { this.fullname = name; }
    public void setphone11(String phone11) { this.phone11 = phone11; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone11;
    }
}
