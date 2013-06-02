package net.scholnick.unittests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{
	private AllTests() {}
	
	public static Test suite()
	{
		TestSuite suite = new TestSuite("Test for net.scholnick.unittests");
		//$JUnit-BEGIN$
		suite.addTestSuite(BoldTagTestCase.class);
		suite.addTestSuite(UnOrderedListCollectionTagTestCase.class);
		//$JUnit-END$
		return suite;
	}

}
