package Controller;

import Model.Entrenador;
import Model.Plan;
import Model.Sala;
import Model.Se_imparte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Se_imparteDAO {

    private static final String host = "jdbc:mysql://localhost/";
    private static final String BD = "chayateam";
    private static final String user = "root";
    private static final String password = "";

    // Método para insertar una relación ternaria en la tabla SE_IMPARTE
    public void insertarSeImparte(Se_imparte seImparte) {
        String sql = "INSERT INTO SE_IMPARTE (entrenador_id, sala_id, plan_codigo, fecha) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Se_imparte.getEntrenador().getId());
            pstmt.setInt(2, seImparte.getSala().getNro_sala());
            pstmt.setInt(3, seImparte.getPlan().getCodigo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Obtener todas las relaciones en SE_IMPARTE
    public List<Se_imparte> obtenerSeImparte() {
        List<Se_imparte> seImparteList = new ArrayList<>();
        String sql = "SELECT * FROM SE_IMPARTE";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int entrenadorId = rs.getInt("entrenador_id");
                int salaId = rs.getInt("sala_id");
                int planCodigo = rs.getInt("plan_codigo");
                String fecha = rs.getString("fecha");

                Entrenador entrenador = new Entrenador(entrenadorId, "NombreEntrenador"); // Placeholder
                Sala sala = new Sala(salaId, "NombreSala"); // Placeholder
                Plan plan = new Plan("10:00", "Lunes", "Descripción", planCodigo); // Placeholder

                Se_imparte seImparte = new Se_imparte(entrenador, sala, plan);
                seImparteList.add(seImparte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seImparteList;
    }

    // UPDATE: Actualizar la fecha en una relación SE_IMPARTE específica
    public void actualizarSeImparteFecha(int entrenadorId, int salaId, int planCodigo, String nuevaFecha) {
        String sql = "UPDATE SE_IMPARTE SET fecha = ? WHERE entrenador_id = ? AND sala_id = ? AND plan_codigo = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevaFecha);
            pstmt.setInt(2, entrenadorId);
            pstmt.setInt(3, salaId);
            pstmt.setInt(4, planCodigo);

            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Fecha de la relación SE_IMPARTE actualizada correctamente.");
            } else {
                System.out.println("No se encontró la relación SE_IMPARTE para actualizar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Eliminar una relación SE_IMPARTE específica
    public void eliminarSeImparte(int entrenadorId, int salaId, int planCodigo) {
        String sql = "DELETE FROM SE_IMPARTE WHERE entrenador_id = ? AND sala_id = ? AND plan_codigo = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, entrenadorId);
            pstmt.setInt(2, salaId);
            pstmt.setInt(3, planCodigo);

            int filasEliminadas = pstmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Relación SE_IMPARTE eliminada correctamente.");
            } else {
                System.out.println("No se encontró la relación SE_IMPARTE para eliminar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}