package pl.qrsor.neetcode.twointegersumII;

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
				Arguments.of(new int[] { 1, 1 }, 2, new int[] { 1, 2 }),
				Arguments.of(new int[] { 1, 2, 3, 4 }, 3, new int[] { 1, 2 }),
				Arguments.of(new int[] { 1, 2, 3, 4 }, 7, new int[] { 3, 4 })
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int target, int[] expected)
	{
		//when
		var result = new Solution().twoSum(input, target);

		//then
		assertArrayEquals(expected, result);
	}
}