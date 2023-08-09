import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUISwitch implements ActionListener{
	public String[] input = new String[12];
	JFrame popup;
	
	JComboBox Blee;
	JTextField FixedAcidity;
	JTextField VolatileAcidity;
	JTextField CitricAcid;
	JTextField ResidualSugar;
	JTextField Chlorides;
	JTextField FreeSulfurDioxide;
	JTextField TotalSulfurDioxide;
	JTextField Density;
	JTextField PH;
	JTextField Sulphates;
	JTextField Alcohol;
	
	JPanel B;
	JPanel F;
	JPanel V;
	JPanel C;
	JPanel R;
	JPanel Rs;
	JPanel Cl;
	JPanel Fs;
	JPanel Ts;
	JPanel D;
	JPanel P;
	JPanel S;
	JPanel A;
	
	String t1;
	String[] t2;
	String answer;
	JLabel classify;
	float [] d;
	wine wineIn;
	RandomForest rfWine;
	JPanel inGUI;//takes in wine inputs, moves to outputGUI
	JPanel outGUI;//displays wine classification, moves to inputGUI or similarGUI
	JPanel similarGUI;//displays a similar wine, moves to inputGUI or get another similar wine
	JTextField get1;
	JTextField get2;
	JTextField get3;
	JTextField get4;
	JTextField get5;
	JTextField get6;
	JTextField get7;
	JTextField get8;
	JTextField get9;
	JTextField get10;
	JTextField get11;
	JTextField get12;
	JTextField get13;
	//display errors using joptionpane
	
	GUISwitch(RandomForest forest, float [] def) {
		wineIn = new wine();
		d = def;
		rfWine = forest;
		popup = new JFrame();
		popup.setSize(690, 420);
		popup.setTitle("Wine Quality App");
		popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//popup.setLayout(new GridLayout(7, 3));
		popup.getContentPane().setBackground(new Color(140, 0, 52));
		
		inGUI = new JPanel();
		inGUI.setBackground(new Color(140, 0, 52));
		inGUI.setLayout(new GridLayout(7, 3));
		
		B = new JPanel();
		B.setBackground(new Color(140, 0, 52));
		F = new JPanel();
		F.setBackground(new Color(140, 0, 52));
		V = new JPanel();
		V.setBackground(new Color(140, 0, 52));
		C = new JPanel();
		C.setBackground(new Color(140, 0, 52));
		R = new JPanel();
		R.setBackground(new Color(140, 0, 52));
		Rs = new JPanel();
		Rs.setBackground(new Color(140, 0, 52));
		Cl = new JPanel();
		Cl.setBackground(new Color(140, 0, 52));
		Fs = new JPanel();
		Fs.setBackground(new Color(140, 0, 52));
		Ts = new JPanel();
		Ts.setBackground(new Color(140, 0, 52));
		D = new JPanel();
		D.setBackground(new Color(140, 0, 52));
		P = new JPanel();
		P.setBackground(new Color(140, 0, 52));
		S = new JPanel();
		S.setBackground(new Color(140, 0, 52));
		A = new JPanel();
		A.setBackground(new Color(140, 0, 52));
		
		JButton button = new JButton();
		button.setText("Test");
		button.addActionListener(this);
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(227, 83, 117));
		button.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		inGUI.add(new JLabel());
		inGUI.add(new JLabel());
		inGUI.add(new JLabel());
		inGUI.add(new JLabel());
		inGUI.add(B);
		inGUI.add(new JLabel());
		inGUI.add(F);
		inGUI.add(V);
		inGUI.add(C);
		inGUI.add(Fs);
		inGUI.add(Ts);
		inGUI.add(D);
		inGUI.add(P);
		inGUI.add(S);
		inGUI.add(A);
		inGUI.add(R);
		inGUI.add(button);
		inGUI.add(Cl);
		
		JLabel Bl = new JLabel("Color/Blee");
		String [] BleeStrings = {"red", "white"};
		Blee = new JComboBox(BleeStrings);
		Bl.setForeground(Color.WHITE);
		B.add(Bl);
		B.add(Box.createHorizontalStrut(15));
		Blee.setForeground(Color.WHITE);
		Blee.setBackground(new Color(227, 83, 117));
		Blee.setBorder(new LineBorder (new Color(227, 83, 117)));;
		B.add(Blee);
		
		JLabel FA = new JLabel("Fixed Acidity:");
		FixedAcidity = new JTextField(5);
		FA.setForeground(Color.WHITE);
		FixedAcidity.setForeground(Color.WHITE);
	    FixedAcidity.setBackground(new Color(227, 83, 117));
	    FixedAcidity.setBorder(new LineBorder (new Color(227, 83, 117)));;
		F.add(FA);
		F.add(FixedAcidity);
		
		
		JLabel VA = new JLabel("Volatile Acidity");
		VolatileAcidity = new JTextField(5);
		VA.setForeground(Color.WHITE);
		VolatileAcidity.setForeground(Color.WHITE);
		VolatileAcidity.setBackground(new Color(227, 83, 117));
		VolatileAcidity.setBorder(new LineBorder (new Color(227, 83, 117)));;
		V.add(VA);
		V.add(VolatileAcidity);
		
		
		JLabel CA = new JLabel("Citric Acid Amount");
		CitricAcid = new JTextField(5);
		CA.setForeground(Color.WHITE);
		CitricAcid.setForeground(Color.WHITE);
		CitricAcid.setBackground(new Color(227, 83, 117));
		CitricAcid.setBorder(new LineBorder (new Color(227, 83, 117)));;
		C.add(CA);
		C.add(CitricAcid);
		
		JLabel RS = new JLabel("Residual Sugar");
		ResidualSugar = new JTextField(5);
		RS.setForeground(Color.WHITE);
		ResidualSugar.setForeground(Color.WHITE);
		ResidualSugar.setBackground(new Color(227, 83, 117));
		ResidualSugar.setBorder(new LineBorder (new Color(227, 83, 117)));;
		R.add(RS);
		R.add(ResidualSugar);
		
		JLabel Ch = new JLabel("Chlorides");
		Chlorides = new JTextField(5);
		Ch.setForeground(Color.WHITE);
		Chlorides.setForeground(Color.WHITE);
		Chlorides.setBackground(new Color(227, 83, 117));
		Chlorides.setBorder(new LineBorder (new Color(227, 83, 117)));;
		Cl.add(Ch);
		Cl.add(Chlorides);
		
		JLabel FSD = new JLabel("Free Sulfur Dioxide");
		FreeSulfurDioxide = new JTextField(5);
		FSD.setForeground(Color.WHITE);
		FreeSulfurDioxide.setForeground(Color.WHITE);
		FreeSulfurDioxide.setBackground(new Color(227, 83, 117));
		FreeSulfurDioxide.setBorder(new LineBorder (new Color(227, 83, 117)));;
		Fs.add(FSD);
		Fs.add(FreeSulfurDioxide);
		
		JLabel TSD = new JLabel("Total Sulfur Dioxide");
		TotalSulfurDioxide = new JTextField(5);
		TSD.setForeground(Color.WHITE);
		TotalSulfurDioxide.setForeground(Color.WHITE);
		TotalSulfurDioxide.setBackground(new Color(227, 83, 117));
		TotalSulfurDioxide.setBorder(new LineBorder (new Color(227, 83, 117)));;
		Ts.add(TSD);
		Ts.add(TotalSulfurDioxide);
		
		JLabel Dn = new JLabel("Density");
		Density = new JTextField(5);
		Dn.setForeground(Color.WHITE);
		Density.setForeground(Color.WHITE);
		Density.setBackground(new Color(227, 83, 117));
		Density.setBorder(new LineBorder (new Color(227, 83, 117)));;
		D.add(Dn);
		D.add(Density);
		
		JLabel pH = new JLabel("Wine pH");
		PH = new JTextField(5);
		pH.setForeground(Color.WHITE);
		PH.setForeground(Color.WHITE);
		PH.setBackground(new Color(227, 83, 117));
		PH.setBorder(new LineBorder (new Color(227, 83, 117)));;
		P.add(pH);
		P.add(PH);
		 
		JLabel Su = new JLabel("Sulfates percentage");
		Sulphates = new JTextField(5);
		Su.setForeground(Color.WHITE);
		Sulphates.setForeground(Color.WHITE);
		Sulphates.setBackground(new Color(227, 83, 117));
		Sulphates.setBorder(new LineBorder (new Color(227, 83, 117)));
		S.add(Su);
		S.add(Sulphates);
		
		JLabel Al = new JLabel("Alcolhol Percentage");
		Alcohol = new JTextField(5);
		Al.setForeground(Color.WHITE);
		Alcohol.setForeground(Color.WHITE);
		Alcohol.setBackground(new Color(227, 83, 117));
		Alcohol.setBorder(new LineBorder (new Color(227, 83, 117)));
		A.add(Al);
		A.add(Alcohol);
		
		inGUI.setSize(690,400);
		popup.add(inGUI);
		popup.setVisible(true);
		
		outGUI = new JPanel();
		outGUI.setBackground(new Color(140, 0, 52));
		outGUI.setLayout(new GridLayout(3,3));
		outGUI.setSize(699, 499);
		
		JTextArea topT = new JTextArea("      This classifier has predicted your\n\twine to be");
		topT.setEditable(false);
		topT.setForeground(Color.WHITE);
		topT.setBackground(new Color(227, 83, 117));
		
		classify = new JLabel("",SwingConstants.CENTER);
		classify.setForeground(Color.WHITE);
		classify.setBackground(new Color(227, 83, 117));	
		
		JButton again = new JButton("Try another Wine");
		again.addActionListener(this);
		again.setForeground(Color.WHITE);
		again.setBackground(new Color(227, 83, 117));
		again.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		JButton recom = new JButton("Find similar Wine");
		recom.addActionListener(this);
		recom.setForeground(Color.WHITE);
		recom.setBackground(new Color(227, 83, 117));
		recom.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		
		outGUI.add(new JLabel());
		outGUI.add(topT);
		outGUI.add(new JLabel());
		outGUI.add(new JLabel());
		outGUI.add(classify);
		outGUI.add(new JLabel());
		outGUI.add(again);
		outGUI.add(new JLabel());
		outGUI.add(recom);
		
		similarGUI = new JPanel(new GridLayout(16, 1));
		similarGUI.setSize(800, 300);
		similarGUI.setBackground(new Color(140, 0, 52));
		
		JLabel disW = new JLabel("A similar wine has attributes", SwingConstants.CENTER);
		disW.setForeground(Color.WHITE);
		disW.setBackground(new Color(227, 83, 117));
		similarGUI.add(disW);
		
		JPanel sim1 = new JPanel();
		JLabel lab1 = new JLabel("Fixed Acidity:");
		get1 = new JTextField(5);
		lab1.setForeground(Color.WHITE);
		get1.setForeground(Color.WHITE);
	    get1.setBackground(new Color(227, 83, 117));
	    get1.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim1.setBackground(new Color(140, 0, 52));
	    sim1.add(lab1);
		sim1.add(get1);
		get1.setEditable(false);
		similarGUI.add(sim1);
		
		JPanel sim2 = new JPanel();
		JLabel lab2 = new JLabel("Volatile Acidity:");
		get2 = new JTextField(5);
		lab2.setForeground(Color.WHITE);
		get2.setForeground(Color.WHITE);
	    get2.setBackground(new Color(227, 83, 117));
	    get2.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim2.setBackground(new Color(140, 0, 52));
	    sim2.add(lab2);
		sim2.add(get2);
		get2.setEditable(false);
		similarGUI.add(sim2);
		
		JPanel sim3 = new JPanel();
		JLabel lab3 = new JLabel("Color:");
		get3 = new JTextField(5);
		lab3.setForeground(Color.WHITE);
		get3.setForeground(Color.WHITE);
	    get3.setBackground(new Color(227, 83, 117));
	    get3.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim3.setBackground(new Color(140, 0, 52));
	    sim3.add(lab3);
		sim3.add(get3);
		get3.setEditable(false);
		similarGUI.add(sim3);
		
		JPanel sim4 = new JPanel();
		JLabel lab4 = new JLabel("Citric Acid:");
		get4 = new JTextField(5);
		lab4.setForeground(Color.WHITE);
		get4.setForeground(Color.WHITE);
	    get4.setBackground(new Color(227, 83, 117));
	    get4.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim4.setBackground(new Color(140, 0, 52));
	    sim4.add(lab4);
		sim4.add(get4);
		get4.setEditable(false);
		similarGUI.add(sim4);
		
		JPanel sim5 = new JPanel();
		JLabel lab5 = new JLabel("Residual Sugar:");
		get5 = new JTextField(5);
		lab5.setForeground(Color.WHITE);
		get5.setForeground(Color.WHITE);
	    get5.setBackground(new Color(227, 83, 117));
	    get5.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim5.setBackground(new Color(140, 0, 52));
	    sim5.add(lab5);
		sim5.add(get5);
		get5.setEditable(false);
		similarGUI.add(sim5);
		
		JPanel sim6 = new JPanel();
		JLabel lab6 = new JLabel("Chlorides:");
		get6 = new JTextField(5);
		lab6.setForeground(Color.WHITE);
		get6.setForeground(Color.WHITE);
	    get6.setBackground(new Color(227, 83, 117));
	    get6.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim6.setBackground(new Color(140, 0, 52));
	    sim6.add(lab6);
		sim6.add(get6);
		get6.setEditable(false);
		similarGUI.add(sim6);
		
		JPanel sim7 = new JPanel();
		JLabel lab7 = new JLabel("Free Sulfur Dioxide:");
		get7 = new JTextField(5);
		lab7.setForeground(Color.WHITE);
		get7.setForeground(Color.WHITE);
	    get7.setBackground(new Color(227, 83, 117));
	    get7.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim7.setBackground(new Color(140, 0, 52));
	    sim7.add(lab7);
		sim7.add(get7);
		get2.setEditable(false);
		similarGUI.add(sim7);
		
		JPanel sim8 = new JPanel();
		JLabel lab8 = new JLabel("Total Sulfur Dioxide:");
		get8 = new JTextField(5);
		lab8.setForeground(Color.WHITE);
		get8.setForeground(Color.WHITE);
	    get8.setBackground(new Color(227, 83, 117));
	    get8.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim8.setBackground(new Color(140, 0, 52));
	    sim8.add(lab8);
		sim8.add(get8);
		get8.setEditable(false);
		similarGUI.add(sim8);
		
		JPanel sim9 = new JPanel();
		JLabel lab9 = new JLabel("Density:");
		get9 = new JTextField(5);
		lab9.setForeground(Color.WHITE);
		get9.setForeground(Color.WHITE);
	    get9.setBackground(new Color(227, 83, 117));
	    get9.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim9.setBackground(new Color(140, 0, 52));
	    sim9.add(lab9);
		sim9.add(get9);
		get9.setEditable(false);
		similarGUI.add(sim9);
		
		JPanel sim10 = new JPanel();
		JLabel lab10 = new JLabel("pH:");
		get10 = new JTextField(5);
		lab10.setForeground(Color.WHITE);
		get10.setForeground(Color.WHITE);
	    get10.setBackground(new Color(227, 83, 117));
	    get10.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim10.setBackground(new Color(140, 0, 52));
	    sim10.add(lab10);
		sim10.add(get10);
		get10.setEditable(false);
		similarGUI.add(sim10);
		
		JPanel sim11 = new JPanel();
		JLabel lab11 = new JLabel("Sulphates:");
		get11 = new JTextField(5);
		lab11.setForeground(Color.WHITE);
		get11.setForeground(Color.WHITE);
	    get11.setBackground(new Color(227, 83, 117));
	    get11.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim11.setBackground(new Color(140, 0, 52));
	    sim11.add(lab11);
		sim11.add(get11);
		get11.setEditable(false);
		similarGUI.add(sim11);
		
		JPanel sim12 = new JPanel();
		JLabel lab12 = new JLabel("Alcohol:");
		get12 = new JTextField(5);
		lab12.setForeground(Color.WHITE);
		get12.setForeground(Color.WHITE);
	    get12.setBackground(new Color(227, 83, 117));
	    get12.setBorder(new LineBorder (new Color(227, 83, 117)));;
		sim12.setBackground(new Color(140, 0, 52));
	    sim12.add(lab12);
		sim12.add(get12);
		get12.setEditable(false);
		similarGUI.add(sim12);
		
		get13 = new JTextField(5);
		get13.setForeground(Color.WHITE);
	    get13.setBackground(new Color(227, 83, 117));
	    get13.setBorder(new LineBorder (new Color(227, 83, 117)));;
		get13.setEditable(false);
		get13.setHorizontalAlignment(JTextField.CENTER);
		get13.setText("apply");
	    similarGUI.add(get13);
	    
		JButton back = new JButton("Input new Wine");
		back.addActionListener(this);
		back.setForeground(Color.WHITE);
		back.setBackground(new Color(227, 83, 117));
		back.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		similarGUI.add(new JLabel());
		similarGUI.add(back);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton read = (JButton)arg0.getSource();
		String nameB = read.getText();
		
		if(nameB.equals("Test")) {//button from inputGUI to test wine and display outputGUI
			input[0] = (String) Blee.getSelectedItem();
			input[1] = FixedAcidity.getText();
			input[2] = VolatileAcidity.getText();
			input[3] = CitricAcid.getText();
			input[4] = ResidualSugar.getText();
			input[5] = Chlorides.getText();
			input[6] = FreeSulfurDioxide.getText();
			input[7] = TotalSulfurDioxide.getText();
			input[8] = Density.getText();
			input[9] = PH.getText();
			input[10] = Sulphates.getText();
			input[11] = Alcohol.getText();
			
			try {
				wineIn.setType(input[0]);
				
				if(input[1].equals(""))
					wineIn.setFixedAcidity(d[0]);
				else
					wineIn.setFixedAcidity(Float.parseFloat(input[1]));
				
				if(input[2].equals(""))
					wineIn.setVolatileAcidity(d[1]);
				else
					wineIn.setVolatileAcidity(Float.parseFloat(input[2]));
				
				if(input[3].equals(""))
					wineIn.setCitricAcid(d[2]);
				else
					wineIn.setCitricAcid(Float.parseFloat(input[3]));
				
				if(input[4].equals(""))
					wineIn.setResidualSugar(d[3]);
				else
					wineIn.setResidualSugar(Float.parseFloat(input[4]));
				
				if(input[5].equals(""))
					wineIn.setChlorides(d[4]);
				else
					wineIn.setChlorides(Float.parseFloat(input[5]));
				
				if(input[6].equals(""))
					wineIn.setFreeSulfur(d[5]);
				else
					wineIn.setFreeSulfur(Float.parseFloat(input[6]));
				
				if(input[7].equals(""))
					wineIn.setTotalSulfur(d[6]);
				else
					wineIn.setTotalSulfur(Float.parseFloat(input[7]));
				
				if(input[8].equals(""))
					wineIn.setDensity(d[7]);
				else
					wineIn.setDensity(Float.parseFloat(input[8]));
				
				if(input[9].equals(""))
					wineIn.setpH(d[8]);
				else
					wineIn.setpH(Float.parseFloat(input[9]));
				
				if(input[10].equals(""))
					wineIn.setSulphates(d[9]);
				else
					wineIn.setSulphates(Float.parseFloat(input[10]));
				
				if(input[11].equals(""))
					wineIn.setAlcohol(d[10]);
				else
					wineIn.setAlcohol(Float.parseFloat(input[11]));
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Enter values must be a number.\nEmpty inputs will apply default values.");
				return;
			}
			
			answer = rfWine.test(wineIn);
			classify.setText(answer);
			popup.remove(inGUI);
			popup.add(outGUI);
			popup.revalidate();
			popup.setSize(699, 499);
		}
		else if(nameB.equals("Try another Wine")){
			//return to inputGUI
			popup.remove(outGUI);
			popup.add(inGUI);
			popup.revalidate();
			popup.setSize(700, 500);
		}
		else if(nameB.equals("Find similar Wine")) {
			wine simli = wineClassifier.findWine(wineIn);
			if(simli == null){
				get1.setText("NA");
				get2.setText("NA");
				get3.setText("NA");
				get4.setText("NA");
				get5.setText("NA");
				get6.setText("NA");
				get7.setText("NA");
				get8.setText("NA");
				get9.setText("NA");
				get10.setText("NA");
				get11.setText("NA");
				get12.setText("NA");
				get13.setText("A similar wine was not foun in the data set");
			}
			else {
				get1.setText(Float.toString(simli.getFixedAcidity()));
				get2.setText(Float.toString(simli.getVolatileAcidity()));
				get3.setText(simli.getType());
				get4.setText(Float.toString(simli.getCitricAcid()));
				get5.setText(Float.toString(simli.getResidualSugar()));
				get6.setText(Float.toString(simli.getChlorides()));
				get7.setText(Float.toString(simli.getFreeSulfur()));
				get8.setText(Float.toString(simli.getTotalSulfur()));
				get9.setText(Float.toString(simli.getDensity()));
				get10.setText(Float.toString(simli.getpH()));
				get11.setText(Float.toString(simli.getSulphates()));
				get12.setText(Float.toString(simli.getAlcohol()));
				String giv = "";
				if(simli.getQuality() == 1)
					giv = "good quality";
				else
					giv = "bad quality";
				get13.setText("The wine found in the data base has "+giv);
			}
			popup.remove(outGUI);
			popup.add(similarGUI);
			popup.revalidate();
			popup.setSize(400, 500);
			
		}
		else if(nameB.equals("Input new Wine")){
			//return to inputGUI
			popup.remove(similarGUI);
			popup.add(inGUI);
			popup.revalidate();
			popup.setSize(700, 500);
		}		
		
	}
}

