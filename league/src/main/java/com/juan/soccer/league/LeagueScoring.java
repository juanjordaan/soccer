package com.juan.soccer.league;

import java.util.stream.Stream;

import com.juan.soccer.match.MatchResult;

public interface LeagueScoring {
	Stream<TeamScore> apply(MatchResult matchresult);
}
