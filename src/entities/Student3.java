package entities;

import java.util.Objects;

public class Student3 {

	private int studentID;

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public Student3(int studentID) {
		this.studentID = studentID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student3 other = (Student3) obj;
		return studentID == other.studentID;
	}
	
	
	
}
