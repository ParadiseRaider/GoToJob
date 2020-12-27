#ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
#Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;

SELECT
	f.name, s.time, f.duration,
    (SELECT
		films.name
	FROM
		shedule JOIN films ON shedule.film_id=films.id
	WHERE
		shedule.id>s.id
    LIMIT 1) as name2,
    (SELECT
		shedule.time
	FROM
		shedule JOIN films ON shedule.film_id=films.id
	WHERE
		shedule.id>s.id
    LIMIT 1) as time2,
    (SELECT
		films.duration
	FROM
		shedule JOIN films ON shedule.film_id=films.id
	WHERE
		shedule.id>s.id
    LIMIT 1) as duration2
FROM
	shedule s JOIN films f ON s.film_id=f.id
WHERE
	TIMESTAMPDIFF(minute,
    date_add(s.time, interval f.duration MINUTE),
	(SELECT
		shedule.time
	FROM
		shedule JOIN films ON shedule.film_id=films.id
	WHERE
		shedule.id>s.id
    LIMIT 1)) < 0
ORDER BY s.time;