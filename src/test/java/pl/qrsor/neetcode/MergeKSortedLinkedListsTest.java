package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeKSortedLinkedListsTest {
    @Test
    void shouldReturnEmptyGivenNoLists() {
        //given
        var lists = new ListNode[]{};

        //when
        var result = new MergeKSortedLinkedLists().mergeKLists(lists);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnEmptyGivenEmptyLists() {
        //given
        var lists = new ListNode[]{null, null};

        //when
        var result = new MergeKSortedLinkedLists().mergeKLists(lists);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnMergedListGivenOneList() {
        //given
        var lists = new ListNode[]{
                ListNode.fromStream(Stream.of(1, 3, 5))
        };

        //when
        var result = new MergeKSortedLinkedLists().mergeKLists(lists);

        //then
        assertThat(result.toValList()).containsExactly(1, 3, 5);
    }

    @Test
    void shouldReturnMergedListGivenTwoLists() {
        //given
        var lists = new ListNode[]{
                ListNode.fromStream(Stream.of(1, 3, 5)),
                ListNode.fromStream(Stream.of(2, 4))
        };

        //when
        var result = new MergeKSortedLinkedLists().mergeKLists(lists);

        //then
        assertThat(result.toValList()).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void shouldReturnMergedListGivenThreeLists() {
        //given
        var lists = new ListNode[]{
                ListNode.fromStream(Stream.of(1, 3, 5)),
                ListNode.fromStream(Stream.of(2, 4)),
                ListNode.fromStream(Stream.of(6))
        };

        //when
        var result = new MergeKSortedLinkedLists().mergeKLists(lists);

        //then
        assertThat(result.toValList()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}