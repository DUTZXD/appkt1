package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.view.ScrollerTextView;

import java.io.FileOutputStream;

public class SecondActivity extends AppCompatActivity {



    ScrollerTextView testTv;

    RelativeLayout root;

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        testTv = findViewById(R.id.test_tv);
        root = findViewById(R.id.root);
//        root.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.scrollBy(10, 10);
////                v.setTranslationX();
//            }
//        });

        testTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ExternalStorageHelper.checkPermission(SecondActivity.this)) {
                    ExternalStorageHelper.requestPermission(SecondActivity.this, PERMISSION_REQUEST_CODE);
                } else {
                    // 权限已经被授予，执行文件保存操作
                    boolean result = ExternalStorageHelper.writeStringToPublicDirectory(SecondActivity.this, "example.txt", "这是要保存的字符串内容");
                    if (result) {
                        Toast.makeText(SecondActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        // 文件成功保存
                    } else {
                        Toast.makeText(SecondActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                        // 文件保存失败
                    }
                }

//                saveToFile("test.txt", "woshilgfjgkbkjoh");
            }
        });
    }

    public void saveToFile(String fileName, String content) {
        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {


        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {

            }

        }
    }
}