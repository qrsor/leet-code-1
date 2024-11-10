package pl.qrsor.neetcode.maxwatercontainer;

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
				Arguments.of(new int[] { 0, 0 }, 0),
				Arguments.of(new int[] { 0, 1 }, 0),
				Arguments.of(new int[] { 1, 0 }, 0),
				Arguments.of(new int[] { 1, 1 }, 1),
				Arguments.of(new int[] { 0, 1, 0 }, 0),
				Arguments.of(new int[] { 0, 1, 1 }, 1),
				Arguments.of(new int[] { 1, 1, 0 }, 1),
				Arguments.of(new int[] { 2, 3, 2 }, 4),
				Arguments.of(new int[] { 1, 0, 1 }, 2),
				Arguments.of(new int[] { 1, 4, 4, 1 }, 4),
				Arguments.of(new int[] { 1, 7, 2, 5, 12, 3, 500, 500, 7, 8, 4, 7, 3, 6 }, 500)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int expected)
	{
		//when
		var result = new Solution().maxArea(input);

		//then
		assertEquals(expected, result);
	}
}