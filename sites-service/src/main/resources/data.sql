-- Insérer des données dans la table sites
INSERT INTO sites (site_id, name, location, longitude, latitude) VALUES
(1, 'Stade de France', 'Saint-Denis, France', 2.3601, 48.9245),
(2, 'Aquatics Center', 'Paris, France', 2.3785, 48.8373),
(3, 'Olympic Stadium', 'Paris, France', 2.3522, 48.8566),
(4, 'Bercy Arena', 'Paris, France', 2.3770, 48.8402),
(5, 'Parc des Princes', 'Paris, France', 2.2520, 48.8414);

-- Insérer des données dans la table sports
INSERT INTO sports (sport_id, name, type) VALUES
(1, 'Football', ARRAY['Olympic']),
(2, 'Swimming', ARRAY['Olympic']),
(3, 'Wheelchair Basketball', ARRAY['Paralympic']),
(4, 'Athletics', ARRAY['Olympic']),
(5, 'Goalball', ARRAY['Paralympic', 'Olympic']);

-- Insérer des données dans la table de jonction hosted_sports
INSERT INTO hosted_sports (site_id, sport_id) VALUES
(1, 1), -- Stade de France hosts Football
(2, 2), -- Aquatics Center hosts Swimming
(3, 4), -- Olympic Stadium hosts Athletics
(4, 3), -- Bercy Arena hosts Wheelchair Basketball
(5, 5), -- Parc des Princes hosts Goalball
(1, 4); -- Stade de France also hosts Athletics
