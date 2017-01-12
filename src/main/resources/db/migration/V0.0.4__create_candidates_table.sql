/**
 * Author:  Евгений
 * Created: 12.01.2017
 */

CREATE TABLE interview.candidates(
    id serial,
    fio varchar,
    description varchar,
    CONSTRAINT candidate_id PRIMARY KEY(id)
);

COMMENT ON TABLE interview.candidates IS 'Таблица данных о кандидатах';

