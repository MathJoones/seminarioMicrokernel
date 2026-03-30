package com.microkernel.core;

import java.util.Map;

public interface Plugin {

    String getName();
    String handle(String action, Map<String, String> params);
}
