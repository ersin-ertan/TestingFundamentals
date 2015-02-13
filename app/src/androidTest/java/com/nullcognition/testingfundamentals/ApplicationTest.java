package com.nullcognition.testingfundamentals;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

   public ApplicationTest(){
	  super(Application.class);
   }
}


/*

Most important mocks

MockApplication

MockContext

RenamingDelegatingContext class delegates calls to a given context and supports database and file operations

MockResources

MockContentProvider

MockContentResolver

MockPackageManager

*/
