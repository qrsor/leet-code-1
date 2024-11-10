package pl.qrsor.neetcode.permutationstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest
{
	public static Stream<Arguments> provideParameters()
	{
		return Stream.of(
				Arguments.of("a", "a", true),
				Arguments.of("b", "a", false),
				Arguments.of("ab", "ba", true),
				Arguments.of("aab", "ba", false),
				Arguments.of("ab", "bca", false),
				Arguments.of("ab", "cab", true)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(String s1, String s2, boolean expected)
	{
		//when
		var result = new Solution().checkInclusion(s1, s2);

		//then
		assertEquals(expected, result);
	}
}