package pl.pw.mini;

public class Problem {
	String content;
	String model_solution;
	int points;
	Subject main_subject;
	Problem(String content,String ms,int p){
		this.content = content;
		this.model_solution = ms;
		this.points = p;
	}
	public String getContent(){
		return this.content;
	}
	public int getPoints(){
		return this.points;
	}
	public String getModelSolution() {
		return this.model_solution;
	}
	protected void setMainSubject(Subject ms){
		this.main_subject = ms;
	}
	
}
