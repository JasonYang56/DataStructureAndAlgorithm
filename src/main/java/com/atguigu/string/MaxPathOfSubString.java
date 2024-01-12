package com.atguigu.string;

import java.util.HashMap;
import java.util.Map;

public class MaxPathOfSubString {
    public static int getMaxConsecutiveSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (last.containsKey(c) && last.get(c) >= start) {
                start = last.get(c) + 1;
            }
            last.put(c, i);
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(getMaxConsecutiveSubstring("abbbbba")); // Output: 5
    }
}

