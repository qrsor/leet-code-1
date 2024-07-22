package pl.qrsor.neetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StringEncodeAndDecode
{
	public String encode(List<String> strs) {
		return strs.stream().map(str -> {
			var length = str.length();
			var separator = ",";
			return length + separator + str;
		}).collect(Collectors.joining(""));
	}

	public List<String> decode(String str) {
		var result = new ArrayList<String>();
		for(int i = 0, j=0; i < str.length();) {
			while(str.charAt(i) != ',') {
				i++;
			}
			int length = Integer.parseInt(str.substring(j, i));
			String decoded = str.substring(i + 1, i + 1 + length);
			result.add(decoded);
			i = i + 1 + length;
			j = i;

		}
		return result;
	}
}
