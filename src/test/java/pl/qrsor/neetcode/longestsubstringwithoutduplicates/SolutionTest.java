package pl.qrsor.neetcode.longestsubstringwithoutduplicates;

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
				Arguments.of("", 0),
				Arguments.of("a", 1),
				Arguments.of("aa", 1),
				Arguments.of("aba", 2),
				Arguments.of("abac", 3),
				Arguments.of("acabac", 3),
				Arguments.of("zxyzabcxyz", 6),
				Arguments.of("pwwkew", 3)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(String input, int expected)
	{
		//given arguments

		//when
		var result = new Solution().lengthOfLongestSubstring(input);

		//then
		assertEquals(expected, result);
	}
}