package test;

import org.testng.annotations.Test;

import fb.FizzBuzz;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FizzBuzzTest {
  
	private PrintStream sysOut;	//standard output
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();	//standard output
	
	
	@Test(dataProvider = "datasetSuccess")
	public void TestSuccess(Integer start, Integer end, Integer fizz, Integer buzz, String[] expected) {
	  
		FizzBuzz.fizzbuzz(start, end, fizz, buzz);	  
		assertEquals(expected, outContent.toString().split("\r\n"));
	}
  
	
	// I personally believe there is no need to a failure test in this case, as it is essentially the negative of the success test
	// fail tests should be used to check proper error exit values, or in integration contexts, i.e.
	// I remember Alian and I discussed about this
	@Test(dataProvider = "datasetFail")
	public void TestFail(Integer start, Integer end, Integer fizz, Integer buzz, String[] expected) {
	  
		FizzBuzz.fizzbuzz(start, end, fizz, buzz);	  
		assertNotEquals(expected, outContent.toString().split("\r\n"));
	}
  
	// grab standard output
	@BeforeMethod
	public void beforeMethod() {

		sysOut = System.out;
		System.setOut(new PrintStream(outContent));
	}

	// restore standard output
	@AfterMethod
	public void afterMethod() {

		System.out.flush();
		outContent.reset(); // reset data
		System.setOut(sysOut);
	}


	@DataProvider
	public Object[][] datasetSuccess() {
		return new Object[][] {
			new Object[] { 1, 10, 2, 5, new String[] { "1", "Fizz", "3", "Fizz", "Buzz", "Fizz", "7", "Fizz", "9", "FizzBuzz"} },
			new Object[] { 1, 10, 2, 3, new String[] { "1", "Fizz", "Buzz", "Fizz", "5", "FizzBuzz", "7", "Fizz", "Buzz", "Fizz"} }
		};
	}
  
	@DataProvider
	public Object[][] datasetFail() {
		return new Object[][] {
			new Object[] { 1, 10, 2, 5, new String[] { "Fizz", "Fizz", "3", "Fizz", "Buzz", "Fizz", "7", "Fizz", "9", "FizzBuzz"} },
			new Object[] { 1, 10, 2, 3, new String[] { "1", "Fizz", "Buzz", "4", "5", "FizzBuzz", "7", "Fizz", "Buzz", "Fizz"} }
		};
	}
	
  
	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
