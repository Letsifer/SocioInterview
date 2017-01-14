/**
 * Author:  Евгений
 * Created: 14.01.2017
 */

ALTER TABLE interview.incomes
ADD COLUMN order_number int;

UPDATE interview.incomes SET order_number = order_number + 1;

UPDATE interview.incomes SET order_number = 99 where text like 'Затрудняюсь ответить';