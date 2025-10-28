package view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.AbstractView;
import core.Application;
import layout.CustomGridBagConstraints;
import view.components.CustomMenuBar;

public class MainWindow extends JFrame {

	private JLabel description = new JLabel();

	private JLabel errorLabel = new JLabel();

	private CardLayout layout = new CardLayout();

	private GridBagLayout frameLayout = new GridBagLayout();
	private CustomGridBagConstraints constraints = new CustomGridBagConstraints();

	private JPanel mainPanel = new JPanel();
	private HashMap<Cards, AbstractView> views = new HashMap<>();

	private CustomMenuBar menuBar;

	public MainWindow() {
		setTitle("Testfenster");
		setIconImage(new ImageIcon(Application.class.getResource("/resources/icons/tk.png")).getImage());

		this.setLayout(frameLayout);
		this.mainPanel.setLayout(layout);

		this.menuBar = new CustomMenuBar(this);

		addViews();
		addComponents();
		flip(getDefaultView());
		this.menuBar.init();
		init();
	}

	public void setErrorText(String text) {
		this.errorLabel.setText(text);
	}

	/**
	 * Views zur App hinzufügen.
	 */
	private void addViews() {
		this.views.put(Cards.CALCULATOR, new CalculatorView(this));
		this.views.put(Cards.RLE, new RLEView(this));

		for (Map.Entry<Cards, AbstractView> element : this.views.entrySet()) {
			this.mainPanel.add(element.getValue(), element.getKey().getLabel());
		}
	}

	/**
	 * Standard-View einstellen
	 * 
	 * @return Key zur definierten HashMap.
	 */
	private Cards getDefaultView() {
		return Cards.CALCULATOR;
	}

	private void addComponents() {
		this.setJMenuBar(this.menuBar);
		this.addNorth(description);
		this.addCenter(mainPanel);
		this.addSouth(errorLabel);
	}

	public MainWindow addNorth(Component component) {
		this.constraints.setRow(0);
		this.constraints.setWeightY(0);
		this.constraints.setFill(GridBagConstraints.HORIZONTAL);
		this.constraints.setAnchor(GridBagConstraints.NORTH);
		this.add(component, this.constraints);
		return this;
	}

	public MainWindow addNorth(Component component, Insets insets) {
		this.constraints.setInsets(insets);
		this.constraints.setRow(0);
		this.constraints.setWeightY(0);
		this.constraints.setFill(GridBagConstraints.HORIZONTAL);
		this.constraints.setAnchor(GridBagConstraints.NORTH);
		this.add(component, this.constraints);
		return this;
	}

	public MainWindow addCenter(Component component) {

		this.constraints.setRow(1);
		this.constraints.setWeightY(1);
		this.constraints.setFill(GridBagConstraints.BOTH);
		this.constraints.setAnchor(GridBagConstraints.NORTH);
		this.add(component, this.constraints);
		return this;
	}

	public MainWindow addSouth(Component component) {
		this.constraints.setRow(2);
		this.constraints.setWeightY(0);
		this.constraints.setFill(GridBagConstraints.HORIZONTAL);
		this.constraints.setAnchor(GridBagConstraints.SOUTH);
		this.add(component, this.constraints);
		return this;
	}

	public MainWindow addSouth(Component component, Insets insets) {

		this.constraints.setInsets(insets);
		this.constraints.setRow(2);
		this.constraints.setWeightY(0);
		this.constraints.setFill(GridBagConstraints.HORIZONTAL);
		this.constraints.setAnchor(GridBagConstraints.SOUTH);
		this.add(component, this.constraints);
		return this;
	}

	public void flip(Cards card) {
		AbstractView view = views.get(card);
		view.onFlip();
		this.description.setText(card.getDescription());
		layout.show(this.mainPanel, card.getLabel());
	}

	public HashMap<Cards, AbstractView> getViews() {
		return this.views;
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 400));
		setPreferredSize(new Dimension(800, 400));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
