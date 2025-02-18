package pl.qrsor.neetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    @Test
    void shouldReturnNegativeOneGivenItemNotFound() {
        //given
        var cache = new LRUCache(1);

        //when
        var result = cache.get(2);

        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void shouldReturnItemFromCacheGivenItemFound() {
        //given
        var cache = new LRUCache(1);
        cache.put(2, 20);

        //when
        var result = cache.get(2);
        var result2 = cache.get(2);

        //then
        assertThat(result).isEqualTo(20);
        assertThat(result2).isEqualTo(20);
    }

    @Test
    void shouldEvictItemFromCache() {
        //given
        var cache = new LRUCache(1);

        //when
        cache.put(1, 10);
        cache.put(2, 20);
        var result1 = cache.get(1);
        var result2 = cache.get(2);

        //then
        assertThat(result1).isEqualTo(-1);
        assertThat(result2).isEqualTo(20);
    }

    @Test
    void shouldEvictItemFromCacheGivenSize2Cache() {
        //given
        var cache = new LRUCache(2);

        //when
        cache.put(1, 1);
        cache.put(2, 2);
        var result1 = cache.get(1);
        cache.put(3, 3);
        var result2 = cache.get(2);
        cache.put(4, 4);
        var result3 = cache.get(1);
        var result4 = cache.get(3);
        var result5 = cache.get(4);

        //then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(-1);
        assertThat(result3).isEqualTo(-1);
        assertThat(result4).isEqualTo(3);
        assertThat(result5).isEqualTo(4);
    }

}