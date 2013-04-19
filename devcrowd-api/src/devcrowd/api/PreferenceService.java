package devcrowd.api;

public interface PreferenceService {
	public String getPreference(String key);
	public void setPreference(String key, String value);
}
