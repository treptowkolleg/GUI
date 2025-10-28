package listener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldButtonEnabler {
	
	public static void enableWhenNotEmpty(JTextField textField, JButton button) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            private void updateButtonState() {
                SwingUtilities.invokeLater(() -> 
                    button.setEnabled(!textField.getText().trim().isEmpty())
                );
            }
        });

        // Initialzustand setzen
        button.setEnabled(!textField.getText().trim().isEmpty());
    }

}
