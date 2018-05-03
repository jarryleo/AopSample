# AopSample
## 面向切片的动态权限申请
### 使用方法
```
    @PermissionRequest({PermissionEnum.CAMERA, PermissionEnum.READ_EXTERNAL_STORAGE})
    public void testPermission() {
        Toast.makeText(this, "测试申请权限", Toast.LENGTH_SHORT).show();
    }
```
### 依赖方法:
Step 1. Add the JitPack repository to your build file （project build）
Add it in your root build.gradle at the end of repositories:
```
    	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency (app build)
```	
	//插件
    	apply plugin: 'cn.leo.permission_plug.permission'
	//依赖
	dependencies {
		 compile 'com.github.jarryleo:AopSample:v1.0'
	}
	//插件仓库
   	buildscript {
	    repositories {
		jcenter()
		maven {
		    url  "https://dl.bintray.com/yjtx256/maven"
		}
	    }
	    dependencies {
		classpath 'cn.leo.plugin:permission-plug:1.0.2'
	    }
	}
```

