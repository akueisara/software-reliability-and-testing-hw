import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class testBoundary extends TestCase
{
	static public Bills getBills=new Bills();
	static public Data startData=new Data();
	static public Data endData=new Data();
	static public float[] charge;
	static public int temp=0;
	static String state_from;
	static String state_to;
	static Random generator=new Random();
	
	public testBoundary(String name)
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
	public void testBoundary1()
	{

		
		//March
		System.out.println("cases start_time end_time from to pass charge");

		//BT01 left1
		startData.year=generator.nextInt(1200)+1800;
		startData.month=3;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=1;
		startData.minute=59;
		startData.second=01;
		endData.year=startData.year;
		endData.month=3;
		endData.day=startData.day;
		endData.hour=17;
		endData.minute=58;
		endData.second=generator.nextInt(59)+1;
		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("BT01  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary2()
	{
		//BT02 left2
		startData.second=02;
		System.out.print("BT02  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary3()
	{
		//BT03 right1
		startData.second=58;
		System.out.print("BT03  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary4()
	{
		//BT04 right2
		startData.second=59;
		System.out.print("BT04  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary5()
	{
		//BT05 middle
		startData.second=30;
		System.out.print("BT05  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary6()
	{
		//BT06 top1
		endData.day++;
		endData.hour=(endData.hour+15)%24;
		System.out.print("BT06  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary7()
	{
		//BT07 top2
		endData.minute--;
		System.out.print("BT07  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary8()
	{
		//BT08 bottom1
		endData.day=startData.day;
		endData.hour=startData.hour+2;
		endData.minute=0;
		System.out.print("BT08  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary9()
	{
		//BT09 bottom2
		endData.minute=0;
		endData.second=0;
		System.out.print("BT09  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	//November
	public void testBoundary10()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=11;
		startData.day=getBills.NovemberSunday(startData.year);
		startData.hour=2;
		startData.minute=59;
		startData.second=01;
		endData.year=startData.year;
		endData.month=11;
		endData.day=startData.day;
		endData.hour=16;
		endData.minute=58;
		endData.second=generator.nextInt(59)+1;
		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("BT01  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary11()
	{
		//BT02 left2
		startData.second=02;
		System.out.print("BT02  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary12()
	{
		
		//BT03 right1
		startData.second=58;
		System.out.print("BT03  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary13()
	{
		//BT04 right2
		startData.second=59;
		System.out.print("BT04  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary14()
	{
		//BT05 middle
		startData.second=30;
		System.out.print("BT05  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary15()
	{
		//BT06 top1
		endData.day++;
		endData.hour=(endData.hour+15)%24;
		System.out.print("BT06  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary16()
	{
		//BT07 top2
		endData.minute--;
		System.out.print("BT07  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary17()
	{
		//BT08 bottom1
		endData.day=startData.day;
		endData.hour=startData.hour;
		endData.minute=0;
		System.out.print("BT08  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testBoundary18()
	{
		//BT09 bottom2
		endData.minute=0;
		endData.second=0;
		System.out.print("BT09  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.printf("%.2f\n",charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}

	

	public static Test suite()
	{
		TestSuite suite=new TestSuite();
		suite.addTest(new testBoundary("testBoundary1"));
		suite.addTest(new testBoundary("testBoundary2"));
		suite.addTest(new testBoundary("testBoundary3"));
		suite.addTest(new testBoundary("testBoundary4"));
		suite.addTest(new testBoundary("testBoundary5"));
		suite.addTest(new testBoundary("testBoundary6"));
		suite.addTest(new testBoundary("testBoundary7"));
		suite.addTest(new testBoundary("testBoundary8"));
		suite.addTest(new testBoundary("testBoundary9"));
		suite.addTest(new testBoundary("testBoundary10"));
		suite.addTest(new testBoundary("testBoundary11"));
		suite.addTest(new testBoundary("testBoundary12"));
		suite.addTest(new testBoundary("testBoundary13"));
		suite.addTest(new testBoundary("testBoundary14"));
		suite.addTest(new testBoundary("testBoundary15"));
		suite.addTest(new testBoundary("testBoundary16"));
		suite.addTest(new testBoundary("testBoundary17"));
		suite.addTest(new testBoundary("testBoundary18"));
		return suite;
	}
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(testBoundary.class);
	}

}
