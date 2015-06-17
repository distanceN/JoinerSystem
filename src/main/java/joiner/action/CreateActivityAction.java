package joiner.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import joiner.entity.Activity;
import joiner.service.ActivityService;
import joiner.util.InitApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Feizhou on 2015/6/14.
 */

public class CreateActivityAction extends ActionSupport{
    private Activity activity;
    private ActivityService activityService;
    public CreateActivityAction() {
        System.out.println("CreateActivityAction constructing");
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        activityService = (ActivityService) context.getBean("activityService");
    }
    @Override
    public String execute() throws Exception {
        String organizer = activity.getOrganizerName();
        System.out.println(organizer);
        if(!isValid(organizer)|| !isValid(activity.getActivityName())){
            System.out.println("organizer name or activity name is not valid");
            return INPUT;
        }
        if(!createActivity(activity)) {
            System.out.println("Create Error");
            return INPUT;
        }
        List<Activity> activityList = activityService.findActivitysByOrganizer(activity.getOrganizerName());
        ActionContext.getContext().getSession().put("activityList" , activityList);
        return SUCCESS;
    }

    public boolean isValid(String keyword) {
        return keyword != null && keyword != "";
    }
    public boolean createActivity(Activity myActivity) {
        if(!activityService.addActivity(myActivity)) {
            System.out.println("Can not add this activity!");
            return false;
        }
        System.out.println("Have added this activity!");
        return true;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public Activity getActivity() {
        return this.activity;
    }
}
