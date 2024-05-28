package com.megayasa.Backend.Helpers;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class DataProperties {
    private static final Configurations configs = new Configurations();
    public static String URL_DB;
    public static String USER_DB;
    public static String PASSWORD_DB;
    public static String GLOBAL_PASSWORD;
    public static String REPORT_FOLDER;
    public static Integer EXPIRED_LOGIN_TIMEOUT;
    public static String UPLOAD_FOLDER;
    public static String DataNotFoundMessage = "Data tidak ditemukan";
    public static String SuccessCreateMessage = "Berhasil menambah data";
    public static String SuccessUpdateMessage = "Berhasil memperbarui data";
    public static String SuccessDeleteMessage = "Berhasil menghapus data";
    public static String UnauthorizedMessage = "Akses ditolak";

    static {
        try {
            Configuration config = configs.properties("application.properties");
            URL_DB = config.getString("db.url");
            USER_DB = config.getString("db.user");
            PASSWORD_DB = config.getString("db.password");
            GLOBAL_PASSWORD = config.getString("global.password");
            REPORT_FOLDER = config.getString("report.folder");
            EXPIRED_LOGIN_TIMEOUT = Integer.valueOf(config.getString("expired.login.timeout"));
            UPLOAD_FOLDER = config.getString("photo.folder");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
