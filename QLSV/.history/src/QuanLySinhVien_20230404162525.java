import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class QuanLySinhVien extends JFrame {

    private List<SinhVien> danhSachSinhVien;
    private JTable tableSinhVien;
    private DefaultTableModel tableModel;
    private JTextField txtHoTen;
    private JTextField txtMaSV;
    private JTextField txtDiemTB;

    public QuanLySinhVien() {
        super("Quan ly sinh vien");

        // Tao danh sach sinh vien tu file data.bin
        danhSachSinhVien = new ArrayList<>();
        docDuLieuTuFile();
        // Tao bang hien thi danh sach sinh vien
        tableModel = new DefaultTableModel(new String[] { "Ho ten", "Ma SV", "Diem TB" }, 0);
        tableSinhVien = new JTable(tableModel);
        tableSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tableSinhVien);
        tableSinhVien.setFillsViewportHeight(true);

        // Tao panel chua cac text field de nhap thong tin sinh vien
        JPanel panelTextFields = new JPanel();
        panelTextFields.setLayout(new BoxLayout(panelTextFields, BoxLayout.Y_AXIS));
        panelTextFields.setBorder(BorderFactory.createTitledBorder("Thong tin sinh vien"));

        JLabel lblHoTen = new JLabel("Ho ten:");
        txtHoTen = new JTextField();
        panelTextFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTextFields.add(lblHoTen);
        panelTextFields.add(txtHoTen);

        JLabel lblMaSV = new JLabel("Ma SV:");
        txtMaSV = new JTextField();
        panelTextFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTextFields.add(lblMaSV);
        panelTextFields.add(txtMaSV);

        JLabel lblDiemTB = new JLabel("Diem TB:");
        txtDiemTB = new JTextField();
        panelTextFields.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTextFields.add(lblDiemTB);
        panelTextFields.add(txtDiemTB);
        // Tao cac nut chuc nang
        JButton btnThem = new JButton("Them");
        JButton btnSua = new JButton("Sua");
        JButton btnXoa = new JButton("Xoa");
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
        panelButtons.add(Box.createRigidArea(new Dimension(0, 5)));
        panelButtons.add(btnThem);
        panelButtons.add(Box.createRigidArea(new Dimension(5, 0)));
        panelButtons.add(btnSua);
        panelButtons.add(Box.createRigidArea(new Dimension(5, 0)));
        panelButtons.add(btnXoa);
        panelButtons.add(Box.createHorizontalGlue());

        // Them cac component vao frame
        add(scrollPane, BorderLayout.CENTER);
        add(panelTextFields, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.SOUTH);

        // Them su kien cho nut Them
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                themSinhVien();
            }
        });

        // Them su kien cho nut Sua
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                suaSinhVien();
            }
        });

        // Them su kien cho nut Xoa
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xoaSinhVien();
            }
        });

        // Kich thuoc cua frame
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Ham them sinh vien vao danh sach
    private void themSinhVien() {
        String hoTen = txtHoTen.getText().trim();
        String maSV = txtMaSV.getText().trim();
        String diemTBStr = txtDiemTB.getText().trim();
        if (hoTen.isEmpty() || maSV.isEmpty() || diemTBStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap day du thong tin");
            return;
        }
        float diemTB = 0;
        try {
            diemTB = Float.parseFloat(diemTBStr);
            if (diemTB < 0 || diemTB > 10) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Diem trung binh khong hop le");
            return;
        }
        SinhVien sv = new SinhVien(hoTen, maSV, diemTB);
        danhSachSinhVien.add(sv);
        tableModel.addRow(new Object[] { hoTen, maSV, diemTB });
        txtHoTen.setText("");
        txtMaSV.setText("");
        txtDiemTB.setText("");
        ghiDuLieuVaoFile();
    }

    // Ham sua sinh vien trong danh sach
    private void suaSinhVien() {
        int row = tableSinhVien.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui long chon sinh vien de sua");
            return;
        }
        String hoTen = txtHoTen.getText().trim();
        String maSV = txtMaSV.getText().trim();
        String diemTBStr = txtDiemTB.getText().trim();
        if (hoTen.isEmpty() || maSV.isEmpty() || diemTBStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap day du thong tin");
            return;
        }
        float diemTB = 0;
        try {
            diemTB = Float.parseFloat(diemTBStr);
            if (diemTB < 0 || diemTB > 10) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Diem trung binh khong hop le");
            return;
        }
        SinhVien sv = danhSachSinhVien.get(row);
        sv.setHoTen(hoTen);
        sv.setMssv(maSV);
        sv.setDiem(diemTB);
        tableModel.setValueAt(hoTen, row, 0);
        tableModel.setValueAt(maSV, row, 1);
        tableModel.setValueAt(diemTB, row, 2);
        txtHoTen.setText("");
        txtMaSV.setText("");
        txtDiemTB.setText("");
    }

    // Ham xoa sinh vien khoi danh sach
    private void xoaSinhVien() {
        int row = tableSinhVien.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui long chon sinh vien de xoa");
            return;
        }
        danhSachSinhVien.remove(row);
        tableModel.removeRow(row);
        txtHoTen.setText("");
        txtMaSV.setText("");
        txtDiemTB.setText("");
    }

    // Ham doc du lieu tu file va hien thi tren bang
    private void docDuLieuTuFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
            danhSachSinhVien = (ArrayList<SinhVien>) ois.readObject();
            for (SinhVien sv : danhSachSinhVien) {
                tableModel.addRow(new Object[] { sv.getHoTen(), sv.getMssv(), sv.getDiem() });
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    // Ham ghi du lieu vao file
    private void ghiDuLieuVaoFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(danhSachSinhVien);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Main
    public static void main(String[] args) {
        new QuanLySinhVien();

    }
}
