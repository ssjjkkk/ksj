--SELF-JOIN : 동일한 테이블끼리 조인할 때 지칭하는 명칭(별도의 키워드가 아니다)

SELECT a.empno 사원번호, a.ename 사원이름, a.mgr 사원의상사사원번호, b.ename 사원의상사이름
  FROM emp a, emp b
 WHERE a.mgr = b.empno
;
-- KING의 경우 상사가 없기 때문에 조인에 실패한다.
-- 따라서 총 행의 수는 13건이 조회된다.

SELECT e.empno, e.ename, e.mgr, m.ename
  FROM emp e JOIN emp m ON e.mgr = m.empno
;

-- 사원중 사원의 번호가 7369 ~ 7698인 사원만 대상으로 해당 사원의 사원번호, 이름, 상사의 사원번호, 상사의 이름 조회
SELECT e.empno, e.ename, e.mgr, m.ename
  FROM emp e JOIN emp m ON e.mgr = m.empno
 WHERE e.empno BETWEEN 7369 AND 7698
;

SELECT e.empno, e.ename, e.mgr, m.ename 
  FROM emp e, emp m
 WHERE e.mgr = m.empno
   AND e.empno BETWEEN 7369 AND 7698
;

-- NON-EQUIP-JOIN : 조인 조건이 =이 아닌 조인

SELECT empno, ename, sal, salgrade.grade
  FROM emp e, salgrade s
 WHERE e.sal BETWEEN s.losal AND s.hisal
;

-- 실습1
SELECT empno, ename, d.deptno, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
;

-- 실습2
SELECT empno, ename, d.deptno, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
   AND d.deptno != 20
;

-- 실습3
SELECT empno, ename, sal, d.deptno, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
   AND sal > 2500
;

-- 실습4
SELECT empno, ename, sal, d.deptno, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
   AND sal > 2500
   AND ename != 'JONES'
;

-- 실습5
SELECT empno, ename, sal, d.deptno, dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
   AND sal = 3000
;

-- 실습6 
SELECT LPROD_GU, lprod_nm, prod_id, prod_name
  FROM prod p, lprod pl
 WHERE p.PROD_LGU = pl.LPROD_GU
;

-- 실습7
SELECT BUYER_ID, BUYER_NAME, prod_id, prod_name
  FROM buyer b, prod p
 WHERE b.BUYER_ID = p.PROD_BUYER 
;

-- 실습8
SELECT MEM_ID, MEM_NAME, prod_id, prod_name, cart_qty
  FROM MEMBER m, cart c, prod p
 WHERE m.MEM_ID = c.CART_MEMBER
   AND c.CART_PROD = p.PROD_ID 

-- 실습9
SELECT c.cid, cnm, pid, DAY, cnt
  FROM customer c, CYCLE cc
 WHERE c.cid = cc.cid
   AND c.cid != 3
;

-- 실습10
SELECT c.cid, cnm, cc.pid, pnm, DAY, cnt
  FROM customer c, CYCLE cc, product p
 WHERE c.cid = cc.cid
   AND cc.pid = p.pid
   AND c.cid != 3
;

-- 실습11
SELECT c.cid, cnm, gc.pid, pnm, a "SUM(CNT)"
  FROM (SELECT cid, SUM(cnt) a, pid
 		FROM CYCLE
		GROUP BY cid, pid
  		) gc,
 	   customer c, product p 
 WHERE c.cid = gc.cid
   AND gc.pid = p.pid
;

-- 실습12
SELECT gc.pid, pnm, a "SUM(CNT)"
  FROM (SELECT pid, SUM(cnt) a
	    FROM cycle
	    GROUP BY pid
  		) gc, product p
 WHERE gc.pid = p.pid
;










