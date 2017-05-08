package com.github.euzee.permission;

interface PermissionCallback {

    void onPermissionGranted();

    void onPermissionDenied();
}
