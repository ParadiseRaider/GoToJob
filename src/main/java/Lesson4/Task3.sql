# список фильмов, для каждого — с указанием общего числа посетителей за все время,
# среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
# Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;

SET @totalPeople = (SELECT
		count(films.name)
	FROM
		orders JOIN shedule ON orders.shedule_id = shedule.id
		JOIN films ON films.id = shedule.film_id);
SET @UniqueMovie = (SELECT
		count(distinct shedule.id)
	FROM
		orders JOIN shedule ON orders.shedule_id = shedule.id
		JOIN films ON films.id = shedule.film_id);

SELECT
	ifnull(f.name,'Итого') as 'name', count(f.name) as film_people,
    @totalPeople / @UniqueMovie  as average,
    sum(s.price) as Sum
FROM
	orders o JOIN shedule s ON o.shedule_id = s.id
    JOIN films f ON f.id = s.film_id
GROUP BY f.name with rollup
ORDER BY Sum DESC;