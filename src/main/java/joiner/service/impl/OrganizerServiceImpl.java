package joiner.service.impl;

import joiner.dao.OrganizerDao;
import joiner.entity.Organizer;
import joiner.service.OrganizerService;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public class OrganizerServiceImpl implements OrganizerService {
    private OrganizerDao organizerDao;

    public OrganizerDao getOrganizerDao() {
        return organizerDao;
    }

    public void setOrganizerDao(OrganizerDao organizerDao) {
        this.organizerDao = organizerDao;
    }

    @Override
    public String addOrganizer(Organizer organizer) {
        return organizerDao.addOrganizer(organizer);
    }

    @Override
    public Organizer findOrganizerById(String organizerId) {
        return organizerDao.findOrganizerById(organizerId);
    }

    @Override
    public List<Organizer> findOrganizersByName(String organizerName) {
        return organizerDao.findOrganizersByName(organizerName);
    }

    @Override
    public List<Organizer> listAll() {
        return organizerDao.listAll();
    }
}
