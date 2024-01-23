SELECT ID, PRODUCT_ID, BRAND_ID, APPLICABLE_PRICE, START_DATE, END_DATE, APPLICATION_PRIORITY, CURRENCY_CODE
FROM PRICES
WHERE PRODUCT_ID = :productId
 AND BRAND_ID = :brandId
 AND :applicationDate BETWEEN START_DATE AND END_DATE