package cn.leo.permissionlib;

import android.Manifest;

/**
 * Created by Leo on 2018/5/2.
 */

public enum PermissionEnum {
    READ_CONTACTS("读取联系人", Manifest.permission.READ_CONTACTS),
    READ_PHONE_STATE("读取电话信息", Manifest.permission.READ_PHONE_STATE),
    READ_CALENDAR("读取日历", Manifest.permission.READ_CALENDAR),
    CAMERA("相机", Manifest.permission.CAMERA),
    CALL_PHONE("拨打电话", Manifest.permission.CALL_PHONE),
    BODY_SENSORS("传感器", Manifest.permission.BODY_SENSORS),
    ACCESS_FINE_LOCATION("精确定位", Manifest.permission.ACCESS_FINE_LOCATION),
    ACCESS_COARSE_LOCATION("粗略定位", Manifest.permission.ACCESS_COARSE_LOCATION),
    READ_EXTERNAL_STORAGE("读取存储卡", Manifest.permission.READ_EXTERNAL_STORAGE),
    WRITE_EXTERNAL_STORAGE("写入存储卡", Manifest.permission.WRITE_EXTERNAL_STORAGE),
    RECORD_AUDIO("录音", Manifest.permission.RECORD_AUDIO),
    READ_SMS("读取短信", Manifest.permission.READ_SMS);
    private String permissionCh;
    private String permission;

    PermissionEnum(String permissionCh, String permission) {
        this.permissionCh = permissionCh;
        this.permission = permission;
    }

    public String getPermissionCh() {
        return permissionCh;
    }

    public String getPermission() {
        return permission;
    }
}
