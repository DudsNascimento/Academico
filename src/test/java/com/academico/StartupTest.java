/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.academico;

import org.junit.Test;
import static org.junit.Assert.*;

public class StartupTest {
    
    @Test
    public void testAppHasAGreeting() {
        Startup classUnderTest = new Startup();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}