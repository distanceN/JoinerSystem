package joiner.service;

import joiner.entity.Activity;

import java.util.List;

/**
 * Created by distanceN on 2015/6/14.
 */
public interface ActivityService {
    public boolean addActivity(Activity activity);
    public Activity findActivityById(String activityId);
    public List<Activity> findActivitysByName(String activityName);
    public List<Activity> listAll();
    public List<Activity> findActivitysByOrganizer(String organizerName);
    public boolean joinedByStudent(String studentId);
}
