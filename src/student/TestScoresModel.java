package student;

public class TestScoresModel 
{
	private Student[] students;
	private int indexSelectedStudent;
	private int studentCount;
	
	public TestScoresModel()
	{
		indexSelectedStudent = -1;
		studentCount = 0;
		students = new Student[10];
	}
	
	public String add(Student s)
	{
		if(studentCount == students.length)
			return "SORRY: student list is full";
		else
		{
			students[studentCount] = s;
			indexSelectedStudent = studentCount;
			studentCount++;
			return null;
		}
	}
	
	public String replace(Student s)
	{
		if(indexSelectedStudent == -1)
			return "Must add a student first";
		else
		{
			students[indexSelectedStudent] = s;
			return null;
		}
	}
	
	public Student first()
	{
		Student s = null;
		if(studentCount == 0)
			indexSelectedStudent = -1;
		else
		{
			indexSelectedStudent = 0;
			s = students[indexSelectedStudent];
		}
		return s;
	}
	
	public Student previous()
	{
		Student s = null;
		if(studentCount == 0)
			indexSelectedStudent = -1;
		else
		{
			indexSelectedStudent = Math.max(0, indexSelectedStudent - 1);
			s = students[indexSelectedStudent];
		}
		return s;
	}
	
	public Student next()
	{
		Student s = null;
		if(studentCount == 0)
			indexSelectedStudent = -1;
		else
		{
			indexSelectedStudent = Math.min(studentCount -1,  indexSelectedStudent +1);
			s = students[indexSelectedStudent];
		}
		return s;
	}
}
