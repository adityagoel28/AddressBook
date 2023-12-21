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

}