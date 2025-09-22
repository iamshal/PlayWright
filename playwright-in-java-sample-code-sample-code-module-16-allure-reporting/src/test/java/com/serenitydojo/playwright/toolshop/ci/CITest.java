package com.serenitydojo.playwright.toolshop.ci;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.serenitydojo.playwright.toolshop.fixtures.ChromeHeadlessOptions;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CI Environment Tests")
@Feature("CI Tests")
@UsePlaywright(ChromeHeadlessOptions.class)
public class CITest {

    @Test
    @Story("Basic CI functionality")
    @DisplayName("Test Playwright is working in CI")
    void testPlaywrightWorking(Page page) {
        // Simple test that doesn't require external websites
        page.navigate("data:text/html,<html><body><h1>Test Page</h1></body></html>");
        
        String title = page.title();
        assertTrue(title.contains("Test Page") || title.isEmpty());
        
        String heading = page.textContent("h1");
        assertTrue(heading.contains("Test Page"));
    }
    
    @Test
    @Story("Basic CI functionality")
    @DisplayName("Test browser capabilities")
    void testBrowserCapabilities(Page page) {
        // Test basic browser functionality
        page.navigate("data:text/html,<html><body><input id='test' value='hello' /></body></html>");
        
        String value = page.inputValue("#test");
        assertTrue("hello".equals(value));
    }
}
