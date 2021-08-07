import catPlate.CatPlate;
import catPlate.Plate;

import java.io.IOException;

public class HomeTaskMain {

    public static void main(String[] args) {
        //Task 1-4 check
        Dog dog1 = new Dog("Bobik");
        dog1.run(600);
        dog1.run(-100);
        dog1.run(200);
        dog1.swim(200);
        dog1.run(10);
        Dog dog2 = new Dog("Druzhok");



        System.out.println(Dog.countOfDogs);
        Cat cat1 = new Cat("Murzik");
        cat1.run(600);
        cat1.run(-100);
        cat1.run(200);
        cat1.swim(100);
        System.out.println(Cat.countOfDogs);

        //Task 5
        Plate plate = new Plate(300);
        CatPlate[] catPlates = new CatPlate[] {new CatPlate("Barsik", 20),
                new CatPlate("Murzik", 500),
                new CatPlate("Toshka", 30)};
        for (CatPlate catPlate: catPlates) {
            catPlate.info();
            catPlate.eat(plate);
            catPlate.info();
        }
        plate.info();
        plate.increaseFood(500);
        plate.info();

        //Task 6 check
        Payment payment = new Payment();
        payment.addProduct(payment.new Product("Cheese", 23.45));
        try {
            payment.addProduct();
        } catch (Exception exception) {
            System.out.println("Smthg went wrong");
        }
        System.out.println(payment.getCartPrice());



        //Task 7 check
        Park park1 = new Park();
        park1.addAttraction(park1.new Attraction("Roller coaster", 25.0, 12));
        System.out.println(park1.attractions.get(0).getName());

        //Task 8 check
        Circle circle = new Circle("Red", "Green");
        circle.printCircleArea(5);
        circle.printCirclePerimeter(6);
        Rectangle rectangle = new Rectangle("Green", "Yellow");
        rectangle.printRectangleArea(8,7);
        rectangle.printRectanglePerimeter(5, 6);
        Triangle triangle = new Triangle("Red", "Green");
        triangle.printTriangleArea(6, 8);
        triangle.printTrianglePerimeter(5,5,5);
    }
}
