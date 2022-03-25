package panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import app.Utils;
import reader.WordGroup;

@SuppressWarnings("serial")
public class ResourcePanel extends JPanel implements ItemListener, ActionListener {
	private JCheckBox[] checkBoxes;
	final private JButton updatingButton = new JButton("Update");
	
	public ResourcePanel() {
		createCheckBoxes();
		add(updatingButton);
		updatingButton.addActionListener(this);
	}
	
	private void createCheckBoxes() {
		final ArrayList<JCheckBox> boxes = new ArrayList<>();
		
		for (Map.Entry<String, WordGroup> entry : Utils.getResources().entrySet()) {
		    boxes.add(new JCheckBox(entry.getKey()));
		}
		
		checkBoxes = boxes.toArray(new JCheckBox[0]);
		
		setLayout(new GridLayout(checkBoxes.length + 1, 1));
		
		for (int i = 0; i < checkBoxes.length; i++) {
			add(checkBoxes[i]);
			checkBoxes[i].addItemListener(this);
		}
	}
	
	private void recreateCheckBoxes() {
		this.removeAll();
		createCheckBoxes();
		add(updatingButton);
		updatingButton.addActionListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) { //throw new error if resource doesnt exist
		 final Object source = e.getItem();
		 String nameOfResourceChanged = "";
		 
		 for (int i = 0; i < checkBoxes.length; ++i) {
			if (source.equals(checkBoxes[i])) {
				nameOfResourceChanged = checkBoxes[i].getText();
				break;
			}
		 }
		 
		 Utils.setIsSelectedForWordGroup(nameOfResourceChanged, e.getStateChange() == ItemEvent.SELECTED);
		 Utils.updateSelectedResources();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updatingButton) {
			recreateCheckBoxes();
		}
	}
	
}
