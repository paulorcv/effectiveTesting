package org.example;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.substringsBetween;
import static org.assertj.core.api.Assertions.assertThat;

class SubstringsTest {
    @Test
    void simpleCase() {
        assertThat(substringsBetween("abcd", "a", "d")
        ).isEqualTo(new String[]{"bc"});
    }

    @Test
    void manyStrings() {
        assertThat(substringsBetween("axcaycazc", "a", "c")
        ).isEqualTo(new String[]{"x", "y", "z"});
    }

    @Test
    void openAndCloseTagsThatAreMoreThanOneChar() {
        assertThat(substringsBetween("alalacalalac", "a", "c")
        ).isEqualTo(new String[]{"lala", "lala"});
    }

    @Test
    void openNull() {
        assertThat(substringsBetween("alalacalalac", null, "c")
        ).isEqualTo(null);
    }

    @Test
    void closeNull() {
        assertThat(substringsBetween("alalacalalac", "a", null)
        ).isEqualTo(null);
    }

    @Test
    void openOrCloseEmpty() {
        assertThat(substringsBetween("alalacalalac", "", "c")
        ).isEqualTo(null);

        assertThat(substringsBetween("alalacalalac", "a", "")
        ).isEqualTo(null);

        assertThat(substringsBetween("alalacalalac", "", "")
        ).isEqualTo(null);

    }

    @Test
    void noSubStrings() {
        assertThat(substringsBetween("acacacacac", "a", "c")
        ).isEqualTo(new String[]{"", "", "", "", ""});
    }

    @Test
    void oneSubstringAndNoSubStrings() {
        assertThat(substringsBetween("alalacacacacac", "a", "c")
        ).isEqualTo(new String[]{"lala", "", "", "", ""});
    }


    @Test
    void openAndCloseWithMoreThanOneChar() {
        assertThat(substringsBetween("lalaaalalabbaalalabb", "aa", "bb")
        ).isEqualTo(new String[]{"alala", "lala"});

        assertThat(substringsBetween("lalaaalalabbaalalabb", "a", "bb")
        ).isEqualTo(new String[]{"laaalala", "alala"});

        assertThat(substringsBetween("lalaaalalabbaalalabb", "aa", "b")
        ).isEqualTo(new String[]{"alala", "lala"});

    }

    @Test
    void openAndCloseNotPresent() {
        assertThat(substringsBetween("lalaaalalabbaalalabb", "x", "bb")
        ).isEqualTo(null);

        assertThat(substringsBetween("lalaaalalabbaalalabb", "a", "x")
        ).isEqualTo(null);

        assertThat(substringsBetween("lalaaalalabbaalalabb", "x", "x")
        ).isEqualTo(null);

    }

    @Test
    void openAndCloseEqualToString() {
        assertThat(substringsBetween("aaaaaaaaaa", "a", "a")
        ).isEqualTo(new String[] {"", "", "", "", ""});

        assertThat(substringsBetween("aaaaaaaaa", "a", "x")
        ).isEqualTo(null);

        assertThat(substringsBetween("aaaaaaaa", "x", "a")
        ).isEqualTo(null);

    }

    @Test
    void withEmpySpaces() {
        assertThat(substringsBetween("aa bb cc dd ee", "aa", "ee")
        ).isEqualTo(new String[] {" bb cc dd "});

        assertThat(substringsBetween("aa bb aa bb ee", "aa", "bb")
        ).isEqualTo(new String[] {" ", " "});

    }

}