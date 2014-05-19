package com.smk.calender.widget;

import java.util.Calendar;
import java.util.Locale;

import com.smk.application.FontsTypeface;
import com.smk.skcalendar.R;

import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MonthAdapter extends BaseAdapter{
	private Context context;
	private final String[] months;
	private final DateFormat dateFormatter = new DateFormat();
	private Object _calendar;
	private FontsTypeface fonts;
 
	public MonthAdapter(Context context, String[] months){
		this.context = context;
		this.months = months;
		_calendar = Calendar.getInstance(Locale.getDefault());
	}
 
	@SuppressWarnings("static-access")
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.calender_month, null);
			fonts = new FontsTypeface(context);
			// set value into textview
			TextView txt_year_months = (TextView) gridView.findViewById(R.id.txt_year_month);
			fonts.setTypeface(txt_year_months, "Semibold");
			txt_year_months.setText(months[position]);
			txt_year_months.setTag(months[position]);
 
			String month = months[position];
			String currentMonth = dateFormatter .format("MMMM", ((Calendar) _calendar).getTime()).toString();
			if (currentMonth.equals(month)) {
				txt_year_months.setTextColor(Color.rgb(45, 165, 218));
			}
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	public int getCount() {
		return months.length;
	}
 
	public Object getItem(int position) {
		return null;
	}
 
	public long getItemId(int position) {
		return 0;
	}
 
}
