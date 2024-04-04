abstract class Shape {
  abstract double getArea();

  abstract void printDetails();

  protected String color;

  String getColor() {
    return color;
  }

  Shape(String color) {
    this.color = color;
  }

  abstract void resize(double factor);
}

class Square extends Shape {
  private double sideLength;

  Square(double sideLength, String color) {
    super(color);
    this.sideLength = sideLength;
  }

  @Override
  double getArea() {
    return sideLength * sideLength;
  }

  @Override
  void printDetails() {
    System.out.println("Shape: Square");
    System.out.println("Color: " + getColor());
    System.out.println("Side length: " + this.sideLength);
    System.out.println("Area: " + getArea());
    System.out.println("----------------------");
  }

  @Override
  void resize(double factor) {
    this.sideLength *= factor;
  }
}

class Rectangle extends Shape {
  private double width, height;

  Rectangle(double w, double h, String color) {
    super(color);
    width = w;
    height = h;
  }

  @Override
  double getArea() {
    return width * height;
  }

  @Override
  void printDetails() {
    System.out.println("Shape: Rectangle");
    System.out.println("Color: " + getColor());
    System.out.println("Width: " + this.width);
    System.out.println("Height: " + this.height);
    System.out.println("Area: " + getArea());
    System.out.println("----------------------");
  }

  @Override
  void resize(double factor) {
    this.width *= factor;
    this.height *= factor;
  }
}

class Circle extends Shape {
  private double radius;

  Circle(double radius, String color) {
    super(color);
    this.radius = radius;
  }

  @Override
  double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  void printDetails() {
    System.out.println("Shape: Rectangle");
    System.out.println("Color: " + getColor());
    System.out.println("Width: " + this.radius);
    System.out.println("Area: " + getArea());
    System.out.println("----------------------");
  }

  @Override
  void resize(double factor) {
    this.radius *= factor;
  }
}

public class Lab4 {

  public static void main(String[] args) {
    Shape[] shapes = {
        new Square(5.0, "Red"),
        new Square(3.0, "Blue"),
        new Rectangle(4.0, 6.0, "Green"),
        new Rectangle(2.0, 8.0, "Yellow"),
        new Circle(7.0, "Orange")
    };

    for (Shape shape : shapes) {
      shape.printDetails();
    }
  }
}