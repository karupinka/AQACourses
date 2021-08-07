public class Dog extends Animal{
    static int countOfDogs = 0;

    public Dog(String name) {
        super(name);
        countOfDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance >= 0 && distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(String.format("Собака - %s не может пробежать %d м.", name, distance));
        }
    }

    @Override
    public void swim(int distance) {
        if (distance >= 0 && distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(String.format("Собака - %s не может проплыть %d м.", name, distance));
        }
    }
}
