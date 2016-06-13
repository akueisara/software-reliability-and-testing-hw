/**
 * @(#)equivalence_SN.java
 *
 */


public class equivalence_SN {

    public static void main(String[] argv){
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


    }


}