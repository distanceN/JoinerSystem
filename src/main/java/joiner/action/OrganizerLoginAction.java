package joiner.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import joiner.entity.Activity;
import joiner.entity.Organizer;
import joiner.service.ActivityService;
import joiner.service.OrganizerService;
import joiner.util.InitApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by distanceN on 2015/6/13.
 */
public class OrganizerLoginAction extends ActionSupport {
    private ActivityService activityService;
    private OrganizerService organizerService;
    private Organizer organizer;
    public OrganizerLoginAction() {
        System.out.println("OrganizerLoginAction constructing");
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        organizerService = (OrganizerService) context.getBean("organizerService");
        activityService = (ActivityService) context.getBean("activityService");
    }
    @Override
    public String execute() throws Exception {
        System.out.println(organizer.getOrganizerName());
        if (!isValid(organizer.getOrganizerId())) {
            System.out.println("ERROR in get organizer name");
            return INPUT;
        }
        if (!isValid(organizer.getOrganizerPassword())) {
            System.out.println("ERROR2 in get organizer password");
            return INPUT;
        }
        if(!organizerCheck(organizer)){
            System.out.println("ERROR in check organizer");
            return ERROR;
        }
        System.out.println("SUCCESS");
        List<Activity> activityList = activityService.findActivitysByOrganizer(organizer.getOrganizerName());
        ActionContext.getContext().getSession().put("organizer" , organizer);
        ActionContext.getContext().getSession().put("activityList" , activityList);
        return SUCCESS;
    }
    public boolean isValid(String keyword) {
        return keyword != null && keyword != "";
    }
    public boolean organizerCheck(Organizer organizer) {
        System.out.print("Inside organizer check, organizer id: ");
        System.out.println(organizer.getOrganizerId());
        Organizer checkOrganizer = organizerService.findOrganizerById(organizer.getOrganizerId());
        if (checkOrganizer == null) {
            System.out.println("No such organizer with organizer id: "
                    + organizer.getOrganizerId());
            return false;
        }
        System.out.println("Organizer name: " + checkOrganizer.getOrganizerName()
                + "\nOrganizer Id: " + checkOrganizer.getOrganizerId()
                + "\npassword: " + checkOrganizer.getOrganizerPassword());
        if (checkOrganizer.getOrganizerId().equals(organizer.getOrganizerId())
                && checkOrganizer.getOrganizerPassword().equals(organizer.getOrganizerPassword())) {
            organizer.setOrganizerName(checkOrganizer.getOrganizerName());
            System.out.println("Organizer id and password correct!");
            return true;
        }
        System.out.println("Organizer name or organizer password is wrong, please check!");
        return false;
    }

    public OrganizerService getOrganizerService() {
        return organizerService;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizerService(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}