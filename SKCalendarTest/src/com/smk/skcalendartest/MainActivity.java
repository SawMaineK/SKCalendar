package com.smk.skcalendartest;

import com.smk.calender.widget.SKCalender;
import com.smk.calender.widget.SKCalender.Callbacks;
import com.smk.skcalendar.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowCalendar = (Button) findViewById(R.id.btn_show_calendar);
        btnShowCalendar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final SKCalender skCalender = new SKCalender(MainActivity.this);
		        skCalender.setCallbacks(new Callbacks() {
					
					public void onChooseDate(String chooseDate) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "Hello Date : "+ chooseDate, Toast.LENGTH_LONG).show();
						skCalender.dismiss();
					}
				});
		        skCalender.setCancelable(true);
		        skCalender.show();
		        
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
