# перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
# Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT
	f.name, s.time, f.duration,
    (SELECT
		shedule.time
	FROM
		shedule JOIN films ON shedule.film_id=films.id
	WHERE
		shedule.id>s.id
	LIMIT 1) as time_next,
    TIMESTAMPDIFF(minute,
    date_add(s.time, interval f.duration MINUTE),
	(SELECT
		shedule.time
	FROM
		shedule JOIN films ON shedule.film_id=films.id
	WHERE
		shedule.id>s.id
	LIMIT 1)) as duration_break
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
	LIMIT 1))>=30
    ORDER BY duration_break DESC;
