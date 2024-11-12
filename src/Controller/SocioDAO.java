package Controller;

import Model.Socio;
import java.sql.*;
import java.util.*;

public class SocioDAO {

    private static final String host = "jdbc:mysql://localhost:3306/";
    private static final String BD = "gym";
    private static final String user = "root";
    private static final String password = "";

    //Insertar un nuevo socio
    public void insertarSocio(Socio socio) {
        String sql = "INSERT INTO Socio (num_socio, Nombre, Apellido, Dirección, Teléfono) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, socio.getNum_socio());
            pstmt.setString(2, socio.getNombre());
            pstmt.setString(3, socio.getApellido());
            pstmt.setString(4, socio.getDireccion());
            pstmt.setLong(5, socio.getTelefono());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todos los socios
    public List<Socio> obtenerSocios() {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT num_socio, Nombre, Apellido, Dirección, Teléfono FROM Socio";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int num_socio = rs.getInt("num_socio");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String direccion = rs.getString("Dirección");
                long telefono = rs.getLong("Teléfono");

                Socio socio = new Socio(num_socio, nombre, apellido, direccion, telefono);
                lista.add(socio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar un socio
    public void actualizarSocio(Socio socio) {
        String sql = "UPDATE Socio SET Nombre = ?, Apellido = ?, Dirección = ?, Teléfono = ? WHERE num_socio = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, socio.getNombre());
            pstmt.setString(2, socio.getApellido());
            pstmt.setString(3, socio.getDireccion());
            pstmt.setLong(4, socio.getTelefono());
            pstmt.setInt(5, socio.getNum_socio());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar un socio
    public void eliminarSocio(int num_socio) {
        String sql = "DELETE FROM Socio WHERE num_socio = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num_socio);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}