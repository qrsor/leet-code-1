package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveNodeFromEndOfLinkedListTest {

    @Test
    void shouldReturnEmptyGivenSingleElementList() {
        //given
        var head = new ListNode();

        //when
        var result = new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(head, 1);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnTailGivenTwoElementList() {
        //given
        var node1 = new ListNode(2);
        var head = new ListNode(1, node1);

        //when
        var result = new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(head, 2);

        //then
        assertThat(result.toValList()).containsExactly(2);
    }


    @Test
    void shouldReturnElementFromMiddle() {
        //given
        var node2 = new ListNode(3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(1, node1);

        //when
        var result = new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(head, 2);

        //then
        assertThat(result.toValList()).containsExactly(1, 3);
    }

    @Test
    void shouldReturnElementFromEnd() {
        //given
        var node2 = new ListNode(3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(1, node1);

        //when
        var result = new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(head, 1);

        //then
        assertThat(result.toValList()).containsExactly(1, 2);
    }
}