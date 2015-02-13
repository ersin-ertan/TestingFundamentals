package com.nullcognition.testingfundamentals;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import butterknife.ButterKnife;

/**
 * Created by ersin on 12/02/15 at 7:13 PM
 */
public class ActivityMainUnitTest extends ActivityUnitTestCase<ActivityMain> {

   private ActivityMain activity;

   public ActivityMainUnitTest(){
	  super(ActivityMain.class);
   }

   @Override
   protected void setUp() throws Exception{
	  super.setUp();

	  Intent intent = new Intent(getInstrumentation().getTargetContext(), ActivityMain.class);

	  startActivity(intent, null, null);

	  activity = getActivity();

	  ButterKnife.inject(activity);
   }

   public void testLayout(){
	  assertNotNull(ButterKnife.findById(activity, R.id.button));
	  Button view = ButterKnife.findById(activity, R.id.button);
	  assertEquals("Incorrect label of the button", activity.getResources()
															.getString(R.string.button_text), view.getText());
   }

   public void testIntentTriggerViaOnClick(){
	  ButterKnife.findById(activity, R.id.button);
	  Button view = ButterKnife.findById(activity, R.id.button);
	  assertNotNull("Button not allowed to be null", view);

	  view.performClick();

	  // TouchUtils cannot be used, only allowed in
	  // InstrumentationTestCase or ActivityInstrumentationTestCase2

	  // Check the intent which was started
	  Intent triggeredIntent = getStartedActivityIntent();
	  assertNotNull("Intent was null", triggeredIntent);
	  String data = triggeredIntent.getExtras()
								   .getString(ActivityMain.ACTIVITY_MAIN_KEY);

	  assertEquals("Incorrect data passed via the intent", "someVal", data);
   }

}
