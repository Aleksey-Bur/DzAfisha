package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();
    private Movie first = new Movie(1, 1, "movie1", "genre1");
    private Movie second = new Movie(2, 2, "movie2", "genre2");
    private Movie third = new Movie(3, 3, "movie3", "genre3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5");
    private Movie sixth = new Movie(6, 6, "movie6", "genre6");
    private Movie seventh = new Movie(7, 7, "movie7", "genre7");
    private Movie eight = new Movie(8, 8, "movie8", "genre8");
    private Movie ninth = new Movie(9, 9, "movie9", "genre9");
    private Movie tenth = new Movie(10, 10, "movie10", "genre10");
    private Movie eleventh = new Movie(11, 11, "movie11", "genre11");

    @BeforeEach
        void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
    }

    @Test
    void shouldGetLessThenLengthMovie() {
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{ninth, eight, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoreThenLengthMovie() {
        manager.add(tenth);
        manager.add(eleventh);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEqualLengthMovie() {
        manager.add(tenth);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}