package catPlate;

public class CatPlate {
    private String name;
    private int appetite;
    private boolean isFull;

    public CatPlate(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate p) {
        if (p.getFood() - appetite >= 0) {
            p.decreaseFood(appetite);
            appetite = 0;
            isFull = true;
        }
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void info() {
        System.out.println(String.format("Cat %s full = %b, appetite = %d", name, isFull, appetite));
    }

    public void increaseAppetite(int appetite) {
        if (appetite >= 0) {
            this.appetite += appetite;
            isFull = false;
        }
    }
}
