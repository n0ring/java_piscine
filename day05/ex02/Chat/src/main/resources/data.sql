INSERT INTO chat.User (user_id, login, password) VALUES (DEFAULT, 'namina', 'pass1234');
INSERT INTO chat.User (user_id, login, password) VALUES (DEFAULT, 'alex', 'pass1234');
INSERT INTO chat.User (user_id, login, password) VALUES (DEFAULT, 'nsdfsfs', 'sfsdf');
INSERT INTO chat.User (user_id, login, password) VALUES (DEFAULT, 'sdfs', 'sf');
INSERT INTO chat.User (user_id, login, password) VALUES (DEFAULT, 'sfd', 'passsdfsd1234');


INSERT INTO chat.Chatroom(chatroom_id, name, owner) VALUES (DEFAULT, 'general', 1);
INSERT INTO chat.Chatroom(chatroom_id, name, owner) VALUES (DEFAULT, 'random', 2);
INSERT INTO chat.Chatroom(chatroom_id, name, owner) VALUES (DEFAULT, 'lab', 2);
INSERT INTO chat.Chatroom(chatroom_id, name, owner) VALUES (DEFAULT, 'adm', 1);
INSERT INTO chat.Chatroom(chatroom_id, name, owner) VALUES (DEFAULT, 'kanal', 1);

INSERT INTO chat.Message (message_id, author, room, text, time) VALUES (DEFAULT, 1, 1, 'hello world', '2022-04-25 17:25:39.000000');
INSERT INTO chat.Message (message_id, author, room, text, time) VALUES (DEFAULT, 2, 2, 'hello', '2022-04-25 17:25:39.000000');
INSERT INTO chat.Message (message_id, author, room, text, time) VALUES (DEFAULT, 4, 3, 'hello everyone', '2022-04-25 17:25:39.000000');
INSERT INTO chat.Message (message_id, author, room, text, time) VALUES (DEFAULT, 5, 3, 'world', '2022-04-25 17:25:39.000000');
INSERT INTO chat.Message (message_id, author, room, text, time) VALUES (DEFAULT, 3, 4, 'world hellow', '2022-04-25 17:25:39.000000');
INSERT INTO chat.Message (message_id, author, room, text, time) VALUES (DEFAULT, 3, 4, 'world hellow', '2022-04-25 17:25:39.000000');
