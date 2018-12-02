package com.caolch.kmbridge.common;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ParamsOption {
    private String configFile = Constants.DEFAULT_CONFIGFILE_PATH;
    private String hostname = Constants.DEFAULT_HOST;
    private String port = Constants.DEFAULT_PORT;
    Options options;

    public ParamsOption() {
        options = new Options();
        options.addOption("c", "config",false, "The path of configure file");
        options.addOption("h", "hostname", false, "hostname");
        options.addOption("p", "port", false, "port");
    }

    public ParamsOption(String[] args) {
        this();
        CommandLineParser parser = new BasicParser();
        try {
            CommandLine cmdLine = parser.parse(this.options, args);
            if (cmdLine.hasOption('c')) {
                setConfigFile(cmdLine.getOptionValue('c'));
            }
            if (cmdLine.hasOption('h')) {
                setHostname(cmdLine.getOptionValue('h'));
            }
            if (cmdLine.hasOption('p')) {
                setPort(cmdLine.getOptionValue('p'));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}