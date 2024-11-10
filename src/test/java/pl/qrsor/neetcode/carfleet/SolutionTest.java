package pl.qrsor.neetcode.carfleet;

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
				Arguments.of(1, new int[] { 0 }, new int[] { 1 }, 1),
				Arguments.of(3, new int[] { 0, 1 }, new int[] { 1, 1 }, 2),
				Arguments.of(3, new int[] { 0, 1 }, new int[] { 2, 1 }, 1),
				Arguments.of(3, new int[] { 0, 1 }, new int[] { 1, 2 }, 2),
				Arguments.of(10, new int[] { 1, 4 }, new int[] { 3, 2 }, 1),
				Arguments.of(10, new int[] { 4, 1, 0, 7 }, new int[] { 2, 2, 1, 1 }, 3)
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int target, int[] position, int[] speed, int expected)
	{
		//given arguments

		//when
		var result = new Solution().carFleet(target, position, speed);

		//then
		assertEquals(expected, result);
	}
}