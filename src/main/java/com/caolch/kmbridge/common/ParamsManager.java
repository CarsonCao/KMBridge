package com.caolch.kmbridge.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ParamsManager {

    private volatile static ParamsManager paramsMgr = null;
    private static ParamsOption paramsOption = null;
    private static RunningType runningType = RunningType.MASTER;
    private static String hostname = Constants.DEFAULT_HOST;
    private static String port = Constants.DEFAULT_PORT;
    private static Properties pro;

    private ParamsManager() {
        pro = new Properties();
    }

    public static ParamsManager getOrCreate() {
        if (paramsMgr == null) {
            synchronized (ParamsManager.class) {
                if (paramsMgr == null) {
                    paramsMgr = new ParamsManager();
                }
            }
        }
        return paramsMgr;
    }

    public static ParamsManager getOrCreate(RunningType type) {
        runningType = type;
        return getOrCreate();
    }

    public void load(String[] args) {
        synchronized (this) {
            if (args != null && args.length > 1 && paramsOption == null) {
                paramsOption = new ParamsOption(args);
            } else if (paramsOption == null) {
                paramsOption = new ParamsOption();
            }
            setPropertiesFromFile();

            String hostKey = runningType.name().toLowerCase() + Constants.PROPERTIES_KEY_HOSTNAME_POST;
            String portKey = runningType.name().toLowerCase() + Constants.PROPERTIES_KEY_PORT_POST;

            if (pro.containsKey(hostKey)) {
                hostname = pro.getProperty(hostKey);
            }
            if (pro.containsKey(portKey)) {
                port = pro.getProperty(portKey);
            }
            System.out.println(paramsOption.getHostname());
            if (paramsOption.getHostname() != null) {
                hostname = paramsOption.getHostname();
            }
            if (paramsOption.getPort() != null) {
                port = paramsOption.getPort();
            }

        }

    }

    private void setPropertiesFromFile() {
        if (getCmdConfigPath() != null && getCmdConfigPath().length() > 0) {
            try {
                this.pro.load(new FileReader(getCmdConfigPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCmdConfigPath() {
        return paramsOption.getConfigFile();
    }


    public static String getHostname() {
        return hostname;
    }

    public static void setHostname(String hostname) {
        ParamsManager.hostname = hostname;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        ParamsManager.port = port;
    }
}
