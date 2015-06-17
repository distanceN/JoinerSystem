package joiner.dao.impl;

import joiner.dao.ActivityDao;
import joiner.entity.Activity;
import joiner.entity.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by distanceN on 2015/6/14.
 */
public class ActivityDaoImpl extends HibernateDaoSupport implements ActivityDao {

    @Override
    public boolean addActivity(Activity activity) {
        boolean flag = true;
        String organizerName = activity.getOrganizerName();
        String name = activity.getActivityName();
        List<Activity> list = findActivitysByName(name);
        if(list.size()!= 0) {
            for(int i = 0; i <list.size();i++) {
                if(list.get(i).
                        getOrganizerName().equals(organizerName)){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            try {

                getHibernateTemplate().save(activity);
                System.out.println("Activity saved ok!");
            } catch (DataAccessException e) {
                e.printStackTrace();
                System.out.println("Sorry, activity can't be added.");
                return false;
            }
        } else {
            System.out.println("The activity name has been existed!");
            return false;
        }
        return true;
    }

    @Override
    public Activity findActivityById(String activityId) {
        System.out.println("Searching activity by id");
        List<Activity> activitys = getHibernateTemplate().find("from Activity where activityId = ?", activityId);
        if (1 > activitys.size()) {
            return null;
        } else {
            return activitys.get(0);
        }
    }

    @Override
    public List<Activity> findActivitysByName(String activityName) {
        return getHibernateTemplate().find("from Activity where activityName = ?", activityName);
    }

    @Override
    public List<Activity> findActivitysByOrganizer(String organizerName) {
        return getHibernateTemplate().find("from Activity where organizerName = ?", organizerName);
    }

    @Override
    public List<Activity> listAll() {
        return getHibernateTemplate().find("from Activity");
    }

    @Override
    public boolean joinedByStudent(String studentId) {
        List<Student> studentsJoined = getHibernateTemplate().find("from Link where studentId = ?", studentId);
        if (studentsJoined == null || studentsJoined.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}