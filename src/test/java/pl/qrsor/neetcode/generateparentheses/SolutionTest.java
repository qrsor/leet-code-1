package pl.qrsor.neetcode.generateparentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest
{
	public static Stream<Arguments> provideParameters()
	{
		return Stream.of(
				Arguments.of(1, List.of("()")),
				Arguments.of(2, List.of("()()", "(())")),
				Arguments.of(3, List.of("()()()", "(())()", "()(())", "((()))", "(()())"))
		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(int n, List<String> expectedResults)
	{
		//given arguments

		//when
		var result = new Solution().generateParenthesis(n);

		//then
		assertEquals(expectedResults.size(), result.size());
		assertTrue(expectedResults.containsAll(result));
		assertTrue(result.containsAll(expectedResults));
	}
}