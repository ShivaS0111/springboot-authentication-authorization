package biz.craftline.server.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Aspect
@Component
class LoggingAspect {
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @After("execution(* biz.craftline.server.domain.*.*(..)) || execution(* biz.craftline.server.api.controller.*.*(..))  || execution(* biz.craftline.server.infrastructure.*.*(..))")
    fun logBeforeMethod(joinPoint: JoinPoint) {
        //if (logger.isInfoEnabled) {
            logger.info("Entering method: {} with args: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
        //}
    }

    @After("execution(* biz.craftline.server.domain.*.*(..)) || execution(* biz.craftline.server.api.controller.*.*(..)) || execution(* biz.craftline.server.infrastructure.*.*(..))")
    fun logAfterMethod(joinPoint: JoinPoint) {
        //if (logger.isInfoEnabled) {
            logger.info("Exiting method: {}", joinPoint.signature.toShortString());
        //}
    }

    @AfterThrowing(pointcut = "execution(* biz.craftline.server.domain.*.*(..)) || execution(* biz.craftline.server.api.controller.*.*(..)) || execution(* biz.craftline.server.infrastructure.*.*(..))", throwing = "ex")
    fun logExceptions(joinPoint: JoinPoint, ex: Throwable) {
        logger.error(
            "Exception in method: {} with args: {}, Exception: {}",
            joinPoint.signature.toShortString(), joinPoint.args, ex.message, ex
        )
    }
}
