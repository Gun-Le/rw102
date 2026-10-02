package backend;

import entity.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLTK implements IQLTK {

    private final String url = "jdbc:mysql://localhost:3306/btvn_buoi8";
    private final String username = "root";
    private final String password = "root";
    private final Scanner sc = new Scanner(System.in);

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public void danhSachAccount() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT a.account_id, a.email, a.username, a.full_name, a.create_date, " +
                "d.department_id, d.department_name, " +
                "p.position_id, p.position_name " +
                "FROM `account` a " +
                "LEFT JOIN `department` d ON a.department_id = d.department_id " +
                "LEFT JOIN `position` p ON a.position_id = p.position_id";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int accId = resultSet.getInt("account_id");
                String email = resultSet.getString("email");
                String uname = resultSet.getString("username");
                String fullName = resultSet.getString("full_name");
                Date dateSql = resultSet.getDate("create_date");
                LocalDate createDate = (dateSql != null) ? dateSql.toLocalDate() : null;

                int depId = resultSet.getInt("department_id");
                String depName = resultSet.getString("department_name");
                Department department = new Department(depId, depName);

                int posId = resultSet.getInt("position_id");
                String posNameStr = resultSet.getString("position_name");
                PositionName posName = (posNameStr != null)
                        ? PositionName.valueOf(posNameStr.toUpperCase().replace(" ", "_"))
                        : null;
                Position position = new Position(posId, posName);

                Account account = new Account(accId, email, uname, fullName, department, position, createDate);
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            return;
        }

        System.out.println("\n==== DANH SÁCH ACCOUNT ====");
        System.out.println("+----+----------------------+-----------------+---------------------+---------------------+------------------+------------+");
        System.out.printf("|%-4s|%-22s|%-17s|%-21s|%-21s|%-18s|%-12s|\n",
                "ID", "Email", "Username", "Full Name", "Department", "Position", "Create Date");
        System.out.println("+----+----------------------+-----------------+---------------------+---------------------+------------------+------------+");
        for (Account acc : accounts) {
            String depName = (acc.getDepartment() != null && acc.getDepartment().getDepartmentName() != null)
                    ? acc.getDepartment().getDepartmentName() : "";
            String posName = (acc.getPosition() != null && acc.getPosition().getPositionName() != null)
                    ? acc.getPosition().getPositionName().name() : "";

            System.out.printf("|%-4d|%-22s|%-17s|%-21s|%-21s|%-18s|%-12s|\n",
                    acc.getAccountId(),
                    acc.getEmail(),
                    acc.getUsername(),
                    acc.getFullName(),
                    depName,
                    posName,
                    acc.getCreateDate());
        }
        System.out.println("+----+----------------------+-----------------+---------------------+---------------------+------------------+------------+");
    }

    @Override
    public void timKiemTheoUsername() {
        System.out.println("\n==== TÌM KIẾM ACCOUNT THEO USERNAME ====");
        System.out.print("Nhập username cần tìm: ");
        String unameInput = sc.nextLine().trim();
        List<Account> accounts = new ArrayList<>();

        String sql = "SELECT a.account_id, a.email, a.username, a.full_name, a.create_date, " +
                "d.department_id, d.department_name, " +
                "p.position_id, p.position_name " +
                "FROM `account` a " +
                "LEFT JOIN `department` d ON a.department_id = d.department_id " +
                "LEFT JOIN `position` p ON a.position_id = p.position_id " +
                "WHERE a.username LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + unameInput + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int accId = resultSet.getInt("account_id");
                    String email = resultSet.getString("email");
                    String uname = resultSet.getString("username");
                    String fullName = resultSet.getString("full_name");
                    Date dateSql = resultSet.getDate("create_date");
                    LocalDate createDate = (dateSql != null) ? dateSql.toLocalDate() : null;

                    int depId = resultSet.getInt("department_id");
                    String depName = resultSet.getString("department_name");
                    Department department = new Department(depId, depName);

                    int posId = resultSet.getInt("position_id");
                    String posNameStr = resultSet.getString("position_name");
                    PositionName posName = (posNameStr != null) ? PositionName.valueOf(posNameStr) : null;
                    Position position = new Position(posId, posName);

                    accounts.add(new Account(accId, email, uname, fullName, department, position, createDate));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            return;
        }

        if (accounts.isEmpty()) {
            System.out.println("Không tìm thấy account nào!");
            return;
        }

        System.out.println("+----+----------------------+-----------------+---------------------+---------------------+------------------+------------+");
        System.out.printf("|%-4s|%-22s|%-17s|%-21s|%-21s|%-18s|%-12s|\n",
                "ID", "Email", "Username", "Full Name", "Department", "Position", "Create Date");
        System.out.println("+----+----------------------+-----------------+---------------------+---------------------+------------------+------------+");
        for (Account acc : accounts) {
            String depName = (acc.getDepartment() != null && acc.getDepartment().getDepartmentName() != null)
                    ? acc.getDepartment().getDepartmentName() : "";
            String posName = (acc.getPosition() != null && acc.getPosition().getPositionName() != null)
                    ? acc.getPosition().getPositionName().name() : "";

            System.out.printf("|%-4d|%-22s|%-17s|%-21s|%-21s|%-18s|%-12s|\n",
                    acc.getAccountId(), acc.getEmail(), acc.getUsername(), acc.getFullName(), depName, posName, acc.getCreateDate());
        }
        System.out.println("+----+----------------------+-----------------+---------------------+---------------------+------------------+------------+");
    }

    @Override
    public void danhSachDepartment() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM `department`";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("department_id");
                String name = resultSet.getString("department_name");
                departments.add(new Department(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            return;
        }

        System.out.println("\n==== DANH SÁCH DEPARTMENT ====");
        System.out.println("+----+-------------------------+");
        System.out.printf("|%-4s|%-25s|\n", "ID", "Department Name");
        System.out.println("+----+-------------------------+");
        for (Department dep : departments) {
            System.out.printf("|%-4d|%-25s|\n", dep.getDepartmentId(), dep.getDepartmentName());
        }
        System.out.println("+----+-------------------------+");
    }

    @Override
    public void timKiemDepartment() {
        System.out.println("\n==== TÌM KIẾM DEPARTMENT THEO TÊN ====");
        System.out.print("Nhập tên department cần tìm: ");
        String nameInput = sc.nextLine().trim();

        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM `department` WHERE department_name LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + nameInput + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("department_id");
                    String name = resultSet.getString("department_name");
                    departments.add(new Department(id, name));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            return;
        }

        if (departments.isEmpty()) {
            System.out.println("Không tìm thấy department nào!");
            return;
        }

        System.out.println("+----+-------------------------+");
        System.out.printf("|%-4s|%-25s|\n", "ID", "Department Name");
        System.out.println("+----+-------------------------+");
        for (Department dep : departments) {
            System.out.printf("|%-4d|%-25s|\n", dep.getDepartmentId(), dep.getDepartmentName());
        }
        System.out.println("+----+-------------------------+");
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("\n========= QUẢN LÝ TÀI KHOẢN =========");
            System.out.println("1. Hiển thị toàn bộ Account");
            System.out.println("2. Tìm kiếm Account theo Username");
            System.out.println("3. Hiển thị danh sách Department");
            System.out.println("4. Tìm kiếm Department theo tên");
            System.out.println("5. Thoát");
            System.out.print("Mời nhập lựa chọn (1 - 5): ");

            if (!sc.hasNextInt()) {
                System.out.println("Vui lòng nhập số!");
                sc.next();
                continue;
            }

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> danhSachAccount();
                case 2 -> timKiemTheoUsername();
                case 3 -> danhSachDepartment();
                case 4 -> timKiemDepartment();
                case 5 -> {
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}
