package com.nullcognition.testingfundamentals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.OnClick;

// import static org.mockito.Mockito.*;

public class ActivityMain extends Activity {

   public static final String ACTIVITY_MAIN_KEY = "amk";

   @InjectView(R.id.button)
   Button button;

   @InjectView(R.id.text_view)
   TextView testView;

   @Override
   protected void onCreate(Bundle savedInstanceState){

	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
   }

   public static Intent startNewActivityI(Context con, String query){

	  String val = "someVal";
	  if(query != null){ val = query;}

	  Intent activitySecond = new Intent(con, ActivitySecond.class);
	  activitySecond.putExtra(ACTIVITY_MAIN_KEY, query);

	  return activitySecond;
   }

   @OnClick(R.id.button)
   public void startNewActivity(){

	  String val = "someVal";

	  Intent activitySecond = new Intent(this, ActivitySecond.class);
	  activitySecond.putExtra(ACTIVITY_MAIN_KEY, val);
	  startActivity(activitySecond);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  getMenuInflater().inflate(R.menu.activity_main_menu, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  int id = item.getItemId();
	  if(id == R.id.action_settings){ return true;}
	  return super.onOptionsItemSelected(item);
   }


}
