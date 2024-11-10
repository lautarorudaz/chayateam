package Controller;

import Model.Plan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {

    private static final String host = "jdbc:mysql://localhost/";
    private static final String BD = "chayateam";
    private static final String user = "root";
    private static final String password = "";

    // Método para insertar un nuevo plan
    public void insertarPlan(Plan plan) {
        String sql = "INSERT INTO PLAN (Hora, Dia, Descripcion, codigo) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getHora());
            pstmt.setString(2, plan.getDia());
            pstmt.setString(3, plan.getDescripcion());
            pstmt.setInt(4, plan.getCodigo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los planes
    public List<Plan> obtenerPlanes() {
        List<Plan> planes = new ArrayList<>();
        String sql = "SELECT Hora, Dia, Descripcion, codigo FROM PLAN";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String hora = rs.getString("Hora");
                String dia = rs.getString("Dia");
                String descripcion = rs.getString("Descripcion");
                int codigo = rs.getInt("codigo");

                Plan plan = new Plan(hora, dia, descripcion, codigo);
                planes.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planes;
    }

    // Método para actualizar un plan existente
    public void actualizarPlan(Plan plan) {
        String sql = "UPDATE PLAN SET Hora = ?, Dia = ?, Descripcion = ? WHERE codigo = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getHora());
            pstmt.setString(2, plan.getDia());
            pstmt.setString(3, plan.getDescripcion());
            pstmt.setInt(4, plan.getCodigo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un plan por código
    public void eliminarPlan(int codigo) {
        String sql = "DELETE FROM PLAN WHERE codigo = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}