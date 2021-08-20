import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HomeMainApp {
    public static void main(String[] args) {
        // Task 1 solution
        String[] stringArray = {"One", "Two", "Three", "Four", "Five", "One", "Two", "Three", "Four", "Five"};
        Set<String> stringSet = new HashSet<>();
        Collections.addAll(stringSet, stringArray);
        for (String str: stringSet) {
            System.out.print(str + "; ");
        }

        System.out.println();

        // Task 2 solution
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "+79817890000");
        phonebook.add("Ivanov", "+79817890001");
        phonebook.add("Petrov", "+79817890056");
        phonebook.add("Sidorov", "+79817890066");

        System.out.println(phonebook.get("Ivanov"));
        System.out.println(phonebook.get("Kirov"));
        System.out.println(phonebook.get("Sidorov"));
    }
}
