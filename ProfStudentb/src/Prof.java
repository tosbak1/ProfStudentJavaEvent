/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof {
	private String name;
	private Date midtermDate;
	private ArrayList<Student> students;
	private ArrayList<CourseListener> courseListeners;
	private TeachingAssistant ta;

	public Prof(String aName) {
		this.name = aName;
		this.courseListeners = new ArrayList<CourseListener>();
	}
	
	 public synchronized void addCourseListener (CourseListener cl){
			courseListeners.add(cl);
		}

	 public synchronized void removeCourseListener (CourseListener cl) {
			courseListeners.remove(cl);
		}


	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {

		CourseEvent e = new CourseEvent(date);
		for(CourseListener c1: courseListeners){
			c1.midtermAnnounced(e);
		}
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		CourseEvent e = new CourseEvent(date);
		for(CourseListener c1: courseListeners){
			c1.midtermPostponed(e);
		}

	}
	
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}
	
	


	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addCourseListener(s);
		p.addCourseListener(s2);
		p.addCourseListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}