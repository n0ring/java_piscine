

create table public.service
(
    id serial primary key,
    email varchar(30) not null
);


INSERT INTO public.service (id, email) VALUES (DEFAULT, 'namina@mail.ru');
INSERT INTO public.service (id, email) VALUES (DEFAULT, 'namina2@mail.ru');
INSERT INTO public.service (id, email) VALUES (DEFAULT, 'namina3@mail.ru');
INSERT INTO public.service (id, email) VALUES (DEFAULT, 'namina4@mail.ru');
INSERT INTO public.service (id, email) VALUES (DEFAULT, 'namina5@mail.ru');
INSERT INTO public.service (id, email) VALUES (DEFAULT, 'namina6@mail.ru');