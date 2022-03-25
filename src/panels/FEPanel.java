package panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import reader.FrenchEnglishPair;

import app.Utils;

@SuppressWarnings("serial")
public abstract class FEPanel extends JPanel {
	protected String frenchWord, englishWord;
	protected boolean isEnglishToFrench = false;
	final private JCheckBox checkbox = new JCheckBox("Is English to French"); 
	final private JButton switchWordButton = new JButton("New Word");

	public FEPanel() {
		add(checkbox);
		add(switchWordButton);
		switchWordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Utils.areResourcesSelected()) {
					doOnNoWord();
					return;
				}
				switchWord(Utils.selectRandomWord());
			}
		});
		checkbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				isEnglishToFrench = e.getStateChange() == ItemEvent.SELECTED;
			}
		});
		this.setPreferredSize(new Dimension(500, 600));
	}
	public void switchWord(FrenchEnglishPair pair) {
		this.englishWord = pair.getEnglishWord();
		this.frenchWord = pair.getFrenchWord();
		doOnWordChange();
	}
	abstract void doOnWordChange();
	abstract void doOnNoWord();
}
