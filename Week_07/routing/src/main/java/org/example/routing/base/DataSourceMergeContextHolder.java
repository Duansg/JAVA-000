package org.example.routing.base;

/**
 * DataSourceMergeContextHolder
 * @author duansg
 * @version 1.0
 */
public class DataSourceMergeContextHolder {

    private static final ThreadLocal<String> MERGE_CONTEXT = new ThreadLocal<>();

    public static void set(String id) {
        MERGE_CONTEXT.set(id);
    }

    public static String get() {
        return MERGE_CONTEXT.get();
    }

    public static void clear() {
        MERGE_CONTEXT.set(null);
    }
}
