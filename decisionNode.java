import java.io.BufferedWriter;
import java.io.IOException;

public class decisionNode implements treeNode{//leaf node
	protected String decision;	
	
	public String getDecision() {
		return decision;
	}


	public void setDecision(String decision) {
		this.decision = decision;
	}


	public void printNode(BufferedWriter writeF) throws IOException {//writes decision
		writeF.write("decision node\n"+decision+"\n");
	}
}
