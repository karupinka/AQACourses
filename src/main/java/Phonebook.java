import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<Integer, ArrayList<String>> phonebookMap;

    public Phonebook() {
        phonebookMap = new HashMap<>();
    }

    public void add(String secondName, String phoneNumber) {
        Integer id = phonebookMap.size() + 1;
        ArrayList<String> arrayListPhone = new ArrayList<>();
        arrayListPhone.add(secondName);
        arrayListPhone.add(phoneNumber);
        if (!phonebookMap.containsValue(arrayListPhone)) {
            phonebookMap.put(id, arrayListPhone);
        }
    }

    public String get(String secondName) {
        List<String> phones = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<String>> map: phonebookMap.entrySet()) {
            if (map.getValue().size() == 2) {
                if (map.getValue().get(0) == secondName) {
                        phones.add(map.getValue().get(1));
                }
            }
        }

        return "Count of people with number: " + phones.size()
                + "\n" + phones.toString();
    }
}
