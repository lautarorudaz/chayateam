package Controller;

import Model.Socio;
import java.sql.*;
import java.util.*;

public class SocioDAO {
    private static final String host = "jdbc:mysql://localhost:3306/";
    private static final String BD = "chayateam";
    private static final String user = "root";
    private static final String password = "";

    // Método para insertar un nuevo Socio
    public void insertarSocio(Socio socio) {
        String sql = "INSERT INTO Socio (nombre, apellido, direccion, telefono) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, socio.getNombre());
            pstmt.setString(2, socio.getApellido());
            pstmt.setString(3, socio.getDireccion());
            pstmt.setLong(4, socio.getTelefono());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los Socios
    public List<Socio> obtenerSocios() {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT num_socio, nombre, apellido, direccion, telefono FROM Socio";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int numSocio = rs.getInt("num_socio");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                long telefono = rs.getLong("telefono");

                Socio socio = new Socio(numSocio, nombre, apellido, direccion, telefono);
                lista.add(socio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para actualizar un Socio
    public void actualizarSocio(Socio socio) {
        String sql = "UPDATE Socio SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE num_socio = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, socio.getNombre());
            pstmt.setString(2, socio.getApellido());
            pstmt.setString(3, socio.getDireccion());
            pstmt.setLong(4, socio.getTelefono());
            pstmt.setInt(5, socio.getNumSocio());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un Socio
    public void eliminarSocio(int numSocio) {
        String sql = "DELETE FROM Socio WHERE num_socio = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numSocio);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}