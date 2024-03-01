package org.example.training;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdIo;
import org.junitpioneer.jupiter.StdOut;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    @StdIo
    public void testMain(StdOut out) throws Exception {
        // Artificially make the test take longer than 5 seconds for demo purposes
        // If the test is too fast, it's harder to see difference between a build with or without caching
        Thread.sleep(5000);

        // call main
        HelloWorld.main();

        // expect System output
        assertEquals("Hello World!", out.capturedLines()[0]);
    }
}
