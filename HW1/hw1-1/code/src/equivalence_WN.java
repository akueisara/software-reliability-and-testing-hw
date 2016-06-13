/**
 * @(#)Equivalence_WN.java
 *
 */


public class equivalence_WN {

    public static void main(String[] argv){
		int strx[]=new int[5];
		int i;

		quadrilateral input = new quadrilateral();

//a=b=c=d (square or rectangle)
		strx[0]=strx[1]=strx[2]=strx[3]=(int)(Math.random()*100);
		i=(int)(Math.random()*10%2);
		if(i==0)
			strx[4]=90;
		else
			strx[4]=(int)(1+Math.random()*90);
		System.out.print("("+(strx[0])+","+(strx[1])+","+(strx[2])+","+(strx[3])+","+(strx[4])+")  ");
		input.check(strx[0],strx[1],strx[2],strx[3],strx[4]);

//a=c,b=d,b!=c (rhombus or parallelogram)
		strx[0]=strx[2]=(int)(1+Math.random()*100);
		do{
			strx[1]=strx[3]=(int)(1+Math.random()*100);
		}while(strx[1]==strx[2]);
		i=(int)(Math.random()*10%2);
		if(i==0)
			strx[4]=90;
		else
			strx[4]=(int)(1+Math.random()*90);
		System.out.print("("+(strx[0])+","+(strx[1])+","+(strx[2])+","+(strx[3])+","+(strx[4])+")  ");
		input.check(strx[0],strx[1],strx[2],strx[3],strx[4]);

//a=c || b=d (harrier-shaped or quadrilateral)
		i=(int)(Math.random()*10%2);
		if(i==0){
			strx[0]=strx[2]=(int)(1+Math.random()*100);
			strx[1]=(int)(1+Math.random()*100);
			do{
				strx[3]=(int)(1+Math.random()*100);
			}while(strx[1]==strx[3]);
			i=(int)(Math.random()*10%2);
			if(i==0)
				strx[4]=90;
			else
				strx[4]=(int)(1+Math.random()*90);
			System.out.print("("+(strx[0])+","+(strx[1])+","+(strx[2])+","+(strx[3])+","+(strx[4])+")  ");
			input.check(strx[0],strx[1],strx[2],strx[3],strx[4]);
		}
		else{
			strx[1]=strx[3]=(int)(1+Math.random()*100);
			strx[0]=(int)(1+Math.random()*100);
			do{
				strx[2]=(int)(1+Math.random()*100);
			}while(strx[0]==strx[2]);
			i=(int)(Math.random()*10%2);
			if(i==0)
				strx[4]=90;
			else
				strx[4]=(int)(1+Math.random()*90);
			System.out.print("("+(strx[0])+","+(strx[1])+","+(strx[2])+","+(strx[3])+","+(strx[4])+")  ");
			input.check(strx[0],strx[1],strx[2],strx[3],strx[4]);

		}

//(a+c)*d=(b+d)*c => ad=bc (trapezium)
		do{
			strx[0]=(int)(1+Math.random()*100);
			strx[1]=(int)(1+Math.random()*100);
			strx[2]=(int)(1+Math.random()*100);
			strx[3]=(int)(1+Math.random()*100);
		}while(strx[0]*strx[3]!=strx[1]*strx[2]||strx[0]==strx[1]);
		i=(int)(Math.random()*10%2);
		if(i==0)
			strx[4]=90;
		else
			strx[4]=(int)(1+Math.random()*90);
		System.out.print("("+(strx[0])+","+(strx[1])+","+(strx[2])+","+(strx[3])+","+(strx[4])+")  ");
		input.check(strx[0],strx[1],strx[2],strx[3],strx[4]);
//others (quadrilateral)
		do{
			strx[0]=(int)(1+Math.random()*100);
			strx[1]=(int)(1+Math.random()*100);
			strx[2]=(int)(1+Math.random()*100);
			strx[3]=(int)(1+Math.random()*100);
		}while(strx[0]==strx[2]||strx[1]==strx[3]||strx[0]==strx[1]||strx[0]*strx[3]==strx[1]*strx[2]);
		i=(int)(Math.random()*10%2);
		if(i==0)
			strx[4]=90;
		else
			strx[4]=(int)(1+Math.random()*90);
		System.out.print("("+(strx[0])+","+(strx[1])+","+(strx[2])+","+(strx[3])+","+(strx[4])+")  ");
		input.check(strx[0],strx[1],strx[2],strx[3],strx[4]);

    }

}