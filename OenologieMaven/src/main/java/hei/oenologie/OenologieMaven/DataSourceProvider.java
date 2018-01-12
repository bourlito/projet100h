package hei.oenologie.OenologieMaven;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {
    private static MysqlDataSource dataSource;

    public static DataSource getDataSource(){
        return dataSource;
    }

    private static void initDataSource(){}
}
