package view;

import javax.swing.JButton;

import core.AbstractView;
import schimkat.berlin.lernhilfe2025ws.welcome.LittleDialog;

public class RLEView extends AbstractView {

	private JButton switchButton = new JButton("Dialog starten");
	

	public RLEView(MainWindow frame) {
		super(frame);
		this.switchButton.addActionListener(e -> LittleDialog.sayHello());
		this.add(switchButton);
		
	}

	@Override
	public void onFlip() {
		this.setTitle("RLE");
	}

}
