package core;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Cards;
import javax.swing.JPanel;

import layout.CustomGridBagConstraints;
import view.MainWindow;
import view.View;

public abstract class AbstractView extends JPanel implements ActionListener {

	protected MainWindow frame;

	private GridBagLayout layout = new GridBagLayout();
	private CustomGridBagConstraints constraints = new CustomGridBagConstraints();

	public AbstractView(MainWindow frame) {
		this.frame = frame;
		setLayout(layout);
	}

	protected void flip(Cards card) {
		this.frame.flip(card);
	}

	protected void setTitle(String title) {
		this.frame.setTitle(title);
	}

	protected CustomGridBagConstraints getConstraints() {
		return this.constraints;
	}

	public abstract void onFlip();
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
