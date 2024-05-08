package entities;

import java.util.Objects;

public class Logs {

	private String userName;
	private String instant;
	
	public Logs(String userName, String instant) {
		this.userName = userName;
		this.instant = instant;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInstant() {
		return instant;
	}

	public void setInstant(String instant) {
		this.instant = instant;
	}

	@Override
	public String toString() {
		return "Logs [userName=" + userName + ", instant=" + instant + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logs other = (Logs) obj;
		return Objects.equals(userName, other.userName);
	}
	
}
