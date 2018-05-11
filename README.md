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
#### Step 1. Add the JitPack repository to your build file
1.在全局build里面添加下面github仓库地址
Add it in your root build.gradle at the end of repositories:
```
buildscript {
    ...
    dependencies {
	...
        classpath 'cn.leo.plugin:magic-plugin:1.0.0'
    }
}
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
google()和jcenter()这两个仓库一般是默认的，如果没有请加上

#### Step 2. Add the dependency
2.在app的build里面添加插件和依赖
```
apply plugin: 'cn.leo.plugin.magic'
...
dependencies {
	implementation 'com.github.jarryleo:AopSample:v3.0'
}
```

