package Controller;

import Model.Entrenador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDAO {

    private static final String host = "jdbc:mysql://localhost/";
    private static final String BD = "chayateam";
    private static final String user = "root";
    private static final String password = "";

    // Método para insertar un nuevo Entrenador
    public void insertarEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO Entrenador (nombre, apellido, teléfono) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entrenador.getNombre());
            pstmt.setString(2, entrenador.getApellido());
            pstmt.setInt(3, entrenador.getTelefono());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los Entrenadores
    public List<Entrenador> obtenerEntrenadores() {
        List<Entrenador> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido,teléfono FROM Entrenador";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                int telefono = rs.getInt("Teléfono");

                Entrenador entrenador = new Entrenador(id, nombre, apellido, telefono);
                lista.add(entrenador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para actualizar un Entrenador
    public void actualizarEntrenador(Entrenador entrenador) {
        // Asegúrate de que el id es válido
        if (entrenador.getId() == 0) {
            System.out.println("ID no válido. No se puede actualizar.");
            return; // Salir si el ID es 0
        }

        String sql = "UPDATE Entrenador SET nombre = ?, apellido = ?, teléfono = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, entrenador.getNombre());
            pstmt.setString(2, entrenador.getApellido());
            pstmt.setInt(3, entrenador.getTelefono());
            pstmt.setInt(4, entrenador.getId());  // Asegúrate de que el id esté correctamente pasado

            // Ejecutar la actualización
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Entrenador actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un entrenador con el ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un Entrenador
    public void eliminarEntrenador(int id) {
        String sql = "DELETE FROM Entrenador WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}