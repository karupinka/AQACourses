import fruit.*;
import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruitsBox;
    private float weight;

    public Box(){
        fruitsBox = new ArrayList<T>();
        weight = 0;
    }

    public void abbFruit(T fruit) {
        fruitsBox.add(fruit);
        countWeight();
    }

    public void removeFruit() {
        if (fruitsBox.size() > 0) {
            fruitsBox.remove(fruitsBox.size() - 1);
            countWeight();
        }
    }

    public void abbFruit(List<T> fruits) {
        this.fruitsBox.addAll(fruits);
        countWeight();
    }

    private void countWeight() {
        if (fruitsBox.isEmpty()) {
            weight = 0;
        } else {
            weight = fruitsBox.size() * fruitsBox.get(0).getWeight();
        }
    }

    public boolean compare(Box anotherBox) {
        boolean isEqualsWeight = false;
        if(anotherBox.getWeight() == weight)
            isEqualsWeight = true;

        return  isEqualsWeight;
    }

    public void addBoxFromBox(Box<? extends T> anotherBox) {
         abbFruit((List<T>) anotherBox.getFruitsBox());
         anotherBox.clearBox();
    }

    public float getWeight() {
        countWeight();
        return weight;
    }

    public List<T> getFruitsBox() {
        return fruitsBox;
    }

    public void clearBox() {
        fruitsBox.clear();
        weight = 0;
    }
}
