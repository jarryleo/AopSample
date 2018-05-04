package cn.leo.aopsample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.leo.permission.PermissionRequest;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
        findViewById(R.id.tvTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPermission();
            }
        });
    }

    @PermissionRequest({Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void testPermission() {
        Toast.makeText(this, "执行权限通过后的业务", Toast.LENGTH_SHORT).show();
    }

    public void test() {
        /*int i = getPackageManager().checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, getPackageName());
        boolean has = PackageManager.PERMISSION_GRANTED == i;
*/
        PackageManager packageManager = getPackageManager();
        PermissionInfo permissionInfo = null;
        PermissionGroupInfo groupInfo = null;
        try {
            permissionInfo = packageManager.
                    getPermissionInfo(Manifest.permission.CAMERA, 0);
            groupInfo = packageManager.getPermissionGroupInfo(permissionInfo.group, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //Toast.makeText(this, permissionInfo.loadLabel(packageManager), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, groupInfo.loadLabel(packageManager), Toast.LENGTH_SHORT).show();
    }
}
