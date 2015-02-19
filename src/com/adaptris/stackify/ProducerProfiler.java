package com.adaptris.stackify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.adaptris.profiler.client.ClientPlugin;
import com.adaptris.profiler.client.EventReceiver;
import com.adaptris.profiler.client.PluginFactory;
import com.adaptris.stackify.stats.ProducerStatsCompiler;

public class ProducerProfiler extends PluginFactory {

  private ClientPlugin plugin;

  @Override
  public ClientPlugin getPlugin() {
    if (this.plugin == null) this.plugin = new ProducersOnly();
    return this.plugin;
  }

  private class ProducersOnly extends StackifyProfilerPlugin {

    @Override
    public List<EventReceiver> getReceivers() {
      return new ArrayList<EventReceiver>(Arrays.asList(ProducerStatsCompiler.getInstance()));
    }

  }
}

