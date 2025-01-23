-- 코드를 작성해주세요
-- 1차 시도: sql은 & 연산이 없는 줄 알고 이진수로 만들고 문자열 자르는 바보같은 짓을 함
SELECT child.ID
    , child.GENOTYPE as GENOTYPE
    , parent.GENOTYPE as PARENT_GENOTYPE
FROM ECOLI_DATA child
    LEFT JOIN ECOLI_DATA parent
        ON parent.ID = child.PARENT_ID
WHERE BIN(parent.GENOTYPE) = SUBSTRING(CONCAT(BIN(child.GENOTYPE)), LENGTH(BIN(child.GENOTYPE)) - LENGTH(BIN(parent.GENOTYPE)) + 1, LENGTH(BIN(parent.GENOTYPE)))
ORDER BY child.ID


-- 코드를 작성해주세요
-- 2차 시도: & 연산 적용하여 간단하게 해결
SELECT child.ID
    , child.GENOTYPE as GENOTYPE
    , parent.GENOTYPE as PARENT_GENOTYPE
FROM ECOLI_DATA child
    JOIN ECOLI_DATA parent
        ON parent.ID = child.PARENT_ID
WHERE parent.GENOTYPE = parent.GENOTYPE & child.GENOTYPE
ORDER BY child.ID