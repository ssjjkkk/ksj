-- 실습1
SELECT b.BUY_DATE, b.BUY_PROD, p.PROD_ID, p.PROD_NAME, b.BUY_QTY 
  FROM BUYPROD b, PROD p
 WHERE b.BUY_PROD(+) = p.PROD_ID
   AND b.BUY_DATE(+) = '2005/01/25'
;

-- 실습2
SELECT NVL(b.BUY_DATE, '2005/01/25'), b.BUY_PROD, p.PROD_ID, p.PROD_NAME, b.BUY_QTY 
  FROM BUYPROD b, PROD p
 WHERE b.BUY_PROD(+) = p.PROD_ID
   AND b.BUY_DATE(+) = '2005/01/25'
;

-- 실습3
SELECT NVL(b.BUY_DATE, '2005/01/25'), b.BUY_PROD, p.PROD_ID, p.PROD_NAME, NVL(b.BUY_QTY, 0) buy_qty  
  FROM BUYPROD b, PROD p
 WHERE b.BUY_PROD(+) = p.PROD_ID
   AND b.BUY_DATE(+) = '2005/01/25'
;

-- 실습4
SELECT p.pid, p.PNM, NVL(c.CID, 1) cid, NVL(c.DAY, 0) day, NVL(c.CNT, 0) cnt 
  FROM CYCLE c, PRODUCT p 
 WHERE c.pid(+) = p.pid
   AND c.cid(+) = 1
;

-- 실습5
SELECT p.PID, p.PNM, NVL(c2.CID, 1) cid, NVL(c2.CNM, 'brown') cnm, NVL(c.DAY, 0) day, NVL(c.CNT, 0) cnt   
  FROM CYCLE c, PRODUCT p, CUSTOMER c2
 WHERE c.PID(+) = p.PID
   AND c.cid = c2.CID(+)
   AND c.cid(+) = 1
;

--SUBQUERY : SQL 내부에서 사용된 SQL (Main 쿼리에서 사용된 쿼리)
--사용위치에 따른 분류
--1. SELECT 절 : scalar(단일의) subquery
--2. FROM 절 : IN-LINE-VIEW
--3. WHERE 절 : SUBQUERY
--
--반환하는 행, 컬럼수에 따른 분류
--1. 단일행, 단일 컬럼
--2. 단일행, 복수 컬럼
--3. 복수행, 단일 컬럼
--4. 복수행, 복수 컬럼
--
--서브쿼리에서 메인쿼리의 컬럼을 사용유무에 따른 분류
--1. 서브쿼리에서 메인쿼리의 컬럼 사용 : corelated subquery ==> 상호 연관 서브쿼리
--		==> 서브쿼리 단독으로 실행하는 것이 불가능
--2. 서브쿼리에서 메인쿼리의 컬럼 미사용 : non(un) corelated subquery ==> 비상호 연관 서브쿼리
--		==> 서브쿼리 단독으로 실행하는 것이 가능

--스칼라 서브쿼리 : SELECT 절에서 사용된 서브쿼리
--* 제약사항 : 반드시 서브쿼리가 하나의 행, 하나의 컬럼을 반환해야한다.

--스칼라 서브쿼리가 다중행 복수컬럼을 리턴하는 경우 (x)
SELECT empno, ename, (SELECT deptno, dname FROM dept)
  FROM emp;
 
--스칼라 서브쿼리가 단일행 복수컬럼을 리턴하는 경우 (x)
SELECT empno, ename, (SELECT deptno, dname FROM dept WHERE deptno = 10)
  FROM emp;
 
--스칼라 서브쿼리가 단일행, 단일컬럼을 리턴하는 경우
SELECT empno, ename, (SELECT deptno FROM dept WHERE deptno = 10)
  FROM emp;

--메인쿼리의 컬럼을 사용하는 스칼라 서브쿼리
SELECT empno, ename, deptno,
		(SELECT dname FROM dept WHERE dept.DEPTNO = emp.deptno) DNAME 
  FROM emp;

--IN-LINE-VIEW ==> paging 처리할 때 사용해봄
 
--SUBQUERY : WHERE 절에서 사용 된 subquery

--smith 가 속한 부서에 속하는 사원들 조회
--WHERE 절에서 서브쿼리 사용시 주의점

--연산자와, 서브쿼리의 반환 행수 주의
-- = 연산자를 사용시 서브쿼리에서 여러개 행(값)을 리턴하면 논리적으로 맞지가 않다
--IN 연산자를 사용시 서브쿼리에서 리턴하는 여러개의 행(값)과 비교가 가능
--smith와 allen이 속한 부서에 속한 사원 조회
SELECT *
  FROM emp
 WHERE deptno in (SELECT deptno
 				  FROM emp
 				  WHERE ename IN ('SMITH', 'ALLEN'))
;

 
 
-- 실습1
SELECT *
  FROM emp
 WHERE sal > (SELECT ROUND(AVG(sal), 2) FROM emp)
;


-- 예제1
--사원이 속한 부서의 급여 평균보다 높은 급여를 받는 사원 정보를 조회
SELECT e.*
  FROM emp e, (SELECT deptno, ROUND(AVG(sal), 2) r
  			   FROM emp
  			   WHERE deptno IS NOT NULL
  			   GROUP BY DEPTNO) se
 WHERE e.deptno = se.deptno
   AND sal > r
;

SELECT *
  FROM emp e
 WHERE sal > (SELECT ROUND(AVG(sal), 2) FROM emp e2 WHERE e.DEPTNO = e2.DEPTNO)
;
			-- 실습1과의 차이점은 서브쿼리가 메인쿼리의 테이블을 참조하는 건지 아닌지 차이 / 상호연관 서브쿼리



-- 실습2
SELECT *
  FROM emp
 WHERE deptno IN (SELECT deptno
 				  FROM emp
 				  WHERE ename IN ('SMITH', 'WARD'))
;

-- 실습3
SELECT * 
  FROM dept
 WHERE deptno NOT IN (SELECT deptno
 					  FROM emp
 					  WHERE deptno IS NOT NULL
 					  GROUP BY deptno)
;















