package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.StudentService;
import com.example.demo.entities.Student;

@Controller
@RequestMapping("/Student")
public class StudentController {
	@Autowired
	private StudentService StudentService;

	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	@PostMapping("saveStudent")
	public String registerStudent(@ModelAttribute Student Student,Model model) {
		
		Integer sId=StudentService.saveStudent(Student);
		String msg="Student registered ";
		model.addAttribute("message",msg);
		
		return "register";
	}
	@GetMapping("/show")
	public String showAllStudent(Model model) {
		
		List<Student> Student=StudentService.getAllStudent();
		model.addAttribute("Student",Student);
		return "show_Student";
	}
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("empId") Integer empId, Model model) {
		StudentService.delbyId(empId);
		List<Student> Student = StudentService.getAllStudent();
		model.addAttribute("Student", Student);
		return "show_Student";
	}
	@GetMapping("/edit")
	public String showEdit(@RequestParam("empId") Integer empId, Model model) {
		Optional<Student> Student = StudentService.getOneStudent(empId);
		model.addAttribute("Student", Student);
		return "edit_Student";
	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student Student,Model model) {
		Integer empId = StudentService.updateStudent(Student);
		String message = "Student Updated, Id : " + empId;
		List<Student> emp = StudentService.getAllStudent();
		model.addAttribute("Student", emp);
		model.addAttribute("message", message);
		return "show_Student";
	}
}

	

