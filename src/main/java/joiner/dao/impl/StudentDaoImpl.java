package joiner.dao.impl;

import joiner.dao.StudentDao;
import joiner.entity.Activity;
import joiner.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
    @Override
    public String addStudent(Student student) {
        String success = "";
        String name = student.getStudentName();
        if(findStudentsByName(name).size() == 0){
            try {
                getHibernateTemplate().save(student);
                success = "Student saved ok!";
            } catch (DataAccessException e) {
                success = "Sorry, student can't be added.";
            }
        } else {
            success = "The student name has been existed!";
        }
        return success;
    }

    @Override
    public Student findStudentById(String studentId) {
        System.out.println("Searching student by id");
        List<Student> students = getHibernateTemplate().find("from Student where studentId = ?", studentId);
        if (1 > students.size()) {
            return null;
        } else {
            return students.get(0);
        }
    }

    @Override
    public List<Student> findStudentsByName(String studentName) {
        return getHibernateTemplate().find("from Student where studentName = ?", studentName);
    }

    @Override
    public List<Student> listAll() {
        return getHibernateTemplate().find("from Student");
    }

    @Override
    public boolean joinedActivity(String activityId) {
        List<Activity> activitiesJoined = getHibernateTemplate().find("from Link where activityId = ?", activityId);
        if (activitiesJoined == null || activitiesJoined.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
