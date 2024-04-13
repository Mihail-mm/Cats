# Сервис по учету котиков и их владельцев

### Существующая информация о котиках:

1) Имя
2) Дата рождения
3) Порода
4) Цвет (один из заранее заданных вариантов)
5) Хозяин
6) Список котиков, с которыми дружит этот котик (из представленных в базе)


### Существующая информация о хозяевах:

1) Имя
2) Дата рождения
3) Список котиков


## Сервис реализует архитектуру Сontroller-Service-Dao.

## Вся информация хранится в БД PostgreSQL. Для связи с БД используется Hibernate и Spring Data JPA.

## Сервис предоставляет HTTP интерфейс (REST API) для получения информации о конкретных котиках и владельцах и для получения фильтрованной информации (например, получить всех рыжих котиков)
