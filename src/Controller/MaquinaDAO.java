package Controller;

import Model.Maquina;
import java.sql.*;
import java.util.*;

public class MaquinaDAO {
    private static final String host = "jdbc:mysql://localhost:3306/";
    private static final String BD = "chayateam";
    private static final String user = "root";
    private static final String password = "";

    // Método para insertar una nueva Máquina
    public void insertarMaquina(Maquina maquina) {
        String sql = "INSERT INTO Maquina (marca, modelo, nro_sala) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maquina.getMarca());
            pstmt.setString(2, maquina.getModelo());
            pstmt.setInt(3, maquina.getNroSala());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las Máquinas
    public List<Maquina> obtenerMaquinas() {
        List<Maquina> lista = new ArrayList<>();
        String sql = "SELECT codigo_maquina, marca, modelo, nro_sala FROM Maquina";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int codigoMaquina = rs.getInt("codigo_maquina");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int nroSala = rs.getInt("nro_sala");

                Maquina maquina = new Maquina(codigoMaquina, marca, modelo, nroSala);
                lista.add(maquina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para actualizar una Máquina
    public void actualizarMaquina(Maquina maquina) {
        String sql = "UPDATE Maquina SET marca = ?, modelo = ?, nro_sala = ? WHERE codigo_maquina = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maquina.getMarca());
            pstmt.setString(2, maquina.getModelo());
            pstmt.setInt(3, maquina.getNroSala());
            pstmt.setInt(4, maquina.getCodigoMaquina());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una Máquina
    public void eliminarMaquina(int codigoMaquina) {
        String sql = "DELETE FROM Maquina WHERE codigo_maquina = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigoMaquina);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}