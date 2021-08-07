public class Circle implements ShapeCircle{
    public String color;
    public String borderColor;

    @Override
    public double getCircleArea(double radius) throws IllegalArgumentException {
        return ShapeCircle.super.getCircleArea(radius);
    }

    @Override
    public double getCirclePerimeter(double radius) throws IllegalArgumentException {
        return ShapeCircle.super.getCirclePerimeter(radius);
    }

    @Override
    public void printCircleArea(double radius) throws IllegalArgumentException {
        ShapeCircle.super.printCircleArea(radius);
    }

    @Override
    public void printCirclePerimeter(double radius) throws IllegalArgumentException {
        ShapeCircle.super.printCirclePerimeter(radius);
    }

    public Circle() {
        color = "No color";
        borderColor = "No color";
    }

    public Circle(String color, String borderColor) {
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }
}
