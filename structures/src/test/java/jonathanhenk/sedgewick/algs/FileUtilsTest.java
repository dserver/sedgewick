package jonathanhenk.sedgewick.algs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;


public class FileUtilsTest extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FileUtilsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FileUtilsTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testListFiles()
    {
    	FileUtils fi = new FileUtils();
    	fi.listFiles("C:\\Users\\Jon\\Desktop\\TestMaveApp");
    }
}