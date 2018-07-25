package com.adaptris.stackify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adaptris.profiler.client.ClientPlugin;
import com.adaptris.profiler.client.EventReceiver;
import com.adaptris.profiler.client.PluginFactory;
import com.adaptris.stackify.stats.ServiceStatsCompiler;

/**
 * {@link PluginFactory} instance that creates listeners for Services only.
 * 
 * 
 */
public class ServiceProfiler extends PluginFactory {

  private ClientPlugin plugin;

  @Override
  public ClientPlugin getPlugin() {
    if (this.plugin == null) this.plugin = new ServicesOnly();
    return this.plugin;
  }

  private class ServicesOnly extends StackifyProfilerPlugin {

    @Override
    public List<EventReceiver> getReceivers() {
      return new ArrayList<EventReceiver>(Arrays.asList(ServiceStatsCompiler.getInstance()));

    }

  }
}
