package joiner.service.impl;

import joiner.dao.ActivityDao;
import joiner.entity.Activity;
import joiner.service.ActivityService;

import java.util.List;

/**
 * Created by distanceN on 2015/6/14.
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao;

    public ActivityDao getActivityDao() {
        return activityDao;
    }

    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public boolean addActivity(Activity activity) {
        return activityDao.addActivity(activity);
    }

    @Override
    public Activity findActivityById(String activityId) {
        return activityDao.findActivityById(activityId);
    }

    @Override
    public List<Activity> findActivitysByName(String activityName) {
        return activityDao.findActivitysByName(activityName);
    }

    @Override
    public List<Activity> listAll() {
        return activityDao.listAll();
    }

    @Override
    public List<Activity> findActivitysByOrganizer(String organizerName) {
        return activityDao.findActivitysByOrganizer(organizerName);
    }
    @Override
    public boolean joinedByStudent(String studentId) {
        return activityDao.joinedByStudent(studentId);
    }
}
