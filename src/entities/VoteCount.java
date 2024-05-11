package entities;

import java.util.Objects;

public class VoteCount {

	private Candidate candidate;
	private int totalVotes = 0;
	
	public VoteCount(Candidate candidate, int totalVotes) {
		this.candidate = candidate;
		this.refreshCount(totalVotes);
	}
	
	public void refreshCount (int input) {
		this.setTotalVotes(this.getTotalVotes()+input);
	}
	 
	public int getTotalVotes() {
		return totalVotes;
	}
	@Override
	public String toString() {
		return totalVotes+"";
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	
	
}
