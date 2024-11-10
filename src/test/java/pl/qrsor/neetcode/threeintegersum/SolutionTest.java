package pl.qrsor.neetcode.threeintegersum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest
{
	public static Stream<Arguments> provideParameters()
	{
		return Stream.of(
				Arguments.of(new int[] { 0, 0, 0 }, List.of(List.of(0, 0, 0))),
				Arguments.of(new int[] { -2, 0, 0, 2, 2 }, List.of(List.of(-2, 0, 2))),
				Arguments.of(new int[] { -1, 0, 1, 2, -1, -4 }, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)))
				,
				Arguments.of(new int[] { 3, 0, -2, -1, 1, 2 }, List.of(List.of(-2, -1, 3), List.of(-2, 0, 2), List.of(-1, 0, 1)))
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int[] input, List<List<Integer>> expected)
	{
		//when
		var result = new Solution().threeSum(input);
		result.forEach(l -> l.sort(Comparator.naturalOrder()));

		//then
		assertIterableEquals(expected, result);
	}
}