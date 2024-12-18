
package com.conference.gui.presentation;

import com.conference.gui.article.Article;
import com.conference.gui.clients.UserClient;
import com.conference.gui.conference.ConferenceClient;
import com.conference.gui.conference.IConferenceRestClient;
import com.conference.gui.entities.Articulo;
import com.conference.gui.entities.Conference;
import com.conference.gui.entities.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Interfaz contenedora 
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */

public class GUIcontainer extends javax.swing.JFrame {

    private Usuario usuario;
    IConferenceRestClient conferenceClient ;
    Article objArticle=new  Article();
    //private UserService userService;
    //private ConferenceService conferenceService;
    //private ArticleService articuloService;

    /**
     * Creates new form GUIcontainer
     */
   
    
    
    
    public GUIcontainer(Usuario us, IConferenceRestClient conferenceClient ) {
        this.conferenceClient = conferenceClient;
        this.usuario = us;
        initComponents();
        listConferences("");//muestra todas las listas
        listArticles();
    }
    
    
       
    @SuppressWarnings("unchecked")
    // Método que se ejecuta cuando el usuario hace clic en "Listado de conferencias"
 public void listConferences(String searchText) {
    pnlListadoCon.removeAll();  // Limpiamos el contenido actual del panel de conferencias

    // Configuramos el layout del panel para mantener el título arriba
    pnlListadoCon.setLayout(new BorderLayout());

    // Añadimos nuevamente el título "Listado de conferencias" en la parte superior
    pnlListadoCon.add(lbListadoCon, BorderLayout.NORTH);

    // Obtenemos todas las conferencias desde el servicio
    List<Conference> conferences = conferenceClient.getConferencias();

   
    // Creamos un panel para listar las conferencias con un BoxLayout para apilar verticalmente
    JPanel panelConferencias = new JPanel();
    panelConferencias.setLayout(new BoxLayout(panelConferencias, BoxLayout.Y_AXIS));  // Apilamos verticalmente los mini paneles

    // Verificamos si hay conferencias disponibles
    if (conferences.isEmpty()) {
        System.out.println("No hay conferencias");
    } else {
        for (Conference conference : conferences) {
            JPanel conferencePanel = new JPanel();  // Creamos un panel para cada conferencia
            conferencePanel.setLayout(new BorderLayout());  // Usamos BorderLayout para organizar componentes
            conferencePanel.setPreferredSize(new Dimension(277, 30));  // Ajustamos el tamaño del panel
            conferencePanel.setMaximumSize(new Dimension(277, 30));  // Evita que los paneles se estiren más allá de este tamaño

            // Etiquetas con la información de la conferencia
            JLabel nameLabel = new JLabel("Conferencia: " + conference.getName());  // Etiqueta con el nombre de la conferencia

            // Botón con el símbolo "+"
            JButton detallesButton = new JButton("+");
            detallesButton.setPreferredSize(new Dimension(45, 40));  // Ajustamos el tamaño del botón
            detallesButton.addActionListener(e -> {
                // Abre la ventana GUIcreateArticle para la conferencia seleccionada
                Article articleUsuario = new Article();
                GUIcreateArticle createArticleView = new GUIcreateArticle(articleUsuario, conference);  // Pasamos ArticleService y Conference al constructor

                // Añadimos GUIcreateArticle al JDesktopPane
                dskpaneContenedor.add(createArticleView);  // Agregamos la ventana al JDesktopPane

                // Configuramos el JInternalFrame para que se muestre correctamente
                createArticleView.setVisible(true);  // Hacemos visible el JInternalFrame
                try {
                    createArticleView.setMaximum(true);  // Lo maximizamos dentro del JDesktopPane (opcional)
                } catch (PropertyVetoException ex) {
                    ex.printStackTrace();
                }
                // Actualizamos la lista de artículos después de abrir la ventana de creación de artículo
                listArticles();
            });

            // Añadimos las etiquetas de información en un sub-panel
            JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));  // Usamos FlowLayout para alinear a la izquierda
            infoPanel.add(nameLabel);

            // Añadimos las etiquetas de información en el centro del mini panel
            conferencePanel.add(infoPanel, BorderLayout.CENTER);

            // Añadimos el botón "+" en el lado derecho del mini panel
            conferencePanel.add(detallesButton, BorderLayout.EAST);

            // Añadimos el mini panel al panel de conferencias
            panelConferencias.add(conferencePanel);

            // Añadimos un espacio entre los paneles para que no se vean juntos
            panelConferencias.add(Box.createRigidArea(new Dimension(0, 1)));
        }
    }

    // Ahora, ponemos el panelConferencias dentro de un JScrollPane para agregar scroll si es necesario
    JScrollPane scrollPane = new JScrollPane(panelConferencias);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // Barra de desplazamiento vertical cuando sea necesario
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  // Deshabilitar barra horizontal

    // Añadimos el JScrollPane al centro de pnlListadoCon
    pnlListadoCon.add(scrollPane, BorderLayout.CENTER);

    // Refrescamos y repintamos el panel para que los cambios se reflejen
    pnlListadoCon.revalidate();
    pnlListadoCon.repaint();

}




    // Método para listar los artículos del usuario
    @SuppressWarnings("unchecked")
   public void listArticles() {
    pnlListadoAr.removeAll(); // Limpiamos el contenido actual del panel de artículos
    pnlListadoAr.setLayout(new BorderLayout()); // Layout para mantener el título arriba

    // Panel para listar los artículos con un BoxLayout vertical
    JPanel panelArticulos = new JPanel();
    panelArticulos.setLayout(new BoxLayout(panelArticulos, BoxLayout.Y_AXIS));

    // Añadimos el título "Listado de artículos" en la parte superior
    pnlListadoAr.add(lbListadoAr, BorderLayout.NORTH);

    // Obtenemos todos los artículos desde el servicio
    List<Articulo> articulos = objArticle.getArticulos();

    // Verificamos si la lista de artículos está vacía
    if (articulos == null || articulos.isEmpty()) {
        System.out.println("No hay Articulos");
    } else {
        // Iteramos sobre cada artículo y creamos un mini panel para mostrar su información
        for (Articulo articulo : articulos) {
            JPanel articuloPanel = new JPanel(new BorderLayout()); // Panel para cada artículo
            articuloPanel.setPreferredSize(new Dimension(277, 30));
            articuloPanel.setMaximumSize(new Dimension(277, 30));

            // Etiqueta con el nombre del artículo
            JLabel nameLabel = new JLabel("Artículo: " + articulo.getNombre());
            articuloPanel.add(nameLabel, BorderLayout.CENTER);

            // Añadimos el mini panel al panel de artículos
            panelArticulos.add(articuloPanel);

            // Añadimos un espacio entre los paneles
            panelArticulos.add(Box.createRigidArea(new Dimension(0, 1)));
        }
    }

    // Ponemos el panelArticulos dentro de un JScrollPane
    JScrollPane scrollPane = new JScrollPane(panelArticulos);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // Añadimos el JScrollPane al centro de pnlListadoAr
    pnlListadoAr.add(scrollPane, BorderLayout.CENTER);

    // Refrescamos y repintamos el panel para que los cambios se reflejen
    pnlListadoAr.revalidate();
    pnlListadoAr.repaint();
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        dskpaneContenedor = new javax.swing.JDesktopPane();
        intfInicio = new javax.swing.JInternalFrame();
        lbBienvenido = new javax.swing.JLabel();
        txtfBusqueda = new javax.swing.JTextField();
        pnlListadoCon = new javax.swing.JPanel();
        lbListadoCon = new javax.swing.JLabel();
        pnlListadoAr = new javax.swing.JPanel();
        lbListadoAr = new javax.swing.JLabel();
        pnlBotonCrearCon = new javax.swing.JPanel();
        lbCrearCon = new javax.swing.JLabel();
        lbCrearCon1 = new javax.swing.JLabel();
        lbBtnBuscar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlSuperior = new javax.swing.JPanel();
        lbeasyConference = new javax.swing.JLabel();
        lbCerrarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(873, 650));
        setSize(new java.awt.Dimension(873, 650));

        pnlFondo.setMinimumSize(new java.awt.Dimension(873, 650));
        pnlFondo.setPreferredSize(new java.awt.Dimension(873, 650));
        pnlFondo.setLayout(new java.awt.BorderLayout());

        dskpaneContenedor.setSelectedFrame(intfInicio);
        dskpaneContenedor.setLayout(new java.awt.BorderLayout());

        intfInicio.setBackground(new java.awt.Color(255, 255, 255));
        intfInicio.setBorder(null);
        intfInicio.setFrameIcon(null);
        intfInicio.setMinimumSize(new java.awt.Dimension(873, 650));
        intfInicio.setPreferredSize(new java.awt.Dimension(873, 650));
        intfInicio.setVisible(true);
        try {
            intfInicio.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        lbBienvenido.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        lbBienvenido.setText("Bienvenido! ");

        txtfBusqueda.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        txtfBusqueda.setText("Buscar conferencia");

        pnlListadoCon.setBackground(new java.awt.Color(236, 236, 236));
        pnlListadoCon.setPreferredSize(new java.awt.Dimension(136, 204));
        pnlListadoCon.setLayout(new java.awt.BorderLayout());

        lbListadoCon.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbListadoCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListadoCon.setText("Listado de conferencias");
        lbListadoCon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 197, 197)));
        pnlListadoCon.add(lbListadoCon, java.awt.BorderLayout.PAGE_START);

        pnlListadoAr.setBackground(new java.awt.Color(236, 236, 236));
        pnlListadoAr.setMinimumSize(new java.awt.Dimension(145, 22));
        pnlListadoAr.setPreferredSize(new java.awt.Dimension(136, 204));
        pnlListadoAr.setLayout(new java.awt.BorderLayout());

        lbListadoAr.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        lbListadoAr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbListadoAr.setText("Listado de articulos");
        lbListadoAr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 197, 197)));
        pnlListadoAr.add(lbListadoAr, java.awt.BorderLayout.PAGE_START);

        pnlBotonCrearCon.setBackground(new java.awt.Color(129, 218, 199));
        pnlBotonCrearCon.setLayout(new java.awt.BorderLayout());

        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbCrearCon.setForeground(new java.awt.Color(255, 255, 255));
        lbCrearCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCrearCon.setText("Crear conferencia");
        lbCrearCon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCrearCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCrearConMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCrearConMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCrearConMouseExited(evt);
            }
        });
        pnlBotonCrearCon.add(lbCrearCon, java.awt.BorderLayout.CENTER);

        lbCrearCon1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbCrearCon1.setForeground(new java.awt.Color(255, 255, 255));
        lbCrearCon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCrearCon1.setText("Crear conferencia");
        lbCrearCon1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCrearCon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCrearCon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCrearCon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCrearCon1MouseExited(evt);
            }
        });
        pnlBotonCrearCon.add(lbCrearCon1, java.awt.BorderLayout.CENTER);

        lbBtnBuscar.setText("buscar");
        lbBtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBtnBuscarMouseClicked(evt);
            }
        });

        jButton1.setText("REFRESCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout intfInicioLayout = new javax.swing.GroupLayout(intfInicio.getContentPane());
        intfInicio.getContentPane().setLayout(intfInicioLayout);
        intfInicioLayout.setHorizontalGroup(
            intfInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intfInicioLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(intfInicioLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(txtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbBtnBuscar))
            .addGroup(intfInicioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnlListadoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(pnlListadoAr, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(intfInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(intfInicioLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1))
                    .addComponent(pnlBotonCrearCon, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        intfInicioLayout.setVerticalGroup(
            intfInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(intfInicioLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(lbBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(intfInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(intfInicioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbBtnBuscar)))
                .addGap(24, 24, 24)
                .addGroup(intfInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlListadoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlListadoAr, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(intfInicioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pnlBotonCrearCon, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        dskpaneContenedor.add(intfInicio, java.awt.BorderLayout.CENTER);
        //getContentPane().add(intfInicio, java.awt.BorderLayout.CENTER);

        pnlFondo.add(dskpaneContenedor, java.awt.BorderLayout.CENTER);
        //getContentPane().add(dskpaneContenedor, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pnlSuperior.setBackground(new java.awt.Color(0, 153, 153));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(1028, 52));
        pnlSuperior.setLayout(new java.awt.BorderLayout(10, 0));

        lbeasyConference.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lbeasyConference.setForeground(new java.awt.Color(255, 255, 255));
        lbeasyConference.setText("easyConference");
        pnlSuperior.add(lbeasyConference, java.awt.BorderLayout.CENTER);
        pnlSuperior.add(lbeasyConference, java.awt.BorderLayout.WEST);

        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        lbCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        lbCerrarSesion.setText("Cerrar sesion");
        lbCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarSesionMouseExited(evt);
            }
        });
        pnlSuperior.add(lbCerrarSesion, java.awt.BorderLayout.PAGE_START);
        pnlSuperior.add(lbCerrarSesion, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCrearConMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseEntered
        // TODO add your handling code here:
        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15));
    }//GEN-LAST:event_lbCrearConMouseEntered

    private void lbCrearConMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseExited
        // TODO add your handling code here:
        lbCrearCon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
    }//GEN-LAST:event_lbCrearConMouseExited

    private void lbCrearConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearConMouseClicked
       
       
        GUIcreateConference crearConferencia = new GUIcreateConference(conferenceClient,usuario);
        try {
            crearConferencia.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        dskpaneContenedor.add(crearConferencia, java.awt.BorderLayout.CENTER);
        crearConferencia.setVisible(true);
    }//GEN-LAST:event_lbCrearConMouseClicked

    private void lbBtnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBtnBuscarMouseClicked
                                          
    String searchText = txtfBusqueda.getText().trim();  // Obtener texto de búsqueda sin modificar el caso
    listConferences(searchText);  // Llamar a la función para listar conferencias con el texto de búsqueda



    }//GEN-LAST:event_lbBtnBuscarMouseClicked

    private void lbCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseEntered
        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14));
    }//GEN-LAST:event_lbCerrarSesionMouseEntered

    private void lbCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseExited
        lbCerrarSesion.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14));
    }//GEN-LAST:event_lbCerrarSesionMouseExited

    private void lbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarSesionMouseClicked
        this.dispose();
        UserClient userclient = new UserClient();
        GUIlogin login = new GUIlogin(userclient); 
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_lbCerrarSesionMouseClicked

    private void lbCrearCon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearCon1MouseClicked
        ConferenceClient conference = new ConferenceClient();
       
        GUIcreateConference crearConferencia = new GUIcreateConference(conferenceClient,usuario);
        try {
            crearConferencia.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GUIcontainer.class.getName()).log(Level.SEVERE, null, ex);
        }

        dskpaneContenedor.add(crearConferencia, java.awt.BorderLayout.CENTER);
        crearConferencia.setVisible(true);
    }//GEN-LAST:event_lbCrearCon1MouseClicked

    private void lbCrearCon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearCon1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCrearCon1MouseEntered

    private void lbCrearCon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCrearCon1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCrearCon1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       listConferences("");//muestra todas las listas
        listArticles();
    
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
         lbBienvenido.setText("Bienvenido! "+ usuario.getName() + " " + usuario.getLastName());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskpaneContenedor;
    private javax.swing.JInternalFrame intfInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbBtnBuscar;
    private javax.swing.JLabel lbCerrarSesion;
    private javax.swing.JLabel lbCrearCon;
    private javax.swing.JLabel lbCrearCon1;
    private javax.swing.JLabel lbListadoAr;
    private javax.swing.JLabel lbListadoCon;
    private javax.swing.JLabel lbeasyConference;
    private javax.swing.JPanel pnlBotonCrearCon;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlListadoAr;
    private javax.swing.JPanel pnlListadoCon;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTextField txtfBusqueda;
    // End of variables declaration//GEN-END:variables

    //@Override
    public void update(Object o) {
        switch (o.getClass().getSimpleName()){
            case "ConferenceService": 
                listConferences(""); 
                break;
            case "ArticleService":
                listArticles();
                break;
        }
        this.repaint();
    }
}
