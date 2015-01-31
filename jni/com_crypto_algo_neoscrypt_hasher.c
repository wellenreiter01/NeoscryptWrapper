#include "com_crypto_algo_neoscrypt_hasher.h"
#include "neoscrypt.h"
#include "neoscrypt.c"
#include <stdint.h>

jbyteArray JNICALL Java_com_crypto_algo_neoscrypt_hasher_neoscrypt
    (JNIEnv *env, jobject object, jbyteArray inputArray, jbyteArray outputArray, jint profile)
{
  jbyteArray hash = NULL;
  jbyte *input = (*env)->GetIntArrayElements(env,inputArray,NULL);
  jbyte *output = (*env)->GetIntArrayElements(env,outputArray,NULL);
  neoscrypt((const uint8_t*)input,(uint8_t*)output,profile);

  hash = (*env)->NewByteArray(env,32);

  if (hash)
  	{
  		(*env)->SetByteArrayRegion(env,hash, 0, 32, output);
  	}
      return hash;
}

