-- 코드를 입력하세요
-- 네비 옵션이 포함된 자동차 리스트 출력, 결과는 ID기준 내림차순
SELECT *
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC