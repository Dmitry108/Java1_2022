package homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CounterViewImpl extends JFrame implements CounterView {

    private final CounterPresenter presenter = new CounterPresenterImpl(this);
    private final Font appFont = new Font("Arial", Font.BOLD, 32);

    private final JTextField counterTextField = new JTextField("0");
    private final JButton decrementButton = new JButton("<");
    private final JButton incrementButton = new JButton(">");

    private final ActionListener textFieldListener = event -> {
        try {
            presenter.setValue(Integer.parseInt(counterTextField.getText()));
        } catch (NumberFormatException e) {
            presenter.setValue(0);
        }
    };

    public CounterViewImpl() {
        createView();
    }

    private void createView() {
        setBounds(500, 500, 300, 120);
        setTitle("Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        counterTextField.setHorizontalAlignment(SwingConstants.CENTER);
        counterTextField.addActionListener(textFieldListener);
        add(counterTextField, BorderLayout.CENTER);

        decrementButton.addActionListener(event -> {
            textFieldListener.actionPerformed(event);
            presenter.decrement();
        });
        add(decrementButton, BorderLayout.WEST);

        incrementButton.addActionListener(event -> {
            textFieldListener.actionPerformed(event);
            presenter.increment();
        });
        add(incrementButton, BorderLayout.EAST);

        for (Component component : this.getComponents()) {
            component.setFont(appFont);
        }
        setVisible(true);
    }

    @Override
    public void showValue(int value) {
        counterTextField.setText(String.valueOf(value));
    }
}