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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by distanceN on 2015/6/16.
 */
public class SeeJoinedAction extends ActionSupport {
    private StudentService studentService;
    private Student student1;
    private ActivityService activityService;
    private Activity activity;
    private LinkService linkService;
    public SeeJoinedAction() {
        System.out.println("SeeJoinedAction constructing");
        ApplicationContext context = InitApplicationContext.getApplicationContext();
        System.out.println("Context ok");
        studentService = (StudentService) context.getBean("studentService");
        activityService = (ActivityService) context.getBean("activityService");
        linkService = (LinkService) context.getBean("linkService");
    }
    @Override
    public String execute() throws Exception {
        if (student1 == null) {
            System.out.println("student is null");
        }
        System.out.println(student1.getStudentId());
        if (!isValid(student1.getStudentId())) {
            System.out.println("ERROR in get student id");
            return INPUT;
        }

        System.out.println("SUCCESS");
        ActionContext.getContext().getSession().put("student" , student1);

        List<Link> links = linkService.findActivitiesByStudent(student1.getStudentId());
        List<Activity> activityList = new ArrayList<Activity>();
        for (Link link : links) {
            activityList.add(activityService.findActivityById(link.getActivityId()));
        }
        ActionContext.getContext().getSession().put("activityList2", activityList);
        return SUCCESS;
    }
    public boolean isValid(String keyword) {
        return keyword != null && keyword != "";
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public Student getStudent1() {
        return student1;
    }

    public ActivityService getActivityService() {
        return activityService;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setStudent1(Student student) {
        this.student1 = student;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LinkService getLinkService() {
        return linkService;
    }

    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }
}