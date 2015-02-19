package com.adaptris.stackify.stats;

import com.adaptris.profiler.ProcessStep;
import com.adaptris.profiler.StepType;

public class ProducerStatsCompiler extends StatsCompiler {

  private static ProducerStatsCompiler instance;
  private static final String METRIC_NAME = "Producers";

  private ProducerStatsCompiler() {
  }

  public synchronized static ProducerStatsCompiler getInstance() {
    if (instance == null) instance = new ProducerStatsCompiler();
    return instance;
  }

  @Override
  protected boolean canHandle(ProcessStep processStep) {
    return processStep.getStepType() == StepType.PRODUCER;
  }

  @Override
  protected String metricPrefix() {
    return METRIC_NAME;
  }
}
