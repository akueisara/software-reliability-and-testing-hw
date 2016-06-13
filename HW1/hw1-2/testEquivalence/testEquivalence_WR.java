import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class testEquivalence_WR extends TestCase
{
	static public Bills getBills=new Bills();
	static public Data startData=new Data();
	static public Data endData=new Data();
	static public float[] charge;
	static public int temp;
	static public int ttemp=0;
	static String state_from;
	static String state_to;
	static Random rand = new Random();
	static int temp2,temp3,temp4;
	
	public testEquivalence_WR(String name)
	{
		super(name);
	}
	protected void setUp() throws Exception
	{
		super.setUp();
	}
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	public void testEquivalence_WR1()
	{

		startData.year=2010;
		startData.month=3;
		startData.day=7;
		startData.hour=01;
		startData.minute=59;
		startData.second=59;
		startData.area= "Asia";
		endData.year=2010;
		endData.month=3;
		endData.day=7;
		endData.hour=3;
		endData.minute=02;
		endData.second=0;
		endData.area= "Asia";
		startData.year = (int)(1+Math.random()*2247+1753);
		
		startData.month=3;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=1;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
		 endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }
		//area
		temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
	temp4 = (int)(1+Math.random()*4);

			if (temp4==0){endData.area="Asia";}
			if (temp4==1){endData.area="Africa";}
			if (temp4==2){endData.area="Americas";}
			if (temp4==3){endData.area="Europe";}
			if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		 state_from=startData.area;
		state_to=endData.area;
		 charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(1,ttemp);
	}
	
	public void testEquivalence_WR2()
	{
		// ************2:59的11月**************
		startData.year = (int)(1+Math.random()*2247+1753);
		
		startData.month=11;
		startData.day=getBills.NovemberSunday(startData.year);
		startData.hour= 2;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
		//判斷結束日期與開始日期同一天OR晚一天
	  temp = (int)(1+Math.random()*30);
        endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }

		//area
	     temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);
		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
		
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
	    state_from=startData.area;
	    state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(1,ttemp);
	}
	
	public void testEquivalence_WR3()
	{
		//@@@@@@@@@@@@@@@@@@@@@@@@@@others@@@@@@@@@@@@@@@@@@@@@@@@
		startData.year = (int)(1+Math.random()*2247+1753);
		//System.out.println(startData.year);
		int i = 0;
		while(i == 3||i==11||i==0){
			i = (int)(1+Math.random()* 12);
		} 
		//for( i=1;i<=9;i++){
		startData.month=i;
		
		startData.day= (int)(1+Math.random()*30);
		while(startData.hour==1 ||startData.hour==2||((startData.day==endData.day)&&endData.hour==1)||((startData.day==endData.day)&&endData.hour==2)){
		startData.hour=(int)(1+Math.random()*23);
		startData.minute=(int)(1+Math.random()*58);
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
		//判斷結束日期與開始日期同一天OR晚一天
		
		  temp = (int)(1+Math.random()*30);

		if((startData.hour+temp)>=24)
			{endData.day=startData.day+1;
			 endData.hour=(startData.hour+temp)%24;
			} 
		else {endData.day=startData.day;
		      endData.hour=startData.hour+temp;}}
		
		temp2=(int)(1+Math.random()*59);
		if((startData.hour==endData.hour)&&
		   (startData.minute+temp2)>=58){
 			endData.minute=startData.minute+1;}
		else {endData.minute=((int)(1+Math.random()*58));}
		
		if((startData.hour==endData.hour)&&
		   (startData.minute == endData.minute)){
		 			endData.second=startData.second+1;}
		else {endData.second=((int)(1+Math.random()*59));}
		
		//area
		temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		 temp4 = (int)(1+Math.random()*4);

		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
	     state_from=startData.area;
		 state_to=endData.area;
		 charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR4()
	{
		//@@@@@@@@@@@@@@@@@others 11月@@@@@@@@@@@@@@@@@@@@@@@@@
		startData.year = (int)(1+Math.random()*2247+1753);
		//System.out.println(startData.year);
	    startData.month=11;
	    endData.year=startData.year;
		endData.month=startData.month;
		
		startData.day= (int)(1+Math.random()*30);
		int temp6=0;
		temp6=getBills.NovemberSunday(startData.year);
		while(startData.hour==1 ||startData.hour==2||((startData.day==endData.day)&&endData.hour==1)||((startData.day==endData.day)&&endData.hour==2)){
		startData.hour=(int)(1+Math.random()*23);}
		
		while((startData.day+2==temp6)||(startData.day+1==temp6)||startData.day==temp6){
			startData.day= (int)(1+Math.random()*30);
			//System.out.print(startData.day);
		}
		startData.minute=(int)(1+Math.random()*58);
		startData.second=(int)(1+Math.random()*58);
		//endData.year=startData.year;
 		
		//判斷結束日期與開始日期同一天OR晚一天
		
		  temp = (int)(1+Math.random()*30);

		if((startData.hour+temp)>=24)
			{endData.day=startData.day+1;
			 endData.hour=(startData.hour+temp)%24;
			} 
		else {endData.day=startData.day;
		      endData.hour=startData.hour+temp;}
		
		temp2=(int)(1+Math.random()*59);
		if((startData.hour==endData.hour)&&
		   (startData.minute+temp2)>=58){
 			endData.minute=startData.minute+1;}
		else {endData.minute=((int)(1+Math.random()*58));}
		
		if((startData.hour==endData.hour)&&
		   (startData.minute == endData.minute)){
		 			endData.second=startData.second+1;}
		else {endData.second=((int)(1+Math.random()*59));}
		
		//area
	    temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);

		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR5()
	{
		//@@@@@@@@@@@@@@@@@others 3月@@@@@@@@@@@@@@@@@@@@@@@@@
		startData.year = (int)(1+Math.random()*2247+1753);
		//System.out.println(startData.year);
	    startData.month=3;
	    endData.year=startData.year;
		endData.month=startData.month;
		
		startData.day= (int)(1+Math.random()*30);
		int temp7=0;
		temp7=getBills.MarchSunday(startData.year);
		while(startData.hour==1 ||startData.hour==2||((startData.day==endData.day)&&endData.hour==1)||((startData.day==endData.day)&&endData.hour==2)){
		startData.hour=(int)(1+Math.random()*23);}
		while((startData.day+2==temp7)||(startData.day+1==temp7)||startData.day==temp7){
			startData.day= (int)(1+Math.random()*30);
			//System.out.print(startData.day);
		}
		startData.minute=(int)(1+Math.random()*58);
		startData.second=(int)(1+Math.random()*58);
		//endData.year=startData.year;
	//	endData.month=startData.month;
		
		//判斷結束日期與開始日期同一天OR晚一天
		
		 temp = (int)(1+Math.random()*30);

		if((startData.hour+temp)>=24)
			{endData.day=startData.day+1;
			 endData.hour=(startData.hour+temp)%24;
			} 
		else {endData.day=startData.day;
		      endData.hour=startData.hour+temp;}
		
		temp2=(int)(1+Math.random()*59);
		if((startData.hour==endData.hour)&&
		   (startData.minute+temp2)>=58){
 			endData.minute=startData.minute+1;}
		else {endData.minute=((int)(1+Math.random()*58));}
		
		if((startData.hour==endData.hour)&&
		   (startData.minute == endData.minute)){
		 			endData.second=startData.second+1;}
		else {endData.second=((int)(1+Math.random()*59));}
		
		//area
	    temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);
		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
		
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR6()
	{
		//********* 1:59 的 11月***********
		startData.year = (int)(1+Math.random()*2247+1753);
		
		startData.month=11;
		startData.day= (int)(1+Math.random()*30);
		startData.hour=1;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
		//判斷結束日期與開始日期同一天OR晚一天
	   endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }
        /*for (int j=(int)(1+Math.random()*58);startData.minute+j>=60;j--)
        {endData.minute=startData.minute+j;}

        for (int k=(int)(1+Math.random()*58);startData.second+k>=60;k--)
        {endData.second=startData.second+k;}*/

		//area
		 temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		 temp4 = (int)(1+Math.random()*4);

			if (temp4==0){endData.area="Asia";}
			if (temp4==1){endData.area="Africa";}
			if (temp4==2){endData.area="Americas";}
			if (temp4==3){endData.area="Europe";}
			if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR7()
	{
		//********* 1:59 的 others月分***********
		startData.year = (int)(1+Math.random()*2247+1753);
		int i = 0;
		while(i == 3||i==11||i==0){
			i = (int)(1+Math.random()* 12);
		} 
		startData.month=i;
		startData.day= (int)(1+Math.random()*30);
		startData.hour=1;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
        endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }
		//area
		 temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		 temp4 = (int)(1+Math.random()*4);

			if (temp4==0){endData.area="Asia";}
			if (temp4==1){endData.area="Africa";}
			if (temp4==2){endData.area="Americas";}
			if (temp4==3){endData.area="Europe";}
			if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR8()
	{
		// ************2:59的3月**************
		startData.year = (int)(1+Math.random()*2247+1753);
		
		startData.month=3;
		startData.day= (int)(1+Math.random()*30);
		startData.hour= 2;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
		//判斷結束日期與開始日期同一天OR晚一天
	   temp = (int)(1+Math.random()*30);
        endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }

		//area
	    temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);

		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
	    state_from=startData.area;
	    state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR9()
	{
		// ************2:59的其他月分**************
		startData.year = (int)(1+Math.random()*2247+1753);
		int i=0;
		while(i == 3||i==11||i==0){
			i = (int)(1+Math.random()* 12);
		} 
		startData.month=i;
		
		startData.day= (int)(1+Math.random()*30);
		startData.hour= 2;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
		//判斷結束日期與開始日期同一天OR晚一天
	   temp = (int)(1+Math.random()*30);
        endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }

		//area
	    temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);

		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
	    state_from=startData.area;
	    state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(0,ttemp);
	}
	
	public void testEquivalence_WR10()
	{
		//@@@@@@@@@@@@@@@@@weak robust 11月-hrs@@@@@@@@@@@@@@@@@@@@@@@@@
		startData.year = (int)(1+Math.random()*2247+1753);
		//System.out.println(startData.year);
	    startData.month=11;
	    endData.year=startData.year;
		endData.month=startData.month;
		
		startData.day= (int)(1+Math.random()*30);
		while(startData.hour==1 ||startData.hour==2||((startData.day==endData.day)&&endData.hour==1)||((startData.day==endData.day)&&endData.hour==2)){
		startData.hour=(int)(1+Math.random()*-23);}
		startData.minute=(int)(1+Math.random()*58);
		startData.second=(int)(1+Math.random()*58);
		
		//判斷結束日期與開始日期同一天OR晚一天
		
	 temp = (int)(1+Math.random()*30);

		if((startData.hour+temp)>=24)
			{endData.day=startData.day+1;
			 endData.hour=(startData.hour+temp)%24;
			} 
		else {endData.day=startData.day;
		      endData.hour=startData.hour-temp;}
		
		temp2=(int)(1+Math.random()*59);
		if((startData.hour==endData.hour)&&
		   (startData.minute+temp2)>=58){
			endData.minute=startData.minute+1;}
		else {endData.minute=((int)(1+Math.random()*58));}
		
		if((startData.hour==endData.hour)&&
		   (startData.minute == endData.minute)){
		 			endData.second=startData.second+1;}
		else {endData.second=((int)(1+Math.random()*59));}
		
		//area
	    temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);

		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
      System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
      
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(2,ttemp);
	}
	
	public void testEquivalence_WR11()
	{
		//@@@@@@@@@@@@@@@@@weak robust 11月+hrs@@@@@@@@@@@@@@@@@@@@@@@@@
		startData.year = (int)(1+Math.random()*2247+1753);
		//System.out.println(startData.year);
	    startData.month=11;
	    endData.year=startData.year;
		endData.month=startData.month;
		
		startData.day= (int)(1+Math.random()*30);
		while(startData.hour==1 ||startData.hour==2||((startData.day==endData.day)&&endData.hour==1)||((startData.day==endData.day)&&endData.hour==2)){
		startData.hour=(int)(1+Math.random()*1000);}
		startData.hour=startData.hour+100;
		startData.minute=(int)(1+Math.random()*58);
		startData.second=(int)(1+Math.random()*58);
		
		//判斷結束日期與開始日期同一天OR晚一天
		
	      temp = (int)(1+Math.random()*30);

		if((startData.hour+temp)>=24)
			{endData.day=startData.day+1;
			 endData.hour=(startData.hour+temp)%1000;
			} 
		else {endData.day=startData.day;
		      endData.hour=startData.hour+temp;
		      endData.hour=endData.hour+9125;}
		
		temp2=(int)(1+Math.random()*59);
		if((startData.hour==endData.hour)&&
		   (startData.minute+temp2)>=58){
			endData.minute=startData.minute+1;}
		else {endData.minute=((int)(1+Math.random()*58));}
		
		if((startData.hour==endData.hour)&&
		   (startData.minute == endData.minute)){
		 			endData.second=startData.second+1;}
		else {endData.second=((int)(1+Math.random()*59));}
		
		//area
	    temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		temp4 = (int)(1+Math.random()*4);

		if (temp4==0){endData.area="Asia";}
		if (temp4==1){endData.area="Africa";}
		if (temp4==2){endData.area="Americas";}
		if (temp4==3){endData.area="Europe";}
		if (temp4==4){endData.area="Oceania";}
      System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
      
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(2,ttemp);
	}
	
	public void testEquivalence_WR12()
	{
		//********* 1:59 的 invalid月分  upper bound***********
		startData.year = (int)(1+Math.random()*2247+1753);
		int i = 0;
		while(i == 3||i==11||i==0){
			i = (int)(1+Math.random()* 12);
		} 
		startData.month=i+12;
		startData.day= (int)(1+Math.random()*30);
		startData.hour=1;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
        endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }
		//area
		 temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		 temp4 = (int)(1+Math.random()*4);

			if (temp4==0){endData.area="Asia";}
			if (temp4==1){endData.area="Africa";}
			if (temp4==2){endData.area="Americas";}
			if (temp4==3){endData.area="Europe";}
			if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(2,ttemp);
	}
	
	public void testEquivalence_WR13()
	{
		//********* 1:59 的 invalid月分  lower bound***********
		startData.year = (int)(1+Math.random()*2247+1753);
		int i = 0;
		while(i == 3||i==11||i==0){
			i = (int)(1+Math.random()* 12);
		} 
		startData.month=-i;
		startData.day= (int)(1+Math.random()*30);
		startData.hour=1;
		startData.minute=59;
		startData.second=(int)(1+Math.random()*58);
		endData.year=startData.year;
		endData.month=startData.month;
		
        endData.day=startData.day;
        endData.hour=startData.hour;
        while(endData.minute*60+endData.second <= startData.minute*60+startData.second){
        	endData.minute = (int)(1+ Math.random()*59);
        	endData.second = (int)(1+ Math.random()*59);
        }
		//area
		 temp3 = (int)(1+Math.random()*4);
		if (temp3==0){startData.area="Asia";}
		if (temp3==1){startData.area="Africa";}
		if (temp3==2){startData.area="Americas";}
		if (temp3==3){startData.area="Europe";}
		if (temp3==4){startData.area="Oceania";}
		
		 temp4 = (int)(1+Math.random()*4);

			if (temp4==0){endData.area="Asia";}
			if (temp4==1){endData.area="Africa";}
			if (temp4==2){endData.area="Americas";}
			if (temp4==3){endData.area="Europe";}
			if (temp4==4){endData.area="Oceania";}
        System.out.print("start data:   ");
		System.out.print(startData.year+" "+"年  ");
		System.out.print(startData.month+" "+"月  ");
		System.out.print(startData.day+" "+"日    ");
		System.out.print(startData.hour+" "+":");
		System.out.print(startData.minute+" "+":");
		System.out.print(startData.second+"     ");
		System.out.println(startData.area);
		
		System.out.print("end   data:   ");
		System.out.print(endData.year+" "+"年  ");
		System.out.print(endData.month+" "+"月  ");
		System.out.print(endData.day+" "+"日    ");
		System.out.print(endData.hour+" "+":");
		System.out.print(endData.minute+" "+":");
		System.out.print(endData.second+"     ");
		System.out.println(endData.area);
		 
        
		state_from=startData.area;
		state_to=endData.area;
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			{System.out.println("Pass daylight saving time");}
		if (charge[0]==2){System.out.println("error");}else {System.out.printf("%.2f\n",charge[1]);}
		System.out.println();
		ttemp=(int)(charge[0]);
		assertEquals(2,ttemp);
	}

	public static Test suite()
	{
		TestSuite suite=new TestSuite();
		suite.addTest(new testEquivalence_WR("testEquivalence_WR1"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR2"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR3"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR4"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR5"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR6"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR7"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR8"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR9"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR10"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR11"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR12"));
		suite.addTest(new testEquivalence_WR("testEquivalence_WR13"));
		
		

		return suite;
	}
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(testEquivalence_WR.class);
	}

}
