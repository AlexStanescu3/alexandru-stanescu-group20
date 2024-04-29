package Database;

import java.sql.*;

public class BookingDatabaseTest {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/BookingApplication?user=postgres&password=alex010398";

    public static void main(String[] args) {

        insertData();

        retrieveData();
    }

    private static void insertData() {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {

            String insertAccommodationSQL = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insertAccommodationSQL);

            preparedStatement1.setInt(1, 1);
            preparedStatement1.setString(2, "Hotel");
            preparedStatement1.setString(3, "Double");
            preparedStatement1.setInt(4, 2);
            preparedStatement1.setString(5, "Luxurious hotel room with ocean view");
            preparedStatement1.executeUpdate();

            preparedStatement1.setInt(1, 2);
            preparedStatement1.setString(2, "Motel");
            preparedStatement1.setString(3, "Single");
            preparedStatement1.setInt(4, 1);
            preparedStatement1.setString(5, "Cozy motel room for solo travelers");
            preparedStatement1.executeUpdate();

            preparedStatement1.setInt(1, 3);
            preparedStatement1.setString(2, "Resort");
            preparedStatement1.setString(3, "Queen");
            preparedStatement1.setInt(4, 4);
            preparedStatement1.setString(5, "Spacious resort room perfect for families");
            preparedStatement1.executeUpdate();


            String insertRoomFairSQL = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(insertRoomFairSQL);

            preparedStatement2.setInt(1, 1);
            preparedStatement2.setDouble(2, 150.0);
            preparedStatement2.setString(3, "Summer");
            preparedStatement2.executeUpdate();

            preparedStatement2.setInt(1, 2);
            preparedStatement2.setDouble(2, 100.0);
            preparedStatement2.setString(3, "Spring");
            preparedStatement2.executeUpdate();

            preparedStatement2.setInt(1, 3);
            preparedStatement2.setDouble(2, 200.0);
            preparedStatement2.setString(3, "Winter");
            preparedStatement2.executeUpdate();


            String insertRelationSQL = "INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement3 = connection.prepareStatement(insertRelationSQL);

            preparedStatement3.setInt(1, 1);
            preparedStatement3.setInt(2, 1); // Accommodation ID
            preparedStatement3.setInt(3, 1); // Room Fair ID
            preparedStatement3.executeUpdate();

            preparedStatement3.setInt(1, 2);
            preparedStatement3.setInt(2, 2);
            preparedStatement3.setInt(3, 2);
            preparedStatement3.executeUpdate();

            preparedStatement3.setInt(1, 3);
            preparedStatement3.setInt(2, 3);
            preparedStatement3.setInt(3, 3);
            preparedStatement3.executeUpdate();

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveData() {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {


            String query = "SELECT accommodation.id, accommodation.type, accommodation.bed_type, accommodation.max_guests, accommodation.description, room_fair.value, room_fair.season " +
                    "FROM accommodation " +
                    "INNER JOIN accommodation_room_fair_relation " +
                    "ON accommodation.id = accommodation_room_fair_relation.accommodation_id " +
                    "INNER JOIN room_fair " +
                    "ON accommodation_room_fair_relation.room_fair_id = room_fair.id";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String bedType = resultSet.getString("bed_type");
                int maxGuests = resultSet.getInt("max_guests");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("value");
                String season = resultSet.getString("season");

                System.out.println("Room ID: " + id);
                System.out.println("Room Type: " + type);
                System.out.println("Bed Type: " + bedType);
                System.out.println("Max Guests: " + maxGuests);
                System.out.println("Description: " + description);
                System.out.println("Price: " + price);
                System.out.println("Season: " + season);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

