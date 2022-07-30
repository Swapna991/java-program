import java.util.*;
class Rectangle
{
   int area, length, breadth; 
   Rectangle() 
   { 
      length = 50; 
      breadth = 20; 
   } 
   void getArea() 
   { 
      area = length * breadth; 
      System.out.println("Area of Rectangle : " + area); 
   }  
}
public class consRectangle
{
   public static void main(String[] args) 
   {
      Rectangle rs = new Rectangle(); 
      rs.getArea();
   }
}