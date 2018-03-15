# MissMe
Android ProgressDialog brought back to life

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-MissMe-green.svg?style=flat )]( https://android-arsenal.com/details/1/6825 ) [ ![Download](https://api.bintray.com/packages/lmntrx-tech/MissMe/missme/images/download.svg) ](https://bintray.com/lmntrx-tech/MissMe/missme/_latestVersion) [![TravisCI](https://api.travis-ci.org/Livin21/MissMe.svg?branch=master)](https://travis-ci.org/Livin21/MissMe) [![](https://jitpack.io/v/Livin21/MissMe.svg)](https://jitpack.io/#Livin21/MissMe) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/72b96bd2ff7a43838eb89b5433b6144c)](https://www.codacy.com/app/livinmathew99/MissMe?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Livin21/MissMe&amp;utm_campaign=Badge_Grade) [![StackShare](https://img.shields.io/badge/tech-stack-0690fa.svg?style=flat)](https://stackshare.io/Livin21/missme)


MissMe is an Android library written in Kotlin. Android SDK's ProgressDialog class was deprecated in Android Oreo. MissMe's ProgressDialog functions exactly the same and has the same interface.

## Screenshots ##
![Horizontal Determinate](https://preview.ibb.co/nLQwHx/Horizontal_Determinate.jpg) ![Horizontal Indeterminate](https://preview.ibb.co/mcAVcx/Horizontal_Indeterminate.jpg) ![Spinner](https://preview.ibb.co/gYpvAH/Spinner.jpg) 

## Gradle Setup ##
Add the following dependency to module/build.gradle:
```gradle
compile 'com.lmntrx.android.library.livin.missme:missme:0.1.5'
```

## How to use it? ##

Usage is similar to original ProgressDialog

```java
ProgressDialog progressDialog = new ProgressDialog(YourActivity.this);

// Set message
progressDialog.setMessage("Please wait");

// Set cancelable
progressDialog.setCancelable(false);

// Show dialog
progressDialog.show();

// Hide
progressDialog.dismiss();
```

NB: You must override activity's onBackPressed()

Java8 Implementation:
```java
@Override
public void onBackPressed() {
    progressDialog.onBackPressed(
            () -> {
                YourActivity.super.onBackPressed();
                return null;
            }
    );
}
```

Kotlin Implementation:
```kotlin
override fun onBackPressed() {
    progressDialog.onBackPressed { super.onBackPressed() }
}
```

* Refer [Sample App](https://github.com/Livin21/MissMe/tree/master/MissMe) for the full implementation
* Full documentation can be found [here](https://github.com/Livin21/MissMe/blob/master/Documentation/index.md)

## Copyright ###
```
 Copyright (c) 2018.  Livin
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
```