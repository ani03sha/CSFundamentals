package org.redquark.csfundamentals.designpatterns.behavioral.template;

/**
 * @Author Anirudh Sharma
 */
public abstract class DBConnectionTemplate {

	public final void run() {
		setDBDriver();
		setCredentials();
		connect();
		prepareStatement();
		setData();
		insert();
		close();
		destroy();
	}

	public abstract void setDBDriver();

	public abstract void setCredentials();

	public void connect() {
		System.out.println("Setting connection...");
	}

	public void prepareStatement() {
		System.out.println("Preparing insert statement...");
	}

	public abstract void setData();

	public void insert() {
		System.out.println("Inserting data...");
	}

	public void close() {
		System.out.println("Closing connections...");
	}

	public void destroy() {
		System.out.println("Destroying connection objects...");
	}
}
