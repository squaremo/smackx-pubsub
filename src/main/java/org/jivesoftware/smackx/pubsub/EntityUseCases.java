/*
 * Created on 2009-04-09
 */
package org.jivesoftware.smackx.pubsub;
 
import java.util.Iterator;

import org.jivesoftware.smackx.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.test.SingleUserTestCase;
import org.jivesoftware.smackx.pubsub.util.XmlUtils;

public class EntityUseCases extends SingleUserTestCase
{
	public void testDiscoverPubsubInfo() throws Exception
	{
		XmlUtils.prettyPrint("Pubsub_Info", getManager().getSupportedFeatures().toXML());
	}

	public void testDiscoverNodeInfo() throws Exception
	{
		Node myNode = getManager().createNode("DiscoNode" + System.currentTimeMillis());
		myNode.discoverInfo();
	}
	
	public void testDiscoverNodeItems() throws Exception
	{
		Node myNode = getPubnode(getManager(), true, false);
		myNode.send(new Item());
		myNode.send(new Item());
		myNode.send(new Item());
		myNode.send(new Item());
		DiscoverItems items = myNode.discoverItems();
		
		int count = 0;
		
		for(Iterator it = items.getItems(); it.hasNext(); it.next(),count++);
		
		assertEquals(4, count);
	}
	
	public void testDiscoverSubscriptions() throws Exception
	{
		getManager().getSubscriptions();
	}
	
	public void testDiscoverNodeSubscriptions() throws Exception
	{
		Node myNode = getPubnode(getManager(), true, true);
		myNode.getSubscriptions();
	}
	
	public void testRetrieveAffiliation() throws Exception
	{
		getManager().getAffiliations();
	}
}
