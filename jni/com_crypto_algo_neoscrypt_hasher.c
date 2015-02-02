#include "com_crypto_algo_neoscrypt_hasher.h"
#include "neoscrypt.h"
#include "neoscrypt.c"
#include <stdint.h>

jbyteArray JNICALL Java_com_crypto_algo_neoscrypt_hasher_neoscrypt
    (JNIEnv *env, jobject object, jbyteArray inputArray, jbyteArray outputArray, jint profile)
{
/* prepare varialbles */

  jbyte *input, *output;
  jbyteArray hash = NULL;
    
  input = (*env)->GetByteArrayElements(env,inputArray,NULL);
  output = (*env)->GetByteArrayElements(env,outputArray,NULL);
  
  /* call naitve function '*/
  neoscrypt((const uint8_t*)input,(uint8_t*)output,profile);
  
  /*copy result into array, clear heap and return result 
   not sure, if just returning the output variable would do the job*/
  hash = (*env)->NewByteArray(env,32);
  
    if (hash)
    	{
    		(*env)->SetByteArrayRegion(env,hash, 0, 32, output);
    	}
    	if (input) (*env)->ReleaseByteArrayElements(env,inputArray, input, 0);
      if (output) (*env)->ReleaseByteArrayElements(env, outputArray, output, 0);
  
        return hash;
}

