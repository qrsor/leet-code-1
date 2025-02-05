package pl.qrsor.neetcode.timebasedkeyvaluestore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TimeMapTest {
    @Test
    void shouldTestStructure() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);
        assertThat(timeMap.get("alice", 1)).isEqualTo("happy");
        assertThat(timeMap.get("alice", 2)).isEqualTo("happy");
        timeMap.set("alice", "sad", 3);
        assertThat(timeMap.get("alice", 3)).isEqualTo("sad");
    }
}