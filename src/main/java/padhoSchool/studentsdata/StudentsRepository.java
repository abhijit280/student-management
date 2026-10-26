package padhoSchool.studentsdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentsRepository {

	String url = "jdbc:mysql://__________/student_db";
	String userName = "root";
	String pass = "__________";
	public void addStudent(String name,String email, int age) {
		String query = "insert into students (name, email, age) values (?,?,?)";
		try (Connection connection = DriverManager.getConnection(url, userName, pass);
				PreparedStatement psmt = connection.prepareStatement(query);){
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setInt(3, age);
			int update = psmt.executeUpdate();
			if (update == 1) {
				System.out.println("Student add succesful...");
			}else {
				System.out.println("failed to add student");
			}
		} catch (Exception e) {
			System.out.println("Connection failed ...");
			e.printStackTrace();
		}
	}
	public void updateStudent(int id, String name,String email, int age) {
		String query = "update students set name=?,email=?,age=? where id=?";
		try (Connection connection = DriverManager.getConnection(url, userName, pass);
				PreparedStatement psmt = connection.prepareStatement(query);){
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setInt(3, age);
			psmt.setInt(4, id);
			int update = psmt.executeUpdate();
			if (update == 1 ) {
				System.out.println("Student data update succesful...");
			}else {
				System.out.println("failed to update student");
			}
		} catch (Exception e) {
			System.out.println("Connection failed ...");
			e.printStackTrace();
		}
	}
	
	public void veiwAllStudents() {
		String query = "select * from students";
//		boolean result = false;
		try (Connection connection = DriverManager.getConnection(url, userName, pass);
				PreparedStatement psmt = connection.prepareStatement(query);){
			ResultSet resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				do {
					int id = resultSet.getInt("id");
					int age = resultSet.getInt("age");
					String name = resultSet.getString("name");
					String email = resultSet.getString("email");
					System.out.println("=============================");
					System.out.println("ID: " + id);
					System.out.println("Age: " + age);
					System.out.println("Name: " + name);
					System.out.println("Email: " + email);
					System.out.println("=============================");
				}while (resultSet.next());
			} else {
				System.out.println("student data is empty ...");
			}
			
		} catch (Exception e) {
			System.out.println("Connection failed ...");
			e.printStackTrace();
		}
	} 
	public void deleteStudent(int id) {
		String query = "delete from students where id=?";
		try (Connection connection = DriverManager.getConnection(url, userName, pass);
				PreparedStatement psmt = connection.prepareStatement(query);){
			psmt.setInt(1, id);
			int update = psmt.executeUpdate();
			if (update == 1) {
				System.out.println("delete Student successful ....");
			}else {
				System.out.println("failed delete ....");
			}
		} catch (Exception e) {
			System.out.println("Connection failed ...");
			e.printStackTrace();
		}
		
	}
	public void findStudentByName(String name) {
		String query = "select * from students where name like ?";//this is the partial search by the query.
		try (Connection connection = DriverManager.getConnection(url, userName, pass);
				PreparedStatement psmt = connection.prepareStatement(query);){
			psmt.setString(1, "%" + name + "%"); // this is the placeholder for Dynamic search. 
			ResultSet resultSet = psmt.executeQuery();
			if (resultSet.next()) {
				do {
				int id = resultSet.getInt("id");
				int age = resultSet.getInt("age");
				String name1 = resultSet.getString("name");
				String email = resultSet.getString("email");
				System.out.println("=============================");
				System.out.println("ID: " + id);
				System.out.println("Age: " + age);
				System.out.println("Name: " + name1);
				System.out.println("Email: " + email);
				System.out.println("=============================");
				}while(resultSet.next());
			} else {
				System.out.println(name+" : Student not found ...");
			}
		} catch (Exception e) {
			System.out.println("Connection failed ...");
			System.out.println("please reconnect the connection");
			e.printStackTrace();
		}
		
		
	}
}
