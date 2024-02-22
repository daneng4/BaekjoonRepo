-- 코드를 입력하세요
-- 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부 조회
-- 냉동시설 여부가 NULL이면 N으로 출력 결과는 창고 ID기준 오름차순
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N')
FROM FOOD_WAREHOUSE
WHERE ADDRESS LIKE '경기도%'