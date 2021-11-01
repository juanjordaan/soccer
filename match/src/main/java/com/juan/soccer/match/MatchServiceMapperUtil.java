package com.juan.soccer.match;

public interface MatchServiceMapperUtil {
	char COMMA_CHAR = ',';
	char SPACE_CHAR = ' ';

	public static MatchResult toMatchResult(String line) {

		int commaIdx = line.indexOf(COMMA_CHAR);

		String teamA = line.substring(0, commaIdx);
		String teamB = line.substring(commaIdx + 2);

		int spaceIdx = teamA.lastIndexOf(SPACE_CHAR);
		int spaceIdx2 = teamB.lastIndexOf(SPACE_CHAR);

		return new MatchResult(
			teamA.substring(0, spaceIdx),
			Integer.parseInt(teamA.substring(spaceIdx + 1)),
			teamB.substring(0, spaceIdx2),
			Integer.parseInt(teamB.substring(spaceIdx2 + 1))
		);
	}
}
