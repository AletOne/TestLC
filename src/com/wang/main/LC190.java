package com.wang.main;

public class LC190 {
	public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 16; i++){
            result = result | n >>> 31 << i;
            n = n << 1;
        }
        
        n = n >>> 16;
        
        for (int i = 0; i < 16; i++){
            result = result | n << 31 >>> i;
            n = n >> 1;
        }
        return result;
    }
}
