INSERT INTO items (name, category, price) VALUES ('swim goggles', 'sporting goods', 15.99);
INSERT INTO items (name, category, price) VALUES ('yoga mat', 'sporting goods', 30.49);
INSERT INTO items (name, category, price) VALUES ('bodyboard', 'sporting goods', 199.99);

INSERT INTO user (id, username, password, enabled) VALUES (0, 'username01', 'password01', true);
INSERT INTO user (id, username, password, enabled) VALUES (1, 'username02', 'password02', true);

INSERT INTO role (id, name) VALUES (0, 'ADMIN');
INSERT INTO role (id, name) VALUES (1, 'USER');

INSERT INTO user_role (user_id, role_id) VALUES (0, 0);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);