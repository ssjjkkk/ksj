-- select : 조회할 때 사용
-- select <컬럼이름> from <테이블 이름>
select ename from emp
-- 사원이름, 번호 조회
-- 1개 이상 컬럼을 조회할 때는 ,(콤마) 사용
select ename, empno from emp
-- 사원번호, 사원이름, 직책 조회
select ename, empno, job from emp
-- as (별칭)
select ename as '사원이름', empno as '사원번호' from emp
-- 모든 컬럼조회 *(아스테리스크)
select * from emp
-- where (필터링)
-- 20번 부서 사원 모두 조회
-- 쿼리 순서 : 1. from 2. where 3. select
select * from emp where deptno = 20;
-- 문제1. job이 manager인 사원이름, 사원번호, 직책, 입사날짜 조회 하시오.
select ename, empno, job, hiredate from emp where job = 'manager'
-- 문제2. job이 MANAGER, SALESMAN인 사원번호, 사원이름 조회
-- or(||), and(&&)
select empno, ename from emp 
where job = 'MANAGER' or job = 'SALESMAN'
-- 문제3. 사원이름이 ALLEN인 사원의 이름,직책,입사날짜 조회
select ename, job, hiredate from emp 
where ename = 'ALLEN'
-- 사원이름이 A로 시작하는 사원의 이름, 사원번호 조회 
-- like : 특정 단어를 검색할 수 있다.
select ename, empno from emp 
where ename like 'A%'
-- 사원 이름에 L이 두번 들어간 사원 이름, 번호 조회
select ename, empno from emp 
where ename like '%L%L%'
-- 보너스를 받지 못한 사원의 급여와 사원번호를 조회
-- null 사원
select sal, empno from emp
where comm is null
-- null 아닌 사원
select sal, empno from emp
where comm is not null
-- 입사날짜가 1987-06-28 이상인 사원 이름,번호,직책 조회
-- >= , <=, >, <
select ename, empno, job, hiredate from emp 
where hiredate >= '1987-06-28'
-- 문제4. 입사일이 1980-12-17 ~ 1982-01-23 사이에 입사한
-- 사원의 이름,번호,입사날짜,직책을 조회하시오.
select ename, empno, hiredate, job from emp
where hiredate >= '1980-12-17' and hiredate <= '1982-01-23'
-- 문제5. 직업이 MANAGER고, 급여가 1300이상 받는 사원번호,이름,급여,직업 조회
select empno as '사원번호', ename, sal, job from emp
where job = 'MANAGER' and sal >= 1300
-- avg, count, max, min 함수 (단일행 함수)
-- 직업이 manager인 사원들의 급여 평균 조회
select avg(sal) as "급여 평균", job from emp where job = 'manager' 
-- 직업이 CLERK인 사원 수 조회
select count(empno) from emp where job = 'CLERK'
-- min 
select min(sal) from emp where job = 'CLERK'
-- max
select max(sal) from emp where job = 'CLERK'
-- 문제6. 입사날짜가 '1987-06-28' 이상인 사원들의 수와 급여 평균 조회
select count(empno) as '사원 수', avg(sal) as '급여 평균'
from emp 
where hiredate >= '1987-06-28'
-- 문제7. 직책이 'manager'가 아닌 사원이름, 직책 조회
select ename, job from emp
where job != 'manager'
-- 문제8. 사원 이름이 'SCOTT', 'JONES'인 사원의 이름,번호,급여,입사날짜 조회
-- 방법 1
select ename, empno, sal, hiredate from emp
where ename = 'SCOTT' or ename = 'JONES'
-- 방법 2
select ename, empno, sal, hiredate from emp
where ename in('SCOTT','JONES')

-- 08.30(화)
-- group by : 특정 컬럼을 그룹핑하는 SQL 문법
-- job 별로 goup by 하기
-- group by 할 컬럼을 select 에도 써주자
select job as '직책 그룹핑' from emp group by job;
-- 입사날짜로 group by
select hiredate from emp group by hiredate;
-- 입사날짜를 년도별로 group by
-- date_format()SQL 내장 함수, 날짜를 원하는 대로 포맷팅 해줌
-- %Y : year(년도),%M :month(월),%d : day(일)
select date_format(hiredate,'%Y')  from emp group by date_format(hiredate,'%Y');
-- 문제.부서별로 그룹핑하고 부서 인원수도 출력하시오.
select deptno,count(empno) from emp group by deptno;
-- 20번 부서를 제외한 나머지 부서 그룹핑!
select deptno from emp where deptno != 20 group by deptno;
-- having : group by 된 결과를 필터링할 때 사용
-- where :필터링
-- where 조건 안쓰고 having 으로 사용하기
-- having 과 where 차이점
-- 1.SQL 실행 순서가 다르다
-- 2.where 조건에 잡계함수(count, max, min, avg...)으로 비교 불가능
-- select sal from emp where sal > min(sal);
-- 3.having 은 집계함수 비교 가능
select deptno as "부서번호", count(empno) as "사원수" from emp group by deptno having count(empno)>=4;
-- group by 된 결과를 필터링하고 싶을 때 사용
-- 문제1. 부서별로 급여합계를 그룹핑 하시오.
select deptno,sum(sal) as'부서별 급여합계' from emp group by deptno;
-- 문제2. 문제1번의 급여 합계가 5000이상인 부서만 조회
select deptno,sum(sal) as'부서별 급여합계' from emp group by deptno having sum(sal)>=5000;
-- 문제3. 문제2번에서 10번 30번 부서 제외
select deptno,sum(sal) as'부서별 급여합계' from emp where deptno != 10 and deptno != 30 group by deptno having sum(sal)>=5000;
-- 문제4.입사날짜를 월별로 그룹핑하고 월별 입사자를 출력하시오.
select count(empno),date_format(hiredate,'%m') from emp group by date_format(hiredate,'%m');
-- 문제5. 직책별로 그룹핑하고 직책별 평균 급여를 조회하고, 평균 급여가 1000 이 넘는 직책만 출력하시오
select job,avg(sal)'직책별 평균 급여'from emp where job != 'manager'group by job having avg(sal)>=1000;
-- 문제6.1982년도에 입사한 모든 사원의 정보 조회
select * from emp where hiredate like '1982%';
select * from emp where date_format(hiredate,'%Y')='1982';
-- 문제7.급여가 1500~2850 사이의 범위에 속하는 사원의 이름, 급여, 직책 조회
select ename,sal,job from emp where sal>=1500 and sal<=2850;

-- order by : 특정 컬럼을 정렬할 때 사용 (항상 마지막에 실행됨)
-- 아래 쿼리는 오름 차순
select ename ,sal from emp order by sal;
-- 아래 쿼리는 내림 차순
select ename ,sal from emp order by sal desc;
-- 컬럼 위치로 정렬하기
-- order by 는 항상 마지막에 실행되기 때문에 select 컬럼 순서를 알고 있다.
select ename,sal from emp order by 2 desc;

-- 총 정리
-- SQL순서 from->where->group by-> having->select->order by 
select deptno, count(empno) from emp where deptno != 10 group by deptno having count(empno)>=3 order by count(empno)desc;
## delete, update, insert
-- delete (데이터 삭제)
-- 삭제할 떄는 where 조건으로 삭제하자
delete from emp; 
-- truncate 테이블 안에 있는 데이터 초기화
truncate table emp;
-- auto commit 을 해제하면 rollback (뒤 돌아가기)으로 돌아갈 수 있음
-- auto commit 설정되어 있으면 rollback 명령어 불가능


-- join*****
-- 관계형 데이터베이스(MySQL,Oracle)를 사용하면 join은 무조건 사용한다
-- depno : 부서번호, dname : 부서이름 , loc : 부서위치
-- 조인은 컬럼이름이 같다고 해서 되는게 아니라, 데이터 타입이 서로 같아야 한다.
-- 컬럼 이름이 같은 이유는 사용자(개발자) 편의성을 뤼해서 같게 헤준다.
-- join 문법
-- 방법1.
select e.ename,e.deptno,d.dname 
from emp as e 
inner join dept as d 
on e.deptno = d.deptno;
-- 방법2.(추천X)
-- where 조건으로도 사용할 수 있지만
-- where 가 나온 목적은 연산자(비교)를 이용해서 필터링을 하는게 목적이다.
-- 때문에 아래 방법보다는 방법1로 join을 사용하자
select e.ename,e.deptno,d.dname from emp as e, dept as d where e.deptno = d.deptno;

-- 사원번호가  7788인 사원의 이름, 직책, 부서번호, 부서이름, 근무지역을 조회하시오
-- 조인 팁: 두 테이블 교집합 컬럼을 찾자
select e.ename, e.job,e.deptno,d.dname,d.loc 
from emp as e 
inner join dept as d 
on e.deptno = d.deptno  
where empno=7788;
-- 부서별로 그룹핑하고 부서번호와 부서이름을 조회하시오
select e.deptno,d.dname 
from emp as e 
inner join dept as d 
on e.deptno = d.deptno 
group by deptno;
-- 직책이 manager인 사원들의 이름, 부서이름,부서위치를 조회하시오
select e.ename, d.dname,d.loc 
from emp as e 
inner join dept as d 
on e.deptno = d.deptno 
where e.job ='manager';

-- inner join 에서 순서는 상관없지만
-- Right join 과 left join 은 상관 있다. 

-- left join , right join : 아우터 조인
-- 40번 부서만 조회
select * from dept where deptno = 40;
-- emp 테이블에 없는 부서번호 조회
select * from emp as e
right join dept as d 
on d.deptno = e.deptno;
-- 
select * from dept as d
left join emp as e 
on d.deptno = e.deptno
where e.empno is null;

-- self join (inner join하고 같음)
-- 그러나 자기 자신을 조인함, 1개 테이블을 사용
select
	boss.empno as '상사 번호',
	boss.ename as '상사 이름',
	underling.empno as '부하직원 번호',
	underling.ename	as '부하지원 이름'
from emp as boss
inner join emp as underling 
on boss.empno = underling.mgr;

-- emp에 insert 하기
insert into  emp (empno,ename,job,sal,hiredate)
values (8000,'손흥민','salesman',7000,now());
-- 문제. 아우터 조인 (left or right) 이용하기
-- 부서에 소속되어 있지 않는 사원 번호, 이름, 입사날짜 조회
select * from emp as e
left join dept as d 
on d.deptno = e.deptno
where d.dname is null;
-- 사원번호가 8000인 사원의 급여를 8000으로 업데이트 하시오


select ename, job, sal 
 from emp;
 
select empno, ename, hiredate
 from emp
 where mgr = 7839;
 
select * 
 from emp
 where sal <= 3000;
 
select e.ename, d.deptno , d.dname, d.loc
 from emp as e
 inner join dept as d
 on e.deptno = d.deptno; 
 
select  d.dname , sum(e.sal)
 from emp as e
 right join dept as d
 on e.deptno = d.deptno
 group by d.dname;
 
select e.ename, e.sal from emp as e inner join dept as d on e.deptno = d.deptno where e.job = "manager" and d.loc = "NEW YORK"
 
select e.ename, d.dname, e.job, ifnull(e.comm, 100)
 from emp as e
 right join dept as d
 on e.deptno = d.deptno
 where date_format(hiredate, '%Y') >= 1983;
 
select e.ename, e.sal, d.loc
 from emp as e
 inner join dept as d
 on e.deptno = d.deptno
 where d.dname in('RESEARCH');
 
select e.ename, e.job, e.sal, d.dname
 from emp as e
 inner join dept as d 
 on e.deptno = d.deptno
 where e.comm is not null;
 
select e.ename, e.job, d.dname, d.loc
 from emp as e
 inner join dept as d
 on e.deptno = d.deptno
 where ename like 'A%';
 
select underling.ename, boss.ename, underling.mgr
 from emp as boss
 right join emp as underling
 on boss.empno = underling .mgr;
 
select underling.ename, underling.mgr, boss.ename
 from emp as boss right join
 emp as underling
 on boss.empno = underling.mgr
 where boss.empno is null;
 
select underling.empno, underling.ename, boss.empno, boss.ename
 from emp as boss
 right join emp as underling
 on boss.empno = underling .mgr
 where boss.empno =7698;
 
select underling.ename, underling.hiredate, boss.ename, boss.hiredate
 from emp as boss
 inner join emp as underling
 on underling.mgr = boss.empno
 where underling.hiredate < boss.hiredate;
 
select e.empno, e.ename, e.sal, e.job, d.dname
 from emp as e
 inner join dept as d
 on e.deptno = d.deptno
 where date_format(hiredate,'%Y')='1982' and job ='MANAGER' or date_format(hiredate,'%Y')='1982' and job ='CLERK';

select d.dname, sum(e.sal)
 from emp as e
 right join dept as d
 on e.deptno = d.deptno
 group by d.dname
 order by e.sal desc;

select underling.ename, boss.ename, d.deptno, d.dname, d.loc
    from emp as boss
    right join emp as underling
    on boss.empno = underling.mgr 
    right join dept as d
    on underling.deptno = d.deptno
    union 
    select underling.ename, boss.ename, d.deptno, d.dname, d.loc
    from emp as boss
    right join emp as underling
    on boss.empno = underling.mgr 
    left join dept as d
    on underling.deptno = d.deptno

select underling.empno, underling.ename, boss.empno, boss.ename, boss.sal, d.dname 
 from emp as boss
 right join emp as underling
 on boss.empno = underling.mgr
 inner join dept as d
 on boss.deptno = d.deptno
 where d.loc = 'CHICAGO' and boss.sal < 5000
 order by underling.hiredate;

select date_format(hiredate, '%m') , count(empno) 
 from emp
 group by date_format(hiredate, '%m')
 order by date_format(hiredate, '%m');

select underling.ename, boss.ename, boss.deptno, d.dname
 from emp as boss
 inner join emp as underling
 on boss.empno = underling.mgr 
 right join dept as d 
 on boss.deptno = d.deptno 
 group by d.deptno;
 
select 
	empno,
	ename,
	job,
	date_format(hiredate,'%Y')
from emp
where sal>2000

-- 전체사원의 사원번호, 사원이ㄹ므, 부서이름을 모두 출력하시오,

select 
	e.empno,
	e.ename,
	d.dname
from emp as e
inner join dept as d
on e.deptno=d.deptno


SELECT
	empno,		
	ename
FROM emp
WHERE empno 


SELECT 
	count(empno)
FROM emp

SELECT
	avg(sal)
FROM emp
	
SELECT
	count(deptno)
FROM dept

SELECT
	sum(comm)
FROM emp
-- 서브쿼리란 하나의 쿼리 문장 내에 포함된 또하나의 쿼리문장
-- 서브쿼리 오는위치
-- 1.select (스칼라 서브쿼리)
-- 2.from (인라인 뷰)
-- 3.where (중첩 서브쿼리)
select
	count(empno)as "empCount",
	(select avg(sal) from emp) as "empSalAvg",
	(select count(deptno) from dept) as "deptCount",
	(select sum(comm) from emp) as "empCommSum"
from emp

SELECT 
			e.empno as '사원번호',
			e.ename as '사원이름',
			e.job as '사원직책',
			e.sal as '사원급여',
			e.hiredate as '입사날짜',
			d.dname as'부서이름'
		FROM emp as e
		INNER JOIN dept as d
		ON e.deptno=d.deptno
		ORDER BY e.empno desc 

update emp 
set 
	ename = '이강인',
	job = 'MANAGER',
	sal = 500,
	comm = 300
where empno = 200
	
alter table emp add column is_use bool
-- DML :select, insert, update,delete
-- DDL : ALTER, DROP, CREATE(AUTO COMMMIT)

update emp
set is_use = true 

select count(*) from emp where is_use = true;

SELECT 
			e.empno as '사원번호',
			e.ename as '사원이름',
			e.job as '사원직책',
			e.sal as '사원급여',
			e.hiredate as '입사날짜',
			d.dname as'부서이름'
		FROM emp as e
		INNER JOIN dept as d
		ON e.deptno=d.deptno
		ORDER BY e.empno desc 
		
select count(*)from emp where empno = 300
	
SELECT
			deptno,
			dname,
			loc
		FROM dept
		
SELECT 
		d.deptno  AS '부서번호',
		d.dname AS '부서이름',
		d.loc AS '근무지',
		count(empno) AS '사원수'
FROM emp as e
RIGHT JOIN dept as d
ON e.deptno=d.deptno
group by e.deptno
-- 부모테이블 delete (참조키제공)
DELETE FROM dept 
WHERE deptno = 30
-- 부모테이블에 데이터를 삭제하고 싶으면 CASCADE 설장을 해야한다.
-- 자식테이블delete (참조키사용)
DELETE FROM emp 
WHERE deptno = 30	


CREATE TABLE A(
	idx int(4) NOT NULL PRIMARY KEY comment'PX아이디',
	create_at datetime DEFAULT current_timestamp comment'생성날짜'	
);

CREATE TABLE B(
	b_idx int(4) NOT NULL PRIMARY KEY COMMENT 'B테이블 PX',
	a_idx int(4) COMMENT 'A테이블 FK',
	FOREIGN KEY(a_idx) REFERENCES A(idx) ON DELETE CASCADE
);

INSERT INTO a(idx) VALUES (1);
INSERT INTO a(idx) VALUES (2);
INSERT INTO a(idx) VALUES (3);
INSERT INTO a(idx) VALUES (4);

INSERT INTO b(b_idx,a_idx) VALUES (2,3);
INSERT INTO b(b_idx,a_idx) VALUES (2,3);


SELECT
			d.deptno,
			d.dname,
			d.loc,
			count(IF(e.is_use=1, e.is_use, NULL)) AS empno
		FROM dept AS d 
		LEFT JOIN emp AS e
		ON d.DEPTNO = e.DEPTNO
		GROUP BY d. 
		ORDER BY d.deptno
-- 로그 테이블 생성하기
-- AUTO_INCREMENT
CREATE TABLE emp_logs(
	log_id bigint(20) AUTO_INCREMENT PRIMARY KEY comment'로그 번호',
	ip varchar(50) comment'사용자 아이피',
	url varchar (100) comment'접속경로',
	http_method varchar(10) comment'http method',
	CREATE_at datetime comment'접속 시간'
)

CREATE TABLE IF NOT EXISTS DEPT (
    DEPTNO DECIMAL(2),
    DNAME VARCHAR(14),
    LOC VARCHAR(13),
    CONSTRAINT PK_DEPT PRIMARY KEY (DEPTNO) 
);

CREATE TABLE IF NOT EXISTS EMP (
    EMPNO DECIMAL(4),
    ENAME VARCHAR(10),
    JOB VARCHAR(9),
    MGR DECIMAL(4),
    HIREDATE DATE,
    SAL DECIMAL(7,2),
    COMM DECIMAL(7,2),
    DEPTNO DECIMAL(2),
    IS_USE tinyint(1) DEFAULT true,
    CONSTRAINT PK_EMP PRIMARY KEY (EMPNO),
    CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
);

CREATE TABLE IF NOT EXISTS emp_logs(
	log_id bigint(20) AUTO_INCREMENT PRIMARY KEY comment'로그 번호',
	ip varchar(50) comment'사용자 아이피',
	url varchar (100) comment'접속경로',
	http_method varchar(10) comment'http method',
	CREATE_at datetime comment'접속 시간'
)

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,STR_TO_DATE('17-12-1980','%d-%m-%Y'),800,NULL,20,true);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,STR_TO_DATE('20-2-1981','%d-%m-%Y'),1600,300,30,true);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,STR_TO_DATE('22-2-1981','%d-%m-%Y'),1250,500,30,true);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,STR_TO_DATE('2-4-1981','%d-%m-%Y'),2975,NULL,20,true);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,STR_TO_DATE('28-9-1981','%d-%m-%Y'),1250,1400,30,true);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,STR_TO_DATE('1-5-1981','%d-%m-%Y'),2850,NULL,30,true);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,STR_TO_DATE('9-6-1981','%d-%m-%Y'),2450,NULL,10,true);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,STR_TO_DATE('13-7-1987','%d-%m-%Y')-85,3000,NULL,20,true);
INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,STR_TO_DATE('17-11-1981','%d-%m-%Y'),5000,NULL,10,true);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,STR_TO_DATE('8-9-1981','%d-%m-%Y'),1500,0,30,true);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,STR_TO_DATE('13-7-1987', '%d-%m-%Y'),1100,NULL,20,true);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,STR_TO_DATE('3-12-1981','%d-%m-%Y'),950,NULL,30,true);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,STR_TO_DATE('3-12-1981','%d-%m-%Y'),3000,NULL,20,true);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,STR_TO_DATE('23-1-1982','%d-%m-%Y'),1300,NULL,10,true);

COMMIT;

-- INSERT 컬럼아름 명사하는ㄴ 문법
-- ex) insult into emp(empno) Values(2000)
-- 컬럼이름을 명시하는 insult 다른 컬럼들은 샹력가능
-- 단 다른 컬럼들이 not null이라면 그 컬럼은 넣어야함
CREATE TABLE IF NOT EXISTS drone (
    uuid VARCHAR(20) PRIMARY KEY COMMENT '드론 고유아이디',
    model_name VARCHAR(30) NOT NULL COMMENT '드론 모델명',
    battery DECIMAL(3,0) DEFAULT 100 COMMENT '배터리',
    loc VARCHAR(50) COMMENT '현재 위치',
    latitude VARCHAR(30) COMMENT '현재 위도',
    longitude VARCHAR(30) COMMENT '현재 경도',
    is_message BOOLEAN COMMENT '드론 통신상태 여부',
    is_use BOOLEAN COMMENT '드론 사용 여부',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS drone_driving (
    driving_no BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '운행 번호',
    uuid VARCHAR(20) COMMENT '드론 고유아이디',
    start_at DATETIME COMMENT '출발 시간',
    end_at DATETIME COMMENT '도착 시간',
    driving_distance DECIMAL(4,1) COMMENT '운행 거리(KM)',
    FOREIGN KEY (uuid) REFERENCES drone (uuid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS drone_driving_history (
    history_no BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '운행 상세이력 번호',
    driving_no BIGINT(20) COMMENT '운행 번호',
    latitude VARCHAR(30) COMMENT '현재 위도',
    longitude VARCHAR(30) COMMENT '현재 경도',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '운행 날짜',
    FOREIGN KEY (driving_no) REFERENCES drone_driving (driving_no)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into drone(uuid, model_name, loc, latitude, longitude, is_message, is_use) 
values(201210325, 'KAZA-556699', '대전 충정로 136', '36.3432473', '127.4487079', true, true);

insert into drone(uuid, model_name, loc, latitude, longitude, is_message, is_use) 
values(101210777, 'SAMA-931207', '대전 중앙로121번길 20', '36.3286904', '127.4229992', true, true);

insert into drone(uuid, model_name, loc, latitude, longitude, is_message, is_use) 
values(211016700, 'AJJK-200489', '대전 진잠로92번길 24', '36.2996845', '127.3169115', true, true);

-- 드론 운행정보
insert into drone_driving(uuid, start_at, end_at, driving_distance)
values(201210325, '2022-11-13 14:02:56', '2022-11-13 15:00:56', 8.5);
insert into drone_driving(uuid, start_at, end_at, driving_distance)
values(101210777, '2022-11-13 09:30:00', null, 0);

-- 드론 운행상세정보
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3286904', '127.4229992', '2022-11-13 14:02:56');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3325226', '127.4338474', '2022-11-13 14:11:30');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3499999', '127.4370503', '2022-11-13 14:22:00');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3577778', '127.4063889', '2022-11-13 14:41:40');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.3711638', '127.3883444', '2022-11-13 14:50:16');
insert into drone_driving_history(driving_no, latitude, longitude, create_at)
values(1, '36.4240196', '127.3958129', '2022-11-13 15:00:56');


SELECT 
		uuid,
		battery,
		model_name AS modelName,
		is_message AS ISMsg,
		latitude,
		longitude
	FROM drone
	
SELECT 
	dd.driving_no AS drivingNo,
	dd.start_at AS startAt,
	dd.end_at AS endAt
FROM drone AS d
INNER JOIN drone_driving AS dd
ON d.uuid  = dd.uuid 
WHERE d.uuid = '101210777'
	
-- 상세 운행기록

SELECT 
ddh.history_no AS historyNo,
ddh.latitude,
ddh.longitude,
ddh.create_at AS createAt
FROM drone_driving AS dd
INNER JOIN drone_driving_history AS ddh
ON dd.driving_no = ddh.driving_no 
WHERE dd.driving_no = 1

CREATE TABLE users(
	user_id varchar(50) PRIMARY KEY comment '회원 아이디',
	pw varchar(200) comment '비밀번호',
	email varchar(30) comment '이메일'
)

INSERT INTO users
(id, pw, email)
VALUES
()

