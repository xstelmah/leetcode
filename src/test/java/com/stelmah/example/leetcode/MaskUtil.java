package com.stelmah.example.leetcode;

public class MaskUtil {

    public static String maskToString(int mask, int size) {
        var sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((((mask >> i) & 1) == 1) ? '1' : '0');
        }
        return sb.toString();
    }

    public static String maskToString(int mask) {
        return maskToString(mask, 32);
    }
}
