package view;

import javax.swing.JButton;

import core.AbstractView;

public class RLEView extends AbstractView {

	private JButton switchButton = new JButton("Zum Rechner");

	public RLEView(MainWindow frame) {
		super(frame);
		this.switchButton.addActionListener(e -> flip(Cards.CALCULATOR));
		this.add(switchButton);
	}

	@Override
	public void onFlip() {
		this.setTitle("RLE");
	}

}
