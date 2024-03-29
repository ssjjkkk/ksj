-- 실습5
-- users 테이블에서 userid가 brown이 아닌 회원의 userid, usernm, reg_dt, reg_dt가 없다면 오늘 날짜로
-- 변경하여 조회해주세요.
SELECT userid, usernm, reg_dt, NVL(reg_dt, SYSDATE) n_reg_dt
  FROM users
 WHERE userid != 'brown'
;

-- SQL 조건문
--CASE
--	WHEN 조건문(참 거짓을 판단할 수 있는 문장) THEN 반환값
--	WHEN 조건문(참 거짓을 판단할 수 있는 문장) THEN 반환값2
--	WHEN 조건문(참 거짓을 판단할 수 있는 문장) THEN 반환값3
--	ELSE 모든 WHEN절을 만족시키지 못할 때 반환할 기본 값
--END

-- emp 테이블에 저장된 job 컬럼의 값을 기준으로 급여(sal)를 인상시키려고 한다. sal컬럼과 함께 인상된 sal컬럼의
-- 값을 비교하고 싶은 상황
-- 급여인상기준
-- job이 SALESMAN : sal * 1.05
-- job이 MANAGER : sal * 1.1
-- job이 PRESIDENT : sal * 1.2
-- 나머지 기타 직군 : sal 유지

SELECT ename, job, sal,
	   CASE 
	   		WHEN job = 'SALESMAN' THEN sal * 1.05
	   		WHEN job = 'MANAGER' THEN sal * 1.1
	   		WHEN job = 'PRESIDENT' THEN sal * 1.2
	   		ELSE sal
	   END inc_sal
  FROM emp
;

SELECT *
  FROM EMP
;

SELECT empno, ename,
	   CASE 
		    WHEN deptno = 10 THEN 'ACCOUNTING'
	   		WHEN deptno = 20 THEN 'RESEARCH'
	   		WHEN deptno = 30 THEN 'SALES'
	   		ELSE NULL
	   END dname
  FROM emp
;

-- DECODE : 조건에 따라 반환 값이 달라지는 함수
--			==> 비교, JAVA (if), SQL - case와 비슷
-- 			단, 비교연산이 (=) 만 가능
-- 			CASE의 WHEN절에 기술할 수 있는 코드는 참 거짓 판단을 할 수 있는 코드면 가능
-- 			ex : sal > 1000
-- 			이것과 다르게 DECODE 함수에서는 sal = 1000, sal 2000

-- DECODE는 가변인자(인자의 갯수가 정해지지 않음, 상황에 다라 늘어날 수도 있다)를 갖는 함수
-- DECODE는 연산자가 제한된다. equals (=) 연산만 가능. CASE 절은 다른 연산자 사용 가능.
-- 문법 : DECODE(기준값[col | expression],
-- 					비교값1, 반환값1,
--					비교값2, 반환값3, ...
--					옵션[기준값이 비교값중에 일치하는 값이 없을 때 기본적으로 반환할 값])
-- ==> java
-- if(기준값 == 비교값1)
-- 		반환값1 반환
-- else if(기준값 == 비교값2)
--		반환값2 반환
-- else
-- 		마지막 인자가 있을경우 마지막 인자를 반환하고
--		마지막 인자가 없을 경우 null을 반환
SELECT empno, job, sal, DECODE(deptno, 10, 'ACCOUNTING',
									   20, 'RESEARCH',
									   30, 'SALES',
									   'dw') DNAME
  FROM emp
 ORDER BY empno
;

SELECT ename, job, deptno, sal,
	   CASE 
	   		WHEN job = 'SALESMAN' THEN sal * 1.05
	   		WHEN job = 'MANAGER' THEN
	   								CASE
	   									WHEN deptno = 30 THEN sal * 1.3
	   									ELSE sal * 1.1
	   								END
	   		WHEN job = 'PRESIDENT' THEN sal * 1.2
	   		ELSE sal
	   END inc_sal
  FROM emp
;
-- 위의 CASE문 중첩 구문을 DECODE 중첩 구문으로 바꿔주세요. 
SELECT ename, job, deptno, sal, DECODE(job, 'SALESMAN', sal * 1.05,
											'MANAGER', DECODE(deptno, 30, sal * 1.3, sal * 1.1),
											'PRESIDENT', sal * 1.2,
											sal) inc_sal
  FROM emp
;

-- 실습7
SELECT empno, ename, hiredate,
	   CASE 
		    WHEN hiredate <= TO_DATE('19831231', 'YYYYMMDD')
		    	 AND hiredate >= TO_DATE('19830101', 'YYYYMMDD') THEN '건강검진대상자'
		    WHEN hiredate <= TO_DATE('19811231', 'YYYYMMDD')
		    	 AND hiredate >= TO_DATE('19810101', 'YYYYMMDD') THEN '건강검진대상자'
		    ELSE '건강검진비대상자'
	   END contact_to_doctor
  FROM emp
;

SELECT empno, ename, hiredate,
	   CASE 
		    WHEN MOD(TO_CHAR(hiredate, 'YYYY'), 2) = 0 THEN '건강검진비대상자'
		    WHEN MOD(TO_CHAR(hiredate, 'YYYY'), 2) = 1 THEN '건강검진대상자'
	   END contact_to_doctor
  FROM emp
;

-- 그룹함수 : 여러개의 행을 입력으로 받아서 하나의 행으로 결과를 리턴하는 함수
-- SUM : 합계
-- COUNT : 행의 수
-- AVG : 평균
-- MAX : 그룹에서 가장 큰 값
-- MIN : 그룹에서 가장 작은 값

-- 사용방법
--SELECT 행들을 묶을 기준1, 행들을 묶을 기준2, 그룹함수 ...
--  FROM 테이블
--[WHERE]
-- GROUP BY 행들을 묶을 기준1, 행들을 묶을 기준2
 
-- 1. 부서번호별 SAL 컬럼의 합
-- ==> 부서번호가 같은 행들을 하나의 행으로 만든다.
-- 2. 부서번호별 가장 큰 급여를 받는사람 급여액수
-- 3. 부서번호별 가장 작은 급여를 받는사람 급여액수
-- 4. 부서번호별 급여 평균액수
-- 5. 부서번호별 급여가 존재하는 사람의 수(sal 컬럼이 null이 아닌 행의 수)
-- 								* : 그 그룹의 행수
SELECT deptno, JOB, SUM(sal), MAX(sal), MIN(sal), AVG(sal)  
  FROM emp
 WHERE deptno IS NOT NULL
 GROUP BY deptno, JOB;

SELECT *
FROM EMP;
-- 그룹함수의 특징
-- 1. NULL값을 무시
-- 30번 부서의 사원 6명중 2명은 comm 값이 NULL
SELECT deptno, SUM(comm) 
  FROM emp
 GROUP BY deptno
;

-- 2. GROUP BY 를 적용 여러행을 하나의 행으로 묶게 되면 SELECT 절에 기술할 수 있는 컬럼이 제한됨
-- ==> SELECT 절에 기술되는 일반 컬럼들은 (그룹 함수를 적용하지 않은) 반드시 GROUP BY 절에 기술 되어야 한다.
-- 		* 단 그룹핑에 영향을 주지 않는 고정된 상수, 함수는 기술하는 것이 가능하다.
SELECT deptno, ename, SUM(sal) 
  FROM emp
 GROUP BY DEPTNO, ENAME
;

-- 3. 일반 함수를 WHERE 절에서 사용하는게 가능
--  WHERE UPPER(ename) = 'SMITH';
-- 그룹함수의 경우 WHERE 절에서 사용하는게 불가능
-- 하지만 HAVING 절에 기술하여 동일한 결과를 나타낼 수 있다.

-- 부서번호별 SUM(sal) 값이 9000보다 큰 행들만 조회하고 싶은 경우
SELECT DEPTNO, SUM(sal) 
  FROM emp
 GROUP BY deptno
HAVING SUM(sal) > 9000
;

-- 위의 쿼리를 HAVING절 없이 작성
SELECT *
  FROM (SELECT DEPTNO, SUM(sal) ss 
  		FROM emp
 		GROUP BY deptno
  		)
 WHERE ss > 9000
;