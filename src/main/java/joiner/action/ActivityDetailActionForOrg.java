package joiner.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import joiner.entity.Activity;
import joiner.entity.Link;
import joiner.service.ActivityService;
import joiner.service.LinkService;
import joiner.util.InitApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Feiz on 2015/6/14.
 */
public class ActivityDetailActionForOrg extends ActionSupport {
    private ActivityService activityService;
    private Activity activity;
    private LinkService linkService;
    public ActivityDetailActionForOrg() {
        System.out.println("ActivityDetailActionForOrg constructing");
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        activityService = (ActivityService) context.getBean("activityService");
        linkService = (LinkService) context.getBean("linkService");
    }
    @Override
    public String execute() throws Exception {
        System.out.println("Begin");
        Activity myActivity = activityService.findActivityById(activity.getActivityId());
        List<Link> students = linkService.findStudentsByActivity(activity.getActivityId());
        ActionContext.getContext().getSession().put("activity" , myActivity);
        ActionContext.getContext().getSession().put("studentList",students);
        System.out.println("SUCCESS");
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