package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CopyLinkedListWithRandomPointerTest {
    @Test
    void shouldReturnEmptyGivenEmptyList() {
        //given
        Node head = null;

        //when
        var result = new CopyLinkedListWithRandomPointer().copyRandomList(head);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnCopyGivenSingleElementWithoutRandom() {
        //given
        var head = new Node(0);

        //when
        var result = new CopyLinkedListWithRandomPointer().copyRandomList(head);

        //then
        assertThat(result).isNotEqualTo(head);
        assertThat(result.toArray()).containsExactly(0, null);
    }

    @Test
    void shouldReturnCopyGivenShortListWithoutRandom() {
        //given
        var node1 = new Node(1);
        var head = new Node(0, node1);

        //when
        var result = new CopyLinkedListWithRandomPointer().copyRandomList(head);

        //then
        assertThat(result).isNotEqualTo(head);
        assertThat(result.toArray()).containsExactly(0, null, 1, null);
    }

    @Test
    void shouldReturnCopyGivenSingleElementRandom() {
        //given
        var head = new Node(0);
        head.random = head;

        //when
        var result = new CopyLinkedListWithRandomPointer().copyRandomList(head);

        //then
        assertThat(result).isNotEqualTo(head);
        assertThat(result.toArray()).containsExactly(0, 0);
    }

    @Test
    void shouldReturnCopyGivenShortListRandom() {
        //given
        var node1 = new Node(1);
        var head = new Node(0, node1);
        node1.random = head;

        //when
        var result = new CopyLinkedListWithRandomPointer().copyRandomList(head);

        //then
        assertThat(result).isNotEqualTo(head);
        assertThat(result.toArray()).containsExactly(0, null, 1, 0);
    }
}