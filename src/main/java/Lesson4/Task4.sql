# число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
# с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

SET @peopleSum1 = (
SELECT
	sum(s.price) as sum
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('09:00:00') and time('15:00:00')
GROUP BY time(s.time) between time('09:00:00') and time('15:00:00'));

SET @peopleCount1 = (
SELECT
	count(f.name) as people
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('09:00:00') and time('15:00:00')
GROUP BY time(s.time) between time('09:00:00') and time('15:00:00'));

SET @peopleSum2 = (
SELECT
	sum(s.price) as sum
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('15:00:00') and time('18:00:00')
GROUP BY time(s.time) between time('15:00:00') and time('18:00:00'));

SET @peopleCount2 = (
SELECT
	count(f.name) as people
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('15:00:00') and time('18:00:00')
GROUP BY time(s.time) between time('15:00:00') and time('18:00:00'));

SET @peopleSum3 = (
SELECT
	sum(s.price) as sum
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('18:00:00') and time('21:00:00')
GROUP BY time(s.time) between time('18:00:00') and time('21:00:00'));

SET @peopleCount3 = (
SELECT
	count(f.name) as people
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('18:00:00') and time('21:00:00')
GROUP BY time(s.time) between time('18:00:00') and time('21:00:00'));

SET @peopleSum4 = (
SELECT
	sum(s.price) as sum
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('21:00:00') and time('23:59:59')
GROUP BY time(s.time) between time('21:00:00') and time('23:59:59'));

SET @peopleCount4 = (
SELECT
	count(f.name) as people
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
WHERE
	time(s.time) between time('21:00:00') and time('23:59:59')
GROUP BY time(s.time) between time('21:00:00') and time('23:59:59'));

SELECT
	@peopleCount1 as '9-15 people', @peopleSum1 as '9-15 sum',
    @peopleCount2 as '15-18 people', @peopleSum2 as '15-18 sum',
    @peopleCount3 as '18-21 people', @peopleSum3 as '18-21 sum',
    @peopleCount4 as '21-00 people', @peopleSum4 as '21-00 sum';
