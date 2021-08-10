import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> box;
    private float weight;

    public Box(){
        box = new ArrayList<T>();
        weight = 0;
    }

    public void abbFruit(T fruit) {
        box.add(fruit);
        countWeight();
    }

    public void removeFruit(T fruit) {
        box.remove(fruit);
        countWeight();
    }

    public void abbFruit(List<T> fruits) {
        box.addAll(fruits);
        countWeight();
    }

    private void countWeight() {
        if (box.isEmpty()) {
            weight = 0;
        } else {
            if (box.get(0) instanceof Apple) {
                weight = box.size() * 1.0f;
            } else if (box.get(0) instanceof Orange) {
                weight = box.size() * 1.5f;
            }
        }
    }

    public boolean compare(Box anotherBox) {
        boolean isEqualsWeight = false;
        if(anotherBox.getWeight() == weight)
            isEqualsWeight = true;

        return  isEqualsWeight;
    }

    public void addBoxFromBox(Box anotherBox) {
        if (!anotherBox.getBox().isEmpty() &&
                !box.isEmpty() &&
                box.get(0).getClass().equals(anotherBox.getBox().get(0).getClass())) {
            abbFruit(anotherBox.getBox());
            anotherBox.clearBox();
        }
    }

    public float getWeight() {
        countWeight();
        return weight;
    }

    public List<T> getBox() {
        return box;
    }

    public void clearBox() {
        box.clear();
        weight = 0;
    }
}
