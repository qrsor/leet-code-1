package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReorderLinkedListTest {
    @Test
    void shouldNotFailGivenNull() {
        //given
        ListNode head = null;

        //when
        new ReorderLinkedList().reorderList(head);

        //then
        assertThat(head).isNull();
    }

    @Test
    void shouldNotFailGivenSingletonList() {
        //given
        var head = new ListNode(1);

        //when
        new ReorderLinkedList().reorderList(head);

        //then
        assertThat(head.next).isNull();
        ;
        assertThat(head.val).isEqualTo(1);
    }

    @Test
    void shouldNotChangeTwoElementList() {
        //given
        var node1 = new ListNode(2);
        var head = new ListNode(1, node1);

        //when
        new ReorderLinkedList().reorderList(head);

        //then
        assertThat(head.val).isEqualTo(1);
    }

    @Test
    void shouldReorderShortList() {
        //given
        var node2 = new ListNode(3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(1, node1);

        //when
        new ReorderLinkedList().reorderList(head);

        //then
        assertThat(head.toValList()).containsExactly(1, 3, 2);
    }

    @Test
    void shouldReorderLongList() {
        //given
        var node5 = new ListNode(6);
        var node4 = new ListNode(5, node5);
        var node3 = new ListNode(4, node4);
        var node2 = new ListNode(3, node3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(1, node1);

        //when
        new ReorderLinkedList().reorderList(head);

        //then
        assertThat(head.toValList()).containsExactly(1, 6, 2, 5, 3, 4);
    }
}