package com.smk.calender.widget;

import java.util.Calendar;
import java.util.Locale;

import com.smk.skcalendar.R;

import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class WeekDaysAdapter extends BaseAdapter {
	private Context context;
	private final String[] weekDays;
	private final DateFormat dateFormatter = new DateFormat();
	private Object _calendar;
 
	public WeekDaysAdapter(Context context, String[] weekDays) {
		this.context = context;
		this.weekDays = weekDays;
		_calendar = Calendar.getInstance(Locale.getDefault());
	}
 
	@SuppressWarnings("static-access")
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.calender_week_day, null);
 
			// set value into textview
			TextView txt_weekDay = (TextView) gridView.findViewById(R.id.txt_week_day);
			txt_weekDay.setText(weekDays[position]);
 
			String weekDay = weekDays[position];
			String currentWeekDay = dateFormatter .format("E", ((Calendar) _calendar).getTime()).toString();
			if (weekDay.equals(currentWeekDay.toUpperCase())) {
				txt_weekDay.setTextColor(Color.RED);
			}
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	public int getCount() {
		return weekDays.length;
	}
 
	public Object getItem(int position) {
		return null;
	}
 
	public long getItemId(int position) {
		return 0;
	}
 
}
