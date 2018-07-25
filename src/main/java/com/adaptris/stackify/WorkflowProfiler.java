package com.adaptris.stackify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adaptris.profiler.client.ClientPlugin;
import com.adaptris.profiler.client.EventReceiver;
import com.adaptris.profiler.client.PluginFactory;
import com.adaptris.stackify.stats.WorkflowStatsCompiler;

/**
 * {@link PluginFactory} instance that creates listeners for Workflows only.
 * 
 * 
 */
public class WorkflowProfiler extends PluginFactory {

  private ClientPlugin plugin;

  @Override
  public ClientPlugin getPlugin() {
    if (this.plugin == null) this.plugin = new WorkflowsOnly();
    return this.plugin;
  }

  private class WorkflowsOnly extends StackifyProfilerPlugin {
    @Override
    public List<EventReceiver> getReceivers() {
      return new ArrayList<EventReceiver>(Arrays.asList(WorkflowStatsCompiler.getInstance()));
    }

  }
}
