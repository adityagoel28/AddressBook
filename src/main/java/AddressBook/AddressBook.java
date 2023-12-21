package AddressBook;

import java.util.*;

public class AddressBook {
    private Map<String, Contact> contacts = new HashMap<>();

    private String formatKey(String firstName, String lastName) {
        return firstName.toLowerCase() + "_" + lastName.toLowerCase(); // key format, converts to lowercase string and concatenates with underscore
    }

    public void addContact(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter zip: ");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter phone number: ");
        long phoneNumber = Long.parseLong(scanner.nextLine());
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        String key = formatKey(firstName, lastName);

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email); // create new contact
        contacts.put(key, newContact);
        System.out.println("Contact added successfully!");
    }

    public void editContact(Scanner scanner) {
        System.out.print("Enter the first name of the contact to edit: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the last name of the contact to edit: ");
        String lastName = scanner.nextLine();
        String key = formatKey(firstName, lastName); // format key

        if (contacts.containsKey(key)) {
            Contact contact = contacts.get(key);

            System.out.print("Enter new first name: ");
            contact.setFirstName(scanner.nextLine());
            System.out.print("Enter new last name: ");
            contact.setLastName(scanner.nextLine());
            System.out.print("Enter new address: ");
            contact.setAddress(scanner.nextLine());
            System.out.print("Enter new city: ");
            contact.setCity(scanner.nextLine());
            System.out.print("Enter new state: ");
            contact.setState(scanner.nextLine());
            System.out.print("Enter new zip: ");
            contact.setZip(Integer.parseInt(scanner.nextLine()));
            System.out.print("Enter new phone number: ");
            contact.setPhoneNumber(Long.parseLong(scanner.nextLine()));
            System.out.print("Enter new email: ");
            contact.setEmail(scanner.nextLine());
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

}