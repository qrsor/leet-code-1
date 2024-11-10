package pl.qrsor.neetcode.dailytemperatures;

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
				Arguments.of(new int[] { 1 }, new int[] { 0 }),
				Arguments.of(new int[] { 1, 1 }, new int[] { 0, 0 }),
				Arguments.of(new int[] { 1, 2 }, new int[] { 1, 0 }),
				Arguments.of(new int[] { 2, 1 }, new int[] { 0, 0 }),
				Arguments.of(new int[] { 30, 38, 30, 36, 35, 40, 28 }, new int[] { 1, 4, 1, 2, 1, 0, 0 }),
				Arguments.of(new int[] { 22, 21, 20 }, new int[] { 0, 0, 0 })
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int[] expected)
	{
		//given arguments

		//when
		var result = new Solution().dailyTemperatures(input);

		//then
		assertArrayEquals(expected, result);
	}
}