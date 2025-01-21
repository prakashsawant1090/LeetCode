# Write your MySQL query statement below

select DISTINCT v.author_id as id from Views v where v.viewer_id = v.author_id order by author_id;