public class Triangle implements ShapeTriangle {
    public String color;
    public String borderColor;

    public Triangle() {
        color = "No color";
        borderColor = "No color";
    }

    public Triangle(String color, String borderColor) {
        this.color = color;
        this.borderColor = borderColor;
    }

    @Override
    public double getTriangleArea(double base, double height) throws IllegalArgumentException {
        return ShapeTriangle.super.getTriangleArea(base, height);
    }

    @Override
    public double getTrianglePerimeter(double firstSide, double secondSide, double thirdSide) throws IllegalArgumentException {
        return ShapeTriangle.super.getTrianglePerimeter(firstSide, secondSide, thirdSide);
    }

    @Override
    public void printTriangleArea(double base, double height) throws IllegalArgumentException {
        ShapeTriangle.super.printTriangleArea(base, height);
    }

    @Override
    public void printTrianglePerimeter(double firstSide, double secondSide, double thirdSide) throws IllegalArgumentException {
        ShapeTriangle.super.printTrianglePerimeter(firstSide, secondSide, thirdSide);
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
