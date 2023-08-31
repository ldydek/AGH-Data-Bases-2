create table country
(
    country_id   int generated always as identity not null,
    country_name varchar2(50)                     not null,
    constraint country_pk primary key (country_id)
)

alter table TRIP
    drop column COUNTRY;

alter table TRIP
    add country_id int;

alter table TRIP
    add constraint trip_fk2 foreign key (COUNTRY_ID) references COUNTRY (COUNTRY_ID)
enable;