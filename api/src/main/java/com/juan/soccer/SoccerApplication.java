package com.juan.soccer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

import com.juan.soccer.league.DemoLeagueRnking;
import com.juan.soccer.league.DemoLeagueScoring;
import com.juan.soccer.league.LeagueRanking;
import com.juan.soccer.league.LeagueScoring;
import com.juan.soccer.league.LeagueServiceUtil;
import com.juan.soccer.league.RankingExporter;
import com.juan.soccer.league.TeamScore;
import com.juan.soccer.match.MatchServiceMapperUtil;
import com.juan.soccer.report.StandardOutExporter;
import com.juan.soccer.util.FilesExecuteAround;

import picocli.CommandLine;
import picocli.CommandLine.Option;

public class SoccerApplication implements Callable<Integer> {
	// cli File input source
	@Option(names = "--fr", required = false)
	static List<String> fileResults = new ArrayList<>();

	// cli String input source
	@Option(names = "--sr", required = false)
	static List<String> stringResults = new ArrayList<>();

	LeagueScoring scoring = new DemoLeagueScoring();
	LeagueRanking ranking = new DemoLeagueRnking();
	RankingExporter exporter = new StandardOutExporter();

	// Application Entry Point
	public static void main(String[] args) {
		System.exit(new CommandLine(new SoccerApplication()).execute(args));
	}

    @Override
    public Integer call() throws Exception {
		long start = System.currentTimeMillis();

		// Aggregate the raw input from various sources and call demo since non reactive app
		demo(Stream.concat(
				FilesExecuteAround.fileLines(fileResults), 
				stringResults.stream()));

		System.out.println("\n\nExecution time : " + (System.currentTimeMillis() - start) + " ms");

		return 0;
	}

    public void demo(Stream<String> strings) {
    	// 1.1 Input - Process formatted and pre validated strings
    	Stream<TeamScore> teamScores = strings
    		.parallel()
    		.map(MatchServiceMapperUtil::toMatchResult)
    		.flatMap(i -> LeagueServiceUtil.leagueScoring(i, scoring::apply));

    	// 1.2 Output - using a ranking mechanism and destination
    	LeagueServiceUtil.leagueRanking(teamScores, ranking::apply, exporter::accept);
    }
}

