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

-- 엔티티 관계도 검색해보기
SELECT *
  FROM countries; 
SELECT *
  FROM regions;  
SELECT *
  FROM LOCATIONS;
SELECT *
  FROM DEPARTMENTS;
SELECT *
  FROM EMPLOYEES;
SELECT *
  FROM jobs;


