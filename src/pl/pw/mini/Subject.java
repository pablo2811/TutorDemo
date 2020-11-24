package pl.pw.mini;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject{
	
	List<Subtopic> all_subtopics;
	Map<Level,List<Subtopic>> categorized_subtopics;
	String subject_name;
	
	public Subject(String name){
		all_subtopics = new ArrayList<>();
		categorized_subtopics = new HashMap<>();
		subject_name = name;
	}
	protected void add_subtopic(Subtopic s){
		if(!all_subtopics.contains(s)){
			all_subtopics.add(s);
			if(categorized_subtopics.containsKey(s.level)) {
				categorized_subtopics.get(s.level).add(s);
			}else{
				categorized_subtopics.put(s.level, new ArrayList<Subtopic>());
				categorized_subtopics.get(s.level).add(s);
			}
		}
	}
	
	
	
}
