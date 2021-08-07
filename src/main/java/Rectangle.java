public class Rectangle implements ShapeRectangle {
    public String color;
    public String borderColor;

    public Rectangle() {
        color = "No color";
        borderColor = "No color";
    }

    public Rectangle(String color, String borderColor) {
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

    @Override
    public double getRectangleArea(double weight, double length) throws IllegalArgumentException {
        return ShapeRectangle.super.getRectangleArea(weight, length);
    }

    @Override
    public double getRectanglePerimeter(double weight, double length) throws IllegalArgumentException {
        return ShapeRectangle.super.getRectanglePerimeter(weight, length);
    }

    @Override
    public void printRectangleArea(double weight, double length) throws IllegalArgumentException {
        ShapeRectangle.super.printRectangleArea(weight, length);
    }

    @Override
    public void printRectanglePerimeter(double weight, double length) throws IllegalArgumentException {
        ShapeRectangle.super.printRectanglePerimeter(weight, length);
    }
}
