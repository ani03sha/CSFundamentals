package org.redquark.csfundamentals.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anirudh Sharma
 */
public class AccessControlProvider {

	private static Map<String, AccessControl> map = new HashMap<>();

	static {
		System.out.println("Fetching data from external resources and creating  access control objects...");
		map.put("USER", new AccessControl("USER", "DO_WORK"));
		map.put("ADMIN", new AccessControl("ADMIN", "ADD/REMOVE USERS"));
		map.put("MANAGER", new AccessControl("MANAGER", "GENERATE/READ REPORTS"));
		map.put("VP", new AccessControl("VP", "MODIFY REPORTS"));
	}

	public static AccessControl getAccessControlObject(String controlLevel) {
		AccessControl accessControl = null;
		try {
			accessControl = map.get(controlLevel);
			if (accessControl != null) {
				return accessControl.clone();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
