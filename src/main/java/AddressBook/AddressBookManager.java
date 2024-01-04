package AddressBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookManager {
    private Map<String, AddressBook> addressBookMap;

    public AddressBookManager() {
        addressBookMap = new HashMap<>();
    }

    public void addAddressBook(String name) {
        if (!addressBookMap.containsKey(name)) {
            addressBookMap.put(name, new AddressBook());
            System.out.println("Address book '" + name + "' created.");
        } else {
            System.out.println("An address book with this name already exists.");
        }
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    public void listAddressBooks() {
        if (addressBookMap.isEmpty()) {
            System.out.println("No address books available.");
        } else {
            System.out.println("Available address books:");
            for (String name : addressBookMap.keySet()) {
                System.out.println(name);
            }
        }
    }

    public boolean addressBookExists(String name) {
        return addressBookMap.containsKey(name);
    }

    public List<Contact> searchPersonsInCityAcrossBooks(String city) {
        return addressBookMap.values().stream()
                .flatMap(ab -> ab.searchContactsByCity(city).stream())
                .collect(Collectors.toList());
    }

    public List<Contact> searchPersonsInStateAcrossBooks(String state) {
        return addressBookMap.values().stream()
                .flatMap(ab -> ab.searchContactsByState(state).stream())
                .collect(Collectors.toList());
    }

}
