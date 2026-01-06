package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static AppConfig instance;

    private final String appName;
    private final String environment;
    private final int port;
    private final String storageMode;


    private AppConfig() {
        // Valeurs par défaut
        String tmpAppName = "MyApp";
        String tmpEnvironment = "DEV";
        int tmpPort = 8080;
        String tmpStorageMode = "MEMORY";


        try (InputStream input = getClass().getClassLoader().getResourceAsStream("app.properties")) {
            if (input != null) {
                Properties props = new Properties();
                props.load(input);

                tmpAppName = props.getProperty("app.name", tmpAppName);
                tmpEnvironment = props.getProperty("app.environment", tmpEnvironment);
                tmpPort = Integer.parseInt(props.getProperty("app.port", String.valueOf(tmpPort)));
                tmpStorageMode = props.getProperty("app.storageMode", tmpStorageMode);
            }
        } catch (IOException e) {
            System.err.println(" Impossible de charger app.properties, utilisation des valeurs par défaut.");
        }

        this.appName = tmpAppName;
        this.environment = tmpEnvironment;
        this.port = tmpPort;
        this.storageMode = tmpStorageMode;
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // Getters
    public String getAppName() {
        return appName;
    }

    public String getEnvironment() {
        return environment;
    }

    public int getPort() {
        return port;
    }

    public String getStorageMode() {
        return storageMode;
    }
}