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
public class SearchActivityAction extends ActionSupport {
    private ActivityService activityService;
    private Activity activity;
    public SearchActivityAction() {
        System.out.println("SearchActivityAction constructing");
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        activityService = (ActivityService) context.getBean("activityService");
    }
    @Override
    public String execute() throws Exception {
        System.out.println(activity.getActivityName());
        if (!isValid(activity.getActivityName())) {
            System.out.println("ERROR in get activity name");
            return INPUT;
        }
        List<Activity> activityList = activityService.findActivitysByName(activity.getActivityName());
        ActionContext.getContext().getSession().put("activityList" , activityList);
        for (Activity a : activityList) {
            System.out.println("id: " + a.getActivityId());
            System.out.println("name: " + a.getActivityName());
            System.out.println("organizer: " + a.getOrganizerName());
            System.out.println();
        }
        return SUCCESS;
    }
    public boolean isValid(String keyword) {
        return keyword != null && keyword != "";
    }

    public ActivityService getActivityService() {
        return activityService;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
