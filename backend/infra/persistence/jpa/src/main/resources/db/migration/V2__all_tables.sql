CREATE TABLE charging_stations
(
    id                 VARCHAR(255)     NOT NULL,
    supplier_id        VARCHAR(255)     NOT NULL,
    name               VARCHAR(255),
    number_of_chargers INT              NOT NULL,
    status             VARCHAR(255),
    minimum_price      INT              NOT NULL,
    price_per_kwh      INT              NOT NULL,
    longitude          DOUBLE PRECISION NOT NULL,
    latitude           DOUBLE PRECISION NOT NULL,
    time_per_schedule  INT              NOT NULL,
    schedule_start     TIMESTAMP,
    schedule_end       TIMESTAMP,
    cep                VARCHAR(255),
    street             VARCHAR(255),
    number             INT              NOT NULL,
    neighborhood       VARCHAR(255),
    city               VARCHAR(255),
    state              VARCHAR(255),
    CONSTRAINT pk_charging_stations PRIMARY KEY (id)
);

CREATE TABLE drivers
(
    id      VARCHAR(255) NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    name    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_drivers PRIMARY KEY (id)
);

CREATE TABLE schedules
(
    id                      VARCHAR(255) NOT NULL,
    charger_liberation_time INT          NOT NULL,
    status                  VARCHAR(255),
    total_recharge_value    FLOAT        NOT NULL,
    charging_station_id     VARCHAR(255) NOT NULL,
    driver_id               VARCHAR(255) NOT NULL,
    vehicle_id              VARCHAR(255) NOT NULL,
    supplier_id             VARCHAR(255) NOT NULL,
    schedule_start          TIMESTAMP,
    schedule_end            TIMESTAMP,
    score                   VARCHAR(255),
    comment                 VARCHAR(255),
    CONSTRAINT pk_schedules PRIMARY KEY (id)
);

CREATE TABLE suppliers
(
    id      VARCHAR(255) NOT NULL,
    name    VARCHAR(255),
    user_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_suppliers PRIMARY KEY (id)
);

CREATE TABLE vehicles
(
    id            VARCHAR(255) NOT NULL,
    name          VARCHAR(255),
    license_plate VARCHAR(255),
    driver_id     VARCHAR(255) NOT NULL,
    CONSTRAINT pk_vehicles PRIMARY KEY (id)
);

ALTER TABLE drivers
    ADD CONSTRAINT uc_drivers_user UNIQUE (user_id);

ALTER TABLE suppliers
    ADD CONSTRAINT uc_suppliers_user UNIQUE (user_id);

ALTER TABLE charging_stations
    ADD CONSTRAINT FK_CHARGING_STATIONS_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES suppliers (id);

ALTER TABLE drivers
    ADD CONSTRAINT FK_DRIVERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE schedules
    ADD CONSTRAINT FK_SCHEDULES_ON_CHARGING_STATION FOREIGN KEY (charging_station_id) REFERENCES charging_stations (id);

ALTER TABLE schedules
    ADD CONSTRAINT FK_SCHEDULES_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES drivers (id);

ALTER TABLE schedules
    ADD CONSTRAINT FK_SCHEDULES_ON_SUPPLIER FOREIGN KEY (supplier_id) REFERENCES suppliers (id);

ALTER TABLE schedules
    ADD CONSTRAINT FK_SCHEDULES_ON_VEHICLE FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);

ALTER TABLE suppliers
    ADD CONSTRAINT FK_SUPPLIERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE vehicles
    ADD CONSTRAINT FK_VEHICLES_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES drivers (id);