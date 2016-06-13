/**
 * @(#)boundary_testing.java
 *
 */

public class boundary_testing {

    public static void main(String[] argv){
    	int lower_bound = 1;
    	int upper_bound = 100;
    	int min = (lower_bound+upper_bound)/2;
    	int a,b,c,d;
    	int p = 45;
    	int stra[]={(min),(min),(min),(min)};
    	int strb[]={(lower_bound),(lower_bound)+1,min,(upper_bound)-1,(upper_bound)};
    	int strp[]={1,2,45,89,90};

		quadrilateral input = new quadrilateral();

		for(int i=0;i<stra.length;i++){
			for(int j=0;j<strb.length;j++){
				stra[i] = strb[j];
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(p)+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],p);
			}
			System.out.println();
			stra[0]=min;stra[1]=min;stra[2]=min;stra[3]=min;
		}

		for(int j=0;j<strp.length;j++){
			p = strp[j];
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(p)+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],p);
		}
		System.out.println();


    }


}