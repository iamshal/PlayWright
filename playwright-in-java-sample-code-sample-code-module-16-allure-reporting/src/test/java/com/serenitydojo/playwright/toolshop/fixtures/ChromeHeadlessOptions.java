package com.serenitydojo.playwright.toolshop.fixtures;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import java.util.Arrays;

public class ChromeHeadlessOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        return new Options().setLaunchOptions(
                        new BrowserType.LaunchOptions()
                                .setArgs(Arrays.asList(
                                    "--no-sandbox", 
                                    "--disable-extensions", 
                                    "--disable-gpu",
                                    "--disable-dev-shm-usage",
                                    "--disable-web-security",
                                    "--ignore-certificate-errors",
                                    "--ignore-ssl-errors",
                                    "--ignore-certificate-errors-spki-list"
                                ))
                ).setHeadless(true)
                .setTestIdAttribute("data-test")
                .setTimeout(120000)
                .setActionTimeout(60000)
                .setNavigationTimeout(120000);
    }
}
