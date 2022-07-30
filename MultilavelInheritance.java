import java.util.Scanner;

class A {  
void add (int a , int b)
{
	System.out.println("addition="+(a+b));}  
}  
class B extends A{  
void sub(int a ,int b)
{
	System.out.println("subtaraction= "+(a-b));}  
}  
class C extends B{  
void MUL(int a,int b)
{
	System.out.println("multiplication="+(a*b));  
}  
class MultilavelInheritance{  
public void main(String args[])
{
	int a,b;
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter First Number");
	a=sc.nextInt();
	System.out.println("Enter Second Number");
	b=sc.nextInt();
	C aa=new C();
	aa.MUL(a, b);
	aa.sub(a , b);
	aa.add(a, b);
	}
}
}