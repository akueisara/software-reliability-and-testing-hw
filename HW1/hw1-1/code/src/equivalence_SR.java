/**
 * @(#)equivalence_SR.java
 *
 */
import java.util.Scanner;

public class equivalence_SR {

    public static void main(String[] argv){
    	int a,b,c,d,p;
    	int str[][]=new int[32][5];
    	int strSR[] = new int[5];
		int quotient;
		int over = 0;

		int stra[]=new int[5];
		int i;


		quadrilateral input = new quadrilateral();

//a=b=c=d (square or rectangle)
		stra[0]=stra[1]=stra[2]=stra[3]=(int)(1+Math.random()*99);
		stra[4]=90;
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

		stra[0]=stra[1]=stra[2]=stra[3]=(int)(1+Math.random()*99);
		stra[4]=(int)(1+Math.random()*88);
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

//a=c,b=d,b!=c (rhombus or parallelogram)
		stra[0]=stra[2]=(int)(1+Math.random()*99);
		do{
			stra[1]=stra[3]=(int)(1+Math.random()*99);
		}while(stra[1]==stra[2]);
		stra[4]=90;
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

		stra[0]=stra[2]=(int)(1+Math.random()*99);
		do{
			stra[1]=stra[3]=(int)(1+Math.random()*99);
		}while(stra[1]==stra[2]);
		stra[4]=(int)(1+Math.random()*88);
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

//a=c || b=d (harrier-shaped or quadrilateral)
		i=(int)(Math.random()*10%2);
		stra[4]=90;
		if(i==0){
			stra[0]=stra[2]=(int)(1+Math.random()*99);
			stra[1]=(int)(1+Math.random()*99);
			do{
				stra[3]=(int)(1+Math.random()*99);
			}while(stra[1]==stra[3]);
			System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
			input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
		}
		else{
			stra[1]=stra[3]=(int)(1+Math.random()*99);
			stra[0]=(int)(1+Math.random()*99);
			do{
				stra[2]=(int)(1+Math.random()*99);
			}while(stra[0]==stra[2]);
			System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
			input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
		}

		stra[4]=(int)(1+Math.random()*88);
		if(i==0){
			stra[0]=stra[2]=(int)(1+Math.random()*99);
			stra[1]=(int)(1+Math.random()*99);
			do{
				stra[3]=(int)(1+Math.random()*99);
			}while(stra[1]==stra[3]);
			System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
			input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
		}
		else{
			stra[1]=stra[3]=(int)(1+Math.random()*99);
			stra[0]=(int)(1+Math.random()*99);
			do{
				stra[2]=(int)(1+Math.random()*99);
			}while(stra[0]==stra[2]);
			System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
			input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
		}


//(a+c)*d=(b+d)*c => ad=bc (trapezium)
		do{
			stra[0]=(int)(1+Math.random()*99);
			stra[1]=(int)(1+Math.random()*99);
			stra[2]=(int)(1+Math.random()*99);
			stra[3]=(int)(1+Math.random()*99);
		}while(stra[0]*stra[3]!=stra[1]*stra[2]||stra[0]==stra[2]);
		stra[4]=90;
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

		do{
			stra[0]=(int)(1+Math.random()*99);
			stra[1]=(int)(1+Math.random()*99);
			stra[2]=(int)(1+Math.random()*99);
			stra[3]=(int)(1+Math.random()*99);
		}while(stra[0]*stra[3]!=stra[1]*stra[2]||stra[0]==stra[2]);
		stra[4]=(int)(1+Math.random()*88);
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

//others (quadrilateral)
		do{
			stra[0]=(int)(1+Math.random()*99);
			stra[1]=(int)(1+Math.random()*99);
			stra[2]=(int)(1+Math.random()*99);
			stra[3]=(int)(1+Math.random()*99);
		}while(stra[0]==stra[2]||stra[1]==stra[3]||stra[0]==stra[1]||stra[0]*stra[3]==stra[1]*stra[2]);
		stra[4]=90;
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

		do{
			stra[0]=(int)(1+Math.random()*99);
			stra[1]=(int)(1+Math.random()*99);
			stra[2]=(int)(1+Math.random()*99);
			stra[3]=(int)(1+Math.random()*99);
		}while(stra[0]==stra[2]||stra[1]==stra[3]||stra[0]==stra[1]||stra[0]*stra[3]==stra[1]*stra[2]);
		stra[4]=(int)(1+Math.random()*88);
		System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
		input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);


//@@@@@@@@@@@@@@@out of range@@@@@@@@@@@@@@@@
		for(i=0;i<32;i++){
			quotient = i;
			int j=4;
			do{
				over = quotient % 2;
				quotient /= 2;
				str[i][j]=over;
				j--;
			}while(quotient > 0);
//		System.out.println(str[i][0]+","+str[i][1]+","+str[i][2]+","+str[i][3]+","+str[i][4]);
		}

//Below
		System.out.println();
 		System.out.println("Below:");
		for(i=0; i<32; i++){
			for(int j=0; j<5;j++){
				if(str[i][j]==0)
					strSR[j] = (int)(0-Math.random()*10);
				else{
					if(j==4)
						strSR[j] = (int)(Math.random()*90);
					else
						strSR[j] = (int)(Math.random()*100);
				}
			}
			System.out.print("("+(strSR[0])+","+(strSR[1])+","+(strSR[2])+","+(strSR[3])+","+(strSR[4])+")  ");
			input.check(strSR[0],strSR[1],strSR[2],strSR[3],strSR[4]);
		}

//Above
 		System.out.println();
  		System.out.println("Above:");

		for(i=0; i<32; i++){
			for(int j=0; j<5;j++){
				if(str[i][j]==0){
					if(j==4)
						strSR[j] = (int)(91+Math.random()*10);
					else
						strSR[j] = (int)(101+Math.random()*10);
				}
				else{
					if(j==4)
						strSR[j] = (int)(Math.random()*90);
					else
						strSR[j] = (int)(Math.random()*100);
				}
			}
			System.out.print("("+(strSR[0])+","+(strSR[1])+","+(strSR[2])+","+(strSR[3])+","+(strSR[4])+")  ");
			input.check(strSR[0],strSR[1],strSR[2],strSR[3],strSR[4]);
		}


    }

}