package kmeans;

import Interfaces.ejes;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class Ventana extends javax.swing.JFrame {

    private ejes plano = new ejes();

    private int x, y, c;
    Random aleatorio = new Random(System.currentTimeMillis());
    DefaultListModel modelo = new DefaultListModel();
    JColorChooser selectColor = new JColorChooser();
    algoritmo kmeans;

    public Ventana() {

        plano.setBounds(10, 10, 501, 501);
        plano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ejesMousePressed(evt);
            }
        });

        this.add(plano);
        initComponents();
        btn_clasificar.setEnabled(false);
    }

    private void ejesMousePressed(MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();

        if (plano.atractoresColocados < Integer.parseInt(num_clases.getText())) {
            agregarAtractor(x, y);
        }
    }

    private void agregarPunto(int x, int y) {
        //añade a lista de puntos
        plano.puntos.add(new Point(x, y));

        //dibuja la lista de puntos
        plano.dibujarPuntos(plano.getGraphics());
    }

    private void agregarAtractor(int x, int y) {
        Color tmp = null;
        tmp = JColorChooser.showDialog(null, "Elige un color", tmp);
        plano.atractores.add(new Point(x, y));
        plano.colores.add(tmp);
        plano.clases.add(plano.atractoresColocados);
        plano.atractoresColocados++;
        System.out.println(plano.atractoresColocados);
        plano.dibujarAtractores(plano.getGraphics());
        if (plano.atractoresColocados == Integer.parseInt(num_clases.getText())) {
            btn_clasificar.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_punots = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPuntos = new javax.swing.JList<>();
        btn_aleatorio = new javax.swing.JButton();
        aleatorios = new javax.swing.JTextField();
        num_clases = new javax.swing.JTextField();
        lbl_clases = new javax.swing.JLabel();
        btn_clasificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("K Means");
        setResizable(false);

        lbl_punots.setText("Puntos");

        jScrollPane1.setViewportView(listaPuntos);

        btn_aleatorio.setText("Añadir aleatoriamente");
        btn_aleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aleatorioActionPerformed(evt);
            }
        });

        lbl_clases.setText("Numero De Clases:");

        btn_clasificar.setText("Clasificar");
        btn_clasificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clasificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Puntos a agregar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbl_punots)
                            .addGap(118, 118, 118))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                    .addComponent(aleatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_aleatorio)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_clases)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(num_clases, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_clasificar)
                        .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_punots)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aleatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_aleatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_clases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_clases))
                .addGap(18, 18, 18)
                .addComponent(btn_clasificar)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aleatorioActionPerformed
        try {
            plano.puntos.clear();
            plano.colores.clear();
            plano.atractores.clear();
            plano.atractoresColocados = 0;
            int numAleatorios = Integer.parseInt(aleatorios.getText());

            if (numAleatorios > 0) {
                plano.getGraphics().clearRect(0, 0, 501, 501);
                for (int i = 0; i < numAleatorios; i++) {
                    x = aleatorio.nextInt(501);
                    y = aleatorio.nextInt(501);
                    agregarPunto(x, y);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Coloca más de 0");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear aleatorios!!! \nColoque un numero para agregar puntos!!!");
        }
    }//GEN-LAST:event_btn_aleatorioActionPerformed

    private void btn_clasificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clasificarActionPerformed

        try {
            if (Integer.parseInt(aleatorios.getText()) > 0 && aleatorios.getText() != "") {
                boolean terminar = false;

                kmeans = new algoritmo(plano.puntos, plano.atractores, plano.clases);

                terminar = true;
                kmeans.clasificar();
                kmeans.calculacentroides();
                plano.clases = kmeans.clases;

                //Verificar si acabo
                for (int i = 0; i < plano.atractores.size(); i++) {
                    if (plano.atractores.get(i).equals(kmeans.centroides.get(i)) != true) {
                        terminar = false;
                    }
                }

                plano.atractores = kmeans.centroides;

                try {
                    Thread.sleep(240);
                    plano.dibujarclasificados(plano.getGraphics());
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "Error!!!");
                }

                if (terminar) {
                    for (int i = 0; i < plano.puntos.size(); i++) {
                        String p = ((plano.puntos.get(i).x) - 250) + "," + ((plano.puntos.get(i).y) - 250) + ": " + plano.clases.get(i);
                        modelo.addElement(p);
                    }
                    listaPuntos.setModel(modelo);

                    JOptionPane.showMessageDialog(this, "No hay cambios!!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Agregar Puntos!!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede clasificar error en los campos!!! \n" + e.getMessage());
        }


    }//GEN-LAST:event_btn_clasificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aleatorios;
    private javax.swing.JButton btn_aleatorio;
    private javax.swing.JButton btn_clasificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_clases;
    private javax.swing.JLabel lbl_punots;
    private javax.swing.JList<String> listaPuntos;
    private javax.swing.JTextField num_clases;
    // End of variables declaration//GEN-END:variables
}
