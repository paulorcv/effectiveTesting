package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.LeftPad.leftPad;
import static org.junit.jupiter.params.provider.Arguments.of;

class LeftPadTest {

    @ParameterizedTest
    @MethodSource("testCases")
    void shouldReturnCorrectResult(String str, int size, String padStr, String expected ) {
        assertThat(new LeftPad().leftPad(str, size, padStr))
                .isEqualTo(expected);
    }


    static Stream<Arguments> testCases() {

        return Stream.of(
                /*
                str parameter
                1 - null
                2 - empty
                3- non-empty
                 */
                of(null, 1, "*", null),
                of("", 2, "*", "**"),
                of("teste", -1, "*", "teste"),
                /*
                size parameter
                1 - negative
                2 - positive
                3- positive
                 */
                of("teste", -1, "*", "teste"),
                of("teste", 1, "*", "teste"),
                of("teste", 10, "*", "*****teste"),
                /*
                padStr parameter
                1 - null
                2 - empty
                3- non-empty
                 */
                of("teste", 10, null, "     teste"),
                of("teste", 10, "", "     teste"),
                of("teste", 10, "*", "*****teste"),
                /*
                str, size parameters
                1 - size < len(str)
                2 - size > len(str)
                */
                of("teste", 2, "*", "teste"),
                of("teste", 10, "*", "*****teste"),
                /*
                boundaries
                1 - size = 0
                2 - size = 1
                3 - str = 1
                4 - padStr = 1
                5 - size = str length
                6 - padStr > 1
                */
                of("teste", 0, "*", "teste"),
                of("teste", 1, "*", "teste"),
                of("t", 5, "*", "****t"),
                of("teste", 5, "ab", "teste"),
                of("t", 10, "ab", "ababababat"),

                /*
                Structural tests
                 1 - the length of padStr is equal to the remaining spaces in str
                 2 - the length of padStr is greater than the remaining spaces in str
                 3 - the length of padStr is smaller than the remaining spaces in str
                 */

                of("abc", 5, "--", "--abc"), // T10
                of("abc", 5, "---", "--abc"), // T11
                of("abc", 5, "-", "--abc") // T12

        );
    }

    @Test
    void sameInstance() {
        String str = "sometext";
        assertThat(leftPad(str, 5, "-")).isSameAs(str);
    }

}