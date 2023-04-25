-- 실습13
SELECT c.REGION_ID, region_name, COUNTRY_NAME
  FROM countries c, regions r
 WHERE c.region_id = r.region_id
   AND c.REGION_ID = 1
;

-- 실습14
SELECT c.REGION_ID, region_name, COUNTRY_NAME, CITY
  FROM countries c, regions r, LOCATIONS l
 WHERE c.region_id = r.region_id
   AND c.COUNTRY_ID = l.COUNTRY_ID 
   AND c.REGION_ID = 1
;

-- 실습15
SELECT c.REGION_ID, region_name, COUNTRY_NAME, CITY, department_name
  FROM countries c, regions r, LOCATIONS l, DEPARTMENTS d 
 WHERE c.region_id = r.region_id
   AND c.COUNTRY_ID = l.COUNTRY_ID 
   AND l.LOCATION_ID = d.LOCATION_ID
   AND c.REGION_ID = 1
;

-- 실습16
SELECT c.REGION_ID, region_name, COUNTRY_NAME, CITY, department_name,
	   CONCAT(first_name, last_name) name
  FROM countries c, regions r, LOCATIONS l, DEPARTMENTS d, EMPLOYEES e 
 WHERE c.region_id = r.region_id
   AND c.COUNTRY_ID = l.COUNTRY_ID 
   AND l.LOCATION_ID = d.LOCATION_ID
   AND d.DEPARTMENT_ID = e.DEPARTMENT_ID
   AND c.REGION_ID = 1
;

-- 실습17
SELECT e.EMPLOYEE_ID, CONCAT(e.FIRST_NAME, e.LAST_NAME) name, j.JOB_ID, j.JOB_TITLE
  FROM jobs j, EMPLOYEES e
 WHERE e.JOB_ID = j.JOB_ID 
;

-- 실습18
SELECT e.MANAGER_ID mgr_id, CONCAT(e2.FIRST_NAME, e2.LAST_NAME) mgr_name, e.EMPLOYEE_ID,
	   CONCAT(e.FIRST_NAME, e.LAST_NAME) name, e.JOB_ID, JOB_TITLE
  FROM JOBS j, EMPLOYEES e, EMPLOYEES e2 
 WHERE j.JOB_ID = e.JOB_ID
   AND e.MANAGER_ID = e2.EMPLOYEE_ID 
;

--조인 성공 여부로 데이터 조회를 결정하는 구분 방법
--INNER JOIN : 조인에 성공하는 데이터만 조회하는 조인 방법
--OUTER JOIN : 조인에 실패 하더라도, 개발자가 지정한 기준이 되는 테이블의 데이터는 나오도록 하는 조인
--
--복습 - 사원의 관리자 이름을 알고싶은 상황
--    - 조회 컬럼 : 사원의 사번, 사원의 이름, 사원의 관리자의 사번, 사원의 관리자의 이름
-- 동일한 테이블끼리 조인 되었기 때문에 : SELF-JOIN
-- 조인 조건을 만족하는 데이터만 조회되었기 때문에 : INNER-JOIN
SELECT e.EMPLOYEE_ID, e.FIRST_NAME || e.LAST_NAME, e.MANAGER_ID, e2.FIRST_NAME || e2.LAST_NAME
  FROM EMPLOYEES e, EMPLOYEES e2 
 WHERE e.MANAGER_ID = e2.EMPLOYEE_ID 







