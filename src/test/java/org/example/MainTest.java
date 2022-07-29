package org.example;

import com.sun.security.auth.module.UnixSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Nested
    class IntegerEqualityTests {
        @Test
        void objectEqualityWithOperator_withinIntegerCache_shouldBeTrue() {
            // Integer caches between -128 and 127
            Integer a = 127;
            Integer b = 127;
            boolean result = a == b; // true
            assertTrue(result);
        }

        @Test
        void objectEqualityWithOperator_outsideOfIntegerCache_shouldBeFalse() {
            // Integer caches between -128 and 127
            Integer a = 128;
            Integer b = 128;
            boolean result = a == b; // false
            assertFalse(result);
        }

        @Test
        void primitiveEqualityWithOperator_outsideOfIntegerCache_shouldBeTrue() {
            // Integer caches between -128 and 127
            int a = 128;
            int b = 128;
            boolean result = a == b; // true
            assertTrue(result);
        }

        @Test
        void primitiveAndObjectEqualityWithOperator_outsideOfIntegerCache_shouldBeTrue() {
            // Integer caches between -128 and 127
            Integer a = 128;
            int b = 128;
            boolean result = a == b; // true
            assertTrue(result);
        }
    }

    @Nested
    class LongEqualityTests {
        @Test
        void objectEqualityWithOperator_withinLongCache_shouldBeTrue() {
            // Long caches between -128 and 127
            Long a = 127L;
            Long b = 127L;
            boolean result = a == b; // true
            assertTrue(result);
        }

        @Test
        void objectEqualityWithOperator_outsideOfLongCache_shouldBeFalse() {
            // Long caches between -128 and 127
            Long a = 128L;
            Long b = 128L;
            boolean result = a == b; // false
            assertFalse(result);
        }

        @Test
        void primitiveEqualityWithOperator_outsideOfLongCache_shouldBeTrue() {
            // Long caches between -128 and 127
            long a = 128L;
            long b = 128L;
            boolean result = a == b; // true
            assertTrue(result);
        }

        @Test
        void primitiveAndObjectEqualityWithOperator_outsideOfLongCache_shouldBeTrue() {
            // Long caches between -128 and 127
            Long a = 128L;
            long b = 128L;
            boolean result = a == b; // true
            assertTrue(result);
        }
    }

    @Test
    void a() {
        ChronoUnit
    }
}
