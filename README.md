# AopSample
## 面向切片的动态权限申请
### 使用方法(注意:只能在Fragment(v4)和FragmentActivity里面使用)
```
    @PermissionRequest(
            {Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void testPermission() {
        //执行权限申请通过后的业务逻辑
    }
```
### 依赖方法:
Step 1. Add the JitPack repository to your build file （project build）,

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
    	apply plugin: 'cn.leo.plugin.permission'
	...
	//插件仓库
   	buildscript {
	    repositories {
		jcenter()
		maven{ url 'https://dl.bintray.com/yjtx256/maven'}
	    }
	    dependencies {
		classpath 'cn.leo.plugin:permission-plugin:3.0.0'
	    }
	}
```

