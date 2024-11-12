package Controller;

import Model.Maquina;
import java.sql.*;
import java.util.*;

public class MaquinaDAO {

    private static final String host = "jdbc:mysql://localhost:3306/";
    private static final String BD = "gym";
    private static final String user = "root";
    private static final String password = "";

    //Insertar una nueva máquina
    public void insertarMaquina(Maquina maquina) {
        String sql = "INSERT INTO Máquina (código_máquina, Marca, Modelo, nro_sala) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, maquina.getCodigoMaquina());
            pstmt.setString(2, maquina.getMarca());
            pstmt.setString(3, maquina.getModelo());
            pstmt.setInt(4, maquina.getNroSala());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todas las máquinas
    public List<Maquina> obtenerMaquinas() {
        List<Maquina> lista = new ArrayList<>();
        String sql = "SELECT código_máquina, Marca, Modelo, nro_sala FROM Máquina";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int codigo_maquina = rs.getInt("código_máquina");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int nro_sala = rs.getInt("nro_sala");

                Maquina maquina = new Maquina(codigo_maquina, marca, modelo, nro_sala);
                lista.add(maquina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Actualizar una máquina
    public void actualizarMaquina(Maquina maquina) {
        String sql = "UPDATE Máquina SET Marca = ?, Modelo = ?, nro_sala = ? WHERE código_máquina = ?";

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

    //Eliminar una máquina
    public void eliminarMaquina(int codigo_maquina) {
        String sql = "DELETE FROM Máquina WHERE código_máquina = ?";

        try (Connection conn = DriverManager.getConnection(host + BD, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo_maquina);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}