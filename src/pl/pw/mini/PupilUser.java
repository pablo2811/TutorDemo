package pl.pw.mini;

import java.util.HashSet;
import java.util.Set;

public class PupilUser{
	String username;
	int points;
	Gender g;
	int age;
	Set<Subject> favourite_subjects;
	Set<Subtopic> favourite_subtopics;
	Set<PupilUser> friends;
	
	PupilUser(String username,int points,Gender g,int age){
		this.username = username;
		this.points = points;
		this.g = g;
		this.age = age;
		favourite_subjects = new HashSet<>();
		favourite_subtopics = new HashSet<>();
	}
	public void add_favsubj(Subject subj){
		favourite_subjects.add(subj);
	}
	public void add_favsubt(Subtopic subt){
		favourite_subtopics.add(subt);
	}
	
	
	enum Gender{
		MALE,
		FEMALE,
		NONBINARY
	}
	
	
	

}
