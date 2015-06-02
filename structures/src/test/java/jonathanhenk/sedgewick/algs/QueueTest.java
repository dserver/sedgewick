package jonathanhenk.sedgewick.algs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;


import edu.princeton.cs.introcs.Out;

public class QueueTest extends TestCase
{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QueueTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QueueTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testEnqueue()
    {
    	Queue<String> q = new Queue<String>();
    	q.enqueue("A");
    	q.enqueue("B");
    	q.enqueue("C");

    	try {
    		Assert.assertEquals("failure - size not 3.", 3, q.size());
	    	Assert.assertEquals("failure - A not at front of queue.", "A", q.dequeue());
	    	Assert.assertEquals("failure - size not 2.", 2, q.size());
	    	Assert.assertEquals("failure - B not at front of queue.", "B", q.dequeue());
	    	Assert.assertEquals("failure - size not 1.", 1, q.size());
	    	Assert.assertEquals("failure - C not at front of queue.", "C", q.dequeue());
	    	Assert.assertEquals("failure - size not 0.", 0, q.size());
	    } catch (Exception e)
	    {
	    	e.printStackTrace(); // shouldn't get here. find out what went wrong.
	    	Assert.fail(e.getMessage());
	    }

    }

    public void testExceptionHandling()
    {
    	Queue<String> q = new Queue<String>();
    	q.enqueue("A");

    	try {
    		q.dequeue();
    	} catch(Exception e)
    	{
	    	e.printStackTrace(); // shouldn't get here. find out what went wrong.
	    	Assert.fail(e.getMessage());
	    }

	    boolean exception_thrown = false;
	    try {
    		q.dequeue();
    	} catch(Exception e)
    	{
	    	exception_thrown = true;
	    } finally
	    {
	    	Assert.assertTrue("failure - exception not thrown.", exception_thrown);
	    }

    }


    public void testEfficiency()
    {
        try {
        Out o = new Out("C:\\Users\\Jon\\algs4\\QSpeed.txt");
        Queue<String> q = new Queue<String>();
        Stopwatch sw = new Stopwatch();


        // Insert and remove 5000 Strings
        for (int i=1; i<=50000; i++)
            q.enqueue("test_string");

        for (int i=1; i<=50000; i++)
            q.dequeue();

        o.println("50K strings," + String.valueOf(sw.elapsedTime()));

        // Insert and remove 100000 Strings
        for (int i=1; i<=100000; i++)
            q.enqueue("test_string");

        for (int i=1; i<=100000; i++)
            q.dequeue();

        o.println("100K strings," + String.valueOf(sw.elapsedTime()));

        // Insert and remove 1000000 Strings
        for (int i=1; i<=1000000; i++)
            q.enqueue("test_string");

        for (int i=1; i<=1000000; i++)
            q.dequeue();

        o.println("1M strings," + String.valueOf(sw.elapsedTime()));



        Assert.assertTrue("f", true);
    } catch (Exception e)
    {
        e.printStackTrace();
        Assert.fail(e.getMessage());
    }
    }
}