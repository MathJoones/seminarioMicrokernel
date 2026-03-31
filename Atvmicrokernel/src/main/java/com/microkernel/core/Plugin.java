package com.microkernel.core;

public interface Plugin {
    String getName();
    void execute();

    // NOVO (evento)
    void onEvent(String event);
}