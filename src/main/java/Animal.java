public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        System.out.println(String.format("%s пробежал %d м.", name, distance));
    }

    public void swim(int distance) {
        System.out.println(String.format("%s проплыл %d м.", name, distance));
    }
}
