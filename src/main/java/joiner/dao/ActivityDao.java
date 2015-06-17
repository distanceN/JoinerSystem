package joiner.dao;

import joiner.entity.Activity;

import java.util.List;

/**
 * Created by distanceN on 2015/6/14.
 */
public interface ActivityDao {
    public boolean addActivity(Activity activity);
    public Activity findActivityById(String activityId);
    public List<Activity> findActivitysByName(String activityName);
    public List<Activity> findActivitysByOrganizer(String organizerName);
    public List<Activity> listAll();
    public boolean joinedByStudent(String studentId);
}
