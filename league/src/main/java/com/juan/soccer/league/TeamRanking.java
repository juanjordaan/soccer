package com.juan.soccer.league;

public class TeamRanking {
	private String teamName;
	private int score;
	private int rank;

	public TeamRanking(String teamName, int score, int rank) {
		super();
		this.teamName = teamName;
		this.score = score;
		this.rank = rank;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "TeamRanking[teamName=" + teamName + ", score=" + score + ", rank=" + rank + "]";
	}
}
