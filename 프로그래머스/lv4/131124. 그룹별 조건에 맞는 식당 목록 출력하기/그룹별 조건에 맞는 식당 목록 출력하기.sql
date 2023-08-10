WITH
    ReviewCounts as(
        SELECT MEMBER_ID, COUNT(*) as COUNT
            FROM REST_REVIEW
            GROUP BY MEMBER_ID
    ),
    MaxReviewCount as (
        SELECT MAX(COUNT) as MAX
        FROM ReviewCounts
    ),
    MaxReviewMembers as (
        SELECT MEMBER_ID
            FROM ReviewCounts
            WHERE COUNT = (SELECT MAX FROM MaxReviewCount)
    )
    
SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
    FROM MEMBER_PROFILE as a
        JOIN REST_REVIEW as b
        ON a.MEMBER_ID = b.MEMBER_ID 
        JOIN MaxReviewMembers as c
        ON a.MEMBER_ID = c.MEMBER_ID
    ORDER BY REVIEW_DATE ASC
        
# SELECT MEMBER_NAME, REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%y-%m-%d") as REVIEW_DATE
# FROM MEMBER_PROFILE as a 
#     JOIN REST_REVIEW as b
#     ON a.MEMBER_ID = b.MEMBER_ID
#     JOIN MaxReviewMembers as c
#     ON a.MEMBER_ID = c.MEMBER_ID
# ORDER BY REVIEW_DATE ASC