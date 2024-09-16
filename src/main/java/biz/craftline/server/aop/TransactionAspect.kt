package biz.craftline.server.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Aspect
@Component
class TransactionAspect {


    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    @Throws(Throwable::class)
    fun manageTransaction(joinPoint: ProceedingJoinPoint): Any {
        logger.info("Start txn: {} with args: {}", joinPoint.signature.toShortString(), joinPoint.args);

        // Start transaction manually if needed
        val result = joinPoint.proceed()
        // Commit transaction after method execution
        logger.info("commi txn: {} with args: {}", joinPoint.signature.toShortString(), joinPoint.args);

        return result
    }
}