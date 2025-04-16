   \echo Вывод всей таблицы в алфавитном порядке.
  SELECT *
    FROM jaegers
ORDER BY model_name;

   \echo Вывод не уничтоженных роботов в алфавитном порядке.
  SELECT *
    FROM jaegers
   WHERE status = 'Active'
ORDER BY model_name;

   \echo Вывод роботов серии Марк-1 и Марк-4 в алфавитном порядке.
  SELECT *
    FROM jaegers
   WHERE mark IN (1, 4)
ORDER BY model_name;

   \echo Вывод всех роботов кроме Марк-1 и Марк-4 по убыванию поля mark.
  SELECT *
    FROM jaegers
   WHERE mark NOT IN (1, 4)
ORDER BY mark DESC;

   \echo Вывод самых старых роботов в алфавитном порядке.
  SELECT *
    FROM jaegers
   WHERE launch = (SELECT MIN(launch) FROM jaegers)
ORDER BY launch;

   \echo Вывод информации о роботах уничтоживших больше всех kaiju.
  SELECT model_name, mark, launch, kaiju_kill
    FROM jaegers
   WHERE kaiju_kill = (SELECT MAX(kaiju_kill) FROM jaegers)
ORDER BY model_name;

   \echo Вывод среднего веса роботов округлённого до 3 знаков после запятой.
  SELECT ROUND(AVG(weight), 3) AS avg_weight
    FROM jaegers;

   \echo Увеличенное на 1 поле kaiju_kill у не уничтоженных роботов.
  UPDATE jaegers
     SET kaiju_kill = kaiju_kill + 1
   WHERE status = 'Active';

  SELECT *
    FROM jaegers
ORDER BY model_name;

   \echo Удаление уничтоженных роботов и вывод оставшихся.
  DELETE
    FROM jaegers
   WHERE status = 'Destroyed';

  SELECT *
    FROM jaegers
ORDER BY model_name;