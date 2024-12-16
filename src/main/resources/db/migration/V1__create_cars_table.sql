CREATE TABLE cars (
                      id UUID PRIMARY KEY,
                      make VARCHAR(50) NOT NULL,
                      model VARCHAR(50) NOT NULL,
                      year INT NOT NULL CHECK (year BETWEEN 1886 AND EXTRACT(YEAR FROM CURRENT_DATE)),
    price NUMERIC(10, 2) NOT NULL CHECK (price > 0),
    vin CHAR(17) NOT NULL UNIQUE
);

INSERT INTO cars (id, make, model, year, price, vin) VALUES
                                                         ('11111111-1111-1111-1111-111111111111', 'Toyota', 'Corolla', 2020, 20000.00, '1HGCM82633A123456'),
                                                         ('22222222-2222-2222-2222-222222222222', 'Honda', 'Civic', 2021, 22000.00, '1HGCM82633A123457'),
                                                         ('33333333-3333-3333-3333-333333333333', 'Ford', 'Focus', 2019, 18000.00, '1HGCM82633A123458'),
                                                         ('44444444-4444-4444-4444-444444444444', 'Chevrolet', 'Malibu', 2022, 25000.00, '1HGCM82633A123459'),
                                                         ('55555555-5555-5555-5555-555555555555', 'Nissan', 'Altima', 2023, 27000.00, '1HGCM82633A123460');