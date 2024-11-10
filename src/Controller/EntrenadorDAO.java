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
        String sql = "INSERT INTO Entrenador (id, nombre, apellido, telefono) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, entrenador.getId());
            pstmt.setString(2, entrenador.getNombre());
            pstmt.setString(3, entrenador.getApellido());
            pstmt.setInt(4, entrenador.getTelefono());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los Entrenadores
    public List<Entrenador> obtenerEntrenadores() {
        List<Entrenador> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, especialidad FROM Entrenador";

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
        String sql = "UPDATE Entrenador SET nombre = ?, especialidad = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, entrenador.getId());
            pstmt.setString(2, entrenador.getNombre());
            pstmt.setString(3, entrenador.getApellido());
            pstmt.setInt(4, entrenador.getTelefono());

            pstmt.executeUpdate();
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