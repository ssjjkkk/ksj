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


