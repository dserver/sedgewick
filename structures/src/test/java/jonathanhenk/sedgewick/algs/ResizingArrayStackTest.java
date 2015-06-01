package jonathanhenk.sedgewick.algs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

/**
 * Unit test for ResizingArrayStack
 */
public class ResizingArrayStackTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ResizingArrayStackTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ResizingArrayStackTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testResizingArrayStackBasics()
    {
        ResizingArrayStack<Integer> stack_A = new ResizingArrayStack<Integer>();

        // ADD SOME ELEMENTS
        stack_A.push(1);
        stack_A.push(2);
        stack_A.push(3);



        Assert.assertEquals("failure - pushed 1, 2, 3 but size not 3.", stack_A.size(), 3);

        try {
            Integer three = stack_A.pop();
            Assert.assertEquals("failure - 3 wasn't at the top of the stack.", three, new Integer(3));
        } catch (Exception e)
        {
            Assert.fail("failure - should pop(), stack isn't empty.");
        }

        


        try {
            Integer two = stack_A.peek();
            Assert.assertEquals("failure - 2 wasn't' at the top of the stack.", two, new Integer(2));
        } catch (Exception e)
        {
            Assert.fail("failure - should be able to peek(), the stack isn't empty.");
        }

    }

    public void testResizing()
    {
        ResizingArrayStack<Integer> stack_A = new ResizingArrayStack<Integer>();

        // add 17 elements
        for (int i=1; i<=17; i++)
            stack_A.push(new Integer(1));

        Assert.assertEquals("failure - size should be 17.", stack_A.size(), 17);
        Assert.assertEquals("failure - max_size should be 32.", stack_A.max_size(), 32);

        try {
        // take away 9 elements
        for (int i=1; i<=9; i++)
            stack_A.pop();
        } catch (Exception e)
        {
            Assert.fail("Exception thrown pop()ing non-empty stack.");
        }

        Assert.assertEquals("failure - size should be 8.", stack_A.size(), 8);
        Assert.assertEquals("failure - max_size should be 16.", 16, stack_A.max_size());
    }

    public void testExceptionThrowing()
    {
        ResizingArrayStack<Integer> stack_A = new ResizingArrayStack<Integer>();

        // TRY POP() ON EMPTY
        boolean exception_thrown = false;
        try
        {
            for (int i=0; i<40;i++)
                stack_A.pop();
        }
        catch (Exception e)
        {
            exception_thrown = true;
        }
        finally
        {
            Assert.assertTrue("failure - no exception thrown pop()ing empty stack.", exception_thrown);
        }

    }

    public void testEquality()
    {
        ResizingArrayStack<Integer> stack_A = new ResizingArrayStack<Integer>();
        ResizingArrayStack<Integer> stack_B = new ResizingArrayStack<Integer>();

        try
        {
            stack_A.push(1);
            stack_A.push(2);

            stack_B.push(1);
            stack_B.push(2);

            Assert.assertTrue("A and B aren't equal. (1,2)", stack_B.equals(stack_A));

            stack_A.pop();
            stack_B.pop();

            Assert.assertTrue("A and B aren't equal.(1)", stack_B.equals(stack_A));

            stack_A.pop();
            stack_B.pop();

            Assert.assertTrue("A and B aren't equal.(Empty)", stack_B.equals(stack_A));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    public void testStackEmptySize()
    {
        ResizingArrayStack<Integer> stack_A = new ResizingArrayStack<Integer>();

        boolean exception_thrown = false;
        try
        {
            stack_A.push(1);
            stack_A.push(2);
            stack_A.pop();
            stack_A.pop();

            Assert.assertEquals("size isn't 0.", stack_A.size(), 0);

        }
        catch (Exception e)
        {
            Assert.fail("Exception thrown.");
        }
    }

}
