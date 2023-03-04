import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        // Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String password = "4508";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            // Подставляем значение вместо wildcard
            statement.setInt(1, 4);

            // Делаем запрос к базе и результат кладем в ResultSet
            final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String idOfEmployee = "id: " + resultSet.getString("id");
                String titleOfEmployee = "name: " + resultSet.getString("first_name") +
                        " " + resultSet.getString("last_name");
                String genderOfEmployee = "gender: " + resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt(5);
                String cityOfEmployee = "city: " + resultSet.getString("city");

                // Выводим данные в консоль
                System.out.println(idOfEmployee);
                System.out.println(titleOfEmployee);
                System.out.println(genderOfEmployee);
                System.out.println("age: " + ageOfEmployee);
                System.out.println(cityOfEmployee);
            }
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(connection);
            Employee employee = new Employee();
            employeeDao.create(employee);
        }
    }
}

