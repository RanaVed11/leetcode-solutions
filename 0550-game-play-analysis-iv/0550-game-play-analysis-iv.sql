SELECT 
    ROUND(
        COUNT(DISTINCT player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM Activity a
WHERE EXISTS (
    SELECT 1
    FROM Activity b
    WHERE a.player_id = b.player_id
      AND DATEDIFF(b.event_date, a.event_date) = 1
      AND a.event_date = (
          SELECT MIN(event_date) 
          FROM Activity 
          WHERE player_id = a.player_id
      )
);
