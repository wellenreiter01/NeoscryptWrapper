#include "com_crypto_algo_neoscrypt_hasher.h"
#include "neoscrypt.h"
#include "neoscrypt.c"
#include <stdint.h>

jcharArray JNICALL Java_com_crypto_algo_neoscrypt_hasher_neoscrypt
    (JNIEnv *env, jobject object, jcharArray inputArray, jcharArray outputArray, jint profile)
{
  jcharArray hash = NULL;
  jchar *input = (*env)->GetIntArrayElements(env,inputArray,NULL);
  jchar *output = (*env)->GetIntArrayElements(env,outputArray,NULL);
  neoscrypt((const uint8_t*)input,(uint8_t*)output,profile);

  hash = (*env)->NewCharArray(env,32);

  if (hash)
  	{
  		(*env)->SetCharArrayRegion(env,hash, 0, 32, output);
  	}
      return hash;
}

