import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Swing {
    Formula1MenaxhimKampionati formula1 = new Formula1MenaxhimKampionati();
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    public Swing() throws FileNotFoundException {
        formula1.lexoGaruesF();
        formula1.lexoGaratF();
        formula1.lexoDatatF();
        JPanel paneliKryesor = new JPanel ();
        paneliKryesor.setBorder ( new TitledBorder( new EtchedBorder(), "Formula 1" ) );


        JTextArea tekstKryesor = new JTextArea ( 30, 70 );
        tekstKryesor.setEditable ( false ); // set textArea non-editable
        JScrollPane scroll = new JScrollPane ( tekstKryesor );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        paneliKryesor.add ( scroll );
        JTextArea teksti2 = new JTextArea ( 5, 15 );
        teksti2.setEditable(true);

        JLabel rreshtBosh = new JLabel("");   // <--- empty label to effect next row
        rreshtBosh.setPreferredSize(new Dimension(3000,0));
        btn1 = new JButton("Shfaq shoferet");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    formula1.perditesoGaruesF();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                String text = formula1.printoGaruesitGui();
                tekstKryesor.setText(text);
            }
        });
        btn2 = new JButton("Rendit sipas pikeve ne rend zbrites");
        btn2.setBounds(1, 1, 250, 30);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formula1.piketRendZbrites();
                String text = formula1.printoGaruesitGui();
                tekstKryesor.setText(text);
            }
        });
        btn3 = new JButton("Rendit sipas pikeve ne rend rrites");
        btn3.setBounds(100, 100, 250, 30);
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formula1.piketRendRrites();
                String text = formula1.printoGaruesitGui();
                tekstKryesor.setText(text);
            }
        });
        btn4 = new JButton("Rendit sipas fitoreve");
        btn4.setBounds(660, 760, 150, 30);
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formula1.fitoretRendZbrites();
                String text = formula1.printoGaruesitGui();
                tekstKryesor.setText(text);
            }
        });
        btn5 = new JButton("Simulo Gare");
        btn5.setBounds(10, 800, 120, 30);
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formula1.perziejVendetGarues();
                String text = formula1.krijoGareGui();
                try {
                    formula1.perditesoGaratF();
                    formula1.perditesoDatatF();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                tekstKryesor.setText(text);
            }
        });
        btn6 = new JButton("Simulo Gare me shans");
        btn6.setBounds(140, 800, 200, 30);
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formula1.perziejVendetGaruesProbabilitet();
                String text = formula1.krijoGareGui();
                try {
                    formula1.perditesoGaratF();
                    formula1.perditesoDatatF();
                } catch (FileNotFoundException ex) {throw new RuntimeException(ex);

                }
                tekstKryesor.setText(text);
            }
        });
        btn7 = new JButton("Shfaq garat ne baze te dates");
        btn7.setBounds(350, 800, 250, 30);
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formula1.datatRendRrites();
                String text = formula1.printoGaratGui();
                tekstKryesor.setText(text);
            }
        });
        btn8 = new JButton("Kerko garat e shoferit");
        btn8.setBounds(120, 850, 300, 30);
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = teksti2.getText();
                String text2 = formula1.kerkoGarues(text);
                tekstKryesor.setText(text2);
            }
        });
        paneliKryesor.add(btn1);
        paneliKryesor.add(btn2);
        paneliKryesor.add(btn3);
        paneliKryesor.add(btn4);
        paneliKryesor.add(rreshtBosh);
        paneliKryesor.add(btn5);
        paneliKryesor.add(btn6);
        paneliKryesor.add(btn7);
        paneliKryesor.add(btn8);
        paneliKryesor.add( teksti2 );
        paneliKryesor.setLayout(new FlowLayout(FlowLayout.LEFT));
        // My code
        JFrame frame = new JFrame ();
        frame.add ( paneliKryesor );
        frame.pack();
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo ( null );
        frame.setVisible ( true );
    }
}
