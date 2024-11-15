package Controller;

import JDBC.DBConfig;
import Model.Cancha;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanchaDAO {

    private static final String host = DBConfig.getHost();
    private static final String bd = DBConfig.getDatabase();
    private static final String user = DBConfig.getUser();
    private static final String password = DBConfig.getPassword();

    //Crear una nueva cancha
    public static void crearCancha(Cancha cancha) {
        String sql = "INSERT INTO Cancha (id, nombre, precio_por_hora) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cancha.getId());
            pstmt.setString(2, cancha.getNombre());
            pstmt.setDouble(3, cancha.getPrecioPorHora());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Listar todas las canchas
    public List<Cancha> listarCancha() {
        List<Cancha> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, precio_por_hora FROM Cancha";

        try (Connection conn = DriverManager.getConnection(host + bd, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio_por_hora = rs.getDouble("precio_por_hora");

                Cancha maquina = new Cancha(id, nombre, precio_por_hora);
                lista.add(maquina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

        //Actualizar una cancha
        public void actualizarCancha(Cancha cancha) {
            String sql = "UPDATE Cancha SET nombre = ?, precio_por_hora = ? WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(host + bd, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, cancha.getNombre());
                pstmt.setDouble(2, cancha.getPrecioPorHora());

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //Eliminar una cancha
        public void eliminarCancha(int id){
            String sql = "DELETE FROM Cancha WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(host + bd, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }