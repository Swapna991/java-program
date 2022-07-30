import java.util.Scanner;

public class pyramid
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

	        System.out.println("Enter number of line:");

		int noOfRows = sc.nextInt();

               int rowCount = 1;

		System.out.println(" ");

		for (int i = noOfRows; i > 0; i--)
		{
			
                    for (int j = 1; j <= i; j++)
			{
				System.out.print(" ");
			}

			for (int j = 1; j <= rowCount; j++)
			{
				System.out.print(j+" ");
			}

			System.out.println();

			rowCount++;
		}
	}
}