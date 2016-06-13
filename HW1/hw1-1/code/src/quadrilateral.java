/**
 * @(#)quadrilateral.java
 *
 */

import java.io.*;
import java.util.Scanner;


public class quadrilateral {

    public static void main(String[] argv) {
    	float a, b, c, d, p;

    	System.out.print("Input: ");
		Scanner in =new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		p = in.nextInt();

        check(a, b, c, d, p);

    }

    public static int check(float a, float b, float c, float d, float p){

    	if (a<1 || a>100 || b<1 || b>100 || c<1 || c>100 || d<1 || d>100 || p<=0 || p>90)
    		System.out.println("Wrong input.");
		else
			partition(a, b, c, d, p);
		return 0;
    }

    public static int partition(float a, float b, float c, float d, float p) {

		if(p==90){
			if(a==c && b==d && b==c)
				System.out.println("This is a square.");
			else if(a==c && b==d)
				System.out.println("This is a rhombus.");
			else if(a==c||b==d)
				System.out.println("This is a harrier-shaped.");
			else if(a*d == b*c)
				System.out.println("This is a trapezium.");
			else
				System.out.println("This is a quadrilateral.");

		}else{
			if(a==c && b==d && b==c)
				System.out.println("This is a rectangle.");
			else if(a==c && b==d)
				System.out.println("This is a parallelogram.");
			else if(a*d == b*c)
				System.out.println("This is a trapezium.");
			else
				System.out.println("This is a quadrilateral.");
		}
        return 0;
    }
}