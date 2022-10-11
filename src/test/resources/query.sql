
-- select * from healthily.customer;
/*
select *
from healthily.workout as w
join healthily.training as t
  on t.fk_workout_id = w.id
join healthily.customer as c
 on w.fk_customer_id = c.id
where c.id = 2
  and t.level = 2
;
*/
select *
from healthily.coach as c;