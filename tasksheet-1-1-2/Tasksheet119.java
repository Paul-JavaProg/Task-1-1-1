import java.util.Scanner;
public class Tasksheet119 {

    public static double Add(double num1, double num2){
        return num1 + num2;
    }
    public static double Subtract(double num1, double num2){
        return num1 - num2;
    }
    public static double Multiply(double num1, double num2){
        return num1 * num2;
    }
    public static String Division(double num1, double num2){
        if (num2 == 0) {
            return "Error! Division by zero is not allowed.";
        }
        return String.valueOf(num1 / num2);
    }
    

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        double num1 = scan.nextDouble();
        System.out.print("Enter Second Number: ");
        double num2 = scan.nextDouble();

        double sum = Add(num1,num2);
        double diff = Subtract(num1, num2);
        double prod = Multiply(num1, num2);
        String quo = Division(num1, num2);

        System.out.println("-------------------------");
        System.out.println("The Sum is: " +  sum);
        System.out.println("The Difference is: " + diff);
        System.out.println("The Product is: " + prod);
        System.out.println("The Quotient is: " +  quo);

        scan.close();
    }
    
}
