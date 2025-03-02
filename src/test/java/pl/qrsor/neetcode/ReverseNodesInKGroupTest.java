package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseNodesInKGroupTest {
    @Test
    void shouldReturnUnchangedGivenSingleElementList() {
        //given
        var input = ListNode.fromIntegers(2);

        //when
        var result = new ReverseNodesInKGroup().reverseKGroup(input, 1);

        //then
        assertThat(result.toValList()).containsExactly(2);
    }

    @Test
    void shouldReturnUnchangedGivenKOne() {
        //given
        var input = ListNode.fromIntegers(1, 2, 3, 4);

        //when
        var result = new ReverseNodesInKGroup().reverseKGroup(input, 1);

        //then
        assertThat(result.toValList()).containsExactly(1, 2, 3, 4);
    }


    @Test
    void shouldInvertWholeListGivenKEqualListSize() {
        //given
        var input = ListNode.fromIntegers(1, 2, 3, 4);

        //when
        var result = new ReverseNodesInKGroup().reverseKGroup(input, 4);

        //then
        assertThat(result.toValList()).containsExactly(4, 3, 2, 1);
    }

    @Test
    void shouldInvertPartOfList() {
        //given
        var input = ListNode.fromIntegers(1, 2, 3, 4);

        //when
        var result = new ReverseNodesInKGroup().reverseKGroup(input, 3);

        //then
        assertThat(result.toValList()).containsExactly(3, 2, 1, 4);
    }

    @Test
    void shouldInvertThreeGroupsOfLists() {
        //given
        var input = ListNode.fromIntegers(1, 2, 3, 4, 5, 6);

        //when
        var result = new ReverseNodesInKGroup().reverseKGroup(input, 2);

        //then
        assertThat(result.toValList()).containsExactly(2, 1, 4, 3, 6, 5);
    }


}