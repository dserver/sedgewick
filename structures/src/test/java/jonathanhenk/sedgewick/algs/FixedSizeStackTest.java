package jonathanhenk.sedgewick.algs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

/**
 * Unit test for FixedSizeStack
 */
public class FixedSizeStackTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FixedSizeStackTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FixedSizeStackTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFixedSizeStackBasics()
    {
        FixedSizeStack<Integer> stack_A = new FixedSizeStack<Integer>(4);

        // TEST size() AND max_size()
        Assert.assertEquals("failure - brand new stack size not 0.", stack_A.size(), 0);
        Assert.assertEquals("failure - wrong max size.", stack_A.max_size(), 4);

        try
        {
            // ADD SOME ELEMENTS
            stack_A.push(1);
            stack_A.push(2);
            stack_A.push(3);
        }
        catch (Exception e)
        {
            Assert.fail("failure - stack shouldn't overflow");
        }

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

    public void testExceptionThrowing()
    {
        FixedSizeStack<Integer> stack_A = new FixedSizeStack<Integer>(4);

        // TRY OVERFLOWING
        boolean exception_thrown = false;
        try
        {
            stack_A.push(1);
            stack_A.push(1);
            stack_A.push(1);
            stack_A.push(1);
            stack_A.push(1);
        }
        catch (Exception e)
        {
            exception_thrown = true;
        }
        finally
        {
            Assert.assertEquals("failure - no exception thrown on overflow.", exception_thrown, true);
        }


        // TRY POP() ON EMPTY
        exception_thrown = false;
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
        FixedSizeStack<Integer> stack_A = new FixedSizeStack<Integer>(2);
        FixedSizeStack<Integer> stack_B = new FixedSizeStack<Integer>(2);

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
        FixedSizeStack<Integer> stack_A = new FixedSizeStack<Integer>(2);

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
