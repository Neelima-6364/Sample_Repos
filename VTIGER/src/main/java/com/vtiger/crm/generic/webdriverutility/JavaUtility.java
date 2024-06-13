package com.vtiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(5000);
		return randomNumber;
	}
	public String getSystemDateYYYYMMDD()
	{
		Date dateobj=new Date();
		//System.out.println(dateobj); Thu May 16 10:09:31 iST
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		return sim.format(dateobj);

	}
	public String getrequiredDateYYYYMMDD(int days)
	{
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = sim.format(dateobj);

		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String date = sim.format(cal.getTime());
		return date;
	}
}