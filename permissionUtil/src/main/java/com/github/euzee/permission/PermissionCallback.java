package com.github.euzee.permission;

public interface PermissionCallback {

    void onPermissionGranted();

    void onPermissionDenied();
}
