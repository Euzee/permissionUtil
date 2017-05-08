[![GitHub license](https://img.shields.io/github/license/dcendents/android-maven-gradle-plugin.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
# permissionUtil
A simple easy-to-use permission helper for Android. 
No need to handle result in onActivityResult and passing it to fragment or model.
PermissionUtil can be used from any place with context only (Activity, Fragment,ViewModel).

``` java
//Easy to use
PermissionUtil.locationBoth(context, requestPermissionListener);
```

## Callback

Simplified callback. Just override method that you need and that's it.
``` java
public abstract class ShortPerCallback implements PermissionCallback {

    @Override
    public void onPermissionGranted() {
    }

    @Override
    public void onPermissionDenied() {
    }
}
```

## Actions

You can directly use prepared requests like :
``` java
PermissionUtil.locationFine(context, requestPermissionListener);
PermissionUtil.locationCoarse(context, requestPermissionListener);
```

Or you can request multiple permissions with your group :
``` java
PermissionUtil.checkGroup(context, requestPermissionListener,new String[]{Manifest.permission.READ_PHONE_STATE});
```

List of permissions that could be requested according to [Dangerous permissions](https://developer.android.com/guide/topics/permissions/requesting.html#normal-dangerous) : 
- contactsRead
- contactsWrite
- contactsRW
- calendarRead
- calendarWrite
- calendarRW
- storageRead
- storageWrite
- storageRW
- locationFine
- locationCoarse
- locationBoth
- camera
- microphone
- phoneReadState
- phoneCall
- phoneReadCallLog
- phoneWriteCallLog
- phoneAddVoiceMail
- phoneSip
- phoneOutgoing
- phoneAll
- sensors
- smsSend
- smsReceive
- smsRead
- smsWap
- smsMms
- smsAll
- checkGroup

# Download

In your module [ ![Download](https://api.bintray.com/packages/euzee/Libs/permissionUtil/images/download.svg) ](https://bintray.com/euzee/Libs/permissionUtil/_latestVersion)
``` groovy
repositories {
    maven { url  "http://dl.bintray.com/euzee/Libs" }
}
compile 'com.github.euzee:permissionUtil:1.0.0'
```
[![](https://jitpack.io/v/Euzee/permissionUtil.svg)](https://jitpack.io/#Euzee/permissionUtil)
``` groovy
repositories {
    maven { url 'https://jitpack.io' }
}
compile 'com.github.Euzee:permissionUtil:1.0.0'
```

# License

    Copyright 2017 Euzee, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
