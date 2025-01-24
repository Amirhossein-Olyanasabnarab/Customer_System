package dk.app.model;

import dk.app.model.enums.CustomerType;

public class LegalCustomer extends Customer{
    private String fax;
    public LegalCustomer(String name, String email, String phone) {
        super(name, email, phone, CustomerType.LEGAL_CUSTOMER);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return super.toString() +
                " ,fax='" + fax + '\''
                ;
    }
}
