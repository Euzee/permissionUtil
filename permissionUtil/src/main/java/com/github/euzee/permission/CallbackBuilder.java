package com.github.euzee.permission;

public class CallbackBuilder {

    private PermissionGranted granted;
    private PermissionDenied denied;
    private int titleId;
    private int messageId;

    public CallbackBuilder() {
    }

    CallbackBuilder onGranted(PermissionGranted call) {
        granted = call;
        return this;
    }

    CallbackBuilder onDenied(PermissionDenied call) {
        denied = call;
        return this;
    }

    CallbackBuilder withRationale(int titleResId, int messageResId) {
        titleId = titleResId;
        messageId = messageResId;
        return this;
    }

    PermissionCallback build() {
        return new PermissionCallback() {
            @Override
            void onPermissionGranted() {
                if (granted != null)
                    granted.onPermissionGranted();
            }

            @Override
            void onPermissionDenied() {
                if (denied != null)
                    denied.onPermissionDenied();
            }

            @Override
            int getRationaleTitleId() {
                return titleId;
            }

            @Override
            int getRationaleMessageId() {
                return messageId;
            }
        };
    }

}
