package com.adaptris.stackify;

import com.adaptris.profiler.client.ClientPlugin;
import com.stackify.metric.MetricManager;

public abstract class StackifyProfilerPlugin implements ClientPlugin {

  @Override
  public void start(Object object) {
  }

  @Override
  public void stop(Object object) {
    MetricManager.shutdown(); // force a flush of any queued metrics.
  }

  @Override
  public void init(Object object) {
  }

  @Override
  public void close(Object object) {
  }

}
