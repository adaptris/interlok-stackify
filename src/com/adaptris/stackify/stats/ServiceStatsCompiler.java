package com.adaptris.stackify.stats;

import com.adaptris.profiler.ProcessStep;
import com.adaptris.profiler.StepType;

public class ServiceStatsCompiler extends StatsCompiler {

  private static ServiceStatsCompiler instance;
  private static final String METRIC_NAME = "Services";

  private ServiceStatsCompiler() {
  }

  public synchronized static ServiceStatsCompiler getInstance() {
    if (instance == null) instance = new ServiceStatsCompiler();
    return instance;
  }

  @Override
  protected boolean canHandle(ProcessStep processStep) {
    return processStep.getStepType() == StepType.SERVICE;
  }

  @Override
  protected String metricPrefix() {
    return METRIC_NAME;
  }
}
