package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountWordsEndingWithTest {

    @Test
    void twoWordsEndingWithS() {
        int words = new CountWordsEndingWith().count("dogs cats");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void twoWordsEndingWithR() {
        int words = new CountWordsEndingWith().count("bar lower hi");
        assertThat(words).isEqualTo(2);
    }

    @Test
    void noWordsAtAll() {
        int words = new CountWordsEndingWith().count("dog cat");
        assertThat(words).isEqualTo(0);
    }

    @Test
    void LastR() {
        int words = new CountWordsEndingWith().count("bar");
        assertThat(words).isEqualTo(1);
    }

    @Test
    void LastS() {
        int words = new CountWordsEndingWith().count("sos");
        assertThat(words).isEqualTo(1);
    }

}