-- COUNTRY
insert into COUNTRY (COUNTRY_NAME)
values ('Polska');

insert into COUNTRY (COUNTRY_NAME)
values ('Niemcy');

insert into COUNTRY (COUNTRY_NAME)
values ('Francja');

insert into COUNTRY (COUNTRY_NAME)
values ('Włochy');

insert into COUNTRY (COUNTRY_NAME)
values ('Hiszpania');


-- PERSON
insert into PERSON (FIRSTNAME, LASTNAME)
values ('Jan', 'Kowalski');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Anna', 'Nowak');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Piotr', 'Wiśniewski');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Maria', 'Dąbrowska');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Andrzej', 'Lewandowski');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Marta', 'Kaczmarek');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Tomasz', 'Zając');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Agnieszka', 'Pawlak');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Krzysztof', 'Mazurek');

insert into PERSON (FIRSTNAME, LASTNAME)
values ('Ewa', 'Kwiatkowska');

-- TRIP
insert into trip(trip_name, trip_date, max_no_places, country_id)
values ('Wycieczka do Paryza', to_date('2022-09-12', 'YYYY-MM-DD'), 3, 12);

insert into trip(trip_name, trip_date, max_no_places, country_id)
values ('Piękny Kraków', to_date('2024-07-03', 'YYYY-MM-DD'), 2, 10);

insert into trip(trip_name, trip_date, max_no_places, country_id)
values ('Znów do Francji', to_date('2023-05-01', 'YYYY-MM-DD'), 2, 12);

insert into trip(trip_name, trip_date, max_no_places, country_id)
values ('Wreszcie w Wenecji', to_date('2024-05-01', 'YYYY-MM-DD'), 2, 13);

-- RESERVATION
-- trip 1
insert into reservation(trip_id, person_id, status)
values (9, 11, 'P');

-- trip 2
insert into reservation(trip_id, person_id, status)
values (9, 12, 'N');

-- trip 3
insert into reservation(trip_id, person_id, status)
values (10, 11, 'P');

-- trip 4
insert into reservation(trip_id, person_id, status)
values (10, 14, 'C');

-- trip 5
insert into reservation(trip_id, person_id, status)
values (11, 14, 'P');

-- trip 6
insert into reservation(trip_id, person_id, status)
values (9, 17, 'N');

-- trip 7
insert into reservation(trip_id, person_id, status)
values (9, 16, 'P');

-- trip 8
insert into reservation(trip_id, person_id, status)
values (10, 12, 'C');

-- trip 9
insert into reservation(trip_id, person_id, status)
values (10, 13, 'P');

-- trip 10
insert into reservation(trip_id, person_id, status)
values (11, 17, 'N');