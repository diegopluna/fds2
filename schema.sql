
    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;

    create table available_dates (
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null
    );

    create table charging_stations (
        latitude float(53) not null,
        longitude float(53) not null,
        minimum_price integer not null,
        number integer,
        number_of_chargers integer not null,
        price_per_kwh integer not null,
        time_per_schedule integer not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        id uuid not null,
        supplier_id uuid not null,
        cep varchar(255),
        city varchar(255),
        name varchar(255),
        neighborhood varchar(255),
        state varchar(255),
        street varchar(255),
        status enum ('ACTIVE','INACTIVE'),
        primary key (id)
    );

    create table drivers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255) not null,
        primary key (id)
    );

    create table schedules (
        charger_liberation_time integer not null,
        total_recharge_value float(24) not null,
        schedule_end timestamp(6),
        schedule_start timestamp(6),
        charging_station_id uuid not null,
        driver_id uuid not null,
        id uuid not null,
        supplier_id uuid not null,
        vehicle_id uuid not null,
        comment varchar(255),
        score enum ('FIVE_STARS','FOUR_STARS','ONE_STAR','THREE_STARS','TWO_STARS'),
        status enum ('ACTIVE','CANCELLED','COMPLETED'),
        primary key (id)
    );

    create table suppliers (
        id uuid not null,
        user_id uuid not null unique,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id uuid not null,
        login varchar(255) unique,
        password varchar(255),
        role enum ('DRIVER','SUPPLIER'),
        primary key (id)
    );

    create table vehicles (
        driver_id uuid not null,
        id uuid not null,
        license_plate varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists available_dates 
       add constraint FKmtedo4nrd1moiu7ksym4wn9lc 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists charging_stations 
       add constraint FKf9lxotf3u603vo1w0nbjoovgw 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists drivers 
       add constraint FKfscpnjt46gco44xh86l99rxh7 
       foreign key (user_id) 
       references users;

    alter table if exists schedules 
       add constraint FK5wcrs7etwxmc7r4dtoe89ecb8 
       foreign key (charging_station_id) 
       references charging_stations;

    alter table if exists schedules 
       add constraint FKa5jukepsmojoquw2176pe5ut2 
       foreign key (driver_id) 
       references drivers;

    alter table if exists schedules 
       add constraint FK4j4w3mt64kme6lbkx3tdx4kh6 
       foreign key (supplier_id) 
       references suppliers;

    alter table if exists schedules 
       add constraint FKap73bwchds4ntqiksp1rg0ecd 
       foreign key (vehicle_id) 
       references vehicles;

    alter table if exists suppliers 
       add constraint FKja3xaqihwgllahrmo5op9ks4d 
       foreign key (user_id) 
       references users;

    alter table if exists vehicles 
       add constraint FKaashphrwfd4ts511y8vj785ia 
       foreign key (driver_id) 
       references drivers;
