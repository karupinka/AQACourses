import fruit.*;

public class HomeTaskMain {
    public static void main(String[] args) {
        // Task 1 solution
        Integer[] array = new Integer[]{1, 2, 3};
        try {
            swapArraysItems(array, 0, 1);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Массив не содержит индекс");
        }

        for (Integer integer: array) {
            System.out.println(integer);
        }

        // Task 2 solution checks
        Box<Orange> orangeBox1 = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        for (int i = 0; i < 10; i++) {
            orangeBox1.abbFruit(new Orange());
            orangeBox2.abbFruit(new Orange());
        }

        for (int i = 0; i < 15; i++) {
            appleBox1.abbFruit(new Apple());
            appleBox2.abbFruit(new Apple());
        }

        System.out.println(orangeBox1.getWeight());
        System.out.println(orangeBox2.getWeight());

        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox1.compare(appleBox1));
        orangeBox1.addBoxFromBox(appleBox1);
        orangeBox1.addBoxFromBox(orangeBox2);

        System.out.println(orangeBox1.compare(orangeBox2));
        appleBox2.removeFruit();
    }

    public static <T> void swapArraysItems(T[] array, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
        if (firstIndex < 0 || firstIndex >= array.length || secondIndex < 0 || secondIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Массив не содержит индекс");
        } else {
            T tmp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = tmp;
        }
    }
}
