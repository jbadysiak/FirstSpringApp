package com.packt.webstore.domain;


public class Customer {
    private String customerId;
    private String name;
    private String surname;
    private String address;
    private long noOfOrdersMade;

    public Customer() {
        super();
    }

    public Customer(String customerId, String name, String surname) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Customer cust = (Customer) obj;

        if (customerId == null){
            if (cust.customerId != null) return false;
        }else if (!customerId.equals(cust.customerId)) return false;

        return true;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "Uzytkownik nr: "+customerId+", nazywa sie: "+name+" "+surname+".";
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(long noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
}
