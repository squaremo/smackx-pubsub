/*
 * Created on 2009-05-05
 */
package org.jivesoftware.smackx.pubsub.test;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PubSubManager;

public class SingleUserTestCase extends PubSubTestCase
{
	protected PubSubManager getManager()
	{
		return getManager(0);
	}
	
	protected Node getPubnode(boolean persistItems, boolean deliverPayload) throws XMPPException
	{
		return getPubnode(getManager(), persistItems, deliverPayload);
	}

	@Override
	protected int getMaxConnections()
	{
		return 1;
	}

}
