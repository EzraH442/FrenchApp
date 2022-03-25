package panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FEHelpPanel extends JPanel implements ActionListener {
	final private FEPanel panel;
	final private JButton helpButton = new JButton("answer");
	private final JLabel helpText = new JLabel();
	
	public FEHelpPanel(FEPanel panel) {
		this.panel = panel;
		helpButton.addActionListener(this);
		add(helpButton);
		add(helpText);
	}
	public FEHelpPanel(FEPanel panel, Dimension d) {
		this.panel = panel;
		helpButton.addActionListener(this);
		add(helpButton);
		add(helpText);
		this.setPreferredSize(d);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		helpText.setText((panel.isEnglishToFrench ? panel.frenchWord : panel.englishWord)); 
	}

}
