package pl.qrsor.neetcode.timebasedkeyvaluestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record TimestampedValue(int timestamp, String value) {
}

public class TimeMap {

    private Map<String, List<TimestampedValue>> internal = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        internal.computeIfAbsent(key, (s) -> new ArrayList<>()).add(new TimestampedValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!internal.containsKey(key)) {
            return "";
        }

        var timestamps = internal.get(key);

        var l = 0;
        var r = timestamps.size() - 1;
        var res = "";

        while (l <= r) {
            var m = l + (r - l) / 2;
            TimestampedValue timestampedValue = timestamps.get(m);
            if (timestampedValue.timestamp() == timestamp) {
                return timestampedValue.value();
            }

            if (timestampedValue.timestamp() <= timestamp) {
                res = timestampedValue.value();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}
