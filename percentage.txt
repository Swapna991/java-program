import java.util.Scanner;
class percentage
{
public static void main(String args[])
{
float a,b,c,d,total,per=1;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of C & C++(TH&PR)");
a=sc.nextFloat();
System.out.println("Enter the number of Architecture(TH&PR)");
b=sc.nextFloat();
System.out.println("Enter the number of GE(TH&PR)");
c=sc.nextFloat();
System.out.println("Enter the number of AECC");
d=sc.nextFloat();
total=a+b+c+d;
per=total/350*100;
System.out.println("The percentage of the Student is:"+per);
}
}