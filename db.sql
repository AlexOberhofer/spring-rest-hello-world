CREATE DATABASE IF NOT EXISTS sample;

CREATE TABLE IF NOT EXISTS sample.SampleTable (
    requestId int NOT NULL AUTO_INCREMENT,
    name varchar(50),
    requestTime timestamp,
    PRIMARY KEY (requestId)
    );