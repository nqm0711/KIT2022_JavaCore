package BTVN.Day7.BTVN1_StreamAPI;

public class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer Name: " + name + " Address: " + address;
    }
}
