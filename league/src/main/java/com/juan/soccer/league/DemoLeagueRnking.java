package com.juan.soccer.league;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoLeagueRnking implements LeagueRanking {
	@Override
	public Stream<TeamRanking> apply(Stream<TeamScore> teamScores) {
		AtomicInteger ints = new AtomicInteger(1);

		List<TeamRanking> teamRankingList = new ArrayList<TeamRanking>();
		teamScores
			.collect(
				Collectors.groupingByConcurrent(TeamScore::getTeamName, Collectors.summingInt(TeamScore::getTeamScore))
			)
			.forEach((key, value) -> teamRankingList.add(new TeamRanking(key, value, 0)));

		return teamRankingList
				.stream()
				.sorted(Comparator.comparingInt(TeamRanking::getScore).reversed().thenComparing(TeamRanking::getTeamName))
				.peek(i -> i.setRank(ints.getAndIncrement()));
	}
}
