package com.microkernel.core;

import com.microkernel.plugins.*;
import java.util.List;

public class PluginLoader {

    public static List<Plugin> loadPlugins() {
        return List.of(
            new FileServicePlugin(),
            new AuthServicePlugin(),
            new LogServicePlugin()
        );
    }
}