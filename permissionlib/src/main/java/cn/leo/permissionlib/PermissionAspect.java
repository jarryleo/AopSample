package cn.leo.permissionlib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by Leo on 2018/5/2.
 */
@Aspect
public class PermissionAspect {
    private static final String POINTCUT_METHOD =
            "execution(@cn.leo.permissionlib.PermissionRequest * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithPermission() {
    }

    @Around("methodAnnotatedWithPermission()")
    public void aroundJoinPoint(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        PermissionRequest annotation = method.getAnnotation(PermissionRequest.class);
        PermissionEnum[] permission = annotation.value();
        Object target = joinPoint.getTarget();
        FragmentActivity fragmentActivity;
        if (target instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) target;
        } else if (target instanceof Fragment) {
            fragmentActivity = ((Fragment) target).getActivity();
        } else {
            throw new NullPointerException("注解权限申请只能在FragmentActivity或者Fragment环境");
        }
        final FragmentActivity finalFragmentActivity = fragmentActivity;
        PermissionUtil.getInstance(fragmentActivity)
                .request(permission)
                .execute(new PermissionUtil.Result() {
                    @Override
                    public void onSuccess() {
                        try {
                            joinPoint.proceed();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailed() {
                        Toast.makeText(finalFragmentActivity, "获取权限失败，操作无法完成!", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
