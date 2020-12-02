package org.example.routing.base;

/**
 * DataSourceContextHolder
 * @author duansg
 * @version 1.0
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> DATASOURCE_CONTEXT = new ThreadLocal<>();

    public static void set(String datasourceType) {
        DATASOURCE_CONTEXT.set(datasourceType);
    }

    public static String get() {
        return DATASOURCE_CONTEXT.get();
    }

    public static void clear() {
        DATASOURCE_CONTEXT.set(null);
    }
}
