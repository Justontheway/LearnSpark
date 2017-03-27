package org.ontheway.learn.java;

/**
 * Java Language Feature test.
 * @author NOTHING
 */
public class JavaLangFeature {
	/** Joins a list of strings using the given separator. */
	// what does String... mean ?
	public String join(String sep, String... elements) {
		StringBuilder sb = new StringBuilder();
		for (String e : elements) {
			if (e != null) {
				if (sb.length() > 0) {
					sb.append(sep);
	        	}
				sb.append(e);
	        }
		}
		System.out.println(elements.getClass());
		return sb.toString();
	}

}