package com.caolch.kmbridge.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ParamsManager {

    private static ParamsOption paramsOption;
    private static Properties pro;
    private static RunningType runningType;

    public ParamsManager() {
        synchronized (this) {
            if (paramsOption == null) {
                paramsOption = new ParamsOption();
            }
            if (pro == null) {
                pro = new Properties();
            }
        }
    }

    public ParamsManager(String[] args) {
        synchronized (this) {
            if (args != null && args.length > 1 && paramsOption == null) {
                paramsOption = new ParamsOption(args);
            } else if (paramsOption == null) {
                paramsOption = new ParamsOption();
            }
            if (pro == null) {
                pro = new Properties();
            }
        }
    }

    public  void load(RunningType type) {

    }

    private void setProperiesFromFile() {
        if (getConfigPath() != null && getConfigPath().length() > 0) {
            try {
                this.pro.load(new FileReader(getConfigPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getHostname() {
        return paramsOption.getHostname();
    }

    public String getPort() {
        return paramsOption.getPort();
    }

    public String getConfigPath() {
        return paramsOption.getConfigFile();
    }
}
