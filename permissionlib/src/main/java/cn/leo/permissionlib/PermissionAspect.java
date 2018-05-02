package cn.leo.permissionlib;

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
        final FragmentActivity target = (FragmentActivity) joinPoint.getTarget();
        PermissionUtil.getInstance(target)
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
                        Toast.makeText(target, "获取权限失败，操作无法完成!", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
