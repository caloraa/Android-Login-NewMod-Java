#include <sys/types.h>
#include <pthread.h>
#include <jni.h>
#include <unistd.h>
#include "Logger.h"

//url
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_Auth_Title(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(("https://yournameserver.000webhostapp.com/login.php"));
}

//dialog
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_Dialog(JNIEnv *env, jobject thiz) {
return env->NewStringUTF(("Remake New Mod Login by ( Calora' )"));
}


// canal mb
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_YTURL(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(("https://youtube.com/channel/UCMFoQhgkOqkwHoVe3Wi5NYw"));
}

// team
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_Team(JNIEnv *env, jobject thiz) {
return env->NewStringUTF(("New Mod"));
}
// team
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_Credits(JNIEnv *env, jobject thiz) {
return env->NewStringUTF(("Copyright © 2021 New Mod"));
}
