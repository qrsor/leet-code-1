package pl.qrsor.neetcode.trappingrainwater;

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
				Arguments.of(new int[] { 0, 0 }, 0),
				Arguments.of(new int[] { 0, 1 }, 0),
				Arguments.of(new int[] { 1, 0 }, 0),
				Arguments.of(new int[] { 1, 1 }, 0),
				Arguments.of(new int[] { 0, 1, 0 }, 0),
				Arguments.of(new int[] { 0, 1, 1 }, 0),
				Arguments.of(new int[] { 1, 1, 0 }, 0),
				Arguments.of(new int[] { 1, 0, 1 }, 1),
				Arguments.of(new int[] { 2, 0, 1 }, 1),
				Arguments.of(new int[] { 1, 0, 2 }, 1),
				Arguments.of(new int[] { 2, 0, 0, 2 }, 4),
				Arguments.of(new int[] { 0, 3, 2, 1, 2, 3, 0 }, 4)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int expected)
	{
		//when
		var result = new Solution().trap(input);

		//then
		assertEquals(expected, result);
	}
}