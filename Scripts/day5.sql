-- sal 를 1000으로 나눴을때의 나머지 ==> MOD 함수, 별도의 연산자는 없다.
-- 몫 : quotient, 나머지 : remainder
SELECT ename, TRUNC(sal/1000, 0) quotient, MOD(sal, 1000) remainder
  FROM emp
;

-- 날짜 관련 함수
-- SYSDATE : 오라클에서 제공해주는 특수함수
-- 			1. 인자가 없음
-- 			2. 오라클이 설치된 서버의 현재 년, 월, 일, 시, 분, 초 정보를 반환해주는 함수

SELECT SYSDATE
  FROM dual
;

-- 날짜타입 +- 정수 : 정수를 일자 취급, 정수만큼 미래, 혹은 과거 날짜의 데이트 값을 반환
-- ex : 오늘 날짜에서 하루 더한 미래 날짜 값은?
SELECT SYSDATE + 1
  FROM dual
;

-- 현재 날짜에서 3시간 뒤 데이트를 구하면?
SELECT SYSDATE + 3/24
  FROM dual
;


-- 현재 날짜에서 1분 뒤 데이트를 구하면?
SELECT SYSDATE + 1/24/60
  FROM dual
;

-- 데이트 표현하는 방법
-- 1. 데이트 리터럴 : NLS_SESSION_PARAMETER 설정에 따르기 때문에 DBMS 환경마다 다르게 인식될 수 있음
-- 2. TO_DATE : 문자열을 날짜로 변경해주는 함수

-- 실습 1
-- 1. 2023년 12월 31일을 DATE 형으로 표현
-- 2. 2023년 12월 31일을 DATE 형으로 표현하고 5일 이전 날짜
-- 3. 현재 날짜
-- 4. 현재 날짜에서 3일 이전 값

SELECT TO_DATE('20231231', 'YYYYMMDD') lastday, TO_DATE('20231231', 'YYYYMMDD') - 5 lastday_before,
	   SYSDATE now, SYSDATE-3 now_before
  FROM dual
;

-- 문자열 ==> 데이트
-- TO_DATE(날짜 문자열, 날짜문자열의 패턴);
-- 데이트 ==> 문자열(보여주고 싶은 형식을 지정할 때)
-- TO_CHAR(데이트 값, 표현하고 싶은 문자열 패턴);
-- TO_DATE 를 더 많이 사용한다. (SYSDATE 리터럴을 사용하면 오류가 발생할 수 있음.)
--    ==> 날짜와 날짜를 비교해야 한다.

-- SYSDATE 현재 날짜는 년도4자리-월2자리-일2자리
SELECT SYSDATE now, TO_CHAR(SYSDATE, 'YYYY-MM-DD') now_format,
	   TO_CHAR(SYSDATE, 'D') 요일인덱스번호,
	   TO_CHAR(SYSDATE, 'DAY') 요일한글표시,
	   TO_CHAR(SYSDATE, 'DY') 요일한글표시앞자리,
	   TO_CHAR(SYSDATE, 'IW') 주초일요일의일자,  -- 달력기준
	   TO_CHAR(SYSDATE, 'WW') 주초일요일의일자,  -- 7일기준
	   TO_CHAR(SYSDATE, 'W') -- "매월 1일 요일을 기준으로 한 주차"ㅜ
  FROM dual
;

SELECT ename, hiredate, TO_CHAR(hiredate, 'YYYY/MM/DD HH24:MI:SS') h1,
	   TO_CHAR(hiredate + 1, 'YYYY/MM/DD HH24:MI:SS') H2,
	   TO_CHAR(hiredate + 1/24, 'YYYY/MM/DD HH24:MI:SS') H2
  FROM EMP
;

-- 실습2 오늘 날짜를 다음과 같은 포맷으로 조회하는 쿼리를 작성하세요.
-- 1. 년-월-일
-- 2. 년-월-일 시간24-분-초
-- 3. 일-월-년
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') 년월일,
	   TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24-MI-SS') 년월일시간분초,
	   TO_CHAR(SYSDATE, 'DD-MM-YYYY') 일월년
  FROM dual
;

-- 날짜관련 오라클 내장함수
-- 내장함수 : 탑재가 되어있음. 오라클에서 제공해주는 함수(많이 사용하니까, 개발자가 별도로 개발하지 않도록)

-- MONTHS_BETWEEN(date1, date2) : 두 날짜 사이의 개월수를 반환(일수가 다르면 소수점으로 계산된다.)
-- ADD_MONTHS(date1, NUMBER) : date1날짜에 NUMBER 만큼의 개월수를 더하고, 뺀 날짜를 리턴
-- NEXT_DAY(date1, 주간요일(1~7)) : date1 이후에 등장하는 첫번째 주간요일의 날짜를 반환
-- LAST_DAY(date1) : date1 날짜가 속한 월의 마지막 날짜를 반환

-- MONTHS_BETWEEN
SELECT ename, TO_CHAR(hiredate, 'YYYY-MM-DD') hiredate,
	   MONTHS_BETWEEN(SYSDATE, hiredate)
  FROM EMP
;

-- ADD_MONTHS
SELECT ADD_MONTHS(SYSDATE, 5) aft5,
	   ADD_MONTHS(SYSDATE, -5) bef5
FROM dual
;

-- NEXT_DAY : 해당 날짜 이후에 등장하는 첫번째 주간요일의 날짜
SELECT NEXT_DAY(SYSDATE, 7) 
  FROM dual
;

-- LAST_DAY : 해당 일자가 속한 월의 마지막 일자를 반환
SELECT LAST_DAY(SYSDATE) 
  FROM dual
;

-- 실습3
-- 파라미터로 YYYYMM형식의 문자열을 받아서 (ex : YYYYMM = 202304) 해당 년월에 해당하는 일자 수를 구해보세요.
-- ex : 파라미터 == 202304 ==> 30
SELECT LAST_DAY(TO_DATE(:yearmonth, 'YYYYMM')) 
  FROM dual
;

SELECT :param param, TO_CHAR(LAST_DAY(TO_DATE(:param, 'YYYYMM')), 'DD') DD
  FROM dual
;

-- 숫자 포맷팅
-- 6,000,000 <==> 6000000
-- 날짜 국가별로 형식이 다르다.
-- 		한국 : yyyy-mm-dd
-- 		미국 : mm-dd-yyyy
-- 숫자
-- 		한국 : 9,000,000.00
-- 		독일 : 9.000.000,00

-- sal(NUMBER) 컬럼의 값을 문자열 포맷팅 적용
SELECT ename, sal, TO_CHAR(sal, 'L9,999.999') fm_sal
  FROM emp
;

SELECT TO_CHAR(0.40, 'FM9990.99')   
  FROM dual
;
-- FM9990.99의 의미
-- 9는 해당 자리의 숫자를 의미하고 값이 없을 경우 소수점 이상은 공백으로, 소수점 이하는 0으로 표시한다.
-- 0은 해당 자리의 숫자를 의미하고 값이 없을 경우 0으로 표시하며 숫자의 길이를 고정적으로 표시 할 때 주로 사용한다.
-- FM은 좌우 9로 치환된 소수점 이상의 공백 및 소수점 이하의 0을 제거한다.

-- FM : 반환값의 앞쪽이나 뒤족에 있는 공백을 제거한다.
-- L : 반환 값의 로컬 통화 기호 위치를 지정한다.


-- NULL과 관련된 함수 : NULL값을 다른 값으로 치환 하거나, 혹은 강제로 NULL을 만드는 것
-- 1. NVL(expr1, expr2)
-- 		 if (expr1 == NULL)
-- 			  expr2를 반환
-- 		 else
-- 			  expr1을 반환
SELECT empno, sal, comm, NVL(comm, 0), sal + NVL(comm, 0)
  FROM emp
;

-- 2. NVL2(expr1, expr2, expr3)
-- 		 if (expr1 != NULL)
-- 			  expr2를 반환
-- 		 else
-- 			  expr3을 반환
SELECT empno, sal, comm,  NVL2(comm, comm, 0), sal + NVL2(comm, comm, 0)
  FROM emp
;

-- 3. NULLIF(expr1, expr2) : NULL을 생성하는 목적
-- 		 if (expr1 == expr2)
-- 			  NULL를 반환
-- 		 else
-- 			  expr1을 반환
SELECT ename, sal, comm, NULLIF(sal, 3000)
  FROM emp
;

-- 4. COALESCE(expr1, expr2, ....) : 인자중에 처음으로 null 값이 아닌 값을 갖는 인자를 반환
-- 		 COALESCE(NULL, NULL, 30, NULL, 50) ==> 30
-- 		 if (expr1 != NULL)
-- 			  expr1를 반환
-- 		 else
-- 			  COALESCE(expr2, ....) ==> 재귀함수 개념
SELECT COALESCE(NULL, NULL, 30, NULL, 50)
  FROM dual
;

-- NULL 처리 실습
-- emp테이블에 한 명을 추가 (INSERT)
INSERT INTO emp (empno, ename, hiredate) VALUES(9999, 'brown', NULL);

-- 조회컬럼 : ename, mgr, mgr컬럼 값이 NULL 이면 111로 치환한 값 - NULL이 아니면 mgr 컬럼값,
-- 		   hiredate, hiredate가 NULL이면 SYSDATE로 표기 - NULL이 아니면 hiredate 컬럼값
SELECT ename, mgr, NVL(mgr, 111) nm, hiredate, NVL2(hiredate, hiredate, SYSDATE) nh
  FROM emp
;

-- 실습4
-- 위 실습 내용에서 mgr 컬럼의 NULL처리를 NVL2, COALESCE 를 사용하여 조회하는 쿼리를 작성해주세요.
SELECT ename, mgr, COALESCE(mgr, 111) cm, NVL2(mgr, mgr, 111) nm
  FROM emp
;






