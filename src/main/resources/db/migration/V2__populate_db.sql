-- Міграція V2__populate_db.sql

-- Додавання клієнтів
INSERT INTO client (name) VALUES
                              ('Alice Johnson'),
                              ('Bob Smith'),
                              ('Charlie Brown'),
                              ('David White'),
                              ('Eve Black'),
                              ('Frank Miller'),
                              ('Grace Hall'),
                              ('Hank Moore'),
                              ('Ivy Green'),
                              ('Jack Scott');

-- Додавання планет
INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('EARTH', 'Earth'),
                                  ('JUPITER', 'Jupiter'),
                                  ('SATURN', 'Saturn');

-- Додавання квитків
INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'EARTH', 'MARS'),
                                                                 (2, 'VEN', 'EARTH'),   -- Bob Smith летить з Venus на Earth
                                                                 (3, 'EARTH', 'JUPITER'), -- Charlie Brown летить з Earth на Jupiter
                                                                 (4, 'MARS', 'SATURN'),  -- David White летить з Mars на Saturn
                                                                 (5, 'VEN', 'MARS'),     -- Eve Black летить з Venus на Mars
                                                                 (6, 'JUPITER', 'EARTH'),-- Frank Miller летить з Jupiter на Earth
                                                                 (7, 'SATURN', 'VEN'),   -- Grace Hall летить з Saturn на Venus
                                                                 (8, 'EARTH', 'SATURN'), -- Hank Moore летить з Earth на Saturn
                                                                 (9, 'MARS', 'VEN'),     -- Ivy Green летить з Mars на Venus
                                                                 (10, 'JUPITER', 'MARS');-- Jack Scott летить з Jupiter на Mars
