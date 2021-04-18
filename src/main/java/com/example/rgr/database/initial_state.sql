
insert into city (id, city) VALUES (1, 'Goiânia');
insert into city (id, city) VALUES (2, 'São Paulo');
insert into city (id, city) VALUES (3, 'Rio de Janeiro');
insert into city (id, city) VALUES (4, 'Belo Horizonte');


insert into cinema (id, cinema, city_id) VALUES (1, 'Cinema Lumier', 1);
insert into cinema (id, cinema, city_id) VALUES (2, 'Cinema Lumier2', 1);
insert into cinema (id, cinema, city_id) VALUES (3, 'Cinema Lumier3', 1);
insert into cinema (id, cinema, city_id) VALUES (4, 'Cinema Lumier4', 2);
insert into cinema (id, cinema, city_id) VALUES (5, 'Cinema 2', 2);
insert into cinema (id, cinema, city_id) VALUES (6, 'Cinema 3', 3);
insert into cinema (id, cinema, city_id) VALUES (7, 'Cinema 4', 4);


insert into movie (id, name) VALUES (1, 'O renegado');
insert into movie (id, name) VALUES (2, 'Bela e a fera');
insert into movie (id, name) VALUES (3, 'Rei Leão');
insert into movie (id, name) VALUES (4, 'Vingadores');


insert into movie_city (id, movie_id, cinema_id) VALUES (null, 1, 1);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 1, 2);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 1, 3);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 1, 5);

insert into movie_city (id, movie_id, cinema_id) VALUES (null, 2, 1);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 2, 2);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 2, 7);

insert into movie_city (id, movie_id, cinema_id) VALUES (null, 4, 5);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 4, 6);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 4, 7);

insert into movie_city (id, movie_id, cinema_id) VALUES (null, 3, 3);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 3, 5);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 3, 6);
insert into movie_city (id, movie_id, cinema_id) VALUES (null, 3, 7);

insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 12:36:31', 12.50 ,1, 2);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 14:36:31', 12.50 ,2, 2);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 16:36:31', 12.50 ,3, 2);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 18:36:31', 12.50 ,1, 2);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 12:36:31', 12.50 ,1, 1);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 14:36:31', 12.50 ,2, 1);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 16:36:31', 12.50 ,3, 1);
insert into schedule_movie (id, schedule, price, cinema_id, movie_id) VALUES (null, '2021-04-18 18:36:31', 12.50 ,1, 1);

insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 1, false, 1);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 2, false, 1);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 3, true, 1);

insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 1, true, 2);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 2, false, 2);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 3, false, 2);

insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 1, true, 3);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 2, false, 3);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 3, true, 3);

insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 1, false, 4);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 2, false, 4);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 3, true, 4);

insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 1, true, 5);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 2, false, 5);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 3, false, 5);

insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 1, true, 6);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 2, false, 6);
insert into accent (id, accent, occupied, schedule_movie_id) VALUES (null, 3, true, 6);


# Selecionar cidades
select city
from city;


# selecionar filmes por cidade
select distinct m.id, m.name from movie m
                                      inner join movie_city mc on m.id = mc.movie_id
                                      inner join cinema c on c.id = mc.cinema_id
                                      inner join city c2 on c.city_id = c2.id
where c.city_id= 1;


# selecionar os cinemas conforme a cidade
select distinct c.id, c.cinema from movie m
                                        inner join movie_city mc on m.id = mc.movie_id
                                        inner join cinema c on c.id = mc.cinema_id
                                        inner join city c2 on c.city_id = c2.id
where c.city_id = 1;


# Selecionar os horários para o cinema
select m.id, m.name, sm.schedule, c.cinema
from movie m
         inner join schedule_movie sm on m.id = sm.movie_id
         inner join cinema c on sm.cinema_id = c.id
where sm.cinema_id = 1 and sm.movie_id = 1;


# Selecionar os acentos para o horário;
select a.accent, a.occupied, sm.schedule, sm.price
from accent a
         inner join schedule_movie sm on a.schedule_movie_id = sm.id
where schedule_movie_id = 1;

select *
from cinema;

select *
from movie;

select *
from accent;

select *
from schedule_movie;