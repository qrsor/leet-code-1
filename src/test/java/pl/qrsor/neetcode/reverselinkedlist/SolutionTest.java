package pl.qrsor.neetcode.reverselinkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void shouldReverseList() {
        //given
        var leaf = new Solution.ListNode(3);
        var mid2 = new Solution.ListNode(2, leaf);
        var mid1 = new Solution.ListNode(1, mid2);
        var head = new Solution.ListNode(0, mid1);

        //when
        var result = new Solution().reverseList(head);

        //then
        assertThat(result.val).isEqualTo(3);
        assertThat(result.next.val).isEqualTo(2);
        assertThat(result.next.next.val).isEqualTo(1);
        assertThat(result.next.next.next.val).isEqualTo(0);
        assertThat(result.next.next.next.next).isNull();
    }
}