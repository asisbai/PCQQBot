package com.binklac.qqbot.protocol.hash;

public class QQHash {
    public static String QHash(long x, String K) {
        int[] N = new int[4];
        for (int T = 0; T < K.length(); T++) {
            N[T % 4] ^= K.charAt(T);
        }
        String[] U = {"EC", "OK"};
        long[] V = new long[4];
        V[0] = x >> 24 & 255 ^ U[0].charAt(0);
        V[1] = x >> 16 & 255 ^ U[0].charAt(1);
        V[2] = x >> 8 & 255 ^ U[1].charAt(0);
        V[3] = x & 255 ^ U[1].charAt(1);

        long[] U1 = new long[8];

        for (int T = 0; T < 8; T++) {
            U1[T] = T % 2 == 0 ? N[T >> 1] : V[T >> 1];
        }

        String[] N1 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String V1 = "";
        for (long aU1 : U1) {
            V1 += N1[(int) ((aU1 >> 4) & 15)];
            V1 += N1[(int) (aU1 & 15)];
        }
        return V1;
    }

    public static String BKNHash(String sKey) {
        return BKNHash(sKey, 5381);
    }

    public static String BKNHash(String sKey, int IntiNumber) {
        int Hash = IntiNumber;
        for (int T = 0; T < sKey.length(); T++) {
            Hash += (Hash << 5) + (int) sKey.charAt(T);
        }
        Hash = Hash & 2147483647;
        return String.valueOf(Hash);
    }
}
