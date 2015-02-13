package com.nullcognition.testingfundamentals;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import butterknife.ButterKnife;

/**
 * Created by ersin on 12/02/15 at 9:27 PM
 */
public class ActivitySecondFunctionalTest extends ActivityInstrumentationTestCase2<ActivitySecond> {

   private static final String NEW_TEXT = "new text";

   public ActivitySecondFunctionalTest(){
	  super(ActivitySecond.class);
   }

   public void testSetText() throws Exception{

	  ActivitySecond activity = getActivity();

	  ButterKnife.inject(activity);

	  // search for the textView
	  final TextView textView = ButterKnife.findById(activity, R.id.text_view2);

	  // set text
	  getActivity().runOnUiThread(new Runnable() { // *important* to run ui event synchronized

		 @Override
		 public void run(){
			textView.setText(NEW_TEXT);
		 }
	  });

	  getInstrumentation().waitForIdleSync();
	  assertEquals("Text incorrect", NEW_TEXT, textView.getText()
													   .toString());

   }

   @UiThreadTest
   public void testSetTextWithAnnotation() throws Exception{

	  ActivitySecond activity = getActivity();

	  // search for the textView
	  final TextView textView = ButterKnife.findById(activity, R.id.text_view2);

	  textView.setText(NEW_TEXT);
	  assertEquals("Text incorrect", NEW_TEXT, textView.getText()
													   .toString());

   }

} 
