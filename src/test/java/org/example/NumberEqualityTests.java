package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class NumberEqualityTests {

    @Nested
    class IntegerEqualityTests {
        @ParameterizedTest
        @ValueSource(ints = {-128, 127})
        void objectEqualityWithOperator_withinIntegerCache_shouldBeTrue(int n) {
            // Integer caches between -128 and 127
            Integer a = n;
            Integer b = n;
            boolean result = a == b;
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void objectEqualityWithOperator_outsideOfIntegerCache_shouldBeFalse(int n) {
            Integer a = n;
            Integer b = n;
            boolean result = a == b;
            assertFalse(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void primitiveEqualityWithOperator_outsideOfIntegerCache_shouldBeTrue(int n) {
            int a = n;
            int b = n;
            boolean result = a == b;
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void primitiveAndObjectEqualityWithOperator_outsideOfIntegerCache_shouldBeTrue(int n) {
            Integer a = n;
            int b = n;
            boolean result = a == b;
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, -128, 127, 128})
        void objectEqualsMethod_shouldBeTrue(int n) {
            Integer a = n;
            Integer b = n;
            boolean result = a.equals(b);
            assertTrue(result);
        }
    }

    @Nested
    class LongEqualityTests {
        @ParameterizedTest
        @ValueSource(longs = {-128L, 127L})
        void objectEqualityWithOperator_withinLongCache_shouldBeTrue(long n) {
            Long a = n;
            Long b = n;
            boolean result = a == b;
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void objectEqualityWithOperator_outsideOfLongCache_shouldBeFalse(long n) {
            Long a = n;
            Long b = n;
            boolean result = a == b;
            assertFalse(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void primitiveEqualityWithOperator_outsideOfLongCache_shouldBeTrue(long n) {
            long a = n;
            long b = n;
            boolean result = a == b;
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(ints = {-129, 128})
        void primitiveAndObjectEqualityWithOperator_outsideOfLongCache_shouldBeTrue(long n) {
            Long a = n;
            long b = n;
            boolean result = a == b;
            assertTrue(result);
        }

        @ParameterizedTest
        @ValueSource(longs = {-129L, -128L, 127L, 128L})
        void objectEqualsMethod_shouldBeTrue(long n) {
            Long a = n;
            Long b = n;
            boolean result = a.equals(b);
            assertTrue(result);
        }
    }


    @Nested
    class NullableIntegerEqualityTests {

        public boolean isEqual(Integer a, Integer b) {
            return Optional.ofNullable(a)
                    .map(aValue -> aValue.equals(b))
                    .orElse(b == null);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "1, 2",
                "1, null",
                "null ,1",
        }, nullValues = {"null"})
        void integerWithDifferentValue_shouldBeFalse(Integer a, Integer b) {
            boolean result = isEqual(a, b);
            assertFalse(result);
        }

        @ParameterizedTest
        @CsvSource(value = {"-129", "-128", "127", "128", "null"}, nullValues = {"null"})
        void integerWithSameValue_shouldBeTrue(Integer n) {
            Integer a = n;
            Integer b = n;
            boolean result = isEqual(a, b);
            assertTrue(result);
        }
    }
}
