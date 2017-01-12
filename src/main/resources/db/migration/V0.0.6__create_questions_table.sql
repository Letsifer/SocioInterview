/**
 * Author:  Евгений
 * Created: 12.01.2017
 */

CREATE TABLE interview.questions(
    id serial,
    text varchar,
    CONSTRAINT question_id PRIMARY KEY(id)
);

COMMENT ON TABLE interview.questions IS 'Список вопросов';

