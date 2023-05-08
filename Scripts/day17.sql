계층쿼리의 SELECT 쿼리의 실행순서 FROM -> START WITH, CONNECT BY -> WHERE
일반쿼리의 SELECT 쿼리의 실행순서 FROM -> WHERE -> SELECT -> (GROUP BY) -> ORDER BY

계층쿼리에서 조회할 행의 조건을 기술할 수 있는 부분이 2곳 존재
1. WHERE - START WITH, CONNECT BY 에 의해 조회된 행을 대상으로 적용
2. CONNECT BY - 다음 행으로 연결할지, 말지를 결정
;

SELECT LPAD(' ', (LEVEL - 1) * 4) || deptnm deptnm 
  FROM dept_h
 START WITH deptcd = 'dept0'
CONNECT BY PRIOR deptcd = p_deptcd AND deptnm != '정보기획부'
;

SELECT LPAD(' ', (LEVEL - 1) * 4) || deptnm deptnm 
  FROM dept_h
 WHERE deptnm != '정보기획부'
 START WITH deptcd = 'dept0'
CONNECT BY PRIOR deptcd = p_deptcd
;

-------------------------------------------------------------------------------------------------------------

[ 계층쿼리에서 사용할 수 있는 특수함수 ]

CONNECT_BY_ROOT(col) - 최상위 행의 'col' 컬럼의 값
SYS_CONNECT_BY_PATH(col, 구분자) - 계층의 순회경로를 표현(각 계층을 지나면서 어떤 컬럼을 지나 왔는지)
CONNECT_BY_ISLEAF - 해당 행이 LEAF 노드(1)인지 아닌지(0)를 반환(최 하단 노드인지 아닌지를 구별해서 알려준다)

SELECT deptcd, p_deptcd, LPAD(' ', (LEVEL-1) * 4) || deptnm deptnm,
	   CONNECT_BY_ROOT(deptnm),
	   LTRIM(SYS_CONNECT_BY_PATH(deptnm, '-'), '-'),
	   CONNECT_BY_ISLEAF
  FROM dept_h
 START WITH deptcd = 'dept0'
CONNECT BY PRIOR deptcd = p_deptcd
;

-- 계층형쿼리 실습1(board_test)

SELECT *
  FROM BOARD_TEST;

SELECT SEQ, LPAD(' ', (LEVEL - 1) * 4) || TITLE TITLE 
  FROM BOARD_TEST 
 START WITH PARENT_SEQ IS NULL
CONNECT BY PRIOR SEQ = PARENT_SEQ
;

-- 실습 2
SELECT SEQ, LPAD(' ', (LEVEL - 1) * 4) || TITLE TITLE 
  FROM BOARD_TEST 
 START WITH PARENT_SEQ IS NULL
CONNECT BY PRIOR SEQ = PARENT_SEQ
ORDER BY seq DESC
;

-- 실습 3
SELECT SEQ, gn, CONNECT_BY_ROOT(seq) s_gn, parent_seq, LPAD(' ', (LEVEL - 1) * 4) || TITLE TITLE 
  FROM BOARD_TEST 
 START WITH PARENT_SEQ IS NULL
CONNECT BY PRIOR SEQ = PARENT_SEQ
 ORDER BY gn DESC, seqs
;





