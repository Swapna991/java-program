import java.util.Scanner;
public class Fibonacci
 {
  
    public static void main(String[] args) 
    {
     
         int n, f0 = 0,f1= 1,sum;
          
            System.out.println("Enter number of teram:");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            System.out.print("The first " + n + " Fibonacci numbers are: ");
            System.out.print(f0 + " " + f1);
            for (int i = 1; i<=n-2; ++i)
            {
                 sum = f0 + f1;
                f0 = f1;
                f1 = sum;
                System.out.print(" " + sum);
            }
  
    }
  }