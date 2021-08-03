package com.vti.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SqlUtils {
    public static void addParams(PreparedStatement preparedStatement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            preparedStatement.setObject(i + 1, param);
        }
    }
}
