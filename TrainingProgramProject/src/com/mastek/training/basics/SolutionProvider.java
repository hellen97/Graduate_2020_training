package com.mastek.training.basics;
//import java.util.Scanner; 

public class SolutionProvider {
 	
	public static int getMaxNumber (int num1,int num2) 		
	
	{															// declare inputs as parameter 
		int max=0;											 	// declare output as local variable 
		if (num1>num2) {
			max=num1;
	}	else {
			max=num2;
			 }
		return max;											 	// return the result to the caller 
	}
	

}

//static class AreaOfRectangle {
//public static void main (String[] args)
//{
//scanner = new Scanner(System.in);
// System.out.println("Enter the length of Rectangle:");
// double length = scanner.nextDouble();
// System.out.println("Enter the width of Rectangle:");
// double width = scanner.nextDouble();
// Area = length*width;
// double area = length*width;
// System.out.println("Area of Rectangle is:"+area);
//}
//}
		  



//  public static void main(String[] args) 
//{ 
//    int dividend = 111, divisor = 10; 
//    int quotient = dividend / divisor; 
//    int remainder = dividend % divisor; 


//    System.out.println("The Quotient is = " + quotient); 
//    System.out.println("The Remainder is = " + remainder); 
//} 



//class SpeedDistanceTime
//{ 
    // Function to calculate speed 
//    static double speed(double dist, double time) 
//    { 
//        System.out.print("\n Distance(km) : " + dist) ; 
//        System.out.print("\n Time(hr) : " + time) ; 
//                  
//        return dist / time; 
//    } 
//
    // Function to calculate distance traveled 
//    static double dis(double speed, double time) 
//    { 
//        System.out.print("\n Time(hr) : " + time) ; 
//        System.out.print("\n Speed(km / hr) : " + speed) ; 
//                  
//        return speed * time; 
//    } 
//      
//    // Function to calculate time taken 
//    static double cal_time(double dist, double speed) 
//    { 
//        System.out.print("\n Distance(km) : "+ dist) ; 
//       System.out.print("\n Speed(km / hr) : " + speed) ; 
//                  
//        return speed * dist ; 
//    } 
//}



// class Calculating circle 
//{
//   static Scanner sc = new Scanner(System.in);
//   public static void main(String args[])
//   {
//      System.out.print("Enter the radius: ");
      /*We are storing the entered radius in double
       * because a user can enter radius in decimals
       */
//      double radius = sc.nextDouble();
      //Area = PI*radius*radius
//      double area = Math.PI * (radius * radius);
//      System.out.println("The area of circle is: " + area);
      //Circumference = 2*PI*radius
//      double circumference= Math.PI * 2*radius;
//      System.out.println( "The circumference of the circle is:"+circumference) ;
//   }



//import java.util.Scanner;
//public class multiplication {

//   public static void main(String[] args)

//{
//   int j,n;

//   System.out.print("Input the number(Table to be calculated): ");
//{
//   System.out.print("Input number of terms : ");
//    Scanner in = new Scanner(System.in);
//		    n = in.nextInt();

//   System.out.println ("\n");
//   for(j=0;j<=n;j++)
//  
//     System.out.println(n+" X "+j+" = " +n*j);
//   }
//}
//}



//import java.util.Scanner;
//public class SmallestNumber {

//public static void main(String[] args)
//   {
//       Scanner in = new Scanner(System.in);
//       System.out.print("Input the first number: ");
//        double num1 = in.nextDouble();
//        System.out.print("Input the Second number: ");
//        double num2 = in.nextDouble();
//        System.out.print("Input the third number: ");
//        double num3 = in.nextDouble();
//        System.out.print("The smallest value is " + smallest(num1, num2, num3)+"\n" );
//    }


//import java.util.Scanner;

//public class StudentAverageGrade
//{
//    public static void main(String args[])
//    {
    
//        int marks[] = new int[6];
//        int g;
//        float total=0, avg;
//        Scanner scanner = new Scanner(System.in);
		
        
//        for(g=0; g<6; g++) { 
//           System.out.print("Enter Marks of Subject"+(g+1)+":");
//           marks[i] = scanner.nextInt();
//           total = total + marks[g];
//        }
//        scanner.close();
//		  Calculating average here
//		  avg = total/6;
//        System.out.print("The student Grade is: ");
//        if(avg>=90)
//        {
//            System.out.print("A");
//       }
//        else if(avg>=80 && avg<90)
//        {
//           System.out.print("B");
//        } 
//        else if(avg>=80 && avg<55)
//        {
//            System.out.print("C");
//        }
//        else
//        {
//            System.out.print("D");
//        }
//    }
// }



	


