public class Cat extends Animal{
    static int countOfDogs = 0;

    public Cat(String name) {
        super(name);
        countOfDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance >= 0 && distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(String.format("Кот - %s не может пробежать %d м.", name, distance));
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }
}
