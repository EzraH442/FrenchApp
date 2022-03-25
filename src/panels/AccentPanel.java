package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AccentPanel extends JPanel implements ActionListener {
	final private FETextField textField;
	final private JButton[] accentButtons = {
			new JButton("à"), new JButton("â"), new JButton("ç"), new JButton("é"),
			new JButton("è"), new JButton("ê"), new JButton("ë"), new JButton("ï"),
			new JButton("î"), new JButton("ô"), new JButton("ù"), new JButton("û"), 
			new JButton("ü")
	};
	
	public AccentPanel(FETextField t) {
		for(JButton button : accentButtons) {
			add(button);
			button.addActionListener(this);
		}
		this.textField = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final JButton source = (JButton) e.getSource();
		final String text = textField.getText();
		
		if (textField.hasTextSelected()) {
			textField.setText(
					text.substring(0, textField.getSelectionStart()) + 
					source.getText() + 
					text.substring(textField.getSelectionEnd()));
		}
		
		else {
			int position = textField.getCaretPosition();
			textField.setText(
					text.substring(0, position) + 
					source.getText() + 
					text.substring(position));
		}
	}
}
