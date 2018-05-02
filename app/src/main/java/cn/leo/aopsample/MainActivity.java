package cn.leo.aopsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.leo.permissionlib.PermissionEnum;
import cn.leo.permissionlib.PermissionRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tvTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPermission();
            }
        });
    }

    @PermissionRequest({PermissionEnum.CAMERA, PermissionEnum.READ_EXTERNAL_STORAGE})
    public void testPermission() {
        Toast.makeText(this, "测试申请权限", Toast.LENGTH_SHORT).show();
    }
}
