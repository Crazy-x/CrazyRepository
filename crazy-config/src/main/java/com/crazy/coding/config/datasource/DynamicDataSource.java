package com.crazy.coding.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String key = DynamicDataSourceHolder.getDataSourceLookupKey();
        return key == null ? "master" : key;
    }
}
