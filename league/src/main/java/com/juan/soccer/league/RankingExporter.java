package com.juan.soccer.league;

import java.util.stream.Stream;

@FunctionalInterface
public interface RankingExporter {
	public void accept(Stream<TeamRanking> teamRankings);
}
