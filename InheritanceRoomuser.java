import java.util.Scanner;
class RoomUser 
{
 int length,breadth;
 Roomuser(int x, int y)
 {
 length=x;
 breadth=y;
 }
 
 void roomArea()
 
 {
 int area;
 area=length*breadth;
 System.out.println("Area of the Room: "+area);
 }
 
}
class Bedroom extends Roomuser
{
 int height;
 Bedroom(int l,int b,int h)
 {
 super(l,b);
 height=h;
 }
 void roomVolume()
 
 {
 int volume;
 volume=length*breadth*height;
 System.out.println("Volume of the Room: "+volume);
 }
}
public class InheritanceRoomuser {
 public static void main(String x[])
 {
 int l,b,h;
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the length of the Room:");
 l=sc.nextInt();
 System.out.println("Enter the breadth of the Room:");
 b=sc.nextInt();
 System.out.println("Enter the height of the Room:");54
 h=sc.nextInt();
 Bedroom br=new Bedroom(l,b,h);
 br.roomArea();
 br.roomVolume();
 }
 
}

