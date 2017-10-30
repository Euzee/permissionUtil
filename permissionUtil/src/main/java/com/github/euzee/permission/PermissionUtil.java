package com.github.euzee.permission;

import android.content.Context;

@SuppressWarnings("unused")
public class PermissionUtil {

    private static PermissionUtil instance;
    private PermissionCallback callback;

    private static PermissionUtil getInstance() {
        if (instance == null)
            instance = new PermissionUtil();
        return instance;
    }

    public static void contactsRead(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.contactsRead(context);
    }

    public static void contactsWrite(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.contactsWrite(context);
    }

    public static void contactsRW(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.contactsRW(context);
    }

    public static void calendarRead(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.calendarRead(context);
    }

    public static void calendarWrite(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.calendarWrite(context);
    }

    public static void calendarRW(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.calendarRW(context);
    }

    public static void storageRead(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.storageRead(context);
    }

    public static void storageWrite(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.storageWrite(context);
    }

    public static void storageRW(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.storageRW(context);
    }

    public static void locationFine(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.locationFine(context);
    }

    public static void locationCoarse(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.locationCoarse(context);
    }

    public static void locationBoth(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.locationBoth(context);
    }

    public static void camera(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.camera(context);
    }

    public static void microphone(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.microphone(context);
    }

    public static void phoneReadState(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneReadState(context);
    }

    public static void phoneCall(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneCall(context);
    }

    public static void phoneReadCallLog(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneReadCallLog(context);
    }

    public static void phoneWriteCallLog(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneWriteCallLog(context);
    }

    public static void phoneAddVoiceMail(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneAddVoiceMail(context);
    }

    public static void phoneSip(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneSip(context);
    }

    public static void phoneOutgoing(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneOutgoing(context);
    }

    public static void phoneAll(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.phoneAll(context);
    }

    public static void sensors(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.sensors(context);
    }

    public static void smsSend(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.smsSend(context);
    }

    public static void smsReceive(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.smsReceive(context);
    }

    public static void smsRead(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.smsRead(context);
    }

    public static void smsWap(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.smsWap(context);
    }

    public static void smsMms(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.smsMms(context);
    }

    public static void smsAll(Context context, PermissionCallback callback) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.smsAll(context);
    }

    public static void checkGroup(Context context, PermissionCallback callback, String[] group) {
        getInstance().setWrappedCallback(callback);
        PermissionActivity.checkGroup(context, group);
    }

    static PermissionCallback getCallback() {
        return getInstance().callback;
    }

    private void setCallback(PermissionCallback callback) {
        this.callback = callback;
    }

    static void onCallbackReady() {
        getInstance().setCallback(null);
    }

    private void setWrappedCallback(PermissionCallback callback) {
        setCallback(wrap(callback));
    }

    private PermissionCallback wrap(PermissionCallback callback) {
        return new PermissionWrapper(callback);
    }
}
