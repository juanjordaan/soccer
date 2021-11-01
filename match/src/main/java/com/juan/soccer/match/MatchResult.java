package com.juan.soccer.match;

public class MatchResult {
	private String teamAName;
	private Integer teamAPoints;

	private String teamBName;
	private Integer teamBPoints;

	public MatchResult() {};

	public MatchResult(String teamAName, Integer teamAPoints, String teamBName, Integer teamBPoints) {
		super();
		this.teamAName = teamAName;
		this.teamAPoints = teamAPoints;
		this.teamBName = teamBName;
		this.teamBPoints = teamBPoints;
	}

	public String getTeamAName() {
		return teamAName;
	}

	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}

	public Integer getTeamAPoints() {
		return teamAPoints;
	}

	public void setTeamAPoints(Integer teamAPoints) {
		this.teamAPoints = teamAPoints;
	}

	public String getTeamBName() {
		return teamBName;
	}

	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}

	public Integer getTeamBPoints() {
		return teamBPoints;
	}

	public void setTeamBPoints(Integer teamBPoints) {
		this.teamBPoints = teamBPoints;
	}

	@Override
	public String toString() {
		return "MatchResult[teamAName=" + teamAName + ", teamAPoints=" + teamAPoints + 
				", teamBName=" + teamBName + ", teamBPoints=" + teamBPoints + "]";
	}
}
