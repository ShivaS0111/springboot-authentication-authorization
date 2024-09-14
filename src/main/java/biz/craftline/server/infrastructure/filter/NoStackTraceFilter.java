package biz.craftline.server.infrastructure.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.util.List;


public class NoStackTraceFilter extends Filter<ILoggingEvent> {

    List<String> stackInfoIgnoreList = List.of("BadCredentialsException", "DataIntegrityViolationException");

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getThrowableProxy() != null && isInStackIgnoredList(event.getThrowableProxy().getClassName())) {
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }

    private boolean isInStackIgnoredList(String className) {
        for (String exception : stackInfoIgnoreList) {
            if (className.contains(exception)) {
                return true;
            }
        }
        return false;
    }
}
