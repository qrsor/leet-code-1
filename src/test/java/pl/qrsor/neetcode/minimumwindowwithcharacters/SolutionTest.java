package pl.qrsor.neetcode.minimumwindowwithcharacters;

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
				Arguments.of("abc", "a", "a"),
				Arguments.of("a", "b", ""),
				Arguments.of("abc", "ca", "abc"),
				Arguments.of("abc", "cba", "abc"),
				Arguments.of("OUZODYXAZV", "XYZ", "YXAZ"),
				Arguments.of("ADOBECODEBANC", "ABC", "BANC")
//				/ /                      0123456789012

		);
	}

	@ParameterizedTest
	@MethodSource("provideParameters")
	void shouldMatchExpectedResults(String s, String t, String expected)
	{
		//when
		var result = new Solution().minWindow(s, t);

		//then
		assertEquals(expected, result);
	}
}