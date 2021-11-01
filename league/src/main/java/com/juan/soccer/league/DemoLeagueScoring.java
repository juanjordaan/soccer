package com.juan.soccer.league;

import java.util.stream.Stream;

import com.juan.soccer.match.MatchResult;

public class DemoLeagueScoring implements LeagueScoring {
	// a draw (tie) is worth 1 point
	// a win is worth 3 points.
	// A loss is worth 0 points
	public static final int TIE_POINTS = 1;
	public static final int WIN_POINTS = 3;
	public static final int LOSS_POINTS = 0;

	@Override
	public Stream<TeamScore> apply(MatchResult matchresult) {
		TeamScore teamA = new TeamScore(matchresult.getTeamAName(), TIE_POINTS);
		TeamScore teamB = new TeamScore(matchresult.getTeamBName(), TIE_POINTS);

		if(matchresult.getTeamAPoints() > matchresult.getTeamBPoints()) {
			teamA.setTeamScore(WIN_POINTS);
			teamB.setTeamScore(LOSS_POINTS);
		} else if (matchresult.getTeamBPoints() > matchresult.getTeamAPoints()) {
			teamA.setTeamScore(LOSS_POINTS);
			teamB.setTeamScore(WIN_POINTS);
		}

		return Stream.of(teamA, teamB);
	}
}
