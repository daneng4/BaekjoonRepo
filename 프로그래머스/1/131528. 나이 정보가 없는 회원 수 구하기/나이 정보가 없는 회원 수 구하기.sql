-- 코드를 입력하세요
-- 나이 정보가 없는 회원 몇명인지 출력, 컬럼명은 USERS
SELECT COUNT(USER_ID) AS USERS
FROM USER_INFO
WHERE AGE IS NULL