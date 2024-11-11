package Controller;

import Model.Sala;
import java.sql.*;
import java.util.*;

public class SalaDAO {
    private static final String host = "jdbc:mysql://localhost:3306/";
    private static final String BD = "chayateam";
    private static final String user = "root";
    private static final String password = "";

    // Método para insertar una nueva Sala
    public void insertarSala(Sala sala) {
        String sql = "INSERT INTO Sala (ubicacion, nro_sala, capacidad) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sala.getUbicacion());
            pstmt.setInt(2, sala.getNro_sala());
            pstmt.setInt(3, sala.getCapacidad());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las Salas
    public List<Sala> obtenerSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT nro_sala, ubicacion, capacidad FROM Sala";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int nroSala = rs.getInt("nro_sala");
                String ubicacion = rs.getString("ubicacion");
                int capacidad = rs.getInt("capacidad");

                Sala sala = new Sala(nroSala, ubicacion, capacidad);
                lista.add(sala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para actualizar una Sala
    public void actualizarSala(Sala sala) {
        String sql = "UPDATE Sala SET ubicacion = ?, capacidad = ? WHERE nro_sala = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sala.getUbicacion());
            pstmt.setInt(2, sala.getCapacidad());
            pstmt.setInt(3, sala.getNro_sala());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una Sala
    public void eliminarSala(int nroSala) {
        String sql = "DELETE FROM Sala WHERE nro_sala = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, nroSala);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}