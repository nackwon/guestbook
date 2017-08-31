-- create sequence

drop sequence seq_questbook;

create sequence seq_questbook
start with 1
increment by 1
maxvalue 9999999999;

-- insert

insert into questbook
values(seq_questbook.nextval, '둘리', '1234', '마이콜 꺼져', sysdate);

insert into questbook
values(seq_questbook.nextval, '마이콜', '1234', '둘리 꺼져', sysdate);



-- list
select no, name, content, to_char(reg_day, 'yyyy-mm-dd hh:mi:ss')
from questbook
order by reg_day desc;


-- delete
delete from questbook
where no = 1
and password = '1234';
commit;