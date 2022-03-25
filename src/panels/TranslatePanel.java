package panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import app.Utils;

@SuppressWarnings("serial")
public class TranslatePanel extends FEPanel implements ActionListener {
	final private JLabel givenWord = new JLabel();
	final private FETextField input = new FETextField(this);
	final private JButton checkAnswer = new JButton("Check");
	final private JLabel output = new JLabel("");
	final private GridLayout layout = new GridLayout(4, 0);
	final private AccentPanel accentPanel = new AccentPanel(input);
	final private String correctText = "true";
	final private String incorrectText = "false";
	final private FEHelpPanel helpPanel = new FEHelpPanel(this);
	public TranslatePanel() {
		addComponents();
		checkAnswer.addActionListener(this);
	}
	private void addComponents() {
		setLayout(layout);
		add(givenWord);
		add(accentPanel);
		add(input);
		add(checkAnswer);
		add(output);
		add(helpPanel);
	}
	
	private void setOutput(boolean isCorrect) {
		output.setText((isCorrect) ? correctText: incorrectText);
	}
	
	private boolean checkIfEquals() {
		return (isEnglishToFrench) ? 
				frenchWord.equals(input.getText()): 
				englishWord.equals(input.getText());	
	}
	private boolean hasResourcesSelected() {
		return frenchWord != null;
	}
	
	void doOnCheck() {
		if (!hasResourcesSelected()) {
			doOnNoWord();
			return;
		}
		
		if (input.getText() == null || !checkIfEquals()) {
			setOutput(false);
			System.out.println(englishWord + " " + frenchWord + " " + input); //do something with this later
		} else {
			setOutput(true);
			switchWord(Utils.selectRandomWord());
			doOnWordChange();
			input.clearInput();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doOnCheck();
	}
	
	@Override 
	void doOnWordChange() {
		givenWord.setText((isEnglishToFrench) ? englishWord : frenchWord);
	}
	

	void doOnNoWord() {
		output.setText("Please select some resources from the resource manager!");
	}
}
