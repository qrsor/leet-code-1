package pl.qrsor.neetcode.longestrepeatingsubstringwithreplacement;

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
				Arguments.of("A", 0, 1),
				Arguments.of("AB", 1, 2),
				Arguments.of("ABA",1, 3),
				Arguments.of("ABBA", 2, 4),
				Arguments.of("ABBB", 2, 4),
				Arguments.of("AAABABB", 1, 5),
				Arguments.of("BBABAAA", 1, 5),
				Arguments.of("AABABBA", 1, 4),
				Arguments.of("ABBABBBABBBB", 1, 8)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(String aString, int replacements,int expected)
	{
		//when
		var result = new Solution().characterReplacement(aString, replacements);

		//then
		assertEquals(expected, result);
	}
}