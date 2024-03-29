SELECT *
	FROM all_users
;

ALTER USER hr account unlock;
ALTER USER hr IDENTIFIED BY java;

-- 테이블 스페이스 생성
CREATE TABLESPACE TS_DBSQL
DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\TS_DBSQL.DBF'
SIZE 100M
AUTOEXTEND ON;

-- 사용자 추가
CREATE USER ksj IDENTIFIED BY java
DEFAULT tablespace TS_DBSQL
TEMPORARY tablespace temp
quota unlimited ON TS_DBSQL
quota 0m ON system;

-- 접속, 생성권한
GRANT CONNECT, RESOURCE TO ksj;

SELECT *
FROM emp;