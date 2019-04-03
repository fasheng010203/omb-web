package com.onemile.bms.datasource.annotation;

import com.onemile.bms.datasource.DynamicDataSourceHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Eric
 * 动态数据源，根据相应规则，可自主选择
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        Object obj = DynamicDataSourceHolder.getDataSource();
        return obj;
    }


}
