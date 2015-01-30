
package com.crypto.algo.neoscrypt;


/* TODO do we need log information?
* logger not available at runtime value add is limted
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
public class hasher {
    /**
     * The wrapper around the original neoscrypt c-code
     * loads the native library passes program parameter to the c-code
     * and returns the result
     */
    private static boolean native_library_loaded = false;
  //  private static Logger log = LoggerFactory.getLogger(hasher.class);

        static {
            try {
                System.loadLibrary("neoscrypt");
                native_library_loaded = true;
            } catch (Throwable e) {
          //    log.error("native library neoscrypt not loaded" ,e);
            }
        }

	public static char[] getHash(char[] input, int profile) {
        /**
         * calls the c- code
         * @parameters:
         * input: string to be hashed
         * profile: defines which hash algorithm to use
         *  - 0x3 : Scrypt
         *  - 0x80000620 : neoscrypt for feathercoin
         */
		hasher neoScrypt = new hasher();
        char[] output = new char[32];


        if (native_library_loaded) {
/* Todo: is char the right data type to pass?

 */
            neoScrypt.neoscrypt(input, output, profile);
          //  log.warn ( "output: ", output);
          //  return neoScrypt.neoscrypt(input, output, profile);
            return output;
        }
        return input;
	}

	private native char[] neoscrypt(char[] input,char[] output,int profile);

}
