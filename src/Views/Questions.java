package Views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.netbeans.lib.awtextra.*;

public class Questions extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] questions;
	private Alternatives[] alternatives;
	
	private JLabel questionTitle;
	private JLabel questionDescription;
	
	private JButton btnA, btnB, btnC, btnD;
	private Dimension btnDefaultDimension = new Dimension(250,150);
	
	public Questions(int questionNumber) {
		
		questions = new String[10];
		alternatives = new Alternatives[10];
		
		questions[0] = "Como o nome da menina que derrubou o forninho?";
		alternatives[0] = new Alternatives("Larissa","Claudia","Giovanna","Suellen",2);
		
		questions[1] = "Qual desses não é um membro da carreta furacão?";
		alternatives[1] = new Alternatives("Homem-Aranha","Fofão","Mickey Mouse","Pica-pau",3);
		
		questions[2] = "De quem é a frase: \"Busquem conhecimento\" ?";
		alternatives[2] = new Alternatives("Bina","Etvaldo","ET Bilu","ET de Varginha",2);
		
		questions[3] = "Onde está Luiza?";
		alternatives[3] = new Alternatives("Roma","Canadá","Texas","Onde ela quiser",1);
		
		questions[4] = "Como é o nome da vó do \"taca-lhe pau Marcos\"?";
		alternatives[4] = new Alternatives("Genoveva","Carlota","Sovelina","Dolores",2);
		
		questions[5] = "A idda nossa amada presidanta era de ?";
		alternatives[5] = new Alternatives("Saldar a mandioca","Estocar vento","Fora Temer","<html>Nem ganhar<br />Nem perder</html>",1);
		
		questions[6] = "Qual o número dessa questão?";
		alternatives[6] = new Alternatives("7","8","5","9",0);
		
		questions[7] = "\"Não vou ser presa, por que eu sou ... !\"";
		alternatives[7] = new Alternatives("Linda","Mulher","Esperta","Rica",3);
		
		questions[8] = "Do que o papai noel da panificadora alfa mais gosta?";
		alternatives[8] = new Alternatives("Do sanduiche","Do Croassant","Do Cacetinho","Do Pão de Queijo",2);
		
		questions[9] = "\"Fizeram tudo com você e te largaram. Mas foi bom?\"";
		alternatives[9] = new Alternatives("Foi óstimo","Foi maravilhoso","Foi bom","Foiste Magnifico",0);
		
		initComponents(questionNumber);
	}
	
	private void initComponents(final int index) {
	    
		setDefaultCloseOperation(3);
		setPreferredSize(new Dimension(800, 600));
	    setSize(new Dimension(800, 600));
	    getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
	    
		int numberPlusOne = index + 1;
		String numberQuestion = index != 6 ? Integer.toString(numberPlusOne) : "?";
		
		this.questionTitle = new JLabel();
		this.questionTitle.setFont(this.setFontSize(36));
		this.questionTitle.setText("Questão " + numberQuestion);
		
		this.questionDescription = new JLabel();
		this.questionDescription.setFont(this.setFontSize(28));
		this.questionDescription.setText(this.questions[index]);
		
		this.btnA = new JButton();
		this.btnA.setFont(this.setFontSize(24));
		this.btnA.setText(this.alternatives[index].getAlternative("A"));
		this.btnA.setPreferredSize(this.btnDefaultDimension);
		this.btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Questions.this.btnActionPerformed(evt, index, "A");
			}
		});
		
		this.btnB = new JButton();
		this.btnB.setFont(this.setFontSize(24));
		this.btnB.setText(this.alternatives[index].getAlternative("B"));
		this.btnB.setPreferredSize(this.btnDefaultDimension);
		this.btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Questions.this.btnActionPerformed(evt, index, "B");
			}
		});
		
		this.btnC = new JButton();
		this.btnC.setFont(this.setFontSize(24));
		this.btnC.setText(this.alternatives[index].getAlternative("C"));
		this.btnC.setPreferredSize(this.btnDefaultDimension);
		this.btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Questions.this.btnActionPerformed(evt, index, "C");
			}
		});
		
		this.btnD = new JButton();
		this.btnD.setFont(this.setFontSize(24));
		this.btnD.setText(this.alternatives[index].getAlternative("D"));
		this.btnD.setPreferredSize(this.btnDefaultDimension);
		this.btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Questions.this.btnActionPerformed(evt, index, "D");
			}
		});
		
	    getContentPane().add(this.questionTitle, new AbsoluteConstraints(20, 10, -1, 50));
	    getContentPane().add(this.questionDescription, new AbsoluteConstraints(20, 80, -1, -1));
	    getContentPane().add(this.btnA, new AbsoluteConstraints(120, 150, -1, -1));
	    getContentPane().add(this.btnB, new AbsoluteConstraints(430, 150, -1, -1));
	    getContentPane().add(this.btnC, new AbsoluteConstraints(120, 350, -1, -1));
	    getContentPane().add(this.btnD, new AbsoluteConstraints(430, 350, -1, -1));
	    pack();
	}
	
	private Font setFontSize(int fontSize) {
		return new Font("Tahoma", 0, fontSize);
	}

	private void btnActionPerformed(ActionEvent evt, int index, String alternative) {
		if(this.alternatives[index].getCorrectAlternative(alternative)) {
			if(index != 9) {
				Questions questoes = new Questions(index+1);
				questoes.setVisible(true);
				questoes.setLocationRelativeTo(null);
				dispose();	
			} else {
				ViewFinal viewFinal = new ViewFinal(index + 1);
				viewFinal.setVisible(true);
				viewFinal.setLocationRelativeTo(null);
				dispose();	
			}
		} else {
			ViewFinal viewFinal = new ViewFinal(index);
			viewFinal.setVisible(true);
			viewFinal.setLocationRelativeTo(null);
			dispose();	
		}
	}
	
	static class Alternatives {
		private String alternativeA, alternativeB, alternativeC, alternativeD;
		private int correctAlternative;
		
		Alternatives(String altA, String altB, String altC, String altD, int correctAlt) {
			this.alternativeA = altA;
			this.alternativeB = altB;
			this.alternativeC = altC;
			this.alternativeD = altD;
			this.correctAlternative = correctAlt;
		}
		
		public String getAlternative(String alternative) {
			switch(alternative) {
				case "A":
					return this.alternativeA;
				case "B":
					return this.alternativeB;
				case "C":
					return this.alternativeC;
				case "D":
					return this.alternativeD;
				default:
					return null;
			}			
		}
		
		public boolean getCorrectAlternative(String alternative) {
			switch(alternative) {
				case "A":
					return this.correctAlternative == 0;
				case "B":
					return this.correctAlternative == 1;
				case "C":
					return this.correctAlternative == 2;
				case "D":
					return this.correctAlternative == 3;
				default:
					return false;
			}			
		}
		
	}
}
