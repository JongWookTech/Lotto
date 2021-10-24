package db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Count {
	public int count(){
		Calendar getToday = Calendar.getInstance();
		getToday.setTime(new Date());
		
		String startdate = "2002-12-07";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
		} catch (ParseException e) {
			System.out.println("오류 : " + e);
		}
		Calendar cmpDate = Calendar.getInstance();
		cmpDate.setTime(date);
		
		long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
		int diffDays = (int) (diffSec / (24*60*60));
		
		return diffDays / 7 + 1;
	}
}
