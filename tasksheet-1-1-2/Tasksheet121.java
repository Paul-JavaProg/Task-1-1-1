import static java.lang.Math.*;
import java.util.Scanner;

public class Tasksheet121 {
     public static int Add(int num1, int num2){
        return addExact(num1, num2);
    }
    public static int Subtract(int num1, int num2){
        return subtractExact(num1, num2);
    }
    public static int Multiply(int num1, int num2){
        return multiplyExact(num1, num2);
    }
    public static int Division(int num1, int num2){
        return floorDiv(num1, num2);
    }
    

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int num1 = scan.nextInt();
        System.out.print("Enter Second Number: ");
        int num2 = scan.nextInt();

        double sum = Add(num1,num2);
        double diff = Subtract(num1, num2);
        double prod = Multiply(num1, num2);
        int quo = Division(num1, num2);

        System.out.println("-------------------------");
        System.out.println("The Sum is: " +  sum);
        System.out.println("The Difference is: " + diff);
        System.out.println("The Product is: " + prod);
        System.out.println("The Quotient is: " +  quo);

        scan.close();
    }
}
