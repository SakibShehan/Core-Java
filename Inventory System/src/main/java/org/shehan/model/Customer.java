package org.shehan.model;

public class Customer {

    private int id;         // DB set করে
    private String name;
    private String email;
    private String phone;
    private  String password;


    public Customer() {}


    public Customer(int id, String name, String email, String phone, String password) {
        this.id = id; this.name = name; this.email = email; this.phone = phone; this.password=password;
    }

    public Customer(String name, String email, String phone , String password) {
        this(0, name, email, phone,password);
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPassword(){return password;}

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPassword(String password){this.password=password;}

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name='%s', email='%s', phone='%s',password='%s'}",
                id, name, email, phone,password);}

}
