CREATE TABLE client(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000)
);

CREATE TABLE planet(
    ID VARCHAR(100) PRIMARY KEY CHECK (id REGEXP '^[A-Z0-9]+$'),
    NAME VARCHAR(500) NOT NULL CHECK (LENGTH(NAME) BETWEEN 1 AND 500)
);

CREATE TABLE Ticket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Первинний сурогатний ключ
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Час створення квитка (UTC)
    client_id BIGINT NOT NULL,  -- Ідентифікатор клієнта
    from_planet_id VARCHAR(50) NOT NULL,  -- Ідентифікатор планети відправлення
    to_planet_id VARCHAR(50) NOT NULL,  -- Ідентифікатор планети прибуття

    FOREIGN KEY (client_id) REFERENCES client(id),  -- Зовнішній ключ на Client
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),  -- Зовнішній ключ на Planet (відправлення)
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)  -- Зовнішній ключ на Planet (прибуття)
);



