package tddjunit.t02;

import org.junit.jupiter.api.*;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.core.Is.isA;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RangeImplTest {
    private Range range;

    @BeforeEach
    void setUp() {
        range = new RangeImpl(1,10);
    }

    @Test
    void testAsListNotNull() {
        assertThat(range.asList(), notNullValue());
    }

    @Test
    void testAsListListClass() {
        assertThat(range.asList(), isA(List.class));
    }

    @Test
    void testIsBefore(){
        Range after = new RangeImpl(-10, -1);
        assertTrue(range.isBefore(after));
    }

    @Test
    void testIsAfter() {
        Range after = new RangeImpl(11, 20);
        assertTrue(range.isAfter(after));
    }

    @Test
    void testIsContains() {
        assertFalse(range.contains(15));
    }

    @Test
    void testIsConcurrent() {
        Range concurrent = new RangeImpl(1,10);
        assertThat(range.isConcurrent(concurrent), is(true));
    }

    @Test
    void testAsIterator() {
        assertThat(range.asIterator().hasNext(), is(true));
    }
}
