package com.car.manage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Map;

/**
 * index controller.
 */
@Controller
@RequestMapping("/car/index")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private DataSource datasource;

    @Value("${car.version}")
    private String systemVersion;

    @Value("${url}")
    private String url;
    @Value("${server.port}")
    private String port;

    /**
     * index.
     *
     * @param map map
     * @return to index page.
     * @throws Exception exception
     */
    @RequestMapping
    public String index(Map<String, Object> map) throws Exception {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("_________________________");
        }
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Connection connection = datasource.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        map.put("os", System.getProperty("os.name"));  //SUPPRESS
        map.put("versionName", systemVersion);
        map.put("database", metaData.getDatabaseProductName());
        map.put("databaseVersion", metaData.getDatabaseProductVersion());

        if (url.indexOf("localhost") != -1) {
            url = url.replace("localhost", ip + ":" + port);
        }
        map.put("url", url);
        return "car/index";
    }
}
