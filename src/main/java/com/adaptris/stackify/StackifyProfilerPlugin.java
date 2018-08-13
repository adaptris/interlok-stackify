package com.adaptris.stackify;

import com.adaptris.profiler.client.ClientPlugin;
import com.stackify.metric.MetricManager;

public abstract class StackifyProfilerPlugin implements ClientPlugin {

  @Override
  public void start() {
  }

  @Override
  public void stop() {
    MetricManager.shutdown(); // force a flush of any queued metrics.
  }

  @Override
  public void init() {}

  @Override
  public void close() {}

}
