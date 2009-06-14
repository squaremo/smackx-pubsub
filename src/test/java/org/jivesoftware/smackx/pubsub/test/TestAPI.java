/*
 * Created on 2009-04-09
 */
package org.jivesoftware.smackx.pubsub.test;
 
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.test.SingleUserTestCase;

public class TestAPI extends SingleUserTestCase
{
	public void testGetNonexistentNode()
	{
		try
		{
			getManager().getNode("" + System.currentTimeMillis());
			assertTrue(false);
		}
		catch (XMPPException e)
		{
		}
	}
	
	public void testGetAllNodes() throws Exception
	{
		getManager().getNodes();
	}
}
