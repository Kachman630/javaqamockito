package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosterManagerTest {

    @Test
    public void shouldReturnEmptyArrayInitially() {
        PosterManager manager = new PosterManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndFindAllMovies() {
        PosterManager manager = new PosterManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithDefaultLimit() {
        PosterManager manager = new PosterManager(); // Лимит по умолчанию = 5
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");

        // Должны вернуться последние 5 в обратном порядке
        String[] expected = {"Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimit() {
        PosterManager manager = new PosterManager(3); // Лимит = 3
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        // Должны вернуться последние 3 в обратном порядке
        String[] expected = {"Film 5", "Film 4", "Film 3"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenTotalLessThanLimit() {
        PosterManager manager = new PosterManager(5); // Лимит = 5
        manager.add("Film 1");
        manager.add("Film 2");

        // Фильмов всего 2, должны вернуться они же в обратном порядке
        String[] expected = {"Film 2", "Film 1"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}