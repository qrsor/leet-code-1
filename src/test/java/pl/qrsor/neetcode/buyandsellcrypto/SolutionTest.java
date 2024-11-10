package pl.qrsor.neetcode.buyandsellcrypto;

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
				Arguments.of(new int[] { 1 }, 0),
				Arguments.of(new int[] { 1, 2 }, 1),
				Arguments.of(new int[] { 2, 1 }, 0),
				Arguments.of(new int[] { 1, 2, 3 }, 2),
				Arguments.of(new int[] { 1, 4, 3 }, 3),
				Arguments.of(new int[] { 2, 4, 1 }, 2),
				Arguments.of(new int[] { 2, 1, 4, 3 }, 3),
				Arguments.of(new int[] { 2, 3, 3, 5, 1, 4, 7 }, 6)

		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, int expected)
	{
		//given arguments

		//when
		var result = new Solution().maxProfit(input);

		//then
		assertEquals(expected, result);
	}
}