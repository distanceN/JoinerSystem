package joiner.service.impl;

import joiner.dao.LinkDao;
import joiner.entity.Link;
import joiner.service.LinkService;

import java.util.List;

/**
 * Created by Feizhou on 2015/6/15.
 */
public class LinkServiceImpl implements LinkService{
    private LinkDao linkDao;

    @Override
    public List<Link> listAll() {
        return linkDao.listAll();
    }

    @Override
    public List<Link> findStudentsByActivity(String activityId) {
        return linkDao.findStudentsByActivity(activityId);
    }

    @Override
    public List<Link> findActivitiesByStudent(String studentId) {
        return linkDao.findActivitiesByStudent(studentId);
    }

    @Override
    public boolean makeJoin(Link link) {
        return linkDao.makeJoin(link);
    }

    public void setLinkDao(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    public LinkDao getLinkDao() {
        return linkDao;
    }
}
