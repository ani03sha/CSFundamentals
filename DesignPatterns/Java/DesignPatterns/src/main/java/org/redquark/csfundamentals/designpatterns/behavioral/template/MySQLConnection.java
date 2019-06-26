package org.redquark.csfundamentals.designpatterns.behavioral.template;

/**
 * @Author Anirudh Sharma
 */
public class MySQLConnection extends DBConnectionTemplate {

	@Override
	public void setDBDriver() {
		System.out.println("Setting MySQL DB drivers...");
	}

	@Override
	public void setCredentials() {
		System.out.println("Setting credentials for MySQL DB...");
	}

	@Override
	public void setData() {
		System.out.println("Setting up data from CSV file...");
	}
}
