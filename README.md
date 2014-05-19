SKCalendar
==========

How to Use:

      final SKCalender skCalender = new SKCalender(this);
      
      skCalender.setCallbacks(new Callbacks() {
      					
            public void onChooseDate(String chooseDate) {
          	  // TODO Auto-generated method stub
          		Toast.makeText(MainActivity.this, "Hello Date : "+ chooseDate, Toast.LENGTH_LONG).show();
          		skCalender.dismiss();
          	}
      });
      
      skCalender.show();
