public interface Shape {
    public String getColor();
    public void setColor(String color);
    public String getBorderColor();
    public void setBorderColor(String borderColor);
}

interface ShapeCircle extends Shape {

    public default double getCircleArea(double radius) throws IllegalArgumentException {
        if (radius < 0) throw new IllegalArgumentException("Only Positive Numbers");
        return Math.PI * radius * radius;
    }

    public default double getCirclePerimeter(double radius) throws IllegalArgumentException {
        if (radius < 0) throw new IllegalArgumentException("Only Positive Numbers");
        return 2 * Math.PI * radius;
    }

    public default void printCircleArea(double radius) throws IllegalArgumentException {
        System.out.println("Circle Area - " + getCircleArea(radius));
    }

    public default void printCirclePerimeter(double radius) throws IllegalArgumentException {
        System.out.println("Circle Perimeter - " + getCirclePerimeter(radius));
    }
}

interface ShapeRectangle extends Shape {

    public default double getRectangleArea(double weight, double length) throws IllegalArgumentException {
        if (weight < 0 || length < 0) throw new IllegalArgumentException("Only Positive Numbers");
        return weight * length;
    }

    public default double getRectanglePerimeter(double weight, double length) throws IllegalArgumentException {
        if (weight < 0 || length < 0) throw new IllegalArgumentException("Only Positive Numbers");
        return (2 * weight + length * 2);
    }

    public default void printRectangleArea(double weight, double length) throws IllegalArgumentException {
        System.out.println("Rectangle Area - " + getRectangleArea(weight, length));
    }

    public default void printRectanglePerimeter(double weight, double length) throws IllegalArgumentException {
        System.out.println("Rectangle Perimeter - " + getRectanglePerimeter(weight, length));
    }
}

interface ShapeTriangle extends Shape {

    public default double getTriangleArea(double base, double height) throws IllegalArgumentException {
        if (base < 0 || height < 0) throw new IllegalArgumentException("Only Positive Numbers");

        return base * height / 2;
    }

    public default double getTrianglePerimeter(double firstSide, double secondSide, double thirdSide) throws IllegalArgumentException {
        if (firstSide < 0 || secondSide < 0 || thirdSide < 0) throw new IllegalArgumentException("Only Positive Numbers");

        return firstSide + secondSide + thirdSide;
    }


    public default void printTriangleArea(double base, double height) throws IllegalArgumentException {
        System.out.println("Triangle Area - " + getTriangleArea(base, height));
    }

    public default void printTrianglePerimeter(double firstSide, double secondSide, double thirdSide) throws IllegalArgumentException {

        System.out.println("Triangle Perimeter - " + getTrianglePerimeter(firstSide, secondSide, thirdSide));
    }
}
