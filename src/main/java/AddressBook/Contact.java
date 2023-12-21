package AddressBook;

public class Contact {
    String firstName, lastName, address, city, state, email;
    int zip;
    long phoneNumber;

    public Contact(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public String getAddress() { return address; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public int getZip() { return zip; }

    public long getPhoneNumber() { return phoneNumber; }

    public String getEmail() { return email; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setAddress(String address) { this.address = address; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setZip(int zip) { this.zip = zip; }

    public void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Contact: " + firstName + " " + lastName + ", Address: " + address + ", City: " + city + ", State: " + state + ", Zip: " + zip + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
