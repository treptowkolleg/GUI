package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.AbstractView;
import layout.CustomGridBagConstraints;
import listener.TextFieldButtonEnabler;
import model.CalculatorModel;

public class CalculatorView extends AbstractView {

	private CalculatorModel model = new CalculatorModel();

	private JButton progressButton = new JButton("Berechen >>");
	private JTextField inputField = new JTextField();
	private JTextField outputField = new JTextField();

	public CalculatorView(MainWindow frame) {
		super(frame);

		// TODO: Wir bauen uns besser einen Field- und Button-Builder wegen der
		// Übersichtlichkeit.
		this.inputField.setPreferredSize(new Dimension(getPreferredSize().width, View.INPUT_HEIGHT));
		this.outputField.setPreferredSize(new Dimension(getPreferredSize().width, View.INPUT_HEIGHT));
		this.progressButton.setPreferredSize(new Dimension(getPreferredSize().width, View.INPUT_HEIGHT));

		this.progressButton.addActionListener(e -> this.switchAction());
		this.inputField.addActionListener(e -> this.switchAction());
		this.outputField.setEditable(false);

		TextFieldButtonEnabler.enableWhenNotEmpty(inputField, progressButton);

		CustomGridBagConstraints c = getConstraints();
		c.setFill(GridBagConstraints.HORIZONTAL);
		c.setRow(0);

		this.add(new JLabel("Ganze Zahl (Dezimal)"));
		c.setWeightX(.5);
		this.add(new JLabel());
		c.setWeightX(1);
		this.add(new JLabel("Ausgabe (Binär)"));

		c.setRow(1);
		this.add(inputField, c);
		c.setWeightX(.5);
		this.add(progressButton, c);
		c.setWeightX(1);
		this.add(outputField, c);

	}

	@Override
	public void onFlip() {
		this.setTitle("Rechner");
		this.inputField.setText(null);
		this.outputField.setText(null);
	}

	private void switchAction() {
		try {
			outputField.setText(model.convertIntToBin(inputField.getText().trim()));
			this.frame.setErrorText(null);
		} catch (NumberFormatException e) {
			this.frame.setErrorText(e.getMessage());
			outputField.setText(null);
		} finally {
			inputField.grabFocus();
		}

	}

}
