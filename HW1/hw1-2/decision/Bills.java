
public class Bills
{
	public float[] bills(Data startData,Data endData,String state_from,String state_to)
	{
		//System.out.print(startData.year+" "+startData.month+" ");
		//float[] charge={0,0,0};
		float[] charge={0,0};	//charge[0]:0no1pass2error
		//if ((startData.hour<0)||startData.hour>24)
		//	charge[2]=1;
		//if ((startData.month<0)||(startData.month)>12)
		//	charge[2]=1;
		int firstSunday_March=MarchSunday(startData.year);
		int firstSunday_November=NovemberSunday(startData.year);
		//System.out.print(firstSunday_March+" ");
		//System.out.print(firstSunday_November+" ");

		
		int totaltime=duration(startData,endData,dstMarch(startData,endData,firstSunday_March));
		if (dstMarch(startData,endData,firstSunday_March))
		{
			totaltime=totaltime-60;
			charge[0]=1;
			//System.out.print("yes"+totaltime+" ");
		}
		else if (dstNovember(startData,endData,firstSunday_November))
		{
			totaltime=totaltime+60;
			charge[0]=1;
		}
		
		if ((startData.hour<0)||(startData.hour>24))
			charge[0]=2;
		if ((startData.month<0)||(startData.month>12))
			charge[0]=2;
		if ((endData.hour<0)||(endData.hour>24))
			charge[0]=2;
		if ((endData.month<0)||(endData.month>12))
			charge[0]=2;
		//System.out.print(totaltime+" ");
		
		float tmp=(float)totaltime;
		if (state_from==state_to)
		{
			if (totaltime>20)
				charge[1]=1+(tmp-20)*(float)0.1;
			else
				charge[1]=tmp*(float)0.05;
		}
		else
		{
			if (totaltime>20)
				charge[1]=1+(int)(tmp-20)*(float)0.2;
			else
				charge[1]=tmp*(float)0.1;
		}
		return charge;
	}
	

	public int duration(Data startData,Data endData,boolean march)
	{
		int totaltime=0;
		int endminute=endData.minute;
		//int startminute=startData.minute;
		int endhour=endData.hour;
		//int starthour=startData.hour;
		if (endData.second>0)	//round up
		{
			endminute=(endData.minute+1)%60;
			if (endminute==0)
			{
				endhour=endData.hour+1;
				if (march)
					endhour++;
			}
		}
		/*
		if (startData.second>0)
		{
			startminute=(startData.minute+1)%60;
			if (startminute==0)
			{
				starthour=startData.hour+1;
			}
		}*/
		//same year,same month,same day
		
		//System.out.print(starthour+" "+startminute+" "+endhour+" "+endminute+" ");
		if (startData.day==endData.day)
		{
			//totaltime=(endData.hour-startData.hour)*60+(60-startData.minute)+endminute;
			//totaltime=(endhour-starthour)*60+(endminute-startminute);
			totaltime=(endhour-startData.hour)*60+(endminute-startData.minute);
			if ((endData.hour<startData.hour)&&endData.hour<2)
				totaltime=0;
		}

		else
			//totaltime=24*60+(endData.hour-startData.hour)*60+(60-startData.minute)+endminute;
			//totaltime=24*60+(endhour-starthour)*60+(endminute-startminute);
			totaltime=24*60+(endhour-startData.hour)*60+(endminute-startData.minute);
		return totaltime;
	}
	
	//get first day of a month
	public int MarchSunday(int year)	//1753/01/01 Monday
	{
		int firstday=1;
		int i=0;
		for (i=1753;i<year;i++)
		{
			if ((i%4==0&&i%100!=0)||i%400==0)	//leap year
				firstday=(firstday+366%7)%7;
			else
				firstday=(firstday+365%7)%7;
		}
		int Febdays=28;
		if ((year%4==0&&year%100!=0)||year%400==0)
			Febdays=29;
		firstday=(firstday+31+Febdays)%7;
		return(1+7-firstday);
	}
	public int NovemberSunday(int year)	//1753/01/01 Monday
	{
		int firstday=1;
		int i=0;
		for (i=1753;i<year;i++)
		{
			if ((i%4==0&&i%100!=0)||(i%400==0))	//leap year
				firstday=(firstday+366%7)%7;
			else
				firstday=(firstday+365%7)%7;
		}
		int Febdays=28;
		if ((year%4==0&&year%100!=0)||(year%400==0))
			Febdays=29;
		firstday=(firstday+276+Febdays)%7;	//276=total days except Feb until 10/31
		return(1+7-firstday);
	}
	private boolean dstMarch(Data startData,Data endData,int firstSunday_March)
	{
		boolean before_March=false;
		boolean after_March=false;
		if (startData.month<3)
			before_March=true;
		else if (startData.month==3)
		{
			if (startData.day<firstSunday_March)
				before_March=true;
			else if (startData.day==firstSunday_March)
			{
				if (startData.hour<=1)
					before_March=true;
			}
		}
		//check if end_time is after daylight saving time
		if (endData.month>3)
			after_March=true;
		else if (endData.month==3)
		{
			if (endData.day>firstSunday_March)
				after_March=true;
			else if (endData.day==firstSunday_March)
			{
				if (endData.hour>=3)
					after_March=true;
				else if (endData.hour==1)
				{
					if (endData.minute==59)
						if (endData.second>=1)
							after_March=true;
				}
			}
		}
		if (before_March&&after_March)
			return true;
		else
			return false;
	}
	
	private boolean dstNovember(Data startData,Data endData,int firstSunday_November)
	{
		boolean before_November=false;
		boolean after_November=false;
		//check if start_time is before daylight saving time
		if (startData.month<11)
			before_November=true;
		else if (startData.month==11)
		{
			if (startData.day<firstSunday_November)
				before_November=true;
			else if (startData.day==firstSunday_November)
			{
				if (startData.hour<=2)
					before_November=true;
			}
		}
		//check if end_time is after daylight saving time
		if (endData.month==12)
			after_November=true;
		else if (endData.month==11)
		{
			if (endData.day>firstSunday_November)
				after_November=true;
			else if (endData.day==firstSunday_November)
			{
				if (endData.hour>=2)
					after_November=true;
			}
			/*
			if (endData.hour>=3)
				after_November=true;
			else if (endData.hour==2)
			{
				if (endData.minute==59)
					if (endData.second>=1)
						after_November=true;
			}
			*/
		}
		if (before_November&&after_November)
			return true;
		else
			return false;
	}
}

