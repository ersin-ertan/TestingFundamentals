package com.nullcognition.testingfundamentals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.AndroidTestCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by ersin on 13/02/15 at 2:14 AM
 *
 * Mocking fail, could not mock class Context pointing to line 25
 */

public class MainActivityTest extends AndroidTestCase {

   @Mock
   Context context;

   @Override
   protected void setUp() throws Exception{
	  System.setProperty("dexmaker.dexcache", "/sdcard"); // needed to get fix dexmaker.dexcache
	  MockitoAnnotations.initMocks(this);
   }

   public void testQuery() throws Exception{

	  Intent intent = ActivityMain.startNewActivityI(context, "query");
	  assertNotNull(intent);

	  Bundle extras = intent.getExtras();
	  assertNotNull(extras);

	  assertEquals("query", extras.getString(ActivityMain.ACTIVITY_MAIN_KEY));
   }
}
