package com.github.euzee.permission;

@SuppressWarnings("WeakerAccess")
public abstract class PermissionCallback {

    abstract void onPermissionGranted();

    abstract void onPermissionDenied();

    int getRationaleTitleId() {
        return 0;
    }

    int getRationaleMessageId() {
        return 0;
    }
}
