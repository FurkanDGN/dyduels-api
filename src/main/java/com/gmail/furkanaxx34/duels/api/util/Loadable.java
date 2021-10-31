package com.gmail.furkanaxx34.duels.api.util;

/**
 * A class that can be loadable.
 */
public interface Loadable {

    /**
     * loads the class.
     */
    void handleLoad() throws Exception;

    /**
     * unloads the class.
     */
    void handleUnload() throws Exception;
}
