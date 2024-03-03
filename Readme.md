# Nginx benchmarks

Простые тесты с балансировкой и кэшированием для nginx

## Как дебажить

1. Устанавливаем докер
2. Устанавливаем java
3. Переходим в папку ```scripts/debug```
4. Запускаем команду ```docker compose up```

## Содержимое

* Java Spring web-приложение с двумя эндпоинтами
* Контроллеры покрыты тестами
* Приложение упакованно в Dockerfile
* Nginx поднимается автоматически через Docker-compose
* Конфигурация Nginx редполагает кеширование и репликацию

## Результаты

| Кол. клиентов одновременно | Кэширование | Кол. реплик | Кол. потоков на каждой реплике | Среднее время запроса | 95% |
|----------------------------|-------------|-------------|--------------------------------|-----------------------|-----|
| 1                          | Нет         | 1           | 1                              | 7                     | 10  |
| 10                         | Нет         | 1           | 1                              | 33                    | 39  |
| 1                          | Нет         | 2           | 1                              | 7                     | 10  |
| 10                         | Нет         | 2           | 1                              | 26                    | 42  |
| 1                          | Нет         | 1           | 10                             | 7                     | 9   |
| 10                         | Нет         | 1           | 10                             | 16                    | 25  |
| 1                          | Нет         | 2           | 10                             | 7                     | 9   |
| 10                         | Нет         | 2           | 10                             | 18                    | 28  |
| 1                          | Да          | 1           | 1                              | 4                     | 4   |
| 10                         | Да          | 1           | 1                              | 11                    | 16  |
| 1                          | Да          | 2           | 1                              | 4                     | 5   |
| 10                         | Да          | 2           | 1                              | 11                    | 15  |
| 1                          | Да          | 1           | 10                             | 4                     | 6   |
| 10                         | Да          | 1           | 10                             | 11                    | 14  |
| 1                          | Да          | 2           | 10                             | 4                     | 5   |
| 10                         | Да          | 2           | 10                             | 11                    | 15  |