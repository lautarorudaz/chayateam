package Controller;

import Model.Plan;
import java.sql.*;
import java.util.*;

public class PlanDAO {

    private static final String host = "jdbc:mysql://localhost/";
    private static final String BD = "gym";
    private static final String user = "root";
    private static final String password = "";

    //Insertar un nuevo plan
    public void insertarPlan(Plan plan) {
        String sql = "INSERT INTO Plan (código_plan, Hora, Día, Descripción) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, plan.getCodigo_plan());
            pstmt.setString(2, plan.getHora());
            pstmt.setString(3, plan.getDia());
            pstmt.setString(4, plan.getDescripcion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obtener todos los planes
    public List<Plan> obtenerPlanes() {
        List<Plan> planes = new ArrayList<>();
        String sql = "SELECT código_plan, Hora, Día, Descripción FROM Plan";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int codigo_plan = rs.getInt("código_plan");
                String hora = rs.getString("Hora");
                String dia = rs.getString("Día");
                String descripcion = rs.getString("Descripción");

                Plan plan = new Plan(codigo_plan, hora, dia, descripcion);
                planes.add(plan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planes;
    }

    //Actualizar un plan
    public void actualizarPlan(Plan plan) {
        String sql = "UPDATE Plan SET Hora = ?, Día = ?, Descripción = ? WHERE código_plan = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, plan.getHora());
            pstmt.setString(2, plan.getDia());
            pstmt.setString(3, plan.getDescripcion());
            pstmt.setInt(4, plan.getCodigo_plan());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Eliminar un plan
    public void eliminarPlan(int codigo_plan) {
        String sql = "DELETE FROM Plan WHERE código_plan = ?";

        try (Connection conn = DriverManager.getConnection(host+BD,user,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo_plan);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}