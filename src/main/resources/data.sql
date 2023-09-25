insert into student3
select *
from student;

create table student20230921 like student;



create table java17.student2
(
    national_id   varchar(10)              not null
        primary key,
    name          varchar(20)              not null,
    family        varchar(40)              not null,
    student_id    bigint                   not null,
    father_name   varchar(20)              null,
    birth_date    date                     not null,
    entrance_date date                     not null,
    is_male       bit                      not null,
    insert_date   datetime default (now()) null,
    field_fk      int                      null,
    constraint student_pk3
        unique (student_id),
    constraint student_fields_id_fk2
        foreign key (field_fk) references java17.fields (id)
);

create index student_entrance_date_index2
    on java17.student2 (entrance_date);



update student
set field='Maths'
where national_id = 1234567893;


# select truncate(sum(s.score)/count(*),2) cnt
# select truncate(s.score,2) cnt
select f.field_name, count(*) cnt, truncate(avg(s.score), 2) avg_score, max(score)
from student s
         inner join
     fields f
     on s.field_fk = f.id
group by f.field_name;
# where f.field_name='Computer';
#   and to_shamsi(s.entrance_date)>'1390-01-01'


select *
from student s
         inner join field_student fs
                    on s.national_id = fs.student_id
         inner join fields f
                    on f.id = fs.field_id

# aggregate
;



insert into fields(field_name)
values ('Computer');
insert into fields(field_name)
values ('Maths');

# delete from student;
# truncate table student;


select *
from (select s.national_id, concat(s.name, ' ', s.family) full_name, sc.score, c.*
      from student s,
           student_course sc,
           course c
      where s.national_id = sc.student_id
        and sc.course_id = c.id) myview
where myview.full_name like 'مح%';

select *
from student
order by entrance_date desc
limit 2 offset 5;

select s.national_id,
       concat(s.name, ' ', s.family)                    full_name,
       sc.score,
       c.*,
       if(s.entrance_date > '2020-01-01', 'New', 'Old') entrance_type
from student s,
     student_course sc,
     course c
where s.national_id = sc.student_id
  and sc.course_id = c.id;

select *
from student
         inner join
     (select s.national_id, avg(sc.score)
      from student s
               inner join student_course sc
                          on s.national_id = sc.student_id
               inner join fields f
                          on f.id = s.field_fk
      where f.field_name = 'Computer'
      group by s.national_id
      having avg(sc.score) < 16.5) score_avg
     on student.national_id = score_avg.national_id;

select student_id, datediff(current_date(), birth_date) / 365
from student
order by birth_date;


select *
from student
where entrance_date <> (select max(entrance_date) from student) /*between '2018-01-01' AND '2022-01-01'*/;

select *
from student
where name like '%j%';

select *
from student s
where national_id not in (select student_id
                          from student_course)