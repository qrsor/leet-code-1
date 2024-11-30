package pl.qrsor.neetcode.slidingwindowmaximum;

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
//				Arguments.of(new int[] { 1, -1 }, 1, new int[] { 1, -1 }),
//				Arguments.of(new int[] { 0, 1, 2 }, 1, new int[] { 0, 1, 2 }),
//				Arguments.of(new int[] { 0, 1, 2 }, 2, new int[] { 1, 2 }),
//				Arguments.of(new int[] { 0, 1, 2 }, 3, new int[] { 2 }),
//				Arguments.of(new int[] { 1, 2, 1, 0, 4, 2, 6 }, 3, new int[] { 2, 2, 4, 4, 6 }),
				Arguments.of(new int[] { 1, 2, 1, 0, 4, 2, 6 }, 5, new int[] { 4, 4, 6 })
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int k, int[] expected)
	{
		//when
		var result = new Solution().maxSlidingWindow(input, k);

		//then
		assertArrayEquals(expected, result);
	}
}