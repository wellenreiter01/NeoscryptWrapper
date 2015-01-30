package com.crypto.algo;
/**
 * Test Class to test funtions of the neoscrypt hasher
 * current tests:
 * - profile 0x3: scrypt
 * - profile 0x80000620: neoscrypt (default if profile is omitted)
 */


import com.crypto.algo.neoscrypt.hasher;

import junit.framework.Assert;

import org.junit.Test;



public class hasher_Test {
/* reference taken from qt-wallet code
*/
    private static char[] reference = new char[]{0x72, 0x58, 0x96, 0x1A, 0xFB, 0x33, 0xFD, 0x12,
            0xD0, 0x0C, 0xAC, 0xB8, 0xD6, 0x3F, 0x4F, 0x4F,
            0x52, 0xBB, 0x69, 0x17, 0x04, 0x38, 0x65, 0xDD,
            0x24, 0xA0, 0x8F, 0x57, 0x88, 0x53, 0x12, 0x2D};


    private static char[] input= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 70
    };


    int i;




    @Test
   public  void neoscryptTest() throws Exception {

       // for (i=0; i<80;input[i] = {i});
       char[] reborn = hasher.getHash(input, 0x80000620);
        org.junit.Assert.assertEquals("LengthTest",reference.length,reborn.length);
        Assert.assertEquals("HashComparison",reference.toString(), (reborn.toString()));
   }

}

