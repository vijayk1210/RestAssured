package models;

public class EmpDetails {


    private String name;
    private boolean permanent;
    private Address address;
    private Long[] phoneNumbers;
    private String role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public EmpDetails(String name, boolean permanent, Address address, Long[] phoneNumbers, String role) {
        this.name = name;
        this.permanent = permanent;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.role = role;
    }

    public static class Address{

        private String street;
        private String city;
        private int zipcode;

        public Address(String street, String city, int zipcode) {
            this.street = street;
            this.city = city;
            this.zipcode = zipcode;
        }


        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getZipcode() {
            return zipcode;
        }

        public void setZipcode(int zipcode) {
            this.zipcode = zipcode;
        }



    }



}
