package pl.qrsor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
	public static void main(String[] args)
	{
var s = "jar";
var t = "jar";

		char[] chars1 = s.toCharArray();
		Arrays.sort(chars1);
		System.out.println(Arrays.hashCode(chars1));
		char[] chars2 = t.toCharArray();
		Arrays.sort(chars2);
		System.out.println(Arrays.hashCode(chars2));
	}
}