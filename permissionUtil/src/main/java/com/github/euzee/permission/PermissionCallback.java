package com.github.euzee.permission;

@SuppressWarnings("WeakerAccess")
public abstract class PermissionCallback {

    public abstract void onPermissionGranted();

    public abstract void onPermissionDenied();

    public int getRationaleTitleId() {
        return 0;
    }

    public int getRationaleMessageId() {
        return 0;
    }
}
