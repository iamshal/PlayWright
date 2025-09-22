package com.serenitydojo.playwright.toolshop.ci;

import com.microsoft.playwright.Page;
import com.serenitydojo.playwright.toolshop.fixtures.BaseTest;
import com.serenitydojo.playwright.toolshop.fixtures.TakesFinalScreenshot;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Robust Contact Form Tests")
@Feature("CI")
public class RobustContactFormTest extends BaseTest implements TakesFinalScreenshot {

    @BeforeEach
    void setupPage(Page page) {
        // Create a simple HTML form for testing
        String htmlForm = """
            <html>
            <head><title>Contact Form Test</title></head>
            <body>
                <h1>Contact Us</h1>
                <form id="contact-form">
                    <label for="firstname">First name</label>
                    <input type="text" id="firstname" name="firstname" required>
                    
                    <label for="lastname">Last name</label>
                    <input type="text" id="lastname" name="lastname" required>
                    
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                    
                    <label for="message">Message</label>
                    <textarea id="message" name="message" required></textarea>
                    
                    <button type="submit">Submit</button>
                </form>
            </body>
            </html>
            """;
        
        page.navigate("data:text/html," + htmlForm);
    }

    @Test
    @Story("Form interaction")
    @DisplayName("Can fill and submit contact form")
    void testFormInteraction(Page page) {
        // Fill the form
        page.fill("#firstname", "John");
        page.fill("#lastname", "Doe");
        page.fill("#email", "john@example.com");
        page.fill("#message", "This is a test message for the contact form.");
        
        // Submit the form
        page.click("button[type='submit']");
        
        // Verify form was filled
        String firstName = page.inputValue("#firstname");
        assertTrue(firstName.equals("John"), "First name should be filled");
        
        String email = page.inputValue("#email");
        assertTrue(email.equals("john@example.com"), "Email should be filled");
    }
}
