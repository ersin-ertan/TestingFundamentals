//package com.nullcognition.testingfundamentals;
//
//import org.mockito.InjectMocks;
//import org.mockito.Matchers;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Created by ersin on 13/02/15 at 1:41 AM
// */
//
//// mockito cannot test final or anon classes, or primitive types
//
//@RunWith(MockitoJUnitRunner.class)
//public class MockitoTest {
//
//   // assume there is a class MyDatabase
//   @Mock
//   MyDatabase databaseMock;
//
//   // used to wrap a real object. Every call, unless specified otherwise, is delegated to the object.
//   public void spyEx(){
//	  // Lets mock a LinkedList
//	  List list = new LinkedList();
//	  List spy = spy(list);
//
////You have to use doReturn() for stubbing
//	  doReturn("foo").when(spy)
//					 .get(0);
//
//// this would not work
//// real method is called so spy.get(0)
//// throws IndexOutOfBoundsException (list is still empty)
//	  when(spy.get(0)).thenReturn("foo");
//
//   }
//
//   @Test
//   public void test1(){
//	  MyClass test = Mockito.mock(MyClass.class);
//	  // define return value for method getUniqueId()
//	  test.when(test.getUniqueId())
//		  .thenReturn(43);
//
//	  // now check if method testing was called with the parameter 12
//	  Mockito.verify(test)
//			 .testing(Matchers.eq(12));
//
//	  // was the method called twice?
//	  Mockito.verify(test, Mockito.times(2));
//   }
//
//   @Test
//   public void testQuery(){
//	  // assume there is a class called ClassToTest
//	  // which could be tested
//	  ClassToTest t = new ClassToTest(databaseMock);
//
//	  // call a method
//	  boolean check = t.query("* from t");
//
//	  // test the return type
//	  assertTrue(check);
//
//	  // test that the query() method on the
//	  // mock object was called
//	  Mockito.verify(databaseMock)
//			 .query("* from t");
//   }
//}
//
//@RunWith(MockitoJUnitRunner.class)
//public class ArticleManagerTest  {
//
//   @Mock
//   private ArticleCalculator calculator;
//   @Mock
//   private ArticleDatabase   database;
//   @Spy
//   private UserProvider userProvider = new ConsumerUserProvider();
//
//   // creates instance of ArticleManager
//   // and performs constructor injection on it
//   @InjectMocks
//   private ArticleManager manager = new ArticleManager();
//
//   @Test
//   public void shouldDoSomething(){
//	  MockitoAnnotations.initMocks(this);
//	  verify(database).addListener(any(ArticleListener.class));
//   }
//}
