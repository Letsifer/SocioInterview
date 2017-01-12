/**
 * Author:  Евгений
 * Created: 12.01.2017
 */

CREATE TABLE interview.respondents_answers(
    id serial,
    question_id int,
    answer_id int not null,
    respondent_id int not null,
    candidate_id int,

    CONSTRAINT resp_answer_id PRIMARY KEY(id),
    
    CONSTRAINT question_fk FOREIGN KEY(question_id)
    REFERENCES interview.questions(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT answer_fk FOREIGN KEY(answer_id)
    REFERENCES interview.answers(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT respondent_fk FOREIGN KEY(respondent_id)
    REFERENCES interview.respondents(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    CONSTRAINT candidate_fk FOREIGN KEY(candidate_id)
    REFERENCES interview.candidates(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
);

COMMENT ON TABLE interview.respondents_answers IS 'Список ответов на вопросы';

