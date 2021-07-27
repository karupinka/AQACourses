public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        String apple = "Apple";
        String banana = "Banana";
        String orange = "Orange";

        System.out.println(orange);
        System.out.println(banana);
        System.out.println(apple);
    }

    public static void checkSumSign() {
        int a = 1;
        int b = 3;
        int sum = a + b;

        if(sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 3;
        String resultString = a >= b ? "a >= b" : "a < b";

        System.out.println(resultString);
    }
}
