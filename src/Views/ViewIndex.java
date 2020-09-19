package Views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.netbeans.lib.awtextra.*;

public class ViewIndex extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton btnPlay;
	private JLabel title;
	private JLabel signature;
	
	public ViewIndex() {
		initComponents();
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(3);//DISPOSE_ON_CLOSE
		setPreferredSize(new Dimension(800, 600));
		getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
		
		this.btnPlay = new JButton();
		this.btnPlay.setFont(this.setFontSize(24));
		this.btnPlay.setText("Iniciar");
		this.btnPlay.setPreferredSize(new Dimension(100,50));
		this.btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ViewIndex.this.btnPlayActionPerformed(evt);
			}
		});
		
		this.title = new JLabel();
		this.title.setFont(this.setFontSize(36));
		this.title.setText("Quiz de Memes");
		this.title.setPreferredSize(new Dimension(400, 50));
		
		this.signature = new JLabel();
		this.signature.setFont(this.setFontSize(20));
		this.signature.setText("feito por: Victor Cabral");
		
		getContentPane().add(this.btnPlay, new AbsoluteConstraints(300, 200, 190, 60));
		getContentPane().add(this.title, new AbsoluteConstraints(280, 50, -1, -1));
		getContentPane().add(this.signature, new AbsoluteConstraints(550, 500, -1, -1));
		pack();
	}
	
	private void btnPlayActionPerformed(ActionEvent evt) {
		Questions questoes = new Questions(0);
		questoes.setVisible(true);
		questoes.setLocationRelativeTo(null);
		dispose();
	}
	
	private Font setFontSize(int fontSize) {
		return new Font("Tahoma", 0, fontSize);
	}
}
