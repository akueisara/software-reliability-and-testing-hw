/**
 * @(#)Equivalence_WR.java
 *
 */


public class equivalence_WR {

    public static void main(String[] argv){
    	int stra[]=new int[5];

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



//@@@@@@@@@@@@@@@out of range@@@@@@@@@@@@@@@@@@@@
//Below
 		System.out.println();
 		System.out.println("Below:");
		for(i=0;i<stra.length;i++){
			if(i==4){
				for(int j=0;j<stra.length-1;j++)
					stra[j] = (int)(Math.random()*100);

				stra[4] = (int)(0-Math.random()*10);
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

			}
			else{
				for(int j=0;j<stra.length;j++)
					stra[j] = (int)(Math.random()*100);

				stra[4] = (int)(Math.random()*90);
				stra[i] = (int)(0-Math.random()*10);
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
			}
		}



//Above

  		System.out.println("\nAbove:");
		for(i=0;i<stra.length;i++){
			if(i==4){
				for(int j=0;j<stra.length;j++)
					stra[j] = (int)(Math.random()*100);

				stra[4] = (int)(91+Math.random()*10);
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);

			}
			else{

				for(int j=0;j<stra.length;j++)
					stra[j] = (int)(Math.random()*100);

				stra[4] = (int)(Math.random()*90);
				stra[i] = (int)(101+Math.random()*10);
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
			}
		}
	}
}