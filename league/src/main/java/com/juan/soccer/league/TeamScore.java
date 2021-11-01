package com.juan.soccer.league;

public class TeamScore {
	private String teamName;
	private Integer teamScore;

	public TeamScore() {
		
	}

	public TeamScore(String teamName) {
		this.teamName = teamName;
	}

	public TeamScore(String teamName, Integer teamScore) {
		this.teamName = teamName;
		this.teamScore = teamScore;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(Integer teamScore) {
		this.teamScore = teamScore;
	}

	@Override
	public String toString() {
		return "TeamScore[teamName=" + teamName + ", teamScore=" + teamScore + "]";
	}
}
