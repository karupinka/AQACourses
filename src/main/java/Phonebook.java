import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<Integer, String> phoneIdMap;
    Map<Integer, String> idSecondNameMap;

    public Phonebook() {
        phoneIdMap = new HashMap<>();
        idSecondNameMap = new HashMap<>();
    }

    public void add(String secondName, String phoneNumber) {
        Integer id = phoneIdMap.size() + 1;
        phoneIdMap.put(id, phoneNumber);
        idSecondNameMap.put(id, secondName);
    }

    public ArrayList<String> get(String secondName) {
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        if (idSecondNameMap.containsValue(secondName)) {
            for (Map.Entry<Integer, String> map : idSecondNameMap.entrySet()) {
                if (map.getValue() == secondName) {
                    ids.add(map.getKey());
                }
            }

            for (Integer id : ids) {
                phones.add(phoneIdMap.get(id));
            }
        }
        return phones;
    }
}
