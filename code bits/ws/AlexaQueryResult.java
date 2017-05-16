package ws;
import java.io.Serializable;

public class AlexaQueryResult implements Serializable {
	private String url;
	private int globalRank;
	private int localRank;
	private String rankChange;
	private String country;

	public AlexaQueryResult() {
	
	}

	public AlexaQueryResult(String url, int globalRank, int localRank, String rankChange, 
		String country) {
		this.url = url;
		this.globalRank = globalRank;
		this.localRank = localRank;
		this.rankChange = rankChange;
		this.country = country;
	}

	public String getUrl() {
		return url;
	}

	public int getGlobalRank() {
		return globalRank;
	}

	public int getLocalRank() {
		return localRank;
	}

	public String getRankChange() {
		return rankChange;
	}

	public String getCountry() {
		return country;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setGlobalRank(int globalRank) {
		this.globalRank = globalRank;
	}

	public void setLocalRank(int localRank) {
		this.localRank = localRank;
	}

	public void setRankChange(String rankChange) {
		this.rankChange = rankChange;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void print() {
		System.out.format("{%n\"url\": %s,%n\"globalRank\": %d,%n\"localRank\": %d,%n\"ranckChange\": \"%s\",%n\"country\": \"%s\"%n}%n", 
			url, globalRank, localRank, rankChange, country);
	}
}