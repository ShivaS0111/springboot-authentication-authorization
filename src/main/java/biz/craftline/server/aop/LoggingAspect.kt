package biz.craftline.server.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


@Aspect
@Component
class LoggingAspect {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Before("execution(* biz.craftline.server.domain.service.*.*(..))")
    fun logBeforeMethod(joinPoint: JoinPoint) {
        logger.info("Entering method: " + joinPoint.signature.name)
    }

    @After("execution(* biz.craftline.server.domain.service.*.*(..))")
    fun logAfterMethod(joinPoint: JoinPoint) {
        logger.info("Exiting method: " + joinPoint.signature.name)
    }
}
