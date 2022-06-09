import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.List;

public class GUI extends JFrame implements ActionListener {
    private JPanel containerPanel;
    private JPanel addKierunkiPanel;
    private JPanel showKierunkiPanel;
    private JTextField nazwaKierunkuTf;
    private JComboBox rodzajKierunkuCb;
    private JComboBox kolegiumCb;
    private JButton addKierunekBtn;
    private JTable tabelaKierunki;
    private JTextField szukajKierunekTf;
    private JButton usunKierunekBtn;
    private JPanel showKolegiaPanel;
    private JTable tablaKolegia;
    private JPanel showPracownicyPanel;
    private JTable tabelaPracownicy;
    private JTextField szukajPracownikaTf;
    private JPanel dodajPracownikaPanel;
    private JTextField dodajPracoTfImie;
    private JTextField dodajPracoTfNazwisko;
    private JComboBox dodajPracoStCb;
    private JComboBox dodajPracoInstytutCb;
    private JRadioButton dodajPracoNieRadioButton;
    private JRadioButton dodajPracoTakRadioButton;
    private JButton dodajPracownikaBtn;
    private JPanel showPrzedmiotyPanel;
    private JTable tabelaPrzedmioty;
    private JTextField szukajPrzedmiotTf;
    private JButton usunPrzedmiotBtn;
    private JButton usunPracownikaBtn;
    private JPanel dodajPrzedmiotPanel;
    private JTextField dodajPrzedmiotyNazwaTf;
    private JTextField dodajPrzedmiotEctsTf;
    private JButton dodajPrzedmiotBtn;
    private JPanel showRocznikiPanel;
    private JTable tabelaRoczniki;
    private JPanel showStudenciPanel;
    private JTable tabelaStudenci;
    private JTextField szukajStudentaTf;
    private JButton usunStudentaBtn;
    private JPanel dodajStudentaPanel;
    private JTextField dodajStudentaPeselTf;
    private JTextField dodajStudentaImieTf;
    private JTextField dodajStudentaNazwiskoTf;
    private JRadioButton mezczyznaRadioBtn;
    private JRadioButton kobietaRadioBtn;
    private JCheckBox socjalneCheckBox;
    private JCheckBox rektoraCheckBox;
    private JButton dodajStudentaBtn;
    private JComboBox comboBoxFiltrKierunki;
    private JPanel panelStart;
    private JTable pracoTable;
    private JTable dodajPrzedmiotPracownikTable;
    private JTable dodajPrzedmiotKierunekTable;
    private JTable dodajStudentaKierunekTable;
    private JTextField textFieldKierunkiWarunek;
    private JComboBox comboBoxKolegiaColumn2;
    private JComboBox comboBoxPracownicyiColumn;
    private JComboBox comboBoxPrzedmiotyColumn;
    private JComboBox comboBoxRocznikiColumn;
    private JComboBox comboBoxStudenciColumn;
    private JComboBox comboBoxKierunkiColumn;
    private JTextField textFieldKolegiaWarunek;
    private JTextField textFieldPracownicyWarunek;
    private JTextField textFieldPrzedmiotyWarunek;
    private JTextField textFieldRocznikiWarunek;
    private JTextField textFieldStudenciWarunek;
    private JButton buttonExport;
    private JPanel panelExport;
    private JTable tabelaPodgladCSV;
    private JRadioButton KierunkiRbEx;
    private JRadioButton KolegiaRbEx;
    private JRadioButton PracownicyRbEx;
    private JRadioButton PrzedmiotyRbEx;
    private JRadioButton RocznikiRbEx;
    private JRadioButton StudenciRbEx;
    private JComboBox comboBoxNazwyKolumn;
    private JTextField textFieldWarunekExport;
    private JButton btnFiltrExport;
    private JPanel panelImport;
    private JRadioButton radioButtonKierunki;
    private JRadioButton radioButtonKolegia;
    private JRadioButton radioButtonPracownicy;
    private JRadioButton radioButtonPrzedmioty;
    private JRadioButton radioButtonRoczniki;
    private JCheckBox HEADERCheckBox;
    private JComboBox comboBoxDelimiter;
    private JButton importButton;
    private JRadioButton radioButtonStudenci;
    private JButton buttonFileChooserImport;
    private JLabel directoryImportLabel;
    private JButton prac_bez_opie_btn;
    private JButton resetRocznikiBtn;
    private JButton showRocznikBtn;
    private JTextField rokRocznikiTf;
    CardLayout cl = new CardLayout();

    DataBase connection = new DataBase();

    JMenuItem importCSV, exportCSV, usunStudenta, dodajStudenta, usunPrzedmiot, dodajPrzedmiot, usunPracownika, dodajPracownika, usunKierunek, dodajKierunek, listaKierunek, listaKolegia, listaPracownicy, listaPrzedmioty, listaRoczniki, listaStudenci;
    JMenuBar menuBar;
    JMenu jMenuOpcje, jMenuKierunki, jMenuKolegia, jMenuPracownicy, jMenuPrzedmioty, jMenuRoczniki, jMenuStudenci;
    ButtonGroup importGroup;
    public GUI() {
        super("Uczelnia");
        this.setContentPane(containerPanel);
        this.setLayout(cl);
        int width = 600;
        int height = 600;
        setSize(width, height);
        this.pack();

        containerPanel.add(panelStart, "panelStart");
        containerPanel.add(showKierunkiPanel, "showKierunkiPanel");
        containerPanel.add(addKierunkiPanel, "addKierunkiPanel");
        containerPanel.add(showKolegiaPanel, "showKolegiaPanel");
        containerPanel.add(showPracownicyPanel, "showPracownicyPanel");
        containerPanel.add(dodajPracownikaPanel, "dodajPracownikaPanel");
        containerPanel.add(showPrzedmiotyPanel, "showPrzedmiotyPanel");
        containerPanel.add(dodajPrzedmiotPanel, "dodajPrzedmiotPanel");
        containerPanel.add(showRocznikiPanel, "showRocznikiPanel");
        containerPanel.add(showStudenciPanel, "showStudenciPanel");
        containerPanel.add(dodajStudentaPanel, "dodajStudentaPanel");
        containerPanel.add(panelExport, "panelExport");
        containerPanel.add(panelImport, "panelImport");

        menuBar = new JMenuBar();
        Font font1 = new Font("SansSerif", Font.BOLD, 16);
        menuBar.setFont(font1);
        UIManager.put("Menu.font", font1);
        jMenuKierunki = new JMenu("Kierunki");
        jMenuKolegia = new JMenu("Kolegia");
        jMenuPracownicy = new JMenu("Pracownicy");
        jMenuPrzedmioty = new JMenu("Przedmioty");
        jMenuRoczniki = new JMenu("Roczniki");
        jMenuStudenci = new JMenu("Studenci");
        jMenuOpcje = new JMenu("Opcje");

        exportCSV = new JMenuItem("Exportuj do CSV");
        importCSV = new JMenuItem("Importuj z CSV");

        listaKierunek = new JMenuItem("Wyświetl/Usuń kierunki");
        dodajKierunek = new JMenuItem("dodaj kierunek");

        listaKolegia = new JMenuItem("Wyświetl kolegia");

        listaPracownicy = new JMenuItem("Wyświetl/Usuń pracowników");
        dodajPracownika = new JMenuItem("Dodaj pracownika");


        listaPrzedmioty = new JMenuItem("Wyświetl/Usuń przedmioty");
        dodajPrzedmiot = new JMenuItem("Dodaj przedmiot");


        listaRoczniki = new JMenuItem("Wyświetl roczniki");


        listaStudenci = new JMenuItem("Wyświetl/Usuń studentów");
        dodajStudenta = new JMenuItem("Dodaj studenta");


        exportCSV.addActionListener(this);

        KierunkiRbEx.addActionListener(this);
        KolegiaRbEx.addActionListener(this);
        PracownicyRbEx.addActionListener(this);
        PrzedmiotyRbEx.addActionListener(this);
        RocznikiRbEx.addActionListener(this);
        StudenciRbEx.addActionListener(this);
        buttonExport.addActionListener(this);

        importCSV.addActionListener(this);
        buttonFileChooserImport.addActionListener(this);
        importButton.addActionListener(this);


        ButtonGroup group = new ButtonGroup();
        group.add(KierunkiRbEx);
        group.add(KolegiaRbEx);
        group.add(PracownicyRbEx);
        group.add(PrzedmiotyRbEx);
        group.add(RocznikiRbEx);
        group.add(StudenciRbEx);

        importGroup = new ButtonGroup();
        importGroup.add(radioButtonKierunki);
        importGroup.add(radioButtonKolegia);
        importGroup.add(radioButtonPracownicy);
        importGroup.add(radioButtonPrzedmioty);
        importGroup.add(radioButtonStudenci);
        importGroup.add(radioButtonRoczniki);

        listaKierunek.addActionListener(this);
        dodajKierunek.addActionListener(this);

        listaKolegia.addActionListener(this);

        listaPracownicy.addActionListener(this);
        dodajPracownika.addActionListener(this);

        listaPrzedmioty.addActionListener(this);
        dodajPrzedmiot.addActionListener(this);
        dodajPrzedmiotBtn.addActionListener(this);

        listaRoczniki.addActionListener(this);
        resetRocznikiBtn.addActionListener(this);
        showRocznikBtn.addActionListener(this);

        listaStudenci.addActionListener(this);
        dodajStudenta.addActionListener(this);
        dodajStudentaBtn.addActionListener(this);
        usunStudentaBtn.addActionListener(this);
        mezczyznaRadioBtn.addActionListener(this);
        kobietaRadioBtn.addActionListener(this);

        comboBoxFiltrKierunki.addActionListener(this);
        szukajKierunekTf.addActionListener(this);
        usunKierunekBtn.addActionListener(this);
        addKierunekBtn.addActionListener(this);

        dodajPracoNieRadioButton.addActionListener(this);
        dodajPracoTakRadioButton.addActionListener(this);
        dodajPracownikaBtn.addActionListener(this);
        usunPracownikaBtn.addActionListener(this);
        prac_bez_opie_btn.addActionListener(this);

        usunPrzedmiotBtn.addActionListener(this);

        jMenuOpcje.add(exportCSV);
        jMenuOpcje.add(importCSV);

        jMenuKierunki.add(listaKierunek);
        jMenuKierunki.add(dodajKierunek);

        jMenuKolegia.add(listaKolegia);

        jMenuPracownicy.add(listaPracownicy);
        jMenuPracownicy.add(dodajPracownika);

        jMenuPrzedmioty.add(listaPrzedmioty);
        jMenuPrzedmioty.add(dodajPrzedmiot);

        jMenuRoczniki.add(listaRoczniki);

        jMenuStudenci.add(listaStudenci);
        jMenuStudenci.add(dodajStudenta);

        setJMenuBar(menuBar);

        menuBar.add(jMenuKierunki);
        menuBar.add(jMenuKolegia);
        menuBar.add(jMenuPracownicy);
        menuBar.add(jMenuPrzedmioty);
        menuBar.add(jMenuRoczniki);
        menuBar.add(jMenuStudenci);
        menuBar.add(jMenuOpcje);

        szukajKierunekTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                cl.show(containerPanel, "showKierunkiPanel");
                List kierunki;
                if (szukajKierunekTf.getText() == "") {
                    kierunki = Kierunki.showList();
                } else {
                    kierunki = Kierunki.searchKierunki(szukajKierunekTf.getText());
                }
                int rekordy = kierunki.size() / 2;
                String data[][] = new String[rekordy][2];
                for (int i = 0, k = 0; i < rekordy; i++) {
                    for (int j = 0; j < 2; j++) {
                        data[i][j] = (String) kierunki.get(k);
                        k++;

                    }
                }
                TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "Rodzaj studiów"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelaKierunki.setModel(model);
            }
        });
        szukajPracownikaTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                List praco;
                if (szukajPracownikaTf.getText() == "") {
                    praco = Pracownicy.listPrac();
                } else {
                    praco = Pracownicy.searchPraco(szukajPracownikaTf.getText());
                }
                int rekordy = praco.size() / 4;
                String data[][] = new String[rekordy][4];
                for (int i = 0, k = 0; i < rekordy; i++) {
                    for (int j = 0; j < 4; j++) {
                        data[i][j] = (String) praco.get(k);
                        k++;

                    }
                }
                TableModel model = new DefaultTableModel(data, new String[]{"Imie", "Nazwisko", "Stopień", "Instytut"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelaPracownicy.setModel(model);
            }
        });
        szukajPrzedmiotTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                List przed;
                if (szukajPrzedmiotTf.getText().equals("")) {
                    przed = Przedmioty.listPrzed();
                } else {
                    przed = Przedmioty.searchPrzed(szukajPrzedmiotTf.getText());
                }

                int rekordy = przed.size() / 2;
                String data[][] = new String[rekordy][2];
                for (int i = 0, k = 0; i < rekordy; i++) {
                    for (int j = 0; j < 2; j++) {
                        data[i][j] = (String) przed.get(k);
                        k++;

                    }
                }
                TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "pkt ECTS"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelaPrzedmioty.setModel(model);
            }
        });

        szukajStudentaTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                List stud = Studenci.searchStud(szukajStudentaTf.getText());
                int rekordy = stud.size() / 9;
                String data[][] = new String[rekordy][9];
                for (int i = 0, k = 0; i < rekordy; i++) {
                    for (int j = 0; j < 9; j++) {
                        data[i][j] = (String) stud.get(k);
                        k++;

                    }
                }
                TableModel model = new DefaultTableModel(data, new String[]{"Nr albumu", "Pesel", "Imie", "Nazwisko", "Kierunek", "Rok", "Socjalne", "Rektorskie", "Płeć"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelaStudenci.setModel(model);
            }
        });

        btnFiltrExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tabela = "";
                for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        tabela = button.getText();
                    }
                }

                String kolumna = comboBoxNazwyKolumn.getModel().getSelectedItem().toString();
                String warunek = textFieldWarunekExport.getText();
                tabelaPodgladCSV.setModel(Export.filtrTable(tabela, kolumna, warunek));
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            GUI frame = new GUI();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if (zrodlo == usunKierunekBtn) {
            int selInt = tabelaKierunki.getSelectedRow();
            String toDel = tabelaKierunki.getModel().getValueAt(selInt, 0).toString();
            Kierunki.delRecord(toDel);

            List kierunki = Kierunki.showList();
            int rekordy = kierunki.size() / 2;
            String data[][] = new String[rekordy][2];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = (String) kierunki.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "Rodzaj studiów"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaKierunki.setModel(model);
            JOptionPane.showMessageDialog(null, "Pomyślnie usunięto jeden rekord");
            szukajKierunekTf.setText("");
            comboBoxFiltrKierunki.setSelectedIndex(0);
        } else if (zrodlo == comboBoxFiltrKierunki || zrodlo == listaKierunek || zrodlo == szukajKierunekTf) {
            if (zrodlo == listaKierunek) {
                szukajKierunekTf.setText("");
                comboBoxFiltrKierunki.setSelectedIndex(0);
            }
            cl.show(containerPanel, "showKierunkiPanel");
            List kierunki;
            if (comboBoxFiltrKierunki.getSelectedItem().toString() == "brak") {
                kierunki = Kierunki.showList();
            } else {
                kierunki = Kierunki.showList(comboBoxFiltrKierunki.getSelectedItem().toString());
            }
            int rekordy = kierunki.size() / 2;
            String data[][] = new String[rekordy][2];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = (String) kierunki.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "Rodzaj studiów"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaKierunki.setModel(model);

        } else if (zrodlo == dodajKierunek) {
            cl.show(containerPanel, "addKierunkiPanel");
            List praco = Pracownicy.listPrac();
            int rekordy = praco.size() / 4;
            String data[][] = new String[rekordy][4];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = (String) praco.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Imie", "Nazwisko", "Stopien", "Instytut"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            pracoTable.setModel(model);

        } else if (zrodlo == addKierunekBtn) {
            if (nazwaKierunkuTf.getText().equals("") || rodzajKierunkuCb.getSelectedItem() == null || kolegiumCb.getSelectedItem() == null || pracoTable.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(null, "Proszę wypełnić wszystkie pola!");
            } else {
                Boolean typ;
                if (rodzajKierunkuCb.getSelectedItem().toString() == "Licencjat") {
                    typ = true;
                } else {
                    typ = false;
                }

                Kierunki.dodajKierunek(nazwaKierunkuTf.getText(), typ, kolegiumCb.getSelectedIndex() + 1, pracoTable.getSelectedRow() + 1);
                JOptionPane.showMessageDialog(null, "Pomyślnie dodano kierunek");
                nazwaKierunkuTf.setText("");
                pracoTable.clearSelection();
                rodzajKierunkuCb.setSelectedIndex(0);
                kolegiumCb.setSelectedIndex(0);

            }
        } else if (zrodlo == listaKolegia) {
            cl.show(containerPanel, "showKolegiaPanel");
            List kolegia = Kolegia.listaKolegia();
            int rekordy = kolegia.size() / 2;
            String data[][] = new String[rekordy][2];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = (String) kolegia.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "Budynek"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tablaKolegia.setModel(model);

        } else if (zrodlo == listaPracownicy) {
            cl.show(containerPanel, "showPracownicyPanel");
            List praco = Pracownicy.listPrac();
            int rekordy = praco.size() / 4;
            String data[][] = new String[rekordy][4];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = (String) praco.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Imie", "Nazwisko", "Stopień", "Istytut"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaPracownicy.setModel(model);

        } else if (zrodlo == dodajPracownika) {
            cl.show(containerPanel, "dodajPracownikaPanel");
        } else if (zrodlo == dodajPracoNieRadioButton) {
            if (dodajPracoTakRadioButton.isSelected()) {
                dodajPracoTakRadioButton.setSelected(false);
            }
        } else if (zrodlo == dodajPracoTakRadioButton) {
            if (dodajPracoNieRadioButton.isSelected()) {
                dodajPracoNieRadioButton.setSelected(false);
            }
        } else if (zrodlo == dodajPracownikaBtn) {
            if (dodajPracoTfImie.getText().equals("") || dodajPracoTfNazwisko.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Proszę uzupełnić wszystkie pola!");
            } else {
                Boolean opiekun;
                if (dodajPracoTakRadioButton.isSelected()) opiekun = true;
                else opiekun = false;
                String imie = dodajPracoTfImie.getText();
                String nazwisko = dodajPracoTfNazwisko.getText();
                String stopien = dodajPracoStCb.getSelectedItem().toString();
                String instytut = dodajPracoInstytutCb.getSelectedItem().toString();
                Pracownicy.dodajPraco(imie, nazwisko, stopien, instytut, opiekun);
                JOptionPane.showMessageDialog(null, "Pomyślnie dodano pracownika!");
                dodajPracoTfNazwisko.setText("");
                dodajPracoTfImie.setText("");
                dodajPracoTakRadioButton.setSelected(false);
                dodajPracoNieRadioButton.setSelected(true);
                dodajPracoInstytutCb.setSelectedIndex(0);
                dodajPracoStCb.setSelectedIndex(0);
            }
        } else if (zrodlo == usunPracownikaBtn) {
            String imie = tabelaPracownicy.getModel().getValueAt(tabelaPracownicy.getSelectedRow(), 0).toString();
            String nazwisko = tabelaPracownicy.getModel().getValueAt(tabelaPracownicy.getSelectedRow(), 1).toString();

            Pracownicy.delRecord(imie, nazwisko);


            tabelaPracownicy.clearSelection();
            szukajPracownikaTf.setText("");
            List praco = Pracownicy.listPrac();
            int rekordy = praco.size() / 4;
            String data[][] = new String[rekordy][4];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = (String) praco.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Imie", "Nazwisko", "Stopień", "Instytut"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaPracownicy.setModel(model);

        } else if (zrodlo == listaPrzedmioty) {
            cl.show(containerPanel, "showPrzedmiotyPanel");
            List przed = Przedmioty.listPrzed();
            int rekordy = przed.size() / 2;
            String data[][] = new String[rekordy][2];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = (String) przed.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "pkt ECTS"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaPrzedmioty.setModel(model);

        } else if (zrodlo == usunPrzedmiotBtn) {
            Przedmioty.delRecord(tabelaPrzedmioty.getModel().getValueAt(tabelaPrzedmioty.getSelectedRow(), 0).toString());
            JOptionPane.showMessageDialog(null, "Pomyślnie usunięto przedmiot!");
        } else if (zrodlo == dodajPrzedmiot) {
            cl.show(containerPanel, "dodajPrzedmiotPanel");
            List praco = Pracownicy.listPrac();
            int rekordy = praco.size() / 4;
            String data[][] = new String[rekordy][4];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = (String) praco.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Imie", "Nazwisko", "Stopień", "Istytut"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            dodajPrzedmiotPracownikTable.setModel(model);


            List kierunki = Kierunki.showList();

            int rekordy2 = kierunki.size() / 2;
            String data2[][] = new String[rekordy2][2];
            for (int i = 0, k = 0; i < rekordy2; i++) {
                for (int j = 0; j < 2; j++) {
                    data2[i][j] = (String) kierunki.get(k);
                    k++;

                }
            }
            TableModel model2 = new DefaultTableModel(data2, new String[]{"Nazwa", "Rodzaj studiów"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            dodajPrzedmiotKierunekTable.setModel(model2);


        } else if (zrodlo == dodajPrzedmiotBtn) {
            int id_prac = dodajPrzedmiotPracownikTable.getSelectedRow() +1;
            int id_kier = dodajPrzedmiotKierunekTable.getSelectedRow() +1;
            if (dodajPrzedmiotyNazwaTf.getText() != null && dodajPrzedmiotEctsTf != null && dodajPrzedmiotPracownikTable.getSelectedRow() != -1 && dodajPrzedmiotKierunekTable.getSelectedRow() != -1) {
                Przedmioty.dodajPrzed(dodajPrzedmiotyNazwaTf.getText(), id_prac, id_kier, Integer.valueOf(dodajPrzedmiotEctsTf.getText()));
                JOptionPane.showMessageDialog(null, "Dodano przedmiot!");
                dodajPrzedmiotKierunekTable.clearSelection();
                dodajPrzedmiotPracownikTable.clearSelection();
                dodajPrzedmiotEctsTf.setText("");
                dodajPrzedmiotyNazwaTf.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Proszę uzupełnić wszystkie pola!");
            }
        } else if (zrodlo == listaRoczniki || zrodlo == resetRocznikiBtn) {
            cl.show(containerPanel, "showRocznikiPanel");
            List rocz = Roczniki.listaRoczniki();
            int rekordy = rocz.size() / 4;
            String data[][] = new String[rekordy][4];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = (String) rocz.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Data rozpoczęcia", "Stopień", "Typ", "Starosta"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaRoczniki.setModel(model);
        } else if (zrodlo == listaStudenci) {
            cl.show(containerPanel, "showStudenciPanel");
            List stud = Studenci.listStud();
            int rekordy = stud.size() / 9;
            String data[][] = new String[rekordy][9];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 9; j++) {
                    data[i][j] = (String) stud.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nr albumu", "Pesel", "Imie", "Nazwisko", "Kierunek", "Rok", "Socjalne", "Rektorskie", "Płeć"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaStudenci.setModel(model);
        } else if (zrodlo == dodajStudenta) {
            cl.show(containerPanel, "dodajStudentaPanel");
            List kierunki = Kierunki.showList();

            int rekordy = kierunki.size() / 2;
            String data[][] = new String[rekordy][2];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = (String) kierunki.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nazwa", "Rodzaj studiów"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            dodajStudentaKierunekTable.setModel(model);

        } else if (zrodlo == dodajStudentaBtn) {
            Boolean socjal = false;
            Boolean rektora = false;
            String plec = "";
            if (socjalneCheckBox.isSelected()) socjal = true;
            if (rektoraCheckBox.isSelected()) rektora = true;
            if (mezczyznaRadioBtn.isSelected()) {
                plec = "Mezczyzna";
            } else if (kobietaRadioBtn.isSelected()) {
                plec = "Kobieta";
            } else {
                JOptionPane.showMessageDialog(null, "Prosze wybrać płeć!");
            }
            if (dodajStudentaPeselTf.getText().length() > 11) {
                JOptionPane.showMessageDialog(null, "Nieprawidłowy pesel!");
                dodajStudentaPeselTf.setText("");
            }
            if (dodajStudentaPeselTf.getText() != null && dodajStudentaImieTf.getText() != null && dodajStudentaNazwiskoTf.getText() != null && dodajStudentaKierunekTable.getSelectedRow() != -1) {
                Studenci.dodajStud(dodajStudentaPeselTf.getText(), dodajStudentaImieTf.getText(), dodajStudentaNazwiskoTf.getText(), dodajStudentaKierunekTable.getModel().getValueAt(dodajStudentaKierunekTable.getSelectedRow(), 0).toString(), 1, socjal, rektora, plec);
                JOptionPane.showMessageDialog(null, "Pomyślnie dodano studenta!");
                dodajStudentaImieTf.setText("");
                dodajStudentaNazwiskoTf.setText("");
                dodajStudentaPeselTf.setText("");
                dodajStudentaKierunekTable.clearSelection();
                kobietaRadioBtn.setSelected(false);
                mezczyznaRadioBtn.setSelected(false);
                rektoraCheckBox.setSelected(false);
                socjalneCheckBox.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(null, "Proszę wypełnić wszystkie pola");
            }
        } else if (zrodlo == kobietaRadioBtn) {
            mezczyznaRadioBtn.setSelected(false);

        } else if (zrodlo == mezczyznaRadioBtn) {
            kobietaRadioBtn.setSelected(false);
        } else if (zrodlo == usunStudentaBtn) {
            String album = tabelaStudenci.getModel().getValueAt(tabelaStudenci.getSelectedRow(), 0).toString();
            Studenci.delRecord(album);
            JOptionPane.showMessageDialog(null, "Pomyślnie usunięto studenta!");
            List stud = Studenci.listStud();
            int rekordy = stud.size() / 9;
            String data[][] = new String[rekordy][9];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 9; j++) {
                    data[i][j] = (String) stud.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Nr albumu", "Pesel", "Imie", "Nazwisko", "Kierunek", "Rok", "Socjalne", "Rektorskie", "Płeć"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaStudenci.setModel(model);
        } else if (zrodlo == exportCSV) {
            cl.show(containerPanel, "panelExport");
        } else if (zrodlo == KierunkiRbEx) {
            String tabela = "Kierunki";
            String[] tabelaKolumny = Export.getColumnNames(tabela);
            ComboBoxModel model = new DefaultComboBoxModel(tabelaKolumny);
            comboBoxNazwyKolumn.setModel(model);
            tabelaPodgladCSV.setModel(Export.updatePreview(tabela));
        } else if (zrodlo == KolegiaRbEx) {
            String tabela = "Kolegia";
            String[] tabelaKolumny = Export.getColumnNames(tabela);
            ComboBoxModel model = new DefaultComboBoxModel(tabelaKolumny);
            comboBoxNazwyKolumn.setModel(model);
            tabelaPodgladCSV.setModel(Export.updatePreview(tabela));
        } else if (zrodlo == PracownicyRbEx) {
            String tabela = "Pracownicy";
            String[] tabelaKolumny = Export.getColumnNames(tabela);
            ComboBoxModel model = new DefaultComboBoxModel(tabelaKolumny);
            comboBoxNazwyKolumn.setModel(model);
            tabelaPodgladCSV.setModel(Export.updatePreview(tabela));
        } else if (zrodlo == PrzedmiotyRbEx) {
            String tabela = "Przedmioty";
            String[] tabelaKolumny = Export.getColumnNames(tabela);
            ComboBoxModel model = new DefaultComboBoxModel(tabelaKolumny);
            comboBoxNazwyKolumn.setModel(model);
            tabelaPodgladCSV.setModel(Export.updatePreview(tabela));
        } else if (zrodlo == RocznikiRbEx) {
            String tabela = "Roczniki";
            String[] tabelaKolumny = Export.getColumnNames(tabela);
            ComboBoxModel model = new DefaultComboBoxModel(tabelaKolumny);
            comboBoxNazwyKolumn.setModel(model);
            tabelaPodgladCSV.setModel(Export.updatePreview(tabela));
        } else if (zrodlo == StudenciRbEx) {
            String tabela = "Studenci";
            String[] tabelaKolumny = Export.getColumnNames(tabela);
            ComboBoxModel model = new DefaultComboBoxModel(tabelaKolumny);
            comboBoxNazwyKolumn.setModel(model);
            tabelaPodgladCSV.setModel(Export.updatePreview(tabela));
        } else if (zrodlo == buttonExport) {
            String choosertitle = "Gdzie zapisać plik csv?";
            String directory = "";
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle(choosertitle);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                directory = chooser.getSelectedFile().toString();
            } else {
                System.out.println("No Selection ");
            }

            if (Export.exportToCSV(tabelaPodgladCSV, directory)) {
                JOptionPane.showMessageDialog(null, "Pomyślnie zapisano plik!");
            } else {
                JOptionPane.showMessageDialog(null, "Wystąpił problem z zapisem pliku. Spróbuj ponownie.");
            }

        } else if (zrodlo == importCSV) {
            cl.show(containerPanel, "panelImport");

        }else if(zrodlo == buttonFileChooserImport){
            String choosertitle = "Wskaż plik csv.";
            String directory = "";
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle(choosertitle);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                directory = chooser.getSelectedFile().toString();
                directoryImportLabel.setText(directory);
            } else {
                System.out.println("No Selection ");
            }

        }else if(zrodlo == importButton){
            String radio = "";
            String header = "NO";
            String delimiter = "";
            if(importGroup.getSelection() != null){
                for (Enumeration<AbstractButton> buttons = importGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        radio = button.getText();
                    }
                }
                if(HEADERCheckBox.isSelected()){
                    header = "YES";
                }

                delimiter = comboBoxDelimiter.getModel().getSelectedItem().toString();

                if(Import.importFromCSV(radio,delimiter,directoryImportLabel.getText(), header)){
                    JOptionPane.showMessageDialog(null,"Import zakończony pomyślnie");
                }else{
                    JOptionPane.showMessageDialog(null,"Problem z importem");
                    JOptionPane.showMessageDialog(null,"SQL: "+Import.sqlexc);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Proszę wybrać tabele!");
            }

        } else if (zrodlo == prac_bez_opie_btn) {
            List praco = Pracownicy.prac_bez_opie();
            int rekordy = praco.size() / 3;
            String data[][] = new String[rekordy][3];
            for (int i = 0, k = 0; i < rekordy; i++) {
                for (int j = 0; j < 3; j++) {
                    data[i][j] = (String) praco.get(k);
                    k++;

                }
            }
            TableModel model = new DefaultTableModel(data, new String[]{"Imie", "Nazwisko", "Instytut"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;//This causes all cells to be not editable
                }
            };
            tabelaPracownicy.setModel(model);
        }else if(zrodlo == showRocznikBtn){
            if(rokRocznikiTf.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Proszę podać rok (np. '2019')");
            }else {
                List rocz = Roczniki.showRocznik(rokRocznikiTf.getText());
                int rekordy = rocz.size() / 6;
                String data[][] = new String[rekordy][6];
                for (int i = 0, k = 0; i < rekordy; i++) {
                    for (int j = 0; j < 6; j++) {
                        data[i][j] = (String) rocz.get(k);
                        k++;

                    }
                }
                TableModel model = new DefaultTableModel(data, new String[]{"Nr albumu", "Imie", "Nazwisko", "Pesel", "Data rozpoczecia", "Kierunek"}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;//This causes all cells to be not editable
                    }
                };
                tabelaRoczniki.setModel(model);
            }
        }
    }


}

