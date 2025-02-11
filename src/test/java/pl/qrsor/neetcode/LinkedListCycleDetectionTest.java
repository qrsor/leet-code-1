package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleDetectionTest {
    @Test
    void shouldReturnFalseGivenEmptyList() {
        //given
        ListNode node = null;

        //when
        var result = new LinkedListCycleDetection().hasCycle(node);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseGivenSingletonList() {
        //given
        var node = new ListNode();

        //when
        var result = new LinkedListCycleDetection().hasCycle(node);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseGivenListWithoutCycle() {
        //given
        var node = new ListNode(1);
        var head = new ListNode(2, node);

        //when
        var result = new LinkedListCycleDetection().hasCycle(head);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseGivenLongListWithoutCycle() {
        //given
        var node1 = new ListNode(1);
        var node2 = new ListNode(2, node1);
        var node3 = new ListNode(3, node2);
        var node4 = new ListNode(4, node3);
        var node5 = new ListNode(5, node4);
        var head = new ListNode(6, node5);

        //when
        var result = new LinkedListCycleDetection().hasCycle(head);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseGivenListWithCycle() {
        //given
        var node1 = new ListNode(1);
        var node2 = new ListNode(2, node1);
        node1.next = node2;
        var head = new ListNode(2, node2);

        //when
        var result = new LinkedListCycleDetection().hasCycle(head);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseGivenLongListWithCycle() {
        //given
        var node1 = new ListNode(1);
        var node2 = new ListNode(2, node1);
        var node3 = new ListNode(3, node2);
        var node4 = new ListNode(4, node3);
        var node5 = new ListNode(5, node4);
        var head = new ListNode(6, node5);
        node1.next = node5;

        //when
        var result = new LinkedListCycleDetection().hasCycle(head);

        //then
        assertThat(result).isTrue();
    }
}