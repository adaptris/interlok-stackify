package com.adaptris.stackify.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adaptris.profiler.ProcessStep;
import com.adaptris.profiler.StepType;

public class WorkflowStatsCompiler extends StatsCompiler {

  private Logger log = LoggerFactory.getLogger(this.getClass());
  private static WorkflowStatsCompiler instance;
  private static final String METRIC_NAME = "Workflows";

  private WorkflowStatsCompiler() {
  }

  public synchronized static WorkflowStatsCompiler getInstance() {
    if (instance == null) instance = new WorkflowStatsCompiler();
    return instance;
  }

  @Override
  protected boolean canHandle(ProcessStep processStep) {
    return processStep.getStepType() == StepType.WORKFLOW;
  }

  @Override
  protected String metricPrefix() {
    return METRIC_NAME;
  }
}
