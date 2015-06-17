package joiner.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import joiner.entity.Activity;
import joiner.entity.Link;
import joiner.entity.Student;
import joiner.service.ActivityService;
import joiner.service.LinkService;
import joiner.service.StudentService;
import joiner.util.InitApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by distanceN on 2015/6/14.
 */
public class ActivityDetailForStuAction extends ActionSupport {
    private ActivityService activityService;
    private Activity activity;
    private StudentService studentService;
    private Student student;
    private LinkService linkService;
    public ActivityDetailForStuAction() {
        System.out.println("ActivityDetailActionForStu constructing");
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        activityService = (ActivityService) context.getBean("activityService");
        studentService = (StudentService) context.getBean("studentService");
        linkService = (LinkService) context.getBean("linkService");
    }
    @Override
    public String execute() throws Exception {
        System.out.println(activity.getActivityId());
        if (!isValid(activity.getActivityId())) {
            System.out.println("ERROR in get activity id");
            return INPUT;
        }
        Activity checkActivity = activityService.findActivityById(activity.getActivityId());
        if (checkActivity == null) {
            System.out.println("No such activity with activity id: "
                    + activity.getActivityId());
            return ERROR;
        }
        System.out.println(checkActivity.getDescription());
        System.out.println("SUCCESS");
        ActionContext.getContext().getSession().put("activity", checkActivity);
        ActionContext.getContext().getSession().put("student", student);

        Link link = new Link();
        link.setActivityId("");
        List<Link> linksWithStudent = linkService.findActivitiesByStudent(student.getStudentId());
        for (Link l : linksWithStudent) {
            if (l.getActivityId().equals(activity.getActivityId())) {
                System.out.println("Link " + l.getActivityId() + " and " + l.getStudentId());
                link = l;
                break;
            }
        }
        ActionContext.getContext().getSession().put("link", link);
        System.out.println("Link has been put");

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

    public StudentService getStudentService() {
        return studentService;
    }

    public Student getStudent() {
        return student;
    }

    public LinkService getLinkService() {
        return linkService;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }
}