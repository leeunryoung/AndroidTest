

SELECT * 
FROM  PROFESSOR
;

SELECT * FROM DEPARTMENT, STUDENT ;

SELECT  name, dept_name FROM DEPARTMENT, STUDENT WHERE department.dept_id = student.dept_id;

SELECT name, 2012-year_emp FROM PROFESSOR ;
SELECT DISTINCT address FROM STUDENT;
SELECT Student.name, student.stu_id, department.dept_name FROM STUDENT, DEPARTMENT WHERE student.dept_id = department.dept_id ;
UPDATE STUDENT 
SET YEAR = YEAR +1;

SELECT name, stu_id FROM STUDENT 
WHERE YEAR =3 OR YEAR =4
ORDER BY name desc, stu_id;

SELECT s.name, d.dept_name FROM STUDENT, DEPARTMENT 
WHERE s.DEPT_ID =d.DEPT_ID ;

SELECT NAME FROM STUDENT  
WHERE RESIDENT_ID LIKE '_______2%'
OR RESIDENT_ID LIKE '%*4%';

SELECT * FROM STUDENT  WHERE  name LIKE '김%';

SELECT  s2.name
FROM STUDENT s1,STUDENT s2
WHERE s1.ADDRESS =S2.ADDRESS  AND s1.name='김광식';
SELECT  name, POSITION, 2012-year_emp
FROM PROFESSOR ;
SELECT  name 이름, POSITION 직위, 2012-year_emp 재직연수
FROM PROFESSOR ;

SELECT  DEPT_ID FROM STUDENT
UNION 
SELECT  dEPT_ID FROM PROFESSOR;

SELECT  s.stu_id
FROM STUDENT s ,DEPARTMENT d , takes t
WHERE s.DEPT_ID = s.stu_id AND 
  t.stu_id=s.stu_id and 
dept_name='컴퓨터공학과' AND grade='A+'

SELECT stu_id fROM STUDENT s ,DEPARTMENT d 
WHERE s.DEPT_ID = d.DEPT_ID  AND dept_name= '산업공학과'
MINUS 
SELECT stu_id FROM TAKES 
WHERE grade='A+';

SELECT  title, credit, YEAR, semester
from course, class
WHERE course.course_id = class.course_id;

SELECT title, credit, YEAR, semester
FROM course LEFT OUTER JOIN CLASS c
using(course_id);

SELECT title, credit, YEAR, semester FROM class;

using(course_id);

SELECT title, credit, YEAR, semester
FROM COURSE, CLASS 
WHERE course.course_id=class.course_id(+)

SELECT title, credit, YEAR, semester
FROM COURSE, CLASS 
WHERE course.course_id(+)=class.course_id

SELECT title, credit, YEAR, semester
FROM COURSE FULL OUTER join CLASS 
USING (course_id);

SELECT title, credit, YEAR, semester
FROM ;
ORDER BY 6 DESC;





SELECT count MGR
FROM STUDENT 
WHERE YEAR=3;

SELECT count (DISTINCT dept_id)
FROM STUDENT 

SELECT count(*)
FROM STUDENT s, DEPARTMENT d  
WHERE  s.dept_id = d.dept_id AND d.dept_name = '컴퓨터공학과';
count(*)

SELECT *
FROM emp
WHERE JOB='SALESMAN' 

SELECT *
FROM emp
WHERE job='SALESMAN' AND sal >= 1500

SELECT SUM(2012-YEAR_EMP)
FROM PROFESSOR

SELECT *
FROM PROFESSOR

SELECT sum(sal)
FROM EMP
WHERE job='SALESMAN'

SELECT *
FROM dept, emp
WHERE dept.deptno = emp.deptno 

SELECT SUM(sal) 
FROM dept, emp
WHERE dept.deptno = emp.deptno 

SELECT YEAR_emp
FROM PROFESSOR p 

SELECT 2012-YEAR_emp
FROM PROFESSOR p 

SELECT sum(YEAR_emp)
FROM PROFESSOR p 

SELECT avg(2012-YEAR_emp)
FROM PROFESSOR p 

SELECT avg(sal) --1400
FROM EMP
WHERE job = 'SALESMAN'

SELECT avg(sal) --1037.5
FROM EMP
WHERE job='CLERK'


SELECT avg(sal) --2758.3
FROM EMP
WHERE job='MANAGER'

SELECT avg(sal) --3000
FROM EMP
WHERE job='ANALYST'

SELECT avg(sal) --5000
FROM EMP
WHERE job='PRESIDENT'

SELECT avg(sal) --5000
FROM EMP
WHERE job='PRESIDENT'

SELECT MAX(sal) 
FROM dept d, emp e
WHERE d.deptno = e.deptno  AND dname ='ACCOUNTING'

SELECT dname, max(sal)
FROM emp;

SELECT dept_id, count(*)
FROM STUDENT s 
GROUP BY dept_id

SELECT dept_name, count(*)
FROM STUDENT s, DEPARTMENT d  
WHERE  s.dept_id = d.dept_id
GROUP BY dept_name

SELECT dname, count(*), avg(sal), max(sal), min(sal)
FROM emp e, dept d
WHERE e.deptno = d.deptno 
GROUP BY dname 
ORDER BY count(*) ASC 


SELECT  dept_name, count(*), avg(2012-YEAR_emp), max(2012-YEAR_emp)
FROM PROFESSOR p, DEPARTMENT d 
WHERE p.dept_id = d.dept_id
GROUP BY dept_name
ORDER BY dept_name Asc

SELECT  dept_name, COUNT(*), AVG(2012-YEAR_EMP), MAX(2012-YEAR_EMP)
FROM PROFESSOR P, DEPARTMENT d 
WHERE P.DEPT_ID = D.DEPT_ID 
GROUP BY dept_name
HAVING  AVG(2012-YEAR_EMP) >= 10

SELECT DNAME, COUNT(*), AVG(SAL), MIN(SAL)
FROM EMP e ,DEPT d 
WHERE e.deptno =d.deptno
GROUP BY dname
HAVING COUNT(*) >=5

SELECT *
FROM emp 
WHERE comm IS null

SELECT *
FROM emp 
WHERE comm <> 1400

SELECT  stu_id
FROM TAKES t 
WHERE GRADE ='A+'

SELECT count(comm)
FROM emp 
WHERE comm IS NULL

SELECT title
FROM COURSE 
WHERE COURSE_ID IN
  (SELECT  DISTINCT course_id
  FROM CLASS
  wHERE CLASSROOM='301호')

SELECT DISTINCT title
FROM course c1, class c2
WHERE c1.course_id = c2.course_id  AND classroom = '301호'

SELECT DISTINCT title
FROM course 
WHERE course_id   NOT IN 
(SELECT DISTINCT course_id
FROM CLASS 
WHERE YEAR =2012 AND semester=2)

CREATE OR REPLACE VIEW v_takes AS
SELECT stu_id, class_id
FROM takes


































































