package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseListTest {
    @Test
    void shouldReverseList() {
        //given
        var leaf = new ListNode(3);
        var mid2 = new ListNode(2, leaf);
        var mid1 = new ListNode(1, mid2);
        var head = new ListNode(0, mid1);

        //when
        var result = new ReverseList().reverseList(head);

        //then
        assertThat(result.toValList()).containsExactly(3, 2, 1, 0);
    }
}