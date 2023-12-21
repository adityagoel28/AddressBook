package AddressBook;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program!");

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while(true){
            System.out.println("Choose an option: ");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Quit");
            String option = sc.nextLine();

            switch(option){
                case "1":
                    addressBook.addContact(sc);
                    break;
                case "2":
                    addressBook.editContact(sc);
                    break;
                case "3":
                    addressBook.deleteContact(sc);
                    break;
                case "4":
                    addressBook.displayAllContacts();
                    break;
                case "5":
                    System.out.println("Exiting Address Book Program");
                    return;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 5.");
            }
        }
    }
}