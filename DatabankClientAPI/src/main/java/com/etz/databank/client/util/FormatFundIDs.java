package com.etz.databank.client.util;

public class FormatFundIDs {

	public static String format(Object[] fundIds) {
		String fIds = "";
		try {
			if (fundIds != null && fundIds.length > 0) {
				for (Object object : fundIds) {
					fIds = fIds + "." + object;
				}
				return fIds.substring(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
}
