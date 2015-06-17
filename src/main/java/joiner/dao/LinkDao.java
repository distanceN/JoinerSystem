package joiner.dao;

import joiner.entity.Link;

import java.util.List;

/**
 * Created by Feizhou on 2015/6/15.
 */
public interface LinkDao {
    public List<Link> listAll();
    public List<Link> findStudentsByActivity(String activityId);
    public List<Link> findActivitiesByStudent(String studentId);
    public boolean makeJoin(Link link);
}
