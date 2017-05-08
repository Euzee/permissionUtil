package com.github.euzee.permission;

class PermissionWrapper implements PermissionCallback {
    private PermissionCallback callback;

    PermissionWrapper(PermissionCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onPermissionGranted() {
        PermissionUtil.onCallbackReady();
        callback.onPermissionGranted();
    }

    @Override
    public void onPermissionDenied() {
        PermissionUtil.onCallbackReady();
        callback.onPermissionDenied();
    }
}
