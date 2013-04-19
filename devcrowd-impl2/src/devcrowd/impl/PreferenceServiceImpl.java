package devcrowd.impl;

import devcrowd.api.PreferenceService;

public class PreferenceServiceImpl implements PreferenceService {

	@Override
	public String getPreference(String key) {
		return "lol";
	}

	@Override
	public void setPreference(String key, String value) {
		System.out.println("Someone tried to store " + key + " " + value);
	}

}
