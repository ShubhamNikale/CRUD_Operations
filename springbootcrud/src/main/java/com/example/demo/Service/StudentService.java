package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;



@Service
public class StudentService {
	@Autowired
	private StudentRepository StudentRepo;
	
	public Integer saveStudent(Student Student) {
		Student s=StudentRepo.save(Student);
		return s.getsId();
	}
		public List<Student> getAllStudent(){
			List<Student> Student=StudentRepo.findAll();
			return Student;
		}
		public void delbyId(Integer sId) {
			StudentRepo.deleteById(sId);
		}
		public Optional<Student> getOneStudent(Integer id) {
			return StudentRepo.findById(id);
		}
		public Integer updateStudent(Student Student) {
			Student e = StudentRepo.save(Student);
			Integer sId = e.getsId();
			return sId;
		}


}
