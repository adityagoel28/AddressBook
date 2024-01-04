package AddressBook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private Map<String, Contact> contacts = new HashMap<>();
    private Map<String, List<Contact>> cityToContacts = new HashMap<>();
    private Map<String, List<Contact>> stateToContacts = new HashMap<>();

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
        if (!contacts.containsKey(key)) {
            contacts.put(key, newContact);
            cityToContacts.computeIfAbsent(city, k -> new ArrayList<>()).add(newContact);
            stateToContacts.computeIfAbsent(state, k -> new ArrayList<>()).add(newContact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Contact already exists.");
        }
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

    public void deleteContact(Scanner scanner) {
        System.out.print("Enter the first name of the contact to delete: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the last name of the contact to delete: ");
        String lastName = scanner.nextLine();
        String key = formatKey(firstName, lastName);

        if (contacts.containsKey(key)) {
            contacts.remove(key);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the address book.");
            return;
        }
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    public List<Contact> searchContactsByCity(String city) {
        return cityToContacts.getOrDefault(city, Collections.emptyList()); // returns empty list if no contacts found
    }

    public List<Contact> searchContactsByState(String state) {
        return stateToContacts.getOrDefault(state, Collections.emptyList());
    }

    public long countContactsByCity(String city) {
        List<Contact> contactsInCity = cityToContacts.get(city);
        return (contactsInCity != null) ? contactsInCity.size() : 0;
    }

    public long countContactsByState(String state) {
        List<Contact> contactsInState = stateToContacts.get(state);
        return (contactsInState != null) ? contactsInState.size() : 0;
    }

    public List<Contact> getSortedContactsByName() {
        return contacts.values().stream()
                .sorted(Comparator.comparing(Contact::getFirstName)
                        .thenComparing(Contact::getLastName))
                .collect(Collectors.toList());
    }

    public List<Contact> getContactsSortedByCity() {
        return contacts.values().stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList());
    }

    public List<Contact> getContactsSortedByState() {
        return contacts.values().stream()
                .sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
    }

    public List<Contact> getContactsSortedByZip() {
        return contacts.values().stream()
                .sorted(Comparator.comparingInt(Contact::getZip))
                .collect(Collectors.toList());
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact contact : contacts.values()) {
                writer.write(contact.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contact contact = parseContact(line);
                System.out.println(contact);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private Contact parseContact(String line) {
        try {
            String[] parts = line.split(", ");

            String namePart = parts[0].substring("Contact: ".length());
            String[] names = namePart.split(" ");
            String firstName = names[0];
            String lastName = names[1];

            String address = parts[1].substring("Address: ".length());
            String city = parts[2].substring("City: ".length());
            String state = parts[3].substring("State: ".length());
            int zip = Integer.parseInt(parts[4].substring("Zip: ".length()));
            long phoneNumber = Long.parseLong(parts[5].substring("Phone: ".length()));
            String email = parts[6].substring("Email: ".length());

            return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid contact line: " + line, e);
        }
    }

}