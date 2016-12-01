import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject{
	private Date midtermDate;

	public CourseEvent(Object arg0) {
		super(arg0);
		midtermDate = (Date) arg0;
	}
	
	public Date getDate(){
		return midtermDate;
	}
}
