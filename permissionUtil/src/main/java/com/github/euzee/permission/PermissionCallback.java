package com.github.euzee.permission;

@SuppressWarnings("WeakerAccess")
public abstract class PermissionCallback {

    abstract void onPermissionGranted();

    abstract void onPermissionDenied();

    String getRationaleTitle() {
        return "";
    }

    String getRationaleMessage() {
        return "";
    }
}
