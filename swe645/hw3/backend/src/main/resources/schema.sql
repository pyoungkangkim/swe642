drop table if exists survey;
CREATE TABLE survey
(
    id               MEDIUMINT NOT NULL AUTO_INCREMENT,
    firstname        varchar(256),
    lastname         varchar(256),
    street           varchar(256),
    city             varchar(256),
    state            varchar(256),
    zip              varchar(256),
    phone            varchar(256),
    email            varchar(256),
    date             varchar(256),
    student          varchar(256),
    atmosphere       varchar(256),
    location         varchar(256),
    dorm             varchar(256),
    campus           varchar(256),
    sport            varchar(256),
    interestedreason varchar(256),
    recommend        varchar(256),
    PRIMARY KEY (id)
);

--firstname: '',
--lastname: '',
--street: '',
--city: '',
--state: '',
--zip: '',
--phone: '',
--email: '',
--date: '',
--// mostliked
--student: '',
--atmosphere: '',
--location: '',
--dorm: '',
--campus: '',
--sport: '',
--interest: '',
--// radio
--interestedreason: '',
--// select
--recommend: ''
