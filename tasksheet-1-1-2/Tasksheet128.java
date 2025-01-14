interface Shape{
    double calculateArea();
    double calculatePerimeter();
}
abstract class AbstractShape implements Shape{
    protected String color;
    protected double length;
    protected double width;

    AbstractShape(String color, double length, double width){
        this.color = color;
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea(){return length * width;}
    public double calculatePerimeter(){return 2 * (length + width);}
}
class Circle extends AbstractShape{
    private double radius;

    public Circle(String color, double radius){
        super(color, 0, 0);
        this.radius = radius;
    }
    @Override
    public double calculateArea(){return Math.PI * radius * radius;}
    public double calculatePerimeter(){return 2 * Math.PI * radius;}
}
class Rectangle extends AbstractShape{
    Rectangle(String color, double length, double width){
        super(color, length, width);
    }  
}
public class Tasksheet128 {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5);

        System.out.println("Circle: ");
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());

        Rectangle rectangle = new Rectangle("Blue", 5, 6);

        System.out.println("\nRetangle: ");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    } 
}
