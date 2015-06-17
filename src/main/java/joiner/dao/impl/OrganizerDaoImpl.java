package joiner.dao.impl;

import joiner.dao.OrganizerDao;
import joiner.entity.Organizer;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public class OrganizerDaoImpl extends HibernateDaoSupport implements OrganizerDao {
    @Override
    public String addOrganizer(Organizer organizer) {
        String success = "";
        String name = organizer.getOrganizerName();
        if(findOrganizersByName(name).size() == 0){
            try {
                getHibernateTemplate().save(organizer);
                success = "Organizer saved ok!";
            } catch (DataAccessException e) {
                success = "Sorry, organizer can't be added.";
            }
        } else {
            success = "The organizer name has been existed!";
        }
        return success;
    }

    @Override
    public Organizer findOrganizerById(String organizerId) {
        System.out.println("Searching organizer by id");
        List<Organizer> organizers = getHibernateTemplate().find("from Organizer where organizerId = ?", organizerId);
        if (1 > organizers.size()) {
            return null;
        } else {
            return organizers.get(0);
        }
    }

    @Override
    public List<Organizer> findOrganizersByName(String organizerName) {
        return getHibernateTemplate().find("from Organizer where organizerName = ?", organizerName);
    }

    @Override
    public List<Organizer> listAll() {
        return getHibernateTemplate().find("from Organizer");
    }
}
