package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaCustomManagerTest {
    private AfishaManager manager = new AfishaManager(5);
    private Movie first = new Movie(1, 1, "movie1", "genre1");
    private Movie second = new Movie(2, 2, "movie2", "genre2");
    private Movie third = new Movie(3, 3, "movie3", "genre3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5");
    private Movie sixth = new Movie(6, 6, "movie6", "genre6");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldGetLessThenLengthMovie() {
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetMoreThenLengthMovie() {
        manager.add(fifth);
        manager.add(sixth);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEqualLengthMovie() {
        manager.add(fifth);
        Movie[] actual = manager.showLast();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}