
/*
Định dạng tên tập tin hình hợp lệ: là chuỗi không có khoảng trắng, tiếp đó là dấu “.” Và
cuối cùng là phần mở rộng “jpg” hoặc “png” hoặc “gif” hoặc “bmp”. Phần mở rộng không
phân biệt chữ hoa, chữ thường.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class E2_ImageFileFormat {
    private JFrame frame;
    private JPanel panel;
    private JLabel lblFilename;
    private JTextField txtFilename;
    private JButton btnCheck;
    private JTextArea result;

    public E2_ImageFileFormat() {
        frame = new JFrame("CHECK VALIDATION OF FILE NAME");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        gbc.weighty = 1;

        lblFilename = new JLabel("File name:");
        lblFilename.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblFilename, gbc);

        txtFilename = new JTextField();
        txtFilename.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtFilename, gbc);

        btnCheck = new JButton("CHECK");
        btnCheck.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btnCheck, gbc);

        result = new JTextArea();
        result.setEditable(false);
        result.setPreferredSize(new Dimension(360, 100));
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(result, gbc);

        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filename = txtFilename.getText();

                if (isValidImageFile(filename))
                    result.setText("VALID");
                else
                    result.setText("INVALID! TRY AGAIN!");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new E2_ImageFileFormat();
    }

    public static boolean isValidImageFile(String filename) {
        return filename.matches("^[^.\\s]+\\.(?i)(jpg|png|gif|bmp)$");
    }
}
