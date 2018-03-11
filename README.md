# MissMe
Android ProgressDialog brought back to life

[ ![Download](https://api.bintray.com/packages/lmntrx-tech/MissMe/missme/images/download.svg) ](https://bintray.com/lmntrx-tech/MissMe/missme/_latestVersion) [![TravisCI](https://api.travis-ci.org/Livin21/MissMe.svg?branch=master)](https://travis-ci.org/Livin21/MissMe) [![](https://jitpack.io/v/Livin21/MissMe.svg)](https://jitpack.io/#Livin21/MissMe) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/72b96bd2ff7a43838eb89b5433b6144c)](https://www.codacy.com/app/livinmathew99/MissMe?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Livin21/MissMe&amp;utm_campaign=Badge_Grade) [![StackShare](https://img.shields.io/badge/tech-stack-0690fa.svg?style=flat)](https://stackshare.io/Livin21/missme)


MissMe is an Android library written in Kotlin. Android SDK's ProgressDialog class was deprecated in Android Oreo. MissMe's ProgressDialog functions exactly the same and has the same interface.

## Gradle Setup ##
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
   ...
   maven { url 'https://jitpack.io' }
  }
 }
```

Add the following dependency to module/build.gradle:
```gradle
compile 'com.github.Livin21:MissMe:v0.1.1'
```