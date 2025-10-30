package view;

import javax.swing.JButton;

import core.AbstractView;
import schimkat.berlin.lernhilfe2025ws.welcome.LittleDialog;

public class RLEView extends AbstractView {

	private JButton switchButton = new JButton("Zum Rechner");
	

	public RLEView(MainWindow frame) {
		super(frame);
		this.switchButton.addActionListener(e -> flip(Cards.CALCULATOR));
		this.add(switchButton);
		
	}

	@Override
	public void onFlip() {
		LittleDialog.sayHello();
		this.setTitle("RLE");
	}

}
