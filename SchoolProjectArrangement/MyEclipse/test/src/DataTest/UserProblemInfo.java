package DataTest;

public class UserProblemInfo {
	private String problem;
	private String ProductID;
	private String answer;
	
	public UserProblemInfo(String problem,String answer,String ProductID) {
		this.problem=problem;
		this.ProductID=ProductID;
		this.answer=answer;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
