package com.crazy.coding.config.datasource;

public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源
     *
     * @param key 数据源名称
     */
    public static void setDataSourceLookupKey(String key) {
        if (key == null) {
            key = "master";
        }
        contextHolder.set(key);
    }

    public static String getDataSourceLookupKey() {
        return contextHolder.get();
    }

    public static void clearDataSourceLookupKey() {
        contextHolder.remove();
    }

}
