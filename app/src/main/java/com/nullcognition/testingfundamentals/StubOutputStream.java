package com.nullcognition.testingfundamentals;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ersin on 12/02/15 at 6:58 PM
 */

public class StubOutputStream extends FileOutputStream {

   int fileWrites = 0;

   public StubOutputStream() throws FileNotFoundException{
	  super(FileDescriptor.out);
   }

   // count number of calls, don't bother to really write something
   @Override
   public void write(byte[] buffer) throws IOException{
	  fileWrites++;
   }

}

// in the class that extends test case

//MockContext context = new MockContext() {
//public java.io.FileOutputStream openFileOutput(String name, int mode)
//  throws java.io.FileNotFoundException {
//   return new StubOutputStream();
//};
//};

// then

// public void testWriteConfigurationShouldAccessFileSystemTwice() {
//assertEquals("No file writes yet", fileWrites, 0);
//Util.writeConfiguration(context);
//  assertEquals("Failed to write twice", 2, fileWrites);
//  }
