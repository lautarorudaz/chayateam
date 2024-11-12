package Controller;

import Model.Entrenador;
import java.sql.*;
import java.util.*;

public class EntrenadorDAO {

    private static final String host = "jdbc:mysql://localhost/";
    private static final String BD = "gym";
    private static final String user = "root";
    private static final String password = "";

    //Insertar un nuevo entrenador
    public void insertarEntrenador(Entrenador entrenador) {
        String sql = "INSERT INTO Entrenador (ID, Nombre, Apellido, Teléfono) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, entrenador.getId());
            pstmt.setString(2, entrenador.getNombre());
            pstmt.setString(3, entrenador.getApellido());
            pstmt.setLong(4, entrenador.getTelefono());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todos los entrenadores
    public List<Entrenador> obtenerEntrenadores() {
        List<Entrenador> lista = new ArrayList<>();
        String sql = "SELECT ID, Nombre, Apellido, Teléfono FROM Entrenador";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                long telefono = rs.getLong("Teléfono");

                Entrenador entrenador = new Entrenador(id, nombre, apellido, telefono);
                lista.add(entrenador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar un entrenador
    public void actualizarEntrenador(Entrenador entrenador) {
        String sql = "UPDATE Entrenador SET Nombre = ?, Apellido = ?, Teléfono = ? WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entrenador.getNombre());
            pstmt.setString(2, entrenador.getApellido());
            pstmt.setLong(3, entrenador.getTelefono());
            pstmt.setInt(4, entrenador.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar un entrenador
    public void eliminarEntrenador(int id) {
        String sql = "DELETE FROM Entrenador WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}