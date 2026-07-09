-- Part 1: Most active user
SELECT u.name AS results
FROM Users u
WHERE u.user_id = (
    SELECT mr.user_id
    FROM MovieRating mr
    JOIN Users uu ON mr.user_id = uu.user_id
    GROUP BY mr.user_id, uu.name
    ORDER BY COUNT(*) DESC, uu.name ASC
    LIMIT 1
)

UNION ALL

-- Part 2: Highest rated movie in Feb 2020
SELECT m.title AS results
FROM Movies m
WHERE m.movie_id = (
    SELECT mr.movie_id
    FROM MovieRating mr
    JOIN Movies mm ON mr.movie_id = mm.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY mr.movie_id, mm.title
    ORDER BY AVG(mr.rating) DESC, mm.title ASC
    LIMIT 1
);
