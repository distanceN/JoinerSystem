package joiner.entity;

import java.io.Serializable;

/**
 * Created by distanceN on 2015/6/14.
 */
public class Link implements Serializable{
    String studentId;
    String activityId;

    public String getStudentId() {
        return studentId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getLinkId() {
        return studentId + activityId;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((activityId == null) ? 0 : activityId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Link other = (Link) obj;
        if (activityId == null)
        {
            if (other.activityId != null)
                return false;
        }
        else if (!activityId.equals(other.activityId))
            return false;
        if (studentId == null)
        {
            if (other.studentId != null)
                return false;
        }
        else if (!studentId.equals(other.studentId))
            return false;
        return true;
    }
}
