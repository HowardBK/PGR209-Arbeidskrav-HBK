create table if not exists manufacturer(
    manufacturer_id bigint primary key,
    manufacturer_website varchar (200),
    manufacturer_phone_number varchar (50),
    manufacturer_name varchar (200)
);

create sequence manufacturer_seq start with 1 increment by 1;