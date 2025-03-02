package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseListTest {
    @Test
    void shouldReverseList() {
        //given
        var head = ListNode.fromIntegers(0, 1, 2, 3);

        //when
        var result = new ReverseList().reverseList(head);

        //then
        assertThat(result.toValList()).containsExactly(3, 2, 1, 0);
    }
}