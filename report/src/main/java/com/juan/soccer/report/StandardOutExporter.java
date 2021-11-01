package com.juan.soccer.report;

import java.util.stream.Stream;

import com.juan.soccer.league.RankingExporter;
import com.juan.soccer.league.TeamRanking;

public class StandardOutExporter implements RankingExporter {
	@Override
	public void accept(Stream<TeamRanking> teamRankings) {
		teamRankings.forEach(i -> 
			System.out.println(i.getRank() + ". " + i.getTeamName() + ", " + i.getScore() + " pts")
		);
	}
}
