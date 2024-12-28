public class Tasksheet120 {
    
    public static int cumulativeSum(int ...numbers){
        int totalSum = 0;
    
        for (int num : numbers) {
            int sum = num * (num + 1) / 2;
            System.out.println("Cumulative Sum for " + num +" = "+ sum);
            totalSum += sum;
        }
    
        return totalSum;
    
    }
    public static void main(String[] args) {
    
        int sum = cumulativeSum(4, 5, 10);
        System.out.println("Total sum: " + sum);
            
    }
    
}
