package joiner.service.impl;

import joiner.dao.StudentDao;
import joiner.entity.Student;
import joiner.service.StudentService;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public String addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public Student findStudentById(String studentId) {
        return studentDao.findStudentById(studentId);
    }

    @Override
    public List<Student> findStudentsByName(String studentName) {
        return studentDao.findStudentsByName(studentName);
    }

    @Override
    public List<Student> listAll() {
        return studentDao.listAll();
    }

    @Override
    public boolean joinedActivity(String activityId) {
        return studentDao.joinedActivity(activityId);
    }
}
