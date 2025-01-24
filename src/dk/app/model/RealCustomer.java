package dk.app.model;

import dk.app.model.enums.CustomerType;

public class RealCustomer extends Customer {

    private String family;
    public RealCustomer(String name, String email, String phone) {
        super(name, email, phone, CustomerType.REAL_CUSTOMER);
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return super.toString() +
                " ,family='" + family + '\''
                ;
    }
}
