/*
 * Created on 2009-05-05
 */
package org.jivesoftware.smackx.pubsub.test;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.test.SmackTestCase;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PubSubManager;

abstract public class PubSubTestCase extends SmackTestCase
{
	private PubSubManager[] manager;

	public PubSubTestCase(String arg0)
	{
		super(arg0);
	}

	public PubSubTestCase()
	{
		super("PubSub Test Case");
	}

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        for (int i=0; i<getMaxConnections(); i++) {
            PubSubManager mgr = getManager(i);
            try {
                mgr.createNode(getHomeNodeId(i));
            }
            catch (XMPPException e) {
                if (e.getXMPPError().getCode() != 409) {
                    // NOT a conflict, i.e., not because it was already there.
                    throw e;
                }
            }
        }
    }

    protected String getHomeNodeId(int conn) {
        return "/home/" + getServiceName() + "/" + getUsername(conn);
    }

    protected String getNodeId(int conn, String name) {
        return getHomeNodeId(conn) + "/" + name;
    }


	protected Node getPubnode(PubSubManager pubMgr, boolean persistItems, boolean deliverPayload) throws XMPPException
	{
		ConfigureForm form = new ConfigureForm(FormType.submit);
		form.setPersistentItems(persistItems);
		form.setDeliverPayloads(deliverPayload);
		form.setAccessModel(AccessModel.open);
		return pubMgr.createNode("Pubnode" + System.currentTimeMillis(), form);
	}

	protected PubSubManager getManager(int idx)
	{
		if (manager == null)
		{
			manager = new PubSubManager[getMaxConnections()];
			
			for(int i=0; i<manager.length; i++)
			{
				manager[i] = new PubSubManager(getConnection(i), getService());
			}
		}
		return manager[idx];
	}
	
	protected String getService()
	{
		return "pubsub." + getServiceName();
	}
}
