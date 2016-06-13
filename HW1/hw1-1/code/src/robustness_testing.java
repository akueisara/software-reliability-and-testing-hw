/**
 * @(#)robustness_testing.java
 *
 */

public class robustness_testing {

    public static void main(String[] argv){
    	int lower_bound = 1;
    	int upper_bound = 100;
    	int min = (lower_bound+upper_bound)/2;
    	int a,b,c,d;
    	int p = 45;
    	int stra[]={(min),(min),(min),(min),(p)};
    	int strb[]={(lower_bound)-1,(lower_bound),(lower_bound)+1,min,(upper_bound)-1,(upper_bound),(upper_bound)+1};
    	int strp[]={0,1,2,45,89,90,91};

		quadrilateral input = new quadrilateral();

		for(int i=0;i<stra.length;i++){
			if(i==4){
				for(int j=0;j<strp.length;j++){
				stra[4] = strp[j];
				System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
				input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
				}
			}
			else{
				for(int j=0;j<strb.length;j++){
					stra[i] = strb[j];
					System.out.print("("+(stra[0])+","+(stra[1])+","+(stra[2])+","+(stra[3])+","+(stra[4])+")  ");
					input.check(stra[0],stra[1],stra[2],stra[3],stra[4]);
				}
			}
			System.out.println();
			stra[0]=min;stra[1]=min;stra[2]=min;stra[3]=min;
		}

    }

}