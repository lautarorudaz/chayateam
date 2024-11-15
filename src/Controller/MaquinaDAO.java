package Controller;

import JDBC.DBConfig;
import Model.Maquina;
import java.sql.*;
import java.util.*;

public class MaquinaDAO {

    private static final String host = DBConfig.getHost();
    private static final String bd = DBConfig.getDatabase();
    private static final String user = DBConfig.getUser();
    private static final String password = DBConfig.getPassword();

    //Insertar una nueva máquina
    public void insertarMaquina(Maquina maquina) {
        String sql = "INSERT INTO Máquina (código_máquina, Marca, Modelo) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, maquina.getCodigoMaquina());
            pstmt.setString(2, maquina.getMarca());
            pstmt.setString(3, maquina.getModelo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todas las máquinas
    public List<Maquina> obtenerMaquinas() {
        List<Maquina> lista = new ArrayList<>();
        String sql = "SELECT código_máquina, Marca, Modelo FROM Máquina";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int codigo_maquina = rs.getInt("código_máquina");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");

                Maquina maquina = new Maquina(codigo_maquina, marca, modelo);
                lista.add(maquina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar una máquina
    public void actualizarMaquina(Maquina maquina) {
        String sql = "UPDATE Máquina SET Marca = ?, Modelo = ? WHERE código_máquina = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maquina.getMarca());
            pstmt.setString(2, maquina.getModelo());
            pstmt.setInt(3, maquina.getCodigoMaquina());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar una máquina
    public void eliminarMaquina(int codigo_maquina) {
        String sql = "DELETE FROM Máquina WHERE código_máquina = ?";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo_maquina);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}