package com.juan.soccer.league.test;

import static com.juan.soccer.league.DemoLeagueScoring.LOSS_POINTS;
import static com.juan.soccer.league.DemoLeagueScoring.TIE_POINTS;
import static com.juan.soccer.league.DemoLeagueScoring.WIN_POINTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.juan.soccer.league.DemoLeagueRnking;
import com.juan.soccer.league.DemoLeagueScoring;
import com.juan.soccer.league.LeagueServiceUtil;
import com.juan.soccer.league.TeamRanking;
import com.juan.soccer.league.TeamScore;
import com.juan.soccer.match.MatchResult;

public class SoccerLeagueTest {
	Function<MatchResult, Stream<TeamScore>> testScorer = (matchresult) -> new DemoLeagueScoring().apply(matchresult);
	Function<Stream<TeamScore>, Stream<TeamRanking>> testRanker = (teamScores) -> new DemoLeagueRnking().apply(teamScores);

	@BeforeEach
	public void init() {
		
    }

	@DisplayName("Test League Scoring Draw")
	@Test
	public void testLeagueScoringDraw_Passes() {
		// Given
		MatchResult drawResult = new MatchResult("a", 6, "b", 6);

		// When
		LeagueServiceUtil.leagueScoring(drawResult, testScorer::apply)
		.forEach(i -> {
			// Then
			if(i.getTeamName().equals("a")) {
				assertEquals(TIE_POINTS, i.getTeamScore());
			} else {
				assertEquals(TIE_POINTS, i.getTeamScore());
			}
		});
	}

	@DisplayName("Test League Scoring Win/Loss")
	@Test
	public void testLeagueScoringWinLoss_Passes() {
		// Given
		MatchResult drawResult = new MatchResult("a", 6, "b", 5);

		// When
		LeagueServiceUtil
			.leagueScoring(drawResult, testScorer::apply)
			.forEach(i -> {
				// Then
				if(i.getTeamName().equals("a")) {
					assertEquals(WIN_POINTS, i.getTeamScore());
				} else {
					assertEquals(LOSS_POINTS, i.getTeamScore());
				}
			});
	}

	@DisplayName("Test League Ranking")
	@Test
	public void testLeagueRanking_Passes() {
		// Then
		Consumer<Stream<TeamRanking>> testRankConsumer = (teamsRanks) -> {
			List<TeamRanking> rankList = teamsRanks.collect(Collectors.toList());
			assertEquals(3, rankList.size());

			TeamRanking r1 = rankList.get(0);
			assertEquals(r1.getTeamName(), "b");
			assertEquals(r1.getScore(), 3);
			assertEquals(r1.getRank(), 1);

			TeamRanking r2 = rankList.get(1);
			assertEquals(r2.getTeamName(), "a1");
			assertEquals(r2.getScore(), 2);
			assertEquals(r2.getRank(), 2);

			TeamRanking r3 = rankList.get(2);
			assertEquals(r3.getTeamName(), "a2");
			assertEquals(r3.getScore(), 2);
			assertEquals(r3.getRank(), 3);
		};

		// Given
		Stream<TeamScore> teamScores = Stream.of(
			new TeamScore("a2", 2),
			new TeamScore("a1", 2),
			new TeamScore("b", 3));

		// When / Then
		LeagueServiceUtil.leagueRanking(teamScores, testRanker::apply, testRankConsumer);
	}
}
