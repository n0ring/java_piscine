create table chat.User
(
    user_id serial primary key,
    login varchar(30) not null ,
    password varchar(30)
);

create table chat.Chatroom
(
    chatroom_id serial primary key,
    name varchar(30),
    owner int not null references chat.User(user_id)
);

create table chat.Message
(
    message_id serial primary key,
    author  int not null references chat.User(user_id),
    room  int not null references chat.Chatroom(chatroom_id),
    text       varchar(255),
    time timestamp
)