import java.util.Scanner;
class positiveornegative
{
public static void main(String args[])
{
int num;
Scanner sc=new Scanner(System.in);
System.out.println("Enter a Number");
num=sc.nextInt();
if(num>0)
System.out.println("is a Positive number"+num);
else
System.out.println("is a Negative number"+num);
}
}