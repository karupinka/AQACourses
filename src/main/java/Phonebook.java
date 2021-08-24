import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<String, ArrayList<String>> phonebookMap;

    public Phonebook() {
        phonebookMap = new HashMap<>();
    }

    public void add(String secondName, String phoneNumber) {
        if (!phonebookMap.containsKey(secondName)) {
            ArrayList<String> phoneList = new ArrayList<String>();
            phoneList.add(phoneNumber);
            phonebookMap.put(secondName, phoneList);
        } else {
            if (!phonebookMap.get(secondName).contains(phoneNumber)) {
                phonebookMap.get(secondName).add(phoneNumber);
            }
        }
    }

    public String get(String secondName) {
        int countOfSize = phonebookMap.containsKey(secondName) ? phonebookMap.get(secondName).size() : 0;
        String phoneList = phonebookMap.get(secondName) == null ? "[]" : phonebookMap.get(secondName).toString();
        return "Count of people with number: " + countOfSize
                + "\n" + phoneList;
    }
}
