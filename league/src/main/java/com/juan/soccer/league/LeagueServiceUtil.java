package com.juan.soccer.league;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import com.juan.soccer.match.MatchResult;

public interface LeagueServiceUtil {
	public static Stream<TeamScore> leagueScoring(MatchResult matchresult, Function<MatchResult, Stream<TeamScore>> leagueScoring) {
		return leagueScoring.apply(matchresult);
	}

	public static void leagueRanking(Stream<TeamScore> teamScores, Function<Stream<TeamScore>, Stream<TeamRanking>> scoring, Consumer<Stream<TeamRanking>> acceptor) {
		acceptor.accept(
			scoring.apply(teamScores)
		);
	}
}
