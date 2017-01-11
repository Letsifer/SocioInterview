/**
 * Author:  Евгений
 * Created: 12.01.2017
 */

CREATE TABLE interview.incomes(
    id serial,
    lower_border int,
    higher_border int,
    text varchar,

    CONSTRAINT incomes_id PRIMARY KEY(id)
);

COMMENT ON TABLE interview.incomes IS 'Таблица распределения доходов';

