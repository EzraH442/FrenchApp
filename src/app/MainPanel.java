package app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panels.FlashcardPanel;
import panels.ResourcePanel;
import panels.TranslatePanel;
import panels.UploadPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	final private CardLayout layoutForCards = new CardLayout(20, 10);
	final private JPanel cards = new JPanel(layoutForCards);
	final private JPanel[] cardPanels = { 
			new FlashcardPanel(), 
			new TranslatePanel(), 
			new ResourcePanel(), 
			new UploadPanel() 
	};
	
	final private String[] comboBoxItems = { 
			"French English Flashcards", 
			"French English Translations", 
			"Manage Uploaded Resources", 
			"Upload Files" 
	};
	
	final private JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
	
	public MainPanel () {
		cb.setBorder(new EmptyBorder(15, 40, 15, 40));
		cb.setFocusable(false);
		cb.setEditable(false);
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				layoutForCards.show(cards, (String) e.getItem());
				
			}
		});
		
		for (int i = 0; i < cardPanels.length; i++) {
			cards.add(cardPanels[i], comboBoxItems[i]);
		}
		
		add(cb, BorderLayout.PAGE_START);
		add(cards, BorderLayout.CENTER);
	}
}
