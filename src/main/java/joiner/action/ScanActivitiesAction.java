package joiner.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import joiner.entity.Activity;
import joiner.service.ActivityService;
import joiner.util.InitApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by distanceN on 2015/6/14.
 */
public class ScanActivitiesAction extends ActionSupport {
    private ActivityService activityService;

    public ScanActivitiesAction() {
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        activityService = (ActivityService) context.getBean("activityService");
    }

    @Override
    public String execute() throws Exception {
        System.out.println("ScanActivitiesAction triggered");
        List<Activity> activityList = activityService.listAll();
        ActionContext.getContext().getSession().put("activityList" , activityList);
        for (Activity a : activityList) {
            System.out.println("id: " + a.getActivityId());
            System.out.println("name: " + a.getActivityName());
            System.out.println("organizer: " + a.getOrganizerName());
            System.out.println();
        }
        return SUCCESS;
    }

    public ActivityService getActivityService() {
        return activityService;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
}
