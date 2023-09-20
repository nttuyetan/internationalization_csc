import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Định dạng ngày hợp lệ: dd/mm/yyyy và các quy tắc về ngày
 */

public class E3_DateFormat {

    private JFrame frame;
    private JPanel panel;
    private JLabel lblDate;
    private JTextField txtDate;
    private JButton btnCheck;
    private JTextArea result;

    private static String date;

    public E3_DateFormat() {
        frame = new JFrame("CHECK A DATE (dd/MM/yyyy) BETWEEN 1900 - 2099");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        gbc.weighty = 1;

        lblDate = new JLabel("File name:");
        lblDate.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblDate, gbc);

        txtDate = new JTextField();
        txtDate.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtDate, gbc);

        btnCheck = new JButton("CHECK");
        btnCheck.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btnCheck, gbc);

        result = new JTextArea();
        result.setEditable(false);
        result.setPreferredSize(new Dimension(360, 100));
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        result.setAlignmentY(Component.CENTER_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(result, gbc);

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isValidSyntax(txtDate.getText())) {
                    if (isValidDate())
                        result.setText("VALID");
                    else
                        result.setText("INVALID! TRY AGAIN!");
                    }
                else
                    result.setText("INVALID! TRY AGAIN!");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new E3_DateFormat();
    }

    public static boolean isValidSyntax(String d) {
        if (d.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/(19|20)\\d\\d")) {
            date = d;
            return true;
        }
        return false;
    }

    public static boolean isValidDate() {
        String[] checkedDate = date.split("/");
        int day = Integer.parseInt(checkedDate[0]);
        int month = Integer.parseInt(checkedDate[1]);

        if (day <= 28)
            return true;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                if (day <= 31)
                    return true;
                break;
            case 2:
                if (isLeapYear() && day <= 29)
                    return true;
                else if (day <= 28)
                    return true;
                break;
            case 4, 6, 9, 11:
                if (day <= 30)
                    return true;
                break;
            }

        return false;
    }

    public static boolean isLeapYear() {
        String[] checkedDate = date.split("/");
        int year = Integer.parseInt(checkedDate[2]);

        if ((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0))
            return true;

        return false;
    }
}
