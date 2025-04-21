CREATE TABLE kegiatan (
    id                  BIGSERIAL PRIMARY KEY NOT NULL,
    kode_kegiatan       varchar(255) NOT NULL,
    nama_kegiatan       varchar(255) NOT NULL,
    status              varchar(255) NOT NULL,
    created_date        timestamp NOT NULL default now(),
    last_modified_date  timestamp NOT NULL default now(),
    version             int NOT NULL default 0
);