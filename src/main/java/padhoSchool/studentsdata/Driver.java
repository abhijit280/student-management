package padhoSchool.studentsdata;

public class Driver {

	public static void main(String[] args) {
		StudentsRepository repository = new StudentsRepository();
		StudentsRepository repository1 = new StudentsRepository();
//		for (int i = 0; i < 10; i++) {
//			repository.addStudent("Abhijit"+i, +i+"abhi@GMAIL.COM", 25);
//		}
		
	//	repository.updateStudent(3, "pradhan", "abhi@gmail.com", 26);
		repository.veiwAllStudents();
	//	repository.deleteStudent(2) ;
		repository1.findStudentByName("dhan");
	}

}
