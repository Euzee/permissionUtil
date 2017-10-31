package com.github.euzee.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v13.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

@SuppressWarnings("unused")
public class PermissionActivity extends Activity {


    private static final String PERMISSION = "PERMISSION";

    static void contactsRead(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_CONTACTS});
    }

    static void contactsWrite(Context context) {
        checkGroup(context, new String[]{Manifest.permission.WRITE_CONTACTS});
    }

    static void contactsRW(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS});
    }

    static void calendarRead(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_CALENDAR});
    }

    static void calendarWrite(Context context) {
        checkGroup(context, new String[]{Manifest.permission.WRITE_CALENDAR});
    }

    static void calendarRW(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR});
    }

    static void storageRead(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE});
    }

    static void storageWrite(Context context) {
        checkGroup(context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE});
    }

    static void storageRW(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});
    }

    static void locationFine(Context context) {
        checkGroup(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION});
    }

    static void locationCoarse(Context context) {
        checkGroup(context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION});
    }

    static void locationBoth(Context context) {
        checkGroup(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION});
    }

    static void camera(Context context) {
        checkGroup(context, new String[]{Manifest.permission.CAMERA});
    }

    static void microphone(Context context) {
        checkGroup(context, new String[]{Manifest.permission.RECORD_AUDIO});
    }

    static void phoneReadState(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_PHONE_STATE});
    }

    static void phoneCall(Context context) {
        checkGroup(context, new String[]{Manifest.permission.CALL_PHONE});
    }

    static void phoneReadCallLog(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_CALL_LOG});
    }

    static void phoneWriteCallLog(Context context) {
        checkGroup(context, new String[]{Manifest.permission.WRITE_CALL_LOG});
    }

    static void phoneAddVoiceMail(Context context) {
        checkGroup(context, new String[]{Manifest.permission.ADD_VOICEMAIL});
    }

    static void phoneSip(Context context) {
        checkGroup(context, new String[]{Manifest.permission.USE_SIP});
    }

    static void phoneOutgoing(Context context) {
        checkGroup(context, new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS});
    }

    static void phoneAll(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.WRITE_CALL_LOG,
                Manifest.permission.ADD_VOICEMAIL,
                Manifest.permission.USE_SIP,
                Manifest.permission.PROCESS_OUTGOING_CALLS});
    }

    static void sensors(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            checkGroup(context, new String[]{Manifest.permission.BODY_SENSORS});
        }
    }

    static void smsSend(Context context) {
        checkGroup(context, new String[]{Manifest.permission.SEND_SMS});
    }

    static void smsReceive(Context context) {
        checkGroup(context, new String[]{Manifest.permission.RECEIVE_SMS});
    }

    static void smsRead(Context context) {
        checkGroup(context, new String[]{Manifest.permission.READ_SMS});
    }

    static void smsWap(Context context) {
        checkGroup(context, new String[]{Manifest.permission.RECEIVE_WAP_PUSH});
    }

    static void smsMms(Context context) {
        checkGroup(context, new String[]{Manifest.permission.RECEIVE_MMS});
    }

    static void smsAll(Context context) {
        checkGroup(context, new String[]{Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_WAP_PUSH,
                Manifest.permission.RECEIVE_WAP_PUSH});
    }

    static void checkGroup(Context context, String[] permissions) {
        if (permissions != null && permissions.length != 0) {
            Intent intent = new Intent(context, PermissionActivity.class);
            intent.putExtra(PERMISSION, permissions);
            context.startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        final String[] requestedPermissions = getRequestedPermissions();
        if (checkIsEmptyPermissions(requestedPermissions)) {
            final int result = checkPermissions(requestedPermissions);
            boolean rationale = checkRationale(requestedPermissions);
            if (rationale && isRationaleExist()) {
                showRationale((dialogInterface, i) -> requestPermissionsIfNeeded(result, requestedPermissions));
            } else {
                requestPermissionsIfNeeded(result, requestedPermissions);
            }
        } else {
            onPermissionDenied();
        }
    }

    private boolean isRationaleExist() {
        PermissionCallback callback = PermissionUtil.getCallback();
        return callback != null && callback.getRationaleMessageId() != 0;
    }

    private void showRationale(DialogInterface.OnClickListener listener) {
        PermissionCallback callback = PermissionUtil.getCallback();
        String title = getCallbackTitle(callback);
        String message = getCallbackMessage(callback);
        AlertDialog dialog = new AlertDialog.Builder(this,R.style.Theme_AppCompat_Light_Dialog_MinWidth)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, listener)
                .create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private String getCallbackTitle(PermissionCallback callback) {
        return callback.getRationaleTitleId() == 0 ? "" : getString(callback.getRationaleTitleId());
    }

    private String getCallbackMessage(PermissionCallback callback) {
        return callback.getRationaleMessageId() == 0 ? "" : getString(callback.getRationaleMessageId());
    }

    private boolean checkRationale(String[] requestedPermissions) {
        boolean result = false;
        for (String permission : requestedPermissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private String[] getRequestedPermissions() {
        return getIntent().getExtras() != null ? getIntent().getExtras().getStringArray(PERMISSION) : null;
    }

    private boolean checkIsEmptyPermissions(String[] requestedPermissions) {
        return requestedPermissions != null && requestedPermissions.length != 0;
    }

    private void requestPermissionsIfNeeded(int result, String[] requestedPermissions) {
        if (result == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    requestedPermissions,
                    1001);
        } else {
            onPermissionGranted();
        }
    }

    private int checkPermissions(String[] requestedPermissions) {
        int result = 0;
        for (String permission : requestedPermissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                result = PackageManager.PERMISSION_DENIED;
                break;
            }
        }
        return result;
    }

    private void onPermissionDenied() {
        if (PermissionUtil.getCallback() != null) {
            PermissionUtil.getCallback().onPermissionDenied();
        }
        finish();
    }

    private void onPermissionGranted() {
        if (PermissionUtil.getCallback() != null) {
            PermissionUtil.getCallback().onPermissionGranted();
        }
        finish();
    }

    private void onShowRationale() {
        if (PermissionUtil.getCallback() != null) {
            PermissionUtil.getCallback().getRationaleMessageId();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        handleGrantResult(checkGrantResults(grantResults));
    }

    private void handleGrantResult(int grantResult) {
        if (grantResult == PackageManager.PERMISSION_GRANTED) {
            onPermissionGranted();
        } else {
            onPermissionDenied();
        }
    }

    private int checkGrantResults(int[] grantResults) {
        int result = 0;
        for (int grant : grantResults) {
            if (grant == PackageManager.PERMISSION_DENIED) {
                result = grant;
                break;
            }
        }
        return result;
    }

}
