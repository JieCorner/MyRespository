package com.javabean;

public class Problem {
	private String problem;
	private String answer;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Problem(String problem,String answer,String username){
		this.problem=problem;
		this.answer=answer;
		this.username=username;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
