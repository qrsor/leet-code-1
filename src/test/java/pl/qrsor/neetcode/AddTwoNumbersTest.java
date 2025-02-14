package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {

    @Test
    public void shouldSumZeros() {
        //given
        var l1 = new ListNode(0);
        var l2 = new ListNode(0);

        //when
        var result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        //then
        assertThat(result.toValList()).containsExactly(0);
    }

    @Test
    public void shouldSumSingleDigits() {
        //given
        var l1 = new ListNode(1);
        var l2 = new ListNode(2);

        //when
        var result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        //then
        assertThat(result.toValList()).containsExactly(3);
    }

    @Test
    public void shouldSumWithCarry() {
        //given
        var l1 = new ListNode(9);
        var l2 = new ListNode(3);

        //when
        var result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        //then
        assertThat(result.toValList()).containsExactly(2, 1);
    }

    @Test
    public void shouldHandleDifferentDigitCountWithCarry() {
        //given
        var l1 = ListNode.fromInteger(128);
        var l2 = new ListNode(3);

        //when
        var result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        //then
        assertThat(result.toValList()).containsExactly(1, 3, 1);
    }

    @Test
    public void shouldHandleDifferentDigitCountWithCarryAndZeros() {
        //given
        var l1 = ListNode.fromInteger(128);
        var l2 = ListNode.fromInteger(902);

        //when
        var result = new AddTwoNumbers().addTwoNumbers(l1, l2);

        //then
        assertThat(result.toValList()).containsExactly(0, 3, 0, 1);
    }
}