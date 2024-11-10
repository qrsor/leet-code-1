package pl.qrsor.neetcode.rpn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest
{
	@Test
	void shouldSumArguments()
	{
		//given
		var input = new String[]{ "1", "3", "+" };

		//when
		var result = new Solution().evalRPN(input);

		//then
		assertEquals(4, result);
	}
}