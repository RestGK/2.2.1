CREATE TABLE cars
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT                NULL,
    model   VARCHAR(255)          NULL,
    series  INT                   NULL,
    CONSTRAINT pk_cars PRIMARY KEY (id)
);

ALTER TABLE cars
    ADD CONSTRAINT uc_cars_user UNIQUE (user_id);

ALTER TABLE cars
    ADD CONSTRAINT FK_CARS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);