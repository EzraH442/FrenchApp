package panels;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import app.Utils;

@SuppressWarnings("serial")
public class FETextField extends JTextField {
	final TranslatePanel attachedPanel;
	
	public FETextField(TranslatePanel p) {
		this.attachedPanel = p;
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					attachedPanel.doOnCheck();
				}
				if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
					if (Utils.areResourcesSelected()) {
						attachedPanel.doOnNoWord();
						return;
					}
					attachedPanel.switchWord(Utils.selectRandomWord());
					clearInput();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}
		});

	}
	
	public void clearInput() {
		this.setText("");
	}
	
	public boolean hasTextSelected() {
		return this.getSelectedText() != null;
	}
}
