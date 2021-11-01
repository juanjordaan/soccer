package com.juan.soccer.league;

import java.util.stream.Stream;

@FunctionalInterface
public interface LeagueRanking {
	Stream<TeamRanking> apply(Stream<TeamScore> teamScores);
}
