package com.privilege.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class C3P0Util {

    private static QueryRunner queryRunner;
    public static QueryRunner getQueryRunner(){
        //准备数据源
        ComboPooledDataSource DataSource = new ComboPooledDataSource();
        queryRunner=new QueryRunner(DataSource);
        return queryRunner;
    }


}
