/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import VIEW.ConfigAparencia;
import PRIVATE.Painel_Pesquisa;
import DTO.PesquisaDTO;
import PRIVATE.EventClick;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPopupMenu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author mello
 */
public class AppPrincipalVIEW extends javax.swing.JFrame {

    private JPopupMenu menu;
    private Painel_Pesquisa procura;

    public AppPrincipalVIEW() {
        initComponents();
        this.setTitle("Weathervane");
        setIconImage();
        connectToDatabase();
        centreWindow(this);
        temperatura.setVisible(false);
        nomeCidade.setVisible(false);
        hora.setVisible(false);
        icone.setVisible(false);
        getIPGeo();

        menu = new JPopupMenu();
        procura = new Painel_Pesquisa();
        menu.add(procura);
        menu.setFocusable(false);
        procura.addEventClick(new EventClick() {
            @Override
            public void itemClick(PesquisaDTO objpesquisadto) {
                menu.setVisible(false);
                pesquisa.setText(objpesquisadto.getTexto());
                addHistorico(objpesquisadto.getTexto());
                connectAPI(objpesquisadto.getTexto());
            }

            @Override
            public void itemRemove(Component com, PesquisaDTO objpesquisadto) {
                procura.remove(com);
                RemoveHistorico(objpesquisadto.getTexto());
                menu.setPopupSize(menu.getWidth(), (procura.conseguirTamanhoItem() * 32) + 2);
                if (procura.conseguirTamanhoItem() == 0) {
                    menu.setVisible(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pesquisa = new PRIVATE.TextField();
        temperatura = new javax.swing.JLabel();
        nomeCidade = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        icone = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botaoAparencia = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        botaoSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pesquisa.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/Assets/search.png"))); // NOI18N
        pesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisaMouseClicked(evt);
            }
        });
        pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesquisaKeyReleased(evt);
            }
        });

        temperatura.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        temperatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temperatura.setText(".");

        nomeCidade.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        nomeCidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeCidade.setText(".");

        hora.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText(".");

        icone.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        icone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenuBar1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jMenuBar1ComponentMoved(evt);
            }
        });

        jMenu1.setText("Settings");

        botaoAparencia.setText("Appeareance");
        botaoAparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAparenciaActionPerformed(evt);
            }
        });
        jMenu1.add(botaoAparencia);

        jMenuBar1.add(jMenu1);

        menuAbout.setText("Help");

        botaoSobre.setText("About");
        botaoSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSobreActionPerformed(evt);
            }
        });
        menuAbout.add(botaoSobre);

        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomeCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(icone, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisaMouseClicked
        if (procura.conseguirTamanhoItem() > 0) {
            menu.show(pesquisa, 0, pesquisa.getHeight());
            procura.clearSelected();
        }
    }//GEN-LAST:event_pesquisaMouseClicked

    private void pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisaKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = pesquisa.getText().trim().toLowerCase();
            procura.setPesquisa(procurar(text));
            if (procura.conseguirTamanhoItem() > 0) {
                menu.show(pesquisa, 0, pesquisa.getHeight());
                menu.setPopupSize(menu.getWidth(), (procura.conseguirTamanhoItem() * 32) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_pesquisaKeyReleased

    private void pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            procura.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            procura.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String texto = procura.getSelectedText();
            pesquisa.setText(texto);
            menu.setVisible(false);
            addHistorico(texto);
            connectAPI(texto);
        }
    }//GEN-LAST:event_pesquisaKeyPressed

    private void jMenuBar1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuBar1ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1ComponentMoved

    private void botaoSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSobreActionPerformed
        TermosdeServico termos = new TermosdeServico();
        termos.setVisible(true);
        termos.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botaoSobreActionPerformed

    private void botaoAparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAparenciaActionPerformed
        ConfigAparencia appearance = new ConfigAparencia();
        appearance.setVisible(true);
        appearance.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_botaoAparenciaActionPerformed

    private List<PesquisaDTO> procurar(String procurar) {
        List<PesquisaDTO> list = new ArrayList<>();
        try {
            String sql = "select DISTINCT cidade, coalesce((select id_historico from historico where cidade=item_salvo limit 1),'') as historico from sugestoes where cidade like ? order by historico DESC, cidade limit 7";

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + procurar + "%");

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String texto = rs.getString(1);
                boolean historico = !rs.getString(2).equals("");
                list.add(new PesquisaDTO(texto, historico));
            }
            rs.close();
            pstm.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "AppPrincipalVIEW: " + error);
            return null;
        }
        return list;
    }

    private void RemoveHistorico(String texto) {
        try {
            String sql = "delete from historico where item_salvo=? limit 1";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, texto);
            pstm.execute();
            pstm.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "AppPrincipalVIEW: " + error);
        }
    }

    private Connection conn;

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10663137?user=sql10663137&password=LWxSrSziSd";
            conn = DriverManager.getConnection(url);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "AppPrincipalVIEW: " + error);
        }
    }

    private void addHistorico(String texto) {
        try {
            boolean add = true;
            String sql = "select id_historico from historico where item_salvo=? limit 1";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, texto);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                add = false;
            }
            rs.close();
            pstm.close();
            if (add) {
                String othersql = "insert into historico (item_salvo) values (?)";
                pstm = conn.prepareStatement(othersql);
                pstm.setString(1, texto);
                pstm.execute();
                pstm.close();
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "AppPrincipalVIEW: " + error);
        }
    }

    private void connectAPI(String texto) {
        try {
            String sql = "SELECT latitude, longitude FROM sugestoes WHERE cidade = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, texto);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String lat = rs.getString("latitude");
                String lon = rs.getString("longitude");
                String api = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=39b4b8957534286d3d7a4a23f5bd3ee6&units=metric&lang=pt_br";

                URL url = null;
                String json = null;

                try {
                    url = new URL(api);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    json = IOUtils.toString(url, "UTF-8");
                } catch (IOException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }

                JSONObject object = new JSONObject(new JSONTokener(json));
                double getTemp = object.getJSONObject("main").getDouble("temp");
                int roundTemp = (int) Math.round(getTemp);

                temperatura.setText(roundTemp + "°C");
                temperatura.setVisible(true);

                String country = object.getJSONObject("sys").getString("country");
                if (country.equals("JP")) {
                    String nameCity = object.getString("name");
                    nomeCidade.setText(nameCity);
                    nomeCidade.setVisible(true);

                } else {
                    //Uso da API de localização
                    try {
                        URL urlLoc = null;
                        urlLoc = new URL("https://nominatim.openstreetmap.org/reverse?lat=" + lat + "&lon=" + lon + "&format=json&zoom=10");
                        try {
                            String jsonLoc = null;
                            jsonLoc = IOUtils.toString(urlLoc, "UTF-8");
                            JSONObject objectLoc = new JSONObject(new JSONTokener(jsonLoc));
                            String getCity = objectLoc.getString("name");

                            nomeCidade.setText(getCity);
                            nomeCidade.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // Colocar o ícone correspondente ao clima
                String iconeCorres = object.getJSONArray("weather").getJSONObject(0).getString("icon");
                URL iconeTemp = null;
                try {
                    iconeTemp = new URL("https://openweathermap.org/img/wn/" + iconeCorres + "@2x.png");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedImage iconeLegivel = null;
                try {
                    iconeLegivel = ImageIO.read(iconeTemp);
                } catch (IOException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }
                ImageIcon iconeVisivel = new ImageIcon(iconeLegivel);
                icone.setIcon(iconeVisivel);
                icone.setVisible(true);

                // Colocar a hora atual
                try {
                    URL horaURL = new URL("https://api.opencagedata.com/geocode/v1/json?q=" + lat + "+" + lon + "&key=bd7b858ce7af4c2a96c17fbfb160e2ae");
                    try {
                        String jsonLoc = null;
                        jsonLoc = IOUtils.toString(horaURL, "UTF-8");
                        JSONObject objectLoc = new JSONObject(new JSONTokener(jsonLoc));
                        String fetchData = objectLoc.getJSONArray("results").getJSONObject(0).getJSONObject("annotations").getJSONObject("timezone").getString("name");

                        ZoneId fuso = ZoneId.of(fetchData);
                        LocalDateTime horaAtual = LocalDateTime.now(fuso);
                        DateTimeFormatter formatado = DateTimeFormatter.ofPattern("HH:mm");
                        String horario = horaAtual.format(formatado);

                        hora.setText(horario);
                        hora.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            rs.close();
            pstm.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "AppPrincipalVIEW: " + error);
        }
    }

    private void getIPGeo() {
        try {
            URL urlIP = new URL("http://httpbin.org/ip");
            String jsonIP = null;
            try {
                jsonIP = IOUtils.toString(urlIP, "UTF-8");
            } catch (IOException ex) {
                Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
            }
            JSONObject object = new JSONObject(new JSONTokener(jsonIP));
            String getIP = object.getString("origin");

            try {
                URL geoIP = new URL("http://ip-api.com/json/" + getIP + "?fields=status,message,country,region,regionName,city,zip,lat,lon,timezone");
                String jsonGeo = null;
                try {
                    jsonGeo = IOUtils.toString(geoIP, "UTF-8");
                } catch (IOException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }
                JSONObject objectIP = new JSONObject(new JSONTokener(jsonGeo));
                double lat = objectIP.getDouble("lat");
                double lon = objectIP.getDouble("lon");
                String city = objectIP.getString("city");
                nomeCidade.setText(city);
                nomeCidade.setVisible(true);

                // Uso da API de clima
                try {
                    URL urlAPI = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=39b4b8957534286d3d7a4a23f5bd3ee6&units=metric&lang=pt_br");
                    try {
                        String jsonAPI = null;
                        jsonAPI = IOUtils.toString(urlAPI, "UTF-8");
                        JSONObject objectAPI = new JSONObject(new JSONTokener(jsonAPI));

                        double getTemp = objectAPI.getJSONObject("main").getDouble("temp");
                        int roundTemp = (int) Math.round(getTemp);

                        temperatura.setText(roundTemp + "°C");
                        temperatura.setVisible(true);

                        // Colocar a hora atual
                        LocalDateTime horaAtual = LocalDateTime.now();
                        DateTimeFormatter formatado = DateTimeFormatter.ofPattern("HH:mm");
                        String horario = horaAtual.format(formatado);
                        hora.setText(horario);
                        hora.setVisible(true);

                        // Colocar o ícone correspondente ao clima
                        String iconeCorres = objectAPI.getJSONArray("weather").getJSONObject(0).getString("icon");
                        URL iconeTemp = new URL("https://openweathermap.org/img/wn/" + iconeCorres + "@2x.png");
                        BufferedImage iconeLegivel = ImageIO.read(iconeTemp);
                        ImageIcon iconeVisivel = new ImageIcon(iconeLegivel);
                        icone.setIcon(iconeVisivel);
                        icone.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (MalformedURLException ex) {
                Logger.getLogger(AppPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppPrincipalVIEW().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/icons8-climate-64.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botaoAparencia;
    private javax.swing.JMenuItem botaoSobre;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel icone;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JLabel nomeCidade;
    private PRIVATE.TextField pesquisa;
    private javax.swing.JLabel temperatura;
    // End of variables declaration//GEN-END:variables

    private void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
