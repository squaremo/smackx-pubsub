/*
 * Created on 2009-04-09
 */
package org.jivesoftware.smackx.pubsub.test;
 
import org.jivesoftware.smackx.pubsub.*;
import java.util.Collection;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.test.SingleUserTestCase;

public class PublisherUseCases extends SingleUserTestCase
{
	public void testSendNodeTrNot() throws Exception
	{
		getPubnode(false, false).send();
	}

	public void testSendNodeTrPay_WithOutPayload() throws XMPPException
	{
		Node node = getPubnode(false, true);
		node.send(new Item());
		node.send(new Item("test" + System.currentTimeMillis()));
	}

	public void testSendNodeTrPay_WithPayload() throws XMPPException
	{
		Node node = getPubnode(false, true);
		node.send(new Item<SimplePayload>(null, 
						new SimplePayload("book", "pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Lord of the Rings</title></book>")));
		node.send(new Item<SimplePayload>("test" + System.currentTimeMillis(), 
						new SimplePayload("book", "pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Two Towers</title></book>")));
	}

	public void testSendNodePerNot() throws Exception
	{
		Node node = getPubnode(true, false);
		node.send(new Item());
		node.send(new Item("test" + System.currentTimeMillis()));
		node.send(new Item<SimplePayload>(null, 
						new SimplePayload("book", "pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Lord of the Rings</title></book>")));
		node.send(new Item<SimplePayload>("test" + System.currentTimeMillis(), 
						new SimplePayload("book", "pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Two Towers</title></book>")));
	}

	public void testSendPerPay_WithPayload() throws Exception
	{
		Node node = getPubnode(true, true);
		node.send(new Item<SimplePayload>(null, 
						new SimplePayload("book", "pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Lord of the Rings</title></book>")));
		node.send(new Item<SimplePayload>("test" + System.currentTimeMillis(), 
						new SimplePayload("book", "pubsub:test:book", "<book xmlns='pubsub:test:book'><title>Two Towers</title></book>")));
	}

	public void testSendPerPay_NoPayload() throws Exception
	{
		Node node = getPubnode(true, true);
		node.send(new Item());
		node.send(new Item("test" + System.currentTimeMillis()));
	}
		
	public void testDeleteItems() throws XMPPException
	{
		Node node = getPubnode(true, false);
		
		node.send(new Item("1"));
		node.send(new Item("2"));
		node.send(new Item("3"));
		node.send(new Item("4"));
		
		node.deleteItem("1");
		Collection<Item> items = node.getItems();
		
		assertTrue(items.size() == 3);
		assertEquals(items.iterator().next().getId(), "2");
	}
}
