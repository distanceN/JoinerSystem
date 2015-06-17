package joiner.dao;

import joiner.entity.Student;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public interface StudentDao {
    public String addStudent(Student student);
    public Student findStudentById(String studentId);
    public List<Student> findStudentsByName(String studentName);
    public List<Student> listAll();
    public boolean joinedActivity(String activityId);
}
