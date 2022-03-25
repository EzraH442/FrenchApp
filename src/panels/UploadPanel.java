package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Utils;

@SuppressWarnings("serial")
public class UploadPanel extends JPanel implements ActionListener {
	final private JFileChooser fileChooser = new JFileChooser();
	final private JButton chooseButton = new JButton("Select files");
	final private JLabel output = new JLabel("Select a file to upload!");
	
	
	public UploadPanel() {
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new TextFileFilter());
		
		add(chooseButton);
		chooseButton.addActionListener(this);
		add(output);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chooseButton) {
	        int returnVal = fileChooser.showDialog(UploadPanel.this, "Select Files");

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            Path file = fileChooser.getSelectedFile().toPath();
	            Utils.createNewResource(file);
	        }
	   }
	}
}
