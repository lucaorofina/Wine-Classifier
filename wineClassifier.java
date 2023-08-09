
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class wineClassifier {
	public static wine [] search;
		
	public static void main(String[] args) throws FileNotFoundException {
		String [] a = new String[12];//strings of wines attributes
		a[0] = "color";
		a[1] = "fixed acidity";
		a[2] = "volatile acidity";
		a[3] = "citric acid";
		a[4] = "residual sugar";
		a[5] = "chlorides";
		a[6] = "free sulfur";
		a[7] = "total sulfur";
		a[8] = "density";
		a[9] = "pH";
		a[10] = "sulphates";
		a[11] = "alcohol";
		
		Scanner red = null, white = null;
		try {
			red = new Scanner(new FileReader("winequality-red.csv"));
			white =  new Scanner(new FileReader("winequality-white.csv"));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Wine date set files not found. Program closing."); 
			System.exit(1);
		}
		
		RandomForest rf = new RandomForest(13,13,null);
		rf.loadData(red, white);
		search = rf.returnSet();
		
		Scanner read = null;
		try {
			read =  new Scanner(new FileReader("forestFileLOAD.txt"));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Random Forest file for classification not found.\nProgram closing."); 
			System.exit(1);
		}
		rf.readForest(read);
		
		float defaultVal[] = new float[11];
		for(int i = 0; i<11; i++)
			defaultVal[i] = 0;
		
		for(int av = 0; av<search.length; av++) {
			defaultVal[0] += search[av].getFixedAcidity();
			defaultVal[1] += search[av].getVolatileAcidity();
			defaultVal[2] += search[av].getCitricAcid();
			defaultVal[3] += search[av].getResidualSugar();
			defaultVal[4] += search[av].getChlorides();
			defaultVal[5] += search[av].getFreeSulfur();
			defaultVal[6] += search[av].getTotalSulfur();
			defaultVal[7] += search[av].getDensity();
			defaultVal[8] += search[av].getpH();
			defaultVal[9] += search[av].getSulphates();
			defaultVal[10] += search[av].getAlcohol();
		}
		
		//order of default values is same for string of attributes(excluding color)
		defaultVal[0] /= (float)search.length;
		defaultVal[1] /= (float)search.length;
		defaultVal[2] /= (float)search.length;
		defaultVal[3] /= (float)search.length;
		defaultVal[4] /= (float)search.length;
		defaultVal[5] /= (float)search.length;
		defaultVal[6] /= (float)search.length;
		defaultVal[7] /= (float)search.length;
		defaultVal[8] /= (float)search.length;
		defaultVal[9] /= (float)search.length;
		defaultVal[10] /= (float)search.length;
		
		
		GUISwitch wg = new GUISwitch(rf, defaultVal);
		read.close();
	}
	    
	public static wine findWine(wine q) {
		int sim;
		float comp;
		for(int j=0; j<6497; j++){ //size of dataset
			sim=0;
			if(q.getType().equals (search[j].getType())) //Wine color is string
				sim++;	
					
			comp = (q.getAlcohol()/10.0f); //10% of the input
			//if wine is + or - 10% of given wine it has similar value for attribute
			if(q.getAlcohol()-comp <= (search[j].getAlcohol()) && (q.getAlcohol()+comp)>=(search[j].getAlcohol()))
				sim++;

			comp =(q.getFixedAcidity()/10.0f);
			if(q.getFixedAcidity()-comp <= (search[j].getFixedAcidity()) && (q.getFixedAcidity()+comp) >= (search[j].getFixedAcidity()))
				sim++; 

				
			comp = (q.getVolatileAcidity()/10.0f);
			if(q.getVolatileAcidity()-comp <= (search[j].getVolatileAcidity()) && (q.getVolatileAcidity()+comp) >= (search[j].getVolatileAcidity()))
				sim++;

			comp = (q.getCitricAcid()/10.0f);
			if(q.getCitricAcid()-comp<=(search[j].getCitricAcid()) && (q.getCitricAcid()+comp) >= (search[j].getCitricAcid()))
				sim++;

			comp= (q.getResidualSugar()/10.0f);
			if(q.getResidualSugar()-comp <= (search[j].getResidualSugar()) && (q.getResidualSugar()+comp) >= (search[j].getResidualSugar()))
				sim++;

			comp = (q.getChlorides()/10.0f);
			if(q.getChlorides()-comp <= (search[j].getChlorides()) && (q.getChlorides()+comp) >= (search[j].getChlorides()))
				sim++;

			comp = (q.getFreeSulfur()/10.0f);
			if(q.getFreeSulfur()-comp <= (search[j].getFreeSulfur()) && (q.getFreeSulfur()+comp) >= (search[j].getFreeSulfur()))
				sim++;

			comp = (q.getTotalSulfur()/10.0f);
			if(q.getTotalSulfur()-comp <= (search[j].getTotalSulfur()) && (q.getTotalSulfur()+comp) >= (search[j].getTotalSulfur()))
				sim++;

			comp = (q.getDensity()/10.0f);
			if(q.getDensity()-comp <= (search[j].getDensity()) && (q.getDensity()+comp) >= (search[j].getDensity()))
				sim++;

			comp = (q.getpH()/10.0f);
			if(q.getpH()-comp <= (search[j].getpH()) && (q.getpH()+comp) >= (search[j].getpH()))
				sim++;
			
			comp = (q.getSulphates()/10.0f);
			if(q.getSulphates()-comp <= (search[j].getSulphates()) && (q.getSulphates()+comp)>=(search[j].getSulphates()))
				sim++;

			if(sim>=7) //if there are at least 7 similarities between wines, return as answer
				return search[j];
			}
			return null;//no similar wine found
	}
}
