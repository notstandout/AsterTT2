# AsterTT2

# AsterTT - Car Management RESTful API

## Описание
Проект реализует RESTful CRUD API для управления справочником автомобилей. Приложение предоставляет возможность аутентификации и авторизации пользователей с использованием JWT, а также позволяет выполнять операции создания, чтения, обновления и удаления информации об автомобилях.

---

## Функциональность API

### Эндпоинты:
1. **Аутентификация**
    - **POST** `/api/auth/login` - Выполняет вход пользователя и возвращает JWT токен.

2. **CRUD операции для автомобилей**
    - **GET** `/main/cars` - Возвращает список всех автомобилей.
    - **GET** `/main/cars/get/{vin}` - Возвращает информацию об автомобиле по VIN.
    - **POST** `/main/cars/add` - Добавляет новый автомобиль.
    - **PUT** `/main/cars/update/{vin}` - Обновляет информацию об автомобиле.
    - **DELETE** `/main/cars/delete/{vin}` - Удаляет автомобиль по VIN.

3. **Дополнительные функции**
    - **GET** `/main/cars/search` - Поиск автомобилей по марке, модели или году выпуска.

### Роли и доступ:
- **USER**
    - Доступ к методам чтения (`GET`).
- **ADMIN**
    - Полный доступ ко всем методам (`GET`, `POST`, `PUT`, `DELETE`).

---

## Используемые технологии
- **Java 17**
- **Spring Boot 3.1.3**
- **Spring Security**
- **Hibernate**
- **PostgreSQL**
- **Flyway**
- **Swagger (SpringDoc OpenAPI)**
- **Lombok**
- **JWT**

---

## Установка и запуск

Вот окончательная версия с пошаговыми инструкциями в **README.md**, начиная с шага 1:

```markdown
# AsterTT - Car Management RESTful API

## Установка и запуск проекта

### Шаг 1: Клонирование репозитория
```bash
git clone https://github.com/username/AsterTT.git
cd AsterTT
```

### Шаг 2: Настройка базы данных PostgreSQL
1. Убедитесь, что **PostgreSQL** установлен и запущен.
2. Создайте базу данных с именем `astertt`:
   ```sql
   CREATE DATABASE astertt;
   ```

3. Откройте файл **application.properties** и укажите настройки подключения:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/astertt
   spring.datasource.username=postgres
   spring.datasource.password=user
   ```

### Шаг 3: Компиляция и запуск миграций
1. Скомпилируйте проект и примените миграции с помощью Flyway:
   ```bash
   ./mvnw flyway:migrate
   ```

2. Запустите приложение:
   ```bash
   ./mvnw spring-boot:run
   ```

### Шаг 4: Запуск и тестирование API
1. Приложение будет доступно по адресу:
   ```
   http://localhost:8080
   ```

2. Для тестирования API используйте **Swagger UI**:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## Работа с Git и загрузка на GitHub

### Шаг 5: Инициализация Git и загрузка проекта
1. Инициализируйте локальный Git-репозиторий (если ещё не выполнено):
   ```bash
   git init
   ```

2. Добавьте удалённый репозиторий:
   ```bash
   git remote add origin https://github.com/notstandout/AsterTT2.git
   ```

3. Добавьте файлы и создайте коммит:
   ```bash
   git add .
   git commit -m "Initial commit: Car Management API"
   ```

4. Загрузите проект в ваш репозиторий:
   ```bash
   git push -u origin main
   ```

---

## Тестирование API с использованием Postman или Swagger

1. **POST** `/api/auth/login` - Получение JWT токена  
   Пример тела запроса:
   ```json
   {
     "username": "admin",
     "password": "asterkz"
   }
   ```

2. **GET** `/main/cars` - Получение списка всех автомобилей.

3. **POST** `/main/cars/add` - Добавление автомобиля.  
   Пример тела запроса:
   ```json
   {
     "make": "Toyota",
     "model": "Camry",
     "year": 2022,
     "price": 30000.0,
     "vin": "12345678901234567"
   }
   ```

---

## Логи и ошибки
- Логи операций отображаются в консоли.
- Обработка ошибок реализована с использованием `@ControllerAdvice`.

---

## Контакты
- **Разработчик:** Meiirbek
- **GitHub:** [https://github.com/notstandout](https://github.com/notstandout)
- **Email:** meir_bek2000@mail.ru
``` 

Теперь вы можете просто скопировать и вставить этот файл в `README.md`. Он содержит пошаговые инструкции для установки, запуска, работы с GitHub и тестирования API. 😊