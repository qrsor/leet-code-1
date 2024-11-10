package pl.qrsor.neetcode.ispalindrome;

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
				Arguments.of("a", true),
//				Arguments.of("?", ???),
				Arguments.of("aa", true),
				Arguments.of("a?", true),
				Arguments.of(" a ", true),
				Arguments.of("ab", false),
				Arguments.of("a ba", true),
				Arguments.of("Was it a car or a cat I saw?", true)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(String input, boolean expected)
	{
		//when
		var result = new Solution().isPalindrome(input);

		//then
		assertEquals(expected, result);
	}
}