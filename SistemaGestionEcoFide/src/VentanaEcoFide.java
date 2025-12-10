/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author leymanwu
 */
public class VentanaEcoFide extends JFrame {

    private GestionResiduos gestion;

    private JTextField campoNombre, campoTipo, campoPeso, campoNombreApilar;
    private JButton btnAgregarResiduo, btnTabla;
    private JTable tablaResiduos;
    private DefaultTableModel modeloTabla;
    private JLabel lblTitulo;
    private JTable tabla, TablaResiduos;
    private JScrollPane scrollTabla;

    public VentanaEcoFide(GestionResiduos gestion) {
        this.gestion = gestion;

        setTitle("Sistema EcoFide");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lblTitulo = new JLabel("Sistema de Gestion EcoFide");
        lblTitulo.setBounds(20, 20, 500, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo);

        btnAgregarResiduo = new JButton("Agregar residuo");
        btnAgregarResiduo.setBounds(30, 70, 160, 50);
        add(btnAgregarResiduo);

        btnTabla = new JButton("Tabla de residuo");
        btnTabla.setBounds(30, 140, 160, 50);
        add(btnTabla);

        btnAgregarResiduo.addActionListener(e -> agregarResiduo());
        btnTabla.addActionListener(e -> verTablaResiduo());
        setVisible(true);

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Residuo");
        modeloTabla.addColumn("Categoría");
        modeloTabla.addColumn("Peso");

        tablaResiduos = new JTable(modeloTabla);

        scrollTabla = new JScrollPane(tablaResiduos);
        scrollTabla.setBounds(220, 70, 350, 350);
        add(scrollTabla);
    }

    public void verTablaResiduo() {

        JFrame ventanaTabla = new JFrame("Tabla Residuo");
        ventanaTabla.setSize(600, 550);
        ventanaTabla.setLayout(null);
        ventanaTabla.setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Tabla de contenido");
        lblTitulo.setBounds(20, 20, 500, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        ventanaTabla.add(lblTitulo);

        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnCerrar = new JButton("Cerrar");

        btnEditar.setBounds(30, 420, 160, 50);
        ventanaTabla.add(btnEditar);

        btnEliminar.setBounds(210, 420, 160, 50);
        ventanaTabla.add(btnEliminar);

        btnCerrar.setBounds(410, 420, 160, 50);
        ventanaTabla.add(btnCerrar);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Residuo");
        modeloTabla.addColumn("Categoría");
        modeloTabla.addColumn("Peso");

        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 80, 540, 300);
        ventanaTabla.add(scroll);
        for (Residuo r : gestion.listaResiduos) {
            Object[] fila = {r.getNombre(), r.getTipoResiduo(), r.getPeso()};
            modeloTabla.addRow(fila);
        }

        btnEditar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(ventanaTabla, "Ingrese el nombre del residuo a editar:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Residuo residuo = null;
                for (Residuo r : gestion.listaResiduos) {
                    if (r.getNombre().equalsIgnoreCase(nombre.trim())) {
                        residuo = r;
                        break;
                    }
                }

                if (residuo != null) {
                    JTextField campoNombre = new JTextField(residuo.getNombre());
                    JTextField campoTipo = new JTextField(residuo.getTipoResiduo());
                    JTextField campoPeso = new JTextField(String.valueOf(residuo.getPeso()));

                    Object[] message = {
                        "Nombre:", campoNombre,
                        "Categoría:", campoTipo,
                        "Peso:", campoPeso
                    };

                    int option = JOptionPane.showConfirmDialog(ventanaTabla, message, "Editar Residuo", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        try {
                            residuo.setNombre(campoNombre.getText().trim());
                            residuo.setTipoResiduo(campoTipo.getText().trim());
                            residuo.setPeso(Double.parseDouble(campoPeso.getText().trim()));
                            modeloTabla.setRowCount(0);
                            for (Residuo r : gestion.listaResiduos) {
                                Object[] fila = {r.getNombre(), r.getTipoResiduo(), r.getPeso()};
                                modeloTabla.addRow(fila);
                            }

                            JOptionPane.showMessageDialog(ventanaTabla, "Residuo editado correctamente.");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(ventanaTabla, "Peso inválido.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(ventanaTabla, "No se encontró ningún residuo con ese nombre.");
                }
            }
        });
        
        btnEliminar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(ventanaTabla, "Ingrese el nombre del residuo a eliminar");
            if (nombre != null && !nombre.trim().isEmpty()) {
                boolean eliminado = gestion.listaResiduos.removeIf(r -> r.getNombre().equalsIgnoreCase(nombre.trim()));
                if (eliminado) {
                    for (Residuo r : gestion.listaResiduos) {
                        Object[] fila = {r.getNombre(), r.getTipoResiduo(), r.getPeso()};
                        modeloTabla.addRow(fila);
                    }
                    JOptionPane.showMessageDialog(ventanaTabla, "Residuo eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(ventanaTabla, "No se encontró ningún residuo con ese nombre.");
                }
            }
        });
        btnCerrar.addActionListener(e -> ventanaTabla.dispose());
        ventanaTabla.setVisible(true);
    }

    public void actualizarTabla() {
        modeloTabla.setRowCount(0);

        for (Residuo r : gestion.listaResiduos) {
            Object[] fila = {
                r.getNombre(),
                r.getTipoResiduo(),
                r.getPeso()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void agregarResiduo() {

        JTextField campoNombre = new JTextField();
        JTextField campoTipo = new JTextField();
        JTextField campoPeso = new JTextField();

        Object[] message = {
            "Nombre del residuo:", campoNombre,
            "Categoría (Vidrio, Plastico,Papel, Metal, Organico):", campoTipo,
            "Peso:", campoPeso
        };

        while (true) {
            int option = JOptionPane.showConfirmDialog(null, message, "Registrar Residuo", JOptionPane.OK_CANCEL_OPTION);

            if (option != JOptionPane.OK_OPTION) {
                return;
            }

            try {
                String nombre = campoNombre.getText().trim();
                String tipo = campoTipo.getText().trim();
                double peso = Double.parseDouble(campoPeso.getText().trim());

                if (nombre.isEmpty() || tipo.isEmpty() || peso <= 0) {
                    JOptionPane.showMessageDialog(null, "Todos los campos deben llenarse correctamente y el peso ser mayor que 0.");
                    continue;
                }

                boolean existe = false;
                for (Residuo r : gestion.listaResiduos) {
                    if (r.getNombre().equalsIgnoreCase(nombre)) {
                        r.setPeso(r.getPeso() + peso);
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    gestion.registrarResiduos(nombre, tipo, peso);
                }

                JOptionPane.showMessageDialog(null, "Residuo registrado correctamente.");
                actualizarTabla();
                return;

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para el peso.");
            }
        }
    }
}
