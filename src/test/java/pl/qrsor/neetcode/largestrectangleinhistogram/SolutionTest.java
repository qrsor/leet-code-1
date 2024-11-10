package pl.qrsor.neetcode.largestrectangleinhistogram;

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
				Arguments.of(new int[] { 0 }, 0),
				Arguments.of(new int[] { 1 }, 1),
				Arguments.of(new int[] { 1, 2 }, 2),
				Arguments.of(new int[] { 2, 1 }, 2),
				Arguments.of(new int[] { 1, 2, 1 }, 3),
				Arguments.of(new int[] { 1, 2, 1, 3 }, 4)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int expected)
	{
		//given arguments

		//when
		var result = new Solution().largestRectangleArea(input);

		//then
		assertEquals(expected, result);
	}
}