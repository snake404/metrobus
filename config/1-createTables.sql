CREATE SEQUENCE bus_history_seq INCREMENT BY 1;
CREATE TABLE LOCALITY(
    id INTEGER PRIMARY KEY,
    name VARCHAR(40),
    status INTEGER
);

CREATE TABLE BUS (
    bus_id BIGINT PRIMARY KEY,
    bus_label VARCHAR(10),
    status INTEGER,
    locality INTEGER REFERENCES locality(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE BUS_HISTORY(
    history_id BIGINT PRIMARY KEY DEFAULT NEXTVAL('bus_history_seq'),
    bus_id BIGINT REFERENCES bus(bus_id) ON DELETE CASCADE ON UPDATE CASCADE,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    locality INTEGER,
    last_update TIMESTAMP
);

