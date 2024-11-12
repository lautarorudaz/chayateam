package Controller;

import JDBC.DBConfig;
import Model.Sala;
import java.sql.*;
import java.util.*;

public class SalaDAO {

    private static final String host = DBConfig.getHost();
    private static final String bd = DBConfig.getDatabase();
    private static final String user = DBConfig.getUser();
    private static final String password = DBConfig.getPassword();

    //Insertar una nueva sala
    public void insertarSala(Sala sala) {
        String sql = "INSERT INTO Sala (nro_sala, Ubicación, Capacidad) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, sala.getNro_sala());
            pstmt.setString(2, sala.getUbicacion());
            pstmt.setInt(3, sala.getCapacidad());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todas las salas
    public List<Sala> obtenerSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT nro_sala, Ubicación, Capacidad FROM Sala";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int nro_sala = rs.getInt("nro_sala");
                String ubicacion = rs.getString("Ubicación");
                int capacidad = rs.getInt("Capacidad");

                Sala sala = new Sala(nro_sala, ubicacion, capacidad);
                lista.add(sala);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar una sala
    public void actualizarSala(Sala sala) {
        String sql = "UPDATE Sala SET Ubicación = ?, Capacidad = ? WHERE nro_sala = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sala.getUbicacion());
            pstmt.setInt(2, sala.getCapacidad());
            pstmt.setInt(3, sala.getNro_sala());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar una sala
    public void eliminarSala(int nro_sala) {
        String sql = "DELETE FROM Sala WHERE nro_sala = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, nro_sala);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}