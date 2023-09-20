
/*
Practice ResourceBundle
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class E5_FlightTicket {

    private JLabel lblSearch;
    private JLabel lblType;
    private JRadioButton rbOneWay;
    private JRadioButton rbRoundTrip;
    private JLabel lblDeparture;
    private JComboBox cbDeparture;
    private JLabel lblDestination;
    private JComboBox cbDestination;
    private JLabel lblDepartureDate;
    private JTextField txtDepartureDate;
    private JLabel lblReturnDate;
    private JTextField txtReturnDate;
    private JLabel lblAdults;
    private JComboBox cbAdults;
    private JLabel lblChildren;
    private JComboBox cbChildren;
    private JLabel lblInfant;
    private JComboBox cbInfant;
    private JButton btnSearch;

    public E5_FlightTicket() {
        JFrame frame = new JFrame("Searching for flight tickets");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JButton btnVi = new JButton("Tieng Viet");
        btnVi.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(btnVi, gbc);

        JButton btnEn = new JButton("English");
        btnEn.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(btnEn, gbc);

        lblSearch = new JLabel();
        lblSearch.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(lblSearch, gbc);

        lblType = new JLabel();
        lblType.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblType, gbc);

        rbOneWay = new JRadioButton();
        rbOneWay.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(rbOneWay, gbc);

        rbRoundTrip = new JRadioButton();
        rbRoundTrip.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(rbRoundTrip, gbc);

        lblDeparture = new JLabel();
        lblDeparture.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblDeparture, gbc);

        cbDeparture = new JComboBox();
        cbDeparture.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cbDeparture, gbc);

        lblDestination = new JLabel();
        lblDestination.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblDestination, gbc);

        cbDestination = new JComboBox();
        cbDestination.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(cbDestination, gbc);

        lblDepartureDate = new JLabel();
        lblDepartureDate.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblDepartureDate, gbc);

        txtDepartureDate = new JTextField();
        txtDepartureDate.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(txtDepartureDate, gbc);

        lblReturnDate = new JLabel();
        lblReturnDate.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(lblReturnDate, gbc);

        txtReturnDate = new JTextField();
        txtReturnDate.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(txtReturnDate, gbc);

        lblAdults = new JLabel();
        lblAdults.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(lblAdults, gbc);

        cbAdults = new JComboBox(new Object[]{1, 2, 3, 4, 5});
        cbAdults.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(cbAdults, gbc);

        lblChildren = new JLabel();
        lblChildren.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(lblChildren, gbc);

        cbChildren = new JComboBox(new Object[]{1, 2, 3, 4, 5});
        cbChildren.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(cbChildren, gbc);

        lblInfant = new JLabel();
        lblInfant.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(lblInfant, gbc);

        cbInfant = new JComboBox(new Object[]{1, 2, 3, 4, 5});
        cbInfant.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(cbInfant, gbc);

        btnSearch = new JButton();
        btnSearch.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 1;
        gbc.gridy = 10;
        panel.add(btnSearch, gbc);

        String defaultLanguage = "vi";
        String defaultCountry = "VN";
        changeTicketFormByLanguage(defaultLanguage, defaultCountry);

        btnVi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = "vi";
                String country = "VN";
                changeTicketFormByLanguage(language, country);
            }
        });

        btnEn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = "en";
                String country = "US";
                changeTicketFormByLanguage(language, country);
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new E5_FlightTicket();
    }

    private void changeTicketFormByLanguage(String language, String country) {
        Locale currentLocal = new Locale(language, country);
        ResourceBundle messages = ResourceBundle.getBundle("TicketLabel", currentLocal);

        lblSearch.setText(messages.getString("searchTickets"));
        lblType.setText(messages.getString("ticketType"));
        rbOneWay.setText(messages.getString("oneWay"));
        rbRoundTrip.setText(messages.getString("roundTrip"));
        lblDeparture.setText(messages.getString("departure"));
        lblDestination.setText(messages.getString("destination"));
        lblDepartureDate.setText(messages.getString("departureDate"));
        lblReturnDate.setText(messages.getString("returnDate"));
        lblAdults.setText(messages.getString("adults"));
        lblChildren.setText(messages.getString("children"));
        lblInfant.setText(messages.getString("infant"));
        btnSearch.setText(messages.getString("search"));
    }
}
