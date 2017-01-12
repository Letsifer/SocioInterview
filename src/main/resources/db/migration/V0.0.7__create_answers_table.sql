/**
 * Author:  Евгений
 * Created: 12.01.2017
 */

CREATE TABLE interview.answers(
    id serial,
    text varchar,
    question_id int not null,

    CONSTRAINT answer_id PRIMARY KEY(id),
    CONSTRAINT question_fk FOREIGN KEY(question_id)
    REFERENCES interview.questions(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

COMMENT ON TABLE interview.answers IS 'Список ответов';

