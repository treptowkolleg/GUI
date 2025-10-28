package view.components;

import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import core.AbstractView;
import view.Cards;
import view.MainWindow;

public class CustomMenuBar extends JMenuBar {

	private MainWindow frame;
	private JMenu functionsMenu = new JMenu("Funktionen");

	public CustomMenuBar(MainWindow frame) {
		this.frame = frame;
	}

	public void init() {
		for (Map.Entry<Cards, AbstractView> element : this.frame.getViews().entrySet()) {
			JMenuItem item = new JMenuItem(element.getKey().getDescription());
			item.addActionListener(e -> this.frame.flip(element.getKey()));
			this.functionsMenu.add(item);
		}
		this.add(functionsMenu);
	}

}
