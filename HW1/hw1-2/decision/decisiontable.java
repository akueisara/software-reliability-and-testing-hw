import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class decisiontable extends TestCase
{
	static public Bills getBills=new Bills();
	static public Data startData=new Data();
	static public Data endData=new Data();
	static public float[] charge;
	//static public int temp=0;
	static String state_from;
	static String state_to;
	static Random generator=new Random();
	
	public decisiontable(String name)
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
	public void decisiontable1()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=3;
		int temp=0;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=generator.nextInt(2);
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=3;
		endData.day=startData.day;
		endData.hour=generator.nextInt(21)+3;
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);
		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT01  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void decisiontable2()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=3;
		int temp=0;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=generator.nextInt(2);
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=3;
		endData.day=startData.day;
		endData.hour=generator.nextInt(2);
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);
		if ((endData.hour==1)&&(endData.minute==59))
			endData.second=0;
		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT02  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	public void decisiontable3()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=3;
		int temp=0;
		startData.day=getBills.MarchSunday(startData.year);
		startData.hour=generator.nextInt(21)+3;
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=3;
		endData.day=startData.day;
		endData.hour=generator.nextInt(24);
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);

		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT03  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	public void decisiontable4()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=11;
		int temp=0;
		startData.day=getBills.NovemberSunday(startData.year);
		startData.hour=generator.nextInt(3);
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=11;
		endData.day=startData.day;
		endData.hour=generator.nextInt(22)+2;
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);

		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT04  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(1,temp);
	}
	
	public void decisiontable5()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=11;
		int temp=0;
		startData.day=getBills.NovemberSunday(startData.year);
		startData.hour=generator.nextInt(3);
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=11;
		endData.day=startData.day;
		endData.hour=generator.nextInt(2);
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);

		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT05  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	public void decisiontable6()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=11;
		int temp=0;
		startData.day=getBills.NovemberSunday(startData.year);
		startData.hour=generator.nextInt(4);
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=11;
		endData.day=startData.day;
		endData.hour=generator.nextInt(2);
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);

		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT06  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	
	public void decisiontable7()
	{
		startData.year=generator.nextInt(1200)+1800;
		startData.month=generator.nextInt(12);
		while(startData.month==3 || startData.month==11)
		{
			startData.month=generator.nextInt(12);
		}
		int temp=0;
		startData.day=getBills.NovemberSunday(startData.year);
		startData.hour=generator.nextInt(24);
		startData.minute=generator.nextInt(60);
		startData.second=generator.nextInt(60);

		endData.year=startData.year;
		endData.month=startData.month;
		endData.day=startData.day;
		endData.hour=generator.nextInt(24);
		endData.minute=generator.nextInt(60);
		endData.second=generator.nextInt(60);

		state_from=startData.state[generator.nextInt(5)];
		state_to=endData.state[generator.nextInt(5)];
		System.out.print("DT07  "+startData.year+"/"+startData.month+"/"+startData.day+" "+startData.hour+":"+startData.minute+":"+startData.second+" ");
		System.out.print(endData.year+"/"+endData.month+"/"+endData.day+" "+endData.hour+":"+endData.minute+":"+endData.second+" ");
		System.out.print(state_from+" "+state_to+" ");
		//float[] charge=getBills.bills(startData,endData,state_from,state_to);
		charge=getBills.bills(startData,endData,state_from,state_to);
		if (charge[0]==1)
			System.out.print("Yes ");
		else
			System.out.print("NO  ");
		//System.out.printf("%.2f\n",charge[1]);
		//System.out.printf("%.2f\n",charge[1]);
		System.out.println();
		temp=(int)(charge[0]);
		assertEquals(0,temp);
	}
	

	public static Test suite()
	{
		TestSuite suite=new TestSuite();
		suite.addTest(new decisiontable("decisiontable1"));
		suite.addTest(new decisiontable("decisiontable2"));
		suite.addTest(new decisiontable("decisiontable3"));
		suite.addTest(new decisiontable("decisiontable4"));
		suite.addTest(new decisiontable("decisiontable5"));
		suite.addTest(new decisiontable("decisiontable6"));
		suite.addTest(new decisiontable("decisiontable7"));

		return suite;
	}
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(decisiontable.class);
	}

}
