
-- insert admin user
insert into user   
values(null,'admin',password('admin'),'관리자','1990-10-31','031-257-1944',
		'010-2668-1944','774-215','경기도 안양시 만안구 181-2','utkg3000@naver.com',now(),'y','관리자');
-- insert admin table
insert into admin 
values(null,1);

-- insert category
insert into category values(null,'셔츠','이쁜 셔츠들',now());
insert into category values(null,'아우터','아우터들 ',now());
insert into category values(null,'하의','이쁜 하의',now());
insert into category values(null,'코트','멋진 코트',now());

-- insert sales_status
insert into sales_status values(null,'판매중');
insert into sales_status values(null,'판매중단');
insert into sales_status values(null,'품절');

-- insert event
insert into event values(null,'NEW',1,'i_new.gif',null);
insert into event values(null,'HIT',3,'i_hit.gif',null);
insert into event values(null,'SALE',4,'i_sale.gif',null);


