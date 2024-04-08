package com.example.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorageHelper {

    // 检查是否有写入外部存储的权限
    public static boolean checkPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    // 请求写入外部存储的权限
    public static void requestPermission(Activity activity, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
    }

    // 将字符串写入到外部存储的公共目录
    public static boolean writeStringToPublicDirectory(Context context, String fileName, String content) {
        // 检查是否有写入权限
        if (!checkPermission(context)) {
            return false;
        }

        // 获取外部存储的 Download 目录
        File publicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!publicDir.exists()) {
            publicDir.mkdirs();
        }

        // 创建文件对象
        File file = new File(publicDir, fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            // 写入内容
            fos.write(content.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

