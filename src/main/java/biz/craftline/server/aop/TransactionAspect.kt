package biz.craftline.server.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component


@Aspect
@Component
class TransactionAspect {
    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    @Throws(Throwable::class)
    fun manageTransaction(pjp: ProceedingJoinPoint): Any {
        // Start transaction manually if needed
        val result = pjp.proceed()
        // Commit transaction after method execution
        return result
    }
}