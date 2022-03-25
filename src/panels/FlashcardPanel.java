package panels;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class FlashcardPanel extends FEPanel implements ActionListener {
	final private Container container = new Container();
	final private CardLayout layout = new CardLayout();
	final private JButton side1 = new JButton(frenchWord);
	final private JButton side2 = new JButton(englishWord);
	
	public FlashcardPanel() {
		setLayout(new GridLayout(3, 0));
		container.setLayout(new CardLayout(0, 30));
		
		container.add(side1);
		container.add(side2);
		container.setLayout(layout);
		
		side1.addActionListener(this);
		side2.addActionListener(this);
		
		add(container);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		layout.next(container);
	}

	@Override
	void doOnWordChange() {
		if (isEnglishToFrench) {
			side1.setText(englishWord);
			side2.setText(frenchWord);
		} else {
			side2.setText(englishWord);
			side1.setText(frenchWord);
		}
		
		layout.first(container);
	}
	
	@Override
	void doOnNoWord() {
		side1.setText("Please select some resources from the resource manager!");
		side2.setText("Please select some resources from the resource manager!");
	}
}