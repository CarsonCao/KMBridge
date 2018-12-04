package com.caolch.kmbridge.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ParamsManager {

    private static ParamsManager paramsMgr = null;
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
            setProperiesFromFile();
            //TO DO
            //按照优先级设置参数，主要是hostname和port
        }

    }

    private void setProperiesFromFile() {
        if (getCmdConfigPath() != null && getCmdConfigPath().length() > 0) {
            try {
                this.pro.load(new FileReader(getCmdConfigPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCmdHostname() {
        return paramsOption.getHostname();
    }

    private String getCmdPort() {
        return paramsOption.getPort();
    }

    private String getCmdConfigPath() {
        return paramsOption.getConfigFile();
    }
}
