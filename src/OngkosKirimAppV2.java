import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AplikasiOngkir {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

class LoginFrame extends JFrame {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JCheckBox cbShowPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("https//AplikasiCekOnkosKirim.com");
        ImageIcon icon = new ImageIcon("src/download (10).png");
        setIconImage(icon.getImage());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel leftPanel = new GradientPanel(new Color(255, 169, 76), new Color(255, 71, 140));
        leftPanel.setLayout(new GridBagLayout());
        JLabel leftLabel = new JLabel("WELCOME");
        leftLabel.setForeground(new Color(255,246,233));
        leftLabel.setFont(new Font("Arial", Font.BOLD, 30));
        leftPanel.add(leftLabel);

        JPanel rightPanel = new GradientPanel(new Color(251, 233, 214), new Color(251, 214, 228));
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.BLACK);
        rightPanel.add(lblEmail, gbc);

        gbc.gridy = 1;
        tfEmail = new RoundedTextField(15);
        rightPanel.add(tfEmail, gbc);

        gbc.gridy = 2;
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.BLACK);
        rightPanel.add(lblPassword, gbc);

        gbc.gridy = 3;
        pfPassword = new RoundedPasswordField(15);
        pfPassword.setEchoChar('*');
        rightPanel.add(pfPassword, gbc);

        gbc.gridy = 4;
        cbShowPassword = new JCheckBox("Show Password");
        cbShowPassword.setFont(new Font("Arial", Font.BOLD, 10));
        cbShowPassword.setForeground(new Color(0, 211, 13));
        cbShowPassword.setOpaque(false);
        cbShowPassword.addActionListener(e -> pfPassword.setEchoChar(cbShowPassword.isSelected() ? '\0' : '*'));
        rightPanel.add(cbShowPassword, gbc);

        gbc.gridy = 6;
        btnLogin = new RoundedButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setPreferredSize(new Dimension(103, 25));
        btnLogin.setForeground(new Color(255,246,233));
        btnLogin.addActionListener(e -> {
            if (!tfEmail.getText().isEmpty() && pfPassword.getPassword().length > 0) {
                new MainFrame(tfEmail.getText()).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Isi semua kolom!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        rightPanel.add(btnLogin, gbc);

        btnLogin.addActionListener(e -> {
            String email = tfEmail.getText().trim();
            char[] password = pfPassword.getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(this, "Isi semua kolom!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!email.contains("@gmail.com")) {
                JOptionPane.showMessageDialog(this, "Masukkan email yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                new MainFrame(email).setVisible(true);
                dispose();
            }
        });
        rightPanel.add(btnLogin, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(200);
        splitPane.setDividerSize(0);
        add(splitPane, BorderLayout.CENTER);
    }
}

class MainFrame extends JFrame {
    private JTextField tfAsal, tfTujuan, tfBerat;
    private JButton btnCekOngkir, btnTambah;
    private JLabel lblHarga;
    private JTable table;
    private DefaultTableModel tableModel;

    public MainFrame(String userEmail) {
        setTitle("Cek Ongkir");
        ImageIcon icon = new ImageIcon("src/download (10).png");
        setIconImage(icon.getImage());
        setSize(1010, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel leftPanel = new GradientPanel(new Color(255, 169, 76), new Color(255, 71, 140));
        leftPanel.setLayout(new GridBagLayout());
        JLabel leftLabel = new JLabel("WELCOME");
        leftLabel.setForeground(new Color(255,246,233));
        leftLabel.setFont(new Font("Arial", Font.BOLD, 30));
        leftPanel.add(leftLabel);

        JPanel rightPanel = new GradientPanel(new Color(251, 233, 214), new Color(251, 214, 228));
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblAsal = new JLabel("Alamat Asal:");
        lblAsal.setForeground(Color.BLACK);
        rightPanel.add(lblAsal, gbc);

        gbc.gridy = 1;
        tfAsal = new RoundedTextField(15);
        rightPanel.add(tfAsal, gbc);

        gbc.gridy = 2;
        JLabel lblTujuan = new JLabel("Alamat Tujuan:");
        lblTujuan.setForeground(Color.BLACK);
        rightPanel.add(lblTujuan, gbc);

        gbc.gridy = 3;
        tfTujuan = new RoundedTextField(15);
        rightPanel.add(tfTujuan, gbc);

        gbc.gridy = 4;
        JLabel lblBerat = new JLabel("Berat Barang (kg):");
        lblBerat.setForeground(Color.BLACK);
        rightPanel.add(lblBerat, gbc);

        gbc.gridy = 5;
        tfBerat = new RoundedTextField(15);
        rightPanel.add(tfBerat, gbc);

        gbc.gridy = 6;
        btnCekOngkir = new RoundedButton("Cek Ongkir");
        btnCekOngkir.setFont(new Font("Arial", Font.BOLD, 14));
        btnCekOngkir.setPreferredSize(new Dimension(173, 25));
        btnCekOngkir.setForeground(new Color(255,246,233));
        lblHarga = new JLabel("Harga: -");
        lblHarga.setForeground(new Color(0, 211, 13));
        rightPanel.add(btnCekOngkir, gbc);

        gbc.gridy = 7;
        rightPanel.add(lblHarga, gbc);

        btnCekOngkir.addActionListener(e -> {
            try {
                double berat = Double.parseDouble(tfBerat.getText().trim());
                double harga = berat * 5000;
                lblHarga.setText("Harga: Rp " + harga);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridy = 8;
        btnTambah = new RoundedButton("Tambah ke Tabel");
        btnTambah.setFont(new Font("Arial", Font.BOLD, 14));
        btnTambah.setPreferredSize(new Dimension(173, 25));
        btnTambah.setForeground(new Color(255,246,233));
        rightPanel.add(btnTambah, gbc);

        gbc.gridy = 9;
        tableModel = new DefaultTableModel(new String[]{"Email/HP", "Asal", "Tujuan", "Berat (kg)", "Harga"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 200));
        rightPanel.add(scrollPane, gbc);

        btnTambah.addActionListener(e -> {
            String asal = tfAsal.getText();
            String tujuan = tfTujuan.getText();
            double berat = Double.parseDouble(tfBerat.getText().trim());
            double harga = berat * 5000;
            tableModel.addRow(new Object[]{userEmail, asal, tujuan, berat, harga});
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(300);
        splitPane.setDividerSize(0);
        add(splitPane, BorderLayout.CENTER);
    }
}

class GradientPanel extends JPanel {
    private final Color startColor;
    private final Color endColor;

    public GradientPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new GradientPaint(0, 0, startColor, 0, getHeight(), endColor));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gradien latar belakang
        GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 169, 76), getWidth(), getHeight(), new Color(255, 71, 140));
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());

        // Border tombol (opsional)
        g2.setColor(new Color(255, 71, 140));
        g2.drawRoundRect(0, 0, getWidth() + 1, getHeight() + 1, getHeight(), getHeight());

        g2.dispose();
        super.paintComponent(g);
    }
}

class RoundedTextField extends JTextField {
    private int arcWidth = 20;
    private int arcHeight = 20;

    public RoundedTextField(int columns) {
        super(columns);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 169, 76), getWidth(), getHeight() , new Color(255, 71, 140));
        g2.setPaint(gradient);
        g2.drawRoundRect(0, 0, getWidth() + 1, getHeight() - 1, arcWidth, arcHeight);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void setBorder(Border border) {
    }
}

class RoundedPasswordField extends JPasswordField {
    private int arcWidth = 20;
    private int arcHeight = 20;

    public RoundedPasswordField(int columns) {
        super(columns);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Margin internal teks
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 169, 76), getWidth(), getHeight(), new Color(255, 71, 140));
        g2.setPaint(gradient);
        g2.drawRoundRect(0, 0, getWidth() + 1, getHeight() - 1, arcWidth, arcHeight);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void setBorder(Border border) {
    }
}
