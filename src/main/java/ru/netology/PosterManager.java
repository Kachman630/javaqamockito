package ru.netology;

public class PosterManager {
    private int limit;
    private String[] movies = new String[0]; // Изначально массив пуст

    // Конструктор по умолчанию (лимит 5)
    public PosterManager() {
        this.limit = 5;
    }

    // Конструктор с параметром (пользовательский лимит)
    public PosterManager(int limit) {
        this.limit = limit;
    }

    // Добавление нового фильма
    public void add(String movie) {
        // Создаем новый массив на 1 элемент больше
        String[] tmp = new String[movies.length + 1];
        // Копируем старые элементы
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        // Добавляем новый фильм в конец
        tmp[movies.length] = movie;
        // Заменяем старый массив новым
        movies = tmp;
    }

    // Вывод всех фильмов в порядке добавления
    public String[] findAll() {
        return movies;
    }

    // Вывод последних добавленных фильмов в обратном порядке
    public String[] findLast() {
        // Вычисляем правильный размер результирующего массива (как в подсказке)
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        // Создаем массив нужного размера
        String[] result = new String[resultLength];

        // Заполняем его в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            // Берем элементы с конца исходного массива
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }
}
