INSERT INTO USER_DETAILS(id, birth_date, name) VALUES(10001, current_date(), 'Dadang');
INSERT INTO USER_DETAILS(id, birth_date, name) VALUES(10002, current_date(), 'Dudung');
INSERT INTO USER_DETAILS(id, birth_date, name) VALUES(10003, current_date(), 'Dendeng');

INSERT INTO post(id, description, user_id) VALUES(2001, 'test post 1', 10001);
INSERT INTO post(id, description, user_id) VALUES(2002, 'test post 2', 10001);
INSERT INTO post(id, description, user_id) VALUES(2003, 'test post 3', 10002);
INSERT INTO post(id, description, user_id) VALUES(2004, 'test post 4', 10002);