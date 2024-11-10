package pl.qrsor.leetcode.problem55canjump;

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
				Arguments.of(new int[] { 0 }, true),
				Arguments.of(new int[] { 1, 0 }, true),
				Arguments.of(new int[] { 1, 0, 0 }, false),
				Arguments.of(new int[] { 0, 1, 0 }, false),
				Arguments.of(new int[] { 1, 1, 0 }, true),
				Arguments.of(new int[] { 1, 0, 1, 0 }, false),
				Arguments.of(new int[] { 2, 0, 1, 0 }, true),
				Arguments.of(new int[] { 1, 2, 0, 0 }, true)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, boolean expected)
	{
		//when
		var result = new Solution().canJump(input);

		//then
		assertEquals(expected, result);
	}
}