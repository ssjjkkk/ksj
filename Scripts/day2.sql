-- 별칭은 SQL내부에서 무조건 대문자로 표현되는데 소문자로 표현하고 싶으면 더블쿼테이션으로 묶는다.
-- 더블 쿼테이션으로 묶으면 별칭 사이에 공백도 넣을 수 있다.

SELECT empno AS 사번, ename "name", sal AS 급여, comm 커미션, sal + comm sal_plus_comm
  FROM emp;
  
SELECT PROD_ID , PROD_NAME name
  FROM prod;
   
SELECT LPROD_GU gu, LPROD_NM nm
  FROM LPROD;

SELECT BUYER_ID 바이어아이디, BUYER_NAME 이름 
  FROM BUYER;
  
 -- literal : 값 자체
 -- literal 표기법 : 값을 표현하는 방법
 -- ex: test 라는 문자열을 표기하는 방법
 -- java : system.out.println("test"), 자바에서는 더블 쿼테이션으로 문자열을 표기한다.
 -- 	 : system.out.println('test'), 싱글쿼테이션으로 표기하면 에러
 -- SQL	 : 'test', sql 에서는 싱글쿼테이션으로 문자열을 표기
 -- 언어마다 연산자 표기, literal 표기법이 다르기 때문에 해당 언어에서 지정하는 방식을 잘 따라야 한다.
 
 -- 문자열 연산
 -- java에서 문자열 결합연산자 : +
 -- SQL에서 문자열 결합 연산자 : ||
 -- SQL에서 문자열 결합 함수 : CONCAT(문자열1, 문자열2) ==> 문자열1 || 문자열2
 
 -- users 테이블의 userid 컬럼과 usernm컬럼을 결합해서 조회하세요.
 -- 문자열 결합연산자와 문자열 결합 함수 모두 사용하세요.
SELECT USERID || USERNM , CONCAT(USERID, USERNM) 
  FROM USERS;
  
-- 임의 문자열 결합 (sal + 500), '아이디 : ' || userid
SELECT '아이디 : ' || USERID, 500, 'test' 
  FROM USERS;
 
SELECT *
  FROM user_tables;

SELECT 'SELECT * FROM ' || TABLE_NAME || ';' AS "select query" 
 FROM user_tables;
  
/*
 * WHERE : 테이블에서 조회할 행의 조건을 기술
 * 		   WHERE절에 기술한 조건이 참일 때 해당 행을 조회한다.
 * 		   SQL에서 가장 어려운 부분, 많은 응용이 발생하는 부분
 */

SELECT *
  FROM USERS
  WHERE USERID = 'brown'
;
  
-- deptno(부서번호)가 30보다 크거나 같은 행을 조회해주세요.
SELECT *
  FROM EMP
  WHERE DEPTNO >= 30
;

SELECT *
  FROM EMP
 WHERE 1=1
;


-- DATE 타입에 대한 WHERE 절 조건 기술
-- emp 테이블에서 hiredate 값이 1982년 1월 1일 이후인 사원들만 조회
-- SQL 에서 DATE 리터럴 표기법 : 'YY/MM/DD'
-- 단, 서버 설정마다 표기법이 다르다.
-- 한국 : YY/MM/DD
-- 미국 : MM/DD/YY
-- '12/11/01' ==> 한국에서 12년 11월 1일 / 미국에서 01년 12월 11일 국가별로 다르게 해석이 가능하기 때문에
-- DATE 리터럴 보다는 문자열을 DATE 타입으로 변경해주는 함수를 주로 사용
-- TO_DATE('날짜문자열', '첫번째 인자의 형식')

SELECT *
  FROM EMP
 WHERE HIREDATE >= TO_DATE('19820101', 'YYYYMMDD')
;

-- 오라클 기본 설정 테이블
SELECT *
  FROM NLS_SESSION_PARAMETERS;

-- BETWEEN AND : 두 값 사이에 위치한 값을 참으로 인식
-- 사용방법 : 비교값 BETWEEN 시작값 AND 종료값
-- 비교값이 시작값과 종료값을 포함하여 사이에 있으면 참으로 인식
 
-- emp 테이블에서 sal값이 1000보다 크거나 같고 2000보다 작거나 같은 사원들만(행들만) 조회해주세요.
SELECT *
  FROM emp
 WHERE sal BETWEEN 1000 AND 2000
-- WHERE sal >= 1000
--   AND sal <= 2000
;

-- emp 테이블에서 고용일자가 1982년 1월 1일 이후, 1983년 1월 1일 이전인 사원들을 조회해주세요.
SELECT *
  FROM emp
 WHERE HIREDATE  BETWEEN TO_DATE('19820101', 'YYYYMMDD') AND TO_DATE('19830101', 'YYYYMMDD')
;


-- emp 테이블에서 deptno(부서번호) 10 혹은 20인 사원들을 조회해주세요.
SELECT *
  FROM emp
-- WHERE DEPTNO = 10
--    OR DEPTNO = 20
 WHERE DEPTNO IN (10, 20)
;

/*
 * WHERE 절에서 사용 가능한 연산자 : LIKE
 * 사용용도 : 문자의 일부분으로 검색을 하고 싶을 때 사용
 * ex : ename 컬럼의 값이 5로 시작하는 사원들을 조회
 * 사용방법 : 컬럼 LIKE '패턴문자열'
 * 마스킹 문자열 : 1. % : 문자가 없거나, 어떤 문자든 여러개의 문자열
 * 				's%': s로 시작하는 모든 문자열을 조회 ==> s, ss, smith
 * 			   2. _ : 어떤 문자든 딱 하나의 문자를 의미
 * 			   'S_' : S로 시작하고 두번째 문자가 어떤 문자든 하나의 문자가 오는 2자리 문자열
 * 			   'S____' : S로 시작하고 문자열의 길이가 5글자인 문자열
 * 
 */

-- emp 테이블에서 ename 컬럼의 값이 S로 시작하는 사원들만 조회해주세요.
SELECT *
  FROM EMP
 WHERE ename LIKE 'S%'
;

SELECT *
  FROM EMP
 WHERE ename LIKE '____S%'
;

-- member테이블에서 회원의 성이 [신]씨인 사람의 mem_id, mem_name 을 조회하는 쿼리를 작성해주세요.
SELECT MEM_ID , MEM_NAME 
  FROM MEMBER
 WHERE MEM_NAME  LIKE '신%'
;


-- member 테이블에서 회원 이름에 글자 [이]가 들어가는 모든 사람의 mem_id, mem_name 을 조회하는 쿼리를 작성해주세요
SELECT MEM_ID , MEM_NAME
  FROM MEMBER
 WHERE MEM_NAME IN ('이')
;

SELECT MEM_ID , MEM_NAME
  FROM MEMBER
 WHERE MEM_NAME like '%이%'
;

-- NULL 비교 : "=" 연산자로 비교 불가 ==> IS

-- comm 컬럼의 값이 null인 사원들만 조회

SELECT empno, ename, comm
  FROM EMP
 where comm = NULL
;

-- NULL값에 대한 비교는 "=" 이 아니라 is 연산자를 사용한다.
SELECT empno, ename, comm
  FROM EMP
 where comm IS NULL
;

-- emp 테이블에서 comm값이 null이 아닌 데이터를 조회
SELECT *
  FROM EMP
 WHERE comm IS NOT NULL
;





