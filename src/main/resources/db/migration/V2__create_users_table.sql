CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

INSERT INTO users (username, password, role) VALUES
                                                     ('admin', '$2a$10$oEJf4UfOemVw6WCOyfZY4eyyZsZssYXam7naNmey/0ExqgVUMx1ia', 'ADMIN'),
                                                     ('user1', '$2a$10$oEJf4UfOemVw6WCOyfZY4eyyZsZssYXam7naNmey/0ExqgVUMx1ia', 'USER'),
                                                     ('user2', '$2a$10$oEJf4UfOemVw6WCOyfZY4eyyZsZssYXam7naNmey/0ExqgVUMx1ia', 'USER'),
                                                     ('user3', '$2a$10$oEJf4UfOemVw6WCOyfZY4eyyZsZssYXam7naNmey/0ExqgVUMx1ia', 'USER'),
                                                     ('user4', '$2a$10$oEJf4UfOemVw6WCOyfZY4eyyZsZssYXam7naNmey/0ExqgVUMx1ia', 'USER');