package com.nep.myfirstwebapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nep.myfirstwebapp.model.Group;
import com.nep.myfirstwebapp.model.GroupRepo;
import com.nep.myfirstwebapp.model.Student;
import com.nep.myfirstwebapp.model.StudentRepo;

@Controller
public class MainController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	GroupRepo groupRepo;

	@GetMapping(value="/")
	public String index(ModelMap modelMap) {
		Iterable<Student> studentsList = studentRepo.findAll();
		modelMap.put("studentsList", studentsList);
		return "students";
	}
	
	@GetMapping(value="/groups")
	public String showGroups(ModelMap modelMap) {
		Iterable<Group> groups = groupRepo.findAll();
		modelMap.put("groups", groups);
		return "groups";
	}
	
	@GetMapping(value="/editgroup")
	public String showEditGroup() {
		return "edit_group";
	}
	
	@GetMapping(value="/editstudent")
	public String showEditStudent() {
		return "edit_student";
	}
	
	@GetMapping(value="/addstudent")
	public String showAddStudent(
			ModelMap modelMap
			) {
		Iterable<Group> groups = groupRepo.findAll();
		modelMap.put("groups", groups);
		return "add_student";
	}
	
	@PostMapping(value="/addstudent")
	public String addStudent(
			@RequestParam String full_name,
			@RequestParam long group
			) {
		Optional<Group> selectedGroup = groupRepo.findById(group);
		if(!selectedGroup.isEmpty()) {			
			Student newStudent = 
					new Student(full_name, selectedGroup.get());
			studentRepo.save(newStudent);
		}
		return "redirect:/";
	}
	
	@PostMapping(value="/addgroup")
	public String addGroup(
			@RequestParam String group_code,
			@RequestParam String programme
			) {
		Group newGroup = new Group(group_code, programme);
		groupRepo.save(newGroup);
		return "redirect:/groups";
	}
	
	@GetMapping(value="/deletegroup/{id}")
	public String deleteGroup(
			@PathVariable long id
			) {
		groupRepo.deleteById(id);
		return "redirect:/groups";
	}
	
	@GetMapping(value="/editgroup/{id}")
	public String showEditGroup(
			ModelMap modelMap,
			@PathVariable long id
			) {
//		Group group = groupRepo.findById(id).get();
		Optional<Group> group = groupRepo.findById(id);
		if(group.isEmpty()) {
			return "redirect:/groups";
		} else {			
			modelMap.put("group", group.get());
			return "edit_group";
		}
	}
	
	@PostMapping(value="/editgroup/{id}")
	public String editGroup(
			@PathVariable long id,
			@RequestParam String group_code,
			@RequestParam String programme
			) {
		Optional<Group> group = groupRepo.findById(id);
		if(!group.isEmpty()) {
			Group editGroup = group.get();
			editGroup.setGroupCode(group_code);
			editGroup.setProgrammeName(programme);
			groupRepo.save(editGroup);
		}
		return "redirect:/groups";
	}
	
//	@PostMapping(value="/add_student")
//	public String addStudent(
//			@RequestParam String first_name,
//			@RequestParam String last_name
//			) {
//		Student student = new Student(first_name, last_name);
//		studentRepo.save(student);
//		return "redirect:/";
//	}
	
}
