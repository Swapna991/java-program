import java.util.scanner;
class productofdigit
{
 public static void main(String args[])
{
  int n,r,temp;
  int product=1;
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter any number:");
  n=sc.nextInt();
  tem=n;
  while(temp!=0)
   {
    r=temp%10;
    product=product*r;
    temp=temp/10;
   }
 System.out.println("Product of digit="+product);
}
}