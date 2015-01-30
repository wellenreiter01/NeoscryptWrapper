
package com.crypto.algo.neoscrypt;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
public class hasher {

    private static boolean native_library_loaded = false;
 //  private static Logger log = LoggerFactory.getLogger(hasher.class);

        static {
            try {
                System.loadLibrary("neoscrypt");
                native_library_loaded = true;
            } catch (Throwable e) {
   //            log.error("native library neoscrypt not loaded" ,e);
            }
        }

	public static char[] getHash(char[] input, int profile) {
		hasher neoScrypt = new hasher();

        if (native_library_loaded) {

            char[] output = input.clone();
            neoScrypt.neoscrypt(input, output, profile);
          //  log.warn ( "output: ", output);
            return output;
        }
        return input;
	}

	private native void neoscrypt(char[] input,char[] output,int profile);

}
