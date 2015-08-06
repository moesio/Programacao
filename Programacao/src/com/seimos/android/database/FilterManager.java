package com.seimos.android.database;

/**
 * @author moesio @ gmail.com
 * @date Aug 3, 2015 7:33:50 PM
 */
public class FilterManager {

	private static String selection;
	private static String[] args;

	private static void split(Filter[] filters) {
		if (selection == null || args == null) {
			if (filters != null && filters.length > 0) {
				args = new String[filters.length];

				StringBuilder selection = new StringBuilder();
				selection.append(filters[0].getClausule());
				args[0] = filters[0].getValue();
				for (int i = 1; i < filters.length; i++) {
					selection.append(", ").append(filters[0].getClausule());
				}
				FilterManager.selection = selection.toString();
			}
		}
	}

	public static String getSelection(Filter[] filters) {
		split(filters);
		return selection;
	}

	public static String[] getArgs(Filter[] filters) {
		split(filters);
		return args;
	}
}
