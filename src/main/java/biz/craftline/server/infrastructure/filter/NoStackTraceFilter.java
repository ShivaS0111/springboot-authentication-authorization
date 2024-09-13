package biz.craftline.server.infrastructure.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;


public class NoStackTraceFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getThrowableProxy() != null &&
                event.getThrowableProxy().getClassName().contains("DataIntegrityViolationException")) {
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }
}
