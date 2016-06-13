import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class testRobustness extends TestCase
{
	static public Bills getBills=new Bills();
	static public Data startData=new Data();
	static public Data endData=new Data();
	static public float[] charge;
	static public int temp=0;
	static String state_from;
	static String state_to;
	static Random generator=new Random();
	
	public testRobustness(String name)
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
	public void testRobustness1()
	{

		
		//March
		System.out.println("cases start_time end_time from to pass charge");

		//RT01 left1
		startData.year=generator.nextInt(1200)+1800;
		startData.month=3;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=1;
		startData.minute=59;
		startData.second=00;
		endData.year=startData.year;
		endData.month=3;
		endData.day=startData.day;
		endData.hour=17;
		endData.minute=58;
		endData.second=generator.nextInt(59)+1;
		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("RT01  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		float[] charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness2()
	{
		//RT02 left2
		startData.second=01;
		System.out.print("RT02  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness3()
	{
		//RT03 left3
		startData.second=02;
		System.out.print("RT03  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness4()
	{
		//RT04 right1
		startData.second=58;
		System.out.print("RT04  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness5()
	{
		//RT05 right2
		startData.second=59;
		System.out.print("RT05  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness6()
	{
		//RT06 right3
		startData.hour=3;
		startData.minute=00;
		startData.second=00;
		endData.minute=59;
		System.out.print("RT06  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	public void testRobustness7()
	{
		//RT07 middle
		startData.hour=1;
		startData.minute=59;
		startData.second=30;
		endData.minute=58;
		System.out.print("RT07  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness8()
	{
		//RT08 top1
		endData.day++;
		endData.hour=(endData.hour+15)%24;
		endData.minute++;
		System.out.print("RT08  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness9()
	{
		//RT09 top2
		endData.minute--;
		System.out.print("RT09  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	
	public void testRobustness10()
	{
		//RT10 top3
		endData.minute--;
		System.out.print("RT10  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness11()
	{
		//RT11 bottom1
		endData.day=startData.day;
		endData.hour=startData.hour+2;
		endData.minute=0;
		System.out.print("RT11  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness12()
	{
		
		//RT12 bottom2
		endData.minute=0;
		endData.second=0;
		System.out.print("RT12  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness13()
	{
		//RT13 bottom2
		endData.hour=startData.hour;
		endData.minute=startData.minute;
		endData.second=0;
		System.out.print("RT13  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	//November
	public void testRobustness14()
	{
		//RT01 left1
		startData.year=generator.nextInt(1200)+1800;
		startData.month=11;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=2;
		startData.minute=59;
		startData.second=00;
		endData.year=startData.year;
		endData.month=11;
		endData.day=startData.day;
		endData.hour=16;
		endData.minute=58;
		endData.second=generator.nextInt(59)+1;
		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("RT01  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness15()
	{
		//RT02 left2
		startData.second=01;
		System.out.print("RT02  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness16()
	{
		//RT03 left3
		startData.second=02;
		System.out.print("RT03  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness17()
	{
		//RT04 right1
		startData.second=58;
		System.out.print("RT04  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness18()
	{
		//RT05 right2
		startData.second=59;
		System.out.print("RT05  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness19()
	{
		//RT06 right3
		startData.hour=3;
		startData.minute=00;
		startData.second=00;
		endData.hour=startData.hour+15;
		endData.minute=0;
		endData.second=0;
		System.out.print("RT06  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	public void testRobustness20()
	{
		//RT07 middle
		startData.hour=2;
		startData.minute=59;
		startData.second=30;
		endData.hour=16;
		endData.minute=58;
		endData.second=generator.nextInt(59)+1;
		System.out.print("RT07  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness21()
	{
		//RT08 top1
		endData.day++;
		endData.hour=(endData.hour+15)%24;
		endData.minute++;
		System.out.print("RT08  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness22()
	{
		//RT09 top2
		endData.minute--;
		System.out.print("RT09  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness23()
	{
		//RT10 top3
		endData.minute--;
		System.out.print("RT10  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}

	public void testRobustness24()
	{
		//RT11 bottom1
		endData.day=startData.day;
		endData.hour=startData.hour;
		endData.minute=0;
		System.out.print("RT11  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness25()
	{
		//RT12 bottom2
		endData.minute=0;
		endData.second=0;
		System.out.print("RT12  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void testRobustness26()
	{
		//RT13 bottom2
		endData.hour=1;
		endData.minute=59;
		endData.second=59;
		System.out.print("RT13  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		System.out.println(charge[1]);
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}

	public static Test suite()
	{
		TestSuite suite=new TestSuite();
		suite.addTest(new testRobustness("testRobustness1"));
		suite.addTest(new testRobustness("testRobustness2"));
		suite.addTest(new testRobustness("testRobustness3"));
		suite.addTest(new testRobustness("testRobustness4"));
		suite.addTest(new testRobustness("testRobustness5"));
		suite.addTest(new testRobustness("testRobustness6"));
		suite.addTest(new testRobustness("testRobustness7"));
		suite.addTest(new testRobustness("testRobustness8"));
		suite.addTest(new testRobustness("testRobustness9"));
		suite.addTest(new testRobustness("testRobustness10"));
		suite.addTest(new testRobustness("testRobustness11"));
		suite.addTest(new testRobustness("testRobustness12"));
		suite.addTest(new testRobustness("testRobustness13"));
		suite.addTest(new testRobustness("testRobustness14"));
		suite.addTest(new testRobustness("testRobustness15"));
		suite.addTest(new testRobustness("testRobustness16"));
		suite.addTest(new testRobustness("testRobustness17"));
		suite.addTest(new testRobustness("testRobustness18"));
		suite.addTest(new testRobustness("testRobustness19"));
		suite.addTest(new testRobustness("testRobustness20"));
		suite.addTest(new testRobustness("testRobustness21"));
		suite.addTest(new testRobustness("testRobustness22"));
		suite.addTest(new testRobustness("testRobustness23"));
		suite.addTest(new testRobustness("testRobustness24"));
		suite.addTest(new testRobustness("testRobustness25"));
		suite.addTest(new testRobustness("testRobustness26"));
		return suite;
	}
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(testRobustness.class);
	}

}
