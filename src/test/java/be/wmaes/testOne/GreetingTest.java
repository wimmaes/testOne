package be.wmaes.testOne;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GreetingTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GreetingTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GreetingTest.class );
    }

    /**
     * Test greeting
    */
    public void testApp()
    {
    	GreetingController greetingController = new GreetingController();
    	
        Greeting greeting = greetingController.greeting("Test Name");
        assertEquals("Hello, Test Name! Nice to have you here.", greeting.getContent().substring(0, 40));
    }
     
}
