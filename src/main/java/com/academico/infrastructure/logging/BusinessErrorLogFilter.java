package com.academico.infrastructure.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.classic.Level;

public class BusinessErrorLogFilter extends Filter<ILoggingEvent> {

  public boolean acceptBusinessErrorLog = true;

  public boolean getAcceptBusinessErrorLog() {
    return this.acceptBusinessErrorLog;
  }

  public void setAcceptBusinessErrorLog(boolean acceptBusinessErrorLog) {
    this.acceptBusinessErrorLog = acceptBusinessErrorLog;
  }

  @Override
  public FilterReply decide(ILoggingEvent event) {
    if(!event.getLevel().equals(Level.ERROR)) {
      return FilterReply.DENY;
    }
    if (event.getMessage().contains("BUSINESS - ")) {
      return this.acceptBusinessErrorLog ? FilterReply.ACCEPT : FilterReply.DENY;
    } else {
      return this.acceptBusinessErrorLog ? FilterReply.DENY : FilterReply.ACCEPT;
    }
  }
}