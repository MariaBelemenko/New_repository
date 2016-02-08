package com.thomsonreuters.pageobjects.utils.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Mailbox {

	protected static final Logger LOG = LoggerFactory.getLogger(Mailbox.class);

	private String username;
	private String domain;
	private String password;

	private List<Message> messages = new ArrayList<Message>();

	private Store store = null;
	private Folder inboxFolder = null;

	public Mailbox(String userName, String domain, String password) {
		this.username = userName;
		this.domain = domain;
		this.password = password;

	}

	public void loadNewMessages() throws MessagingException {
		close();

		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getInstance(props, null);
		store = session.getStore();
		store.connect("imap." + domain, username + "@" + domain, password);
		inboxFolder = store.getFolder("INBOX");
		inboxFolder.open(Folder.READ_WRITE);

		Message msg[] = inboxFolder.getMessages();
		FetchProfile fetchProfile = new FetchProfile();
		fetchProfile.add(FetchProfile.Item.ENVELOPE);
		inboxFolder.fetch(msg, fetchProfile);

		for (int i = 0; i < msg.length; i++) {
			if (!msg[i].getFlags().contains(Flags.Flag.DELETED)) {
				messages.add(msg[i]);
			}
			msg[i].setFlag(Flags.Flag.DELETED, true);
		}

	}

	private void close() {
		try {
			messages.clear();
			if (inboxFolder != null) {
				inboxFolder.close(true);
				inboxFolder = null;
			}
			if (store != null) {
				store.close();
				store = null;
			}
		} catch (MessagingException e) {
			LOG.info("Could not close mailbox");
		}
	}

	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}

	public Message waitForMessageWithTitle(String title, int timeoutSeconds, int intervalSeconds) throws Throwable {
		Message result = null;

		long stopTime = System.currentTimeMillis() + timeoutSeconds * 1000;

		while (stopTime > System.currentTimeMillis() && result == null) {

			try {
				loadNewMessages();

				for (Message m : messages) {
					if (!m.getSubject().contains(title)) {
						continue;
					}
					result = m;
				}
			} catch (MessagingException e) {
				LOG.info("Could not load messages");
			}
			if (result == null) {
				Thread.sleep(intervalSeconds * 1000);
			}
		}
		if (result == null) {
			throw new Exception("Could not get message with title '" + title + "'");
		}
		return result;
	}

	public List<Message> getMessages() {
		return messages;
	}

}
