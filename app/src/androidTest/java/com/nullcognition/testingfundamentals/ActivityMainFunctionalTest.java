package com.nullcognition.testingfundamentals;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;

/**
 * Created by ersin on 12/02/15 at 9:19 PM
 */
public class ActivityMainFunctionalTest extends ActivityInstrumentationTestCase2<ActivityMain> {

   private ActivityMain activity;

   public ActivityMainFunctionalTest(){
	  super(ActivityMain.class);
   }

   @Override
   protected void setUp() throws Exception{
	  super.setUp();

	  setActivityInitialTouchMode(false);

	  activity = getActivity();

	  ButterKnife.inject(activity);
   }

   public void testStartActivitySecond() throws Exception{

	  // add monitor to check for the second activity
	  Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ActivitySecond.class.getName(), null, false);

	  // find button and click it
	  Button view = ButterKnife.findById(activity, R.id.button);

	  // TouchUtils handles the sync with the main thread internally
	  TouchUtils.clickView(this, view);

	  // to click on a object, e.g., in a listview
	  // listView.getChildAt(0);

	  // wait 2 seconds for the start of the activity
	  ActivitySecond startedActivity = (ActivitySecond)monitor.waitForActivityWithTimeout(2000);
	  assertNotNull(startedActivity);

	  // search for the textView
	  TextView textView = ButterKnife.findById(startedActivity, R.id.text_view2);

	  // check that the TextView is on the screen
	  ViewAsserts.assertOnScreen(startedActivity.getWindow()
												.getDecorView(), textView);
	  // validate the text on the TextView
	  assertEquals("Text incorrect", "Hello world!", textView.getText()
														.toString());

	  // press back and click again
	  this.sendKeys(KeyEvent.KEYCODE_BACK);

	  TouchUtils.clickView(this, view);
   }
}
