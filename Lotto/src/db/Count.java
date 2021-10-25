package db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Count {
	public int count(){
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		
		String startdate = "2002-12-07";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
		} catch (ParseException e) {
			System.out.println("오류 : " + e);
		}
		Calendar firstdate = Calendar.getInstance();
		firstdate.setTime(date);
		
		long sec = (today.getTimeInMillis() - firstdate.getTimeInMillis()) / 1000;
		int days = (int) (sec / (24*60*60));
		
		return days / 7 + 1;	
	}
}
