package pl.qrsor.neetcode.mergetwosortedlinkedlists;

import org.junit.jupiter.api.Test;
import pl.qrsor.neetcode.ListNode;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    void shouldMergeLists() {
        //given
        var leaf1 = new ListNode(4);
        var mid1 = new ListNode(2, leaf1);
        var head1 = new ListNode(1, mid1);

        var leaf2 = new ListNode(5);
        var mid2 = new ListNode(3, leaf2);
        var head2 = new ListNode(1, mid2);

        //when
        var result = new Solution().mergeTwoLists(head1, head2);


        //then
        var values = new ArrayList<Integer>();
        var node = result;
        do {
            values.add(node.val);
            node = node.next;
        } while (node != null);

        assertThat(values).containsExactly(1, 1, 2, 3, 4, 5);

    }
}