package com.juan.soccer.match.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.juan.soccer.match.MatchResult;
import com.juan.soccer.match.MatchServiceMapperUtil;

// https://stackoverflow.com/questions/40685523/how-to-junit-a-java-util-function-using-mockito
public class SoccerMatchTest {
	
	@BeforeEach
	public void init() {
        
    }

	@DisplayName("Test Mapper Arguments - Passes")
	@Test
	public void testMapper_Passes() {
		// Given
		String input = "a 1, b 2";

		// When
		MatchResult matchResult = MatchServiceMapperUtil.toMatchResult(input);

		// Then
		assertEquals("a", matchResult.getTeamAName());
		assertEquals(1, matchResult.getTeamAPoints());
		assertEquals("b", matchResult.getTeamBName());
		assertEquals(2, matchResult.getTeamBPoints());
	}
}
