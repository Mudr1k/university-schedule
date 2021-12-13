SELECT (first_name || ' ' || last_name) fio, g.name
FROM student
         join groups g on g.id = student.groups_id
where groups_id in (2, 3);

SELECT d.name, g.name, s.name, c.number
FROM schedule
         join classroom c on c.id = schedule.classroom_id
         join day d on d.id = schedule.day_id
         join groups g on g.id = schedule.groups_id
         join subject s on s.id = schedule.subject_id
order by c.number;

SELECT d.name, s.name subject, c.number classroom
FROM schedule
         join classroom c on c.id = schedule.classroom_id
         join day d on d.id = schedule.day_id
         join groups g on g.id = schedule.groups_id
         join subject s on s.id = schedule.subject_id
where d.id = 1
  AND g.id = (SELECT groups.id
              FROM groups
                       join student s on groups.id = s.groups_id
              WHERE (s.first_name || ' ' || s.last_name) = 'Alex Smith');

SELECT d.name, s.name subject, c.number classroom
FROM schedule
         join classroom c on c.id = schedule.classroom_id
         join day d on d.id = schedule.day_id
         join groups g on g.id = schedule.groups_id
         join subject s on s.id = schedule.subject_id
where d.id = 3
  AND g.id = (SELECT groups.id
              FROM groups
                       join student s on groups.id = s.groups_id
              WHERE (s.first_name || ' ' || s.last_name) = 'Lisa Cook');

SELECT d.name, s.name subject, c.number classroom
FROM schedule
         join classroom c on c.id = schedule.classroom_id
         join day d on d.id = schedule.day_id
         join groups g on g.id = schedule.groups_id
         join subject s on s.id = schedule.subject_id
where g.id = (SELECT groups.id
              FROM groups
                       join student s on groups.id = s.groups_id
              WHERE (s.first_name || ' ' || s.last_name) = 'Eva Miller');
