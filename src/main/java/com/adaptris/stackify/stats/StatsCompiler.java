package com.adaptris.stackify.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adaptris.profiler.ProcessStep;
import com.adaptris.profiler.client.EventReceiver;
import com.stackify.metric.Counter;
import com.stackify.metric.MetricFactory;
import com.stackify.metric.Timer;

public abstract class StatsCompiler implements EventReceiver {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  protected StatsCompiler() {
  }

  @Override
  public void onEvent(ProcessStep processStep) {
    if (canHandle(processStep)) {
      String id = processStep.getStepInstanceId();
      if (isEmpty(id)) {
        id = "unknown";
      }
      String metricName = metricPrefix() + id;
      log.trace("Increment Counter for {}", metricName);
      
      Counter counter = MetricFactory.getCounter(metricPrefix(), id + " count");
      counter.increment();

      Timer timer = MetricFactory.getTimer(metricPrefix(), id + " time");
      timer.durationMs(processStep.getTimeTakenMs());
      
//      SerializableAdaptrisMessage message = processStep.getMessage();
//      String exception = message.getMetadataValue(CoreConstants.OBJ_METADATA_EXCEPTION);
//      if(exception != null)
//        com.stackify.api.common.log.direct.Logger.queueException(new Exception(exception));
    }
  }

  protected abstract boolean canHandle(ProcessStep processStep);
  
  protected abstract String metricPrefix();
  
  private static boolean isEmpty(String s) {
    return "".equals(s) || s == null;
  }
}
