package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.netbeans.lib.awtextra.*;

public class ViewFinal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel gifFaustao, congratulationMessage, scoreMessage, scoreResult, signature;
	private JButton btnPlayAgain, btnGoToIndex;
	private Dimension btnDefaultDimension = new Dimension(250,50);
	
	public ViewFinal(int finalScore) {
		initComponents(finalScore);
	}
	
	private void initComponents(int score) {
		
		setDefaultCloseOperation(3);
		setPreferredSize(new Dimension(800, 600));
	    setSize(new Dimension(800, 600));
		getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
	    
		this.congratulationMessage = new JLabel();
		this.congratulationMessage.setFont(this.setFontSize(36));
		this.congratulationMessage.setText(score == 10 ? "Parabéns!" : "Errou!");
		getContentPane().add(this.congratulationMessage, new AbsoluteConstraints(score == 10 ? 300 : 350, 20, 200, 50));
		
		if(score != 10) {
			this.gifFaustao = new JLabel();
			this.gifFaustao.setIcon(new ImageIcon(getClass().getResource("/images/fausto.gif")));
			getContentPane().add(this.gifFaustao, new AbsoluteConstraints(150, 180, 450, 250));	
		}
		
		this.scoreMessage = new JLabel();
		this.scoreMessage.setFont(this.setFontSize(24));
		this.scoreMessage.setText("Sua Pontuação:");
		getContentPane().add(this.scoreMessage, new AbsoluteConstraints(300, 80, 200, 50));
		
		this.scoreResult = new JLabel();
		this.scoreResult.setFont(this.setFontSize(24));
		this.scoreResult.setText(Integer.toString(score));
		getContentPane().add(this.scoreResult, new AbsoluteConstraints(370, 110, 50, 50));
		
		this.btnGoToIndex = new JButton();
		this.btnGoToIndex.setFont(this.setFontSize(24));
		this.btnGoToIndex.setText("Ir para Home");
		this.btnGoToIndex.setPreferredSize(this.btnDefaultDimension);
		this.btnGoToIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ViewFinal.this.btnGoToIndexActionPerformed(evt);
			}
		});
		getContentPane().add(this.btnGoToIndex, new AbsoluteConstraints(100, 450, -1, -1));
		
		this.btnPlayAgain = new JButton();
		this.btnPlayAgain.setFont(this.setFontSize(24));
		this.btnPlayAgain.setText("Jogar Novamente");
		this.btnPlayAgain.setPreferredSize(this.btnDefaultDimension);
		this.btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ViewFinal.this.btnPlayAgainActionPerformed(evt);
			}
		});
		getContentPane().add(this.btnPlayAgain, new AbsoluteConstraints(450, 450, -1, -1));
		
		this.signature = new JLabel();
		this.signature.setFont(this.setFontSize(20));
		this.signature.setText("feito por: Victor Cabral");
		getContentPane().add(this.signature, new AbsoluteConstraints(550, 500, -1, -1));
	    pack();
	}
	
	private Font setFontSize(int fontSize) {
		return new Font("Tahoma", 0, fontSize);
	}
	
	private void btnPlayAgainActionPerformed(ActionEvent evt) {
		Questions questions = new Questions(0);
		questions.setVisible(true);
		questions.setLocationRelativeTo(null);
		dispose();	
	}
	
	private void btnGoToIndexActionPerformed(ActionEvent evt) {
		ViewIndex viewIndex = new ViewIndex();
		viewIndex.setVisible(true);
		viewIndex.setLocationRelativeTo(null);
		dispose();	
	}
}
