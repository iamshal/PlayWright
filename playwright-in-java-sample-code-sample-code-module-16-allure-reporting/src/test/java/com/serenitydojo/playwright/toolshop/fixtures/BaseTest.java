package com.serenitydojo.playwright.toolshop.fixtures;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;

@UsePlaywright(ChromeHeadlessOptions.class)
public abstract class BaseTest {
    
    @BeforeEach
    void setUpTimeouts(Page page) {
        // Set extended timeouts for CI environment
        page.setDefaultTimeout(120000); // 2 minutes
        page.setDefaultNavigationTimeout(120000); // 2 minutes
    }
}
