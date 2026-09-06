import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 617 555 0102"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 617 555 0103"));
        contacts.put("Katherine Johnson", new Contact("Katherine Johnson", "+1 617 555 0104"));

        System.out.println("Contacts stored: " + contacts.size());
        System.out.println();

        // Step 5: look up a contact
        lookUp(contacts, "Grace Hopper");
        lookUp(contacts, "Marie Curie");
        System.out.println();

        // Step 6: print sorted list
        printSorted(contacts);
    }

    // Prints the contact stored under the given name, or a message if there is none
    public static void lookUp(HashMap<String, Contact> contacts, String name) {
        Contact found = contacts.get(name);

        if (found == null) {
            System.out.println("No contact found for: " + name);
        } else {
            System.out.println("Found: " + found);
        }
    }

    // Prints every contact, sorted alphabetically by name
    public static void printSorted(HashMap<String, Contact> contacts) {
        ArrayList<String> names = new ArrayList<>(contacts.keySet());
        Collections.sort(names);

        System.out.println("=== All Contacts (sorted) ===");
        for (String name : names) {
            System.out.println(contacts.get(name));
        }
    }
}
