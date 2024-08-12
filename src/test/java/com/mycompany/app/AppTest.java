package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        // Redirect System.out to capture output
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        // Test if the constructor works without throwing exceptions
        try {
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain() {
        // Run the main method
        App.main(null);

        // Define the expected output
        String expectedOutput = "Hello World!" + System.lineSeparator() + " Welcome to pipeline";

        // Get the actual output and trim any trailing newlines
        String actualOutput = outContent.toString().trim();

        // Compare the actual output with the expected output
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void cleanUpStreams() {
        // Restore original System.out
        System.setOut(null);
    }
}
