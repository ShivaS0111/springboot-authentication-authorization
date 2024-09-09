package biz.craftline.server.aop

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import kotlin.jvm.Throws

//@Aspect
//@Component
public class SecurityAspect {

    //@Before("@annotation(biz.craftline.server.aop.DynamicPermissionCheck)")
    //@Throws(AccessDeniedException::class)
   fun checkPermission( joinPoint: JoinPoint)  {
        // Fetch user permissions from the context (or JWT token)
        // Check if the user has the necessary permission for the operation
       var hasPermission = false//...check logic;

        if (!hasPermission) {
            throw AccessDeniedException("User lacks permission for this operation");
        }
    }
}
