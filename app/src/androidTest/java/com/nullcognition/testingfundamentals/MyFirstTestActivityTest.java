package com.nullcognition.testingfundamentals;

import android.media.AudioManager;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import org.mockito.Mockito;

// if static import, idea will optimize imports from .* to this:

import static android.media.AudioManager.RINGER_MODE_SILENT;
import static android.media.AudioManager.STREAM_RING;

/**
 * Created by ersin on 11/02/15 at 12:40 AM
 */


class MyFirstTestActivityTest extends ActivityInstrumentationTestCase2<ActivityMain> {

   private ActivityMain activityMain;
   private TextView     textView;

   public MyFirstTestActivityTest(){

	  super(ActivityMain.class);
   }

   /* invoked by the test runner before it runs any tests in the test class
   */
   @Override
   protected void setUp() throws Exception{


	  /*
	  Defining the instance variables that store the state of the fixture.

	  Creating and storing a reference to an instance of the Activity under test.

	  Obtaining a reference to any UI components in the Activity that you want to test.
	  */

	  super.setUp(); // required by JUNIT

	  activityMain = getActivity();

	  textView = (TextView)activityMain.findViewById(R.id.text_view);
   }

   public void testPreconditions(){

	  assertNotNull("activity main is null", activityMain);
	  assertNotNull("text view is null", textView);
   }

   public void testMyFirstTestTextView_labelText(){

	  final String expected = activityMain.getString(R.string.hello_world);
	  final String actual = textView.getText()
									.toString();

	  assertEquals(expected, actual);
   }

   // http://corner.squareup.com/2012/10/mockito-android.html
   // example

   public void maximizeVolume(AudioManager audioManager){

	  if(audioManager.getRingerMode() != RINGER_MODE_SILENT){

		 int max = audioManager.getStreamMaxVolume(STREAM_RING);

		 audioManager.setStreamVolume(STREAM_RING, max, 0);
	  }
   }

   public void testSilentRingerIsNotDisturbed(){

	  // 1. Prepare mocks and script their behavior.

	  AudioManager audioManager = Mockito.mock(AudioManager.class);

	  Mockito.when(audioManager.getRingerMode())
			 .thenReturn(RINGER_MODE_SILENT);

	  // 2. Test the code of interest.
	  maximizeVolume(audioManager);

	  // 3. Validate that we saw exactly what we wanted.

	  Mockito.verify(audioManager)
			 .getRingerMode();

	  Mockito.verifyNoMoreInteractions(audioManager);
   }


}




































































