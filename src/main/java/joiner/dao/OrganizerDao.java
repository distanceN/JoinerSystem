package joiner.dao;

import joiner.entity.Organizer;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public interface OrganizerDao {
    public String addOrganizer(Organizer organizer);
    public Organizer findOrganizerById(String organizerId);
    public List<Organizer> findOrganizersByName(String organizerName);
    public List<Organizer> listAll();
}
