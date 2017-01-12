/**
 * Author:  Евгений
 * Created: 12.01.2017
 */

CREATE TABLE interview.respondents(
    id serial,
    personal_number int,
    age int,
    gender varchar,
    living_time_in_moscow varchar,
    education varchar,
    using_internet varchar,
    evaluation varchar,
    income_id int,

    CONSTRAINT respondent_id PRIMARY KEY(id),
    CONSTRAINT income_fk FOREIGN KEY(income_id)
    REFERENCES interview.incomes.id
    ON UPDATE NO ACTION ON DELETE NO ACTION
);

COMMENT ON TABLE interview.respondents IS 'Таблица данных о респондентах';

