package dk.app.model;

import dk.app.model.enums.CustomerType;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Customer {
    private  final AtomicInteger ID_COUNTER = new AtomicInteger(1);
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private final CustomerType customerType;
    private Boolean deleted;

    public Customer(String name, String email, String phone, CustomerType customerType) {
        this.id = ID_COUNTER.getAndIncrement();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.deleted = false;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Customer => id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", type=" + customerType ;
    }
}
