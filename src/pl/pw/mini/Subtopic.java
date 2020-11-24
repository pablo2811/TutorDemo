package pl.pw.mini;

import java.util.ArrayList;
import java.util.List;

public class Subtopic {
	Level level;
	List<Problem> problems;
	String name;
	Subtopic(String name, Level l){
		level = l;
		problems = new ArrayList<>();
		this.name = name;
	}
}
