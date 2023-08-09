import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RandomForest {
	private int treeNum;//number of trees to create (pick odd number to prevent ties)
	private decisionTree forest[];//set size to treeNum
	private int maxDepth;//max depth each tree can get
	private String attributes[];// all possible attributes
	private wine dataSet[];//all data from dataset, not subset (total wine , red + white, = 6497)
	private int setSize;//dataset size forest has
	private int treeDataSize;//amount from dataset each tree receives
	
	RandomForest(int tree, int depth, String at[]){
		treeNum = tree;
		maxDepth = depth;
		attributes = at;
		forest = new decisionTree[treeNum];
	}

	public wine[] returnSet(){
		return dataSet;
	}
	
	public void loadData(Scanner red, Scanner white) {//given data set is divided into 2 files (1 for red, 1 for white)
		int i = 0;
		dataSet = new wine[6497];//given 1599 red and 4898 white
		String s;
		String [] atr;
		wine in;
		int q;
		//files are csv files, first line is order of attributes
		//data set has no missing attributes
		s = red.nextLine();
		while(red.hasNextLine()) {
			s = red.nextLine();
			atr = s.split(";");
			in = new wine();
			in.setFixedAcidity(Float.parseFloat(atr[0]));
			in.setVolatileAcidity(Float.parseFloat(atr[1]));
			in.setCitricAcid(Float.parseFloat(atr[2]));
			in.setResidualSugar(Float.parseFloat(atr[3]));
			in.setChlorides(Float.parseFloat(atr[4]));
			in.setFreeSulfur(Float.parseFloat(atr[5]));
			in.setTotalSulfur(Float.parseFloat(atr[6]));
			in.setDensity(Float.parseFloat(atr[7]));
			in.setpH(Float.parseFloat(atr[8]));
			in.setSulphates(Float.parseFloat(atr[9]));
			in.setAlcohol(Float.parseFloat(atr[10]));
			
			q = Integer.parseInt(atr[11]);
			if(q > 6)
				in.setQuality(1);//good quality
			else
				in.setQuality(0);//bad quality
			
			in.setType("red");
			dataSet[i] = in;
			i++;
		}
		
		s = white.nextLine();
		
		while(white.hasNextLine()) {
			s = white.nextLine();
			atr = s.split(";");
			in = new wine();
			in.setFixedAcidity(Float.parseFloat(atr[0]));
			in.setVolatileAcidity(Float.parseFloat(atr[1]));
			in.setCitricAcid(Float.parseFloat(atr[2]));
			in.setResidualSugar(Float.parseFloat(atr[3]));
			in.setChlorides(Float.parseFloat(atr[4]));
			in.setFreeSulfur(Float.parseFloat(atr[5]));
			in.setTotalSulfur(Float.parseFloat(atr[6]));
			in.setDensity(Float.parseFloat(atr[7]));
			in.setpH(Float.parseFloat(atr[8]));
			in.setSulphates(Float.parseFloat(atr[9]));
			in.setAlcohol(Float.parseFloat(atr[10]));
			
			q = Integer.parseInt(atr[11]);
			if(q > 6)
				in.setQuality(1);//good quality
			else
				in.setQuality(0);//bad quality
			
			in.setType("white");
			dataSet[i] = in;
			i++;
		}
		
		setSize = 6497;
	}
	
	
	
	public void buildForest(){
		treeDataSize = (setSize * 2)/3;
		int a = attributes.length;
		Random r = new Random();//random number generator
		wine [] dataR;
		int x;//number of attributes for singular tree
		boolean [] selected = new boolean[a];//array for all possible attributes
		int s;//an selected attribute
		
		for(int i = 0; i<treeNum; i++) {//create each tree
			for(int j = 0; j<a; j++)//set to no selected attributes for tree to be created
				selected[j] = false;
			
			x = r.nextInt(a);//0-(attributes-1)
			x++;//1 - attributes
			
			int k = 0;
			if(x == 12) {//if tree would take all attributes
				k = 12;
				for(int m = 0; m<12; m++)
					selected[m] = true;
			}
			
			while(k<x) {//select attributes randomly
				s = r.nextInt(a);//select attribute by index
				if(selected[s] == false) {//select x amount of different attributes
					selected[s] = true;
					k++;
				}
			}
	
			String [] atrTree = new String[x];
			k = 0;
			for(int apply = 0; apply<a; apply++) {//array of selected attributes
				if(selected[apply]) {
					atrTree[k] = attributes[apply];
					k++;
				}
			}
			
			dataR = new wine[treeDataSize];
			//create data subset from determined size(can include repeats of the same instance)
			for(int d = 0; d<treeDataSize; d++)
				dataR[d] = dataSet[(r.nextInt(dataSet.length))];//select random wine in data set
			
			forest[i] = new decisionTree(maxDepth, atrTree, dataR);
			forest[i].buildTree();
		}
	}
	
	
	public String test(wine w) {
		String answer;
		int class1 = 0;//good
		int class2 = 0;//bad
		for(int i = 0; i<treeNum; i++) {
			answer = forest[i].test(w);
			if(answer.equals("good quality"))
				class1++;
			else
				class2++;
		}
		
		if(class1 > class2)//return majority answer
			return "good quality";
		return "bad quality";
	}
	
	public void writeForest(BufferedWriter writeF) throws IOException {
		writeF.write("Random forest for Wines\n"+treeNum+"\n\n");
		for(int i = 0; i<treeNum; i++)
			forest[i].printTree(writeF);
	}
	
	public void readForest(Scanner read) {
		String r = read.nextLine();
		r = read.nextLine();
		treeNum = Integer.parseInt(r);
		forest =  new decisionTree[treeNum];
		for(int i = 0; i<treeNum; i++) {
			forest[i] = new decisionTree(maxDepth, null, null);
			
			r = read.nextLine();//skip empty line
			forest[i].readTree(read);
		}
	}
	
	public wine getWine() {
		Random r = new Random();
		int x = r.nextInt(setSize);
		return dataSet[x];
	}
}
