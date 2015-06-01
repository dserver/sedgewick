package jonathanhenk.projects.expression_evaluator;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

public class ExpressionEvaluatorTest extends TestCase
{
	    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ExpressionEvaluatorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ExpressionEvaluatorTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testSimpleAdd()
    {
    	String exp = "(4+3)";

    	try
    	{
    		Double d = ExpressionEvaluator.eval_exp(exp);
    		Assert.assertEquals("failure - (4+3).", new Double(7), d);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		Assert.fail(e.getMessage());
    	}
    }

    public void testNestedAddition()
    {
    	String exp = "((4+3)+2)";

    	try
    	{
    		Double d = ExpressionEvaluator.eval_exp(exp);
    		Assert.assertEquals("failure - " + exp + ".", new Double(9), d);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		Assert.fail(e.getMessage());
    	}

    }

    public void testAdditionWithMultiplication1()
    {
    	String exp = "((4+3)*2)";

    	try
    	{
    		Double d = ExpressionEvaluator.eval_exp(exp);
    		Assert.assertEquals("failure - " + exp + ".", new Double(14), d);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		Assert.fail(e.getMessage());
    	}
    }

    public void testAdditionWithMultiplication2()
    {
    	String exp = "((1+2)*(2+(2*4)))";

    	try
    	{
    		Double d = ExpressionEvaluator.eval_exp(exp);
    		Assert.assertEquals("failure - " + exp + ".", new Double(30), d);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		Assert.fail(e.getMessage());
    	}
    }

    public void testSqrt()
    {
    	String exp = "(sqrt(4))";

    	try
    	{
    		Double d = ExpressionEvaluator.eval_exp(exp);
    		Assert.assertEquals("failure - " + exp + ".", new Double(2), d);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		Assert.fail(e.getMessage());
    	}
    }

}