package com.amo.database;

import java.sql.*;

public class SampleAccessor {

    private Connection connection;

    public SampleAccessor(Connection c) {
        if(c != null) {
            this.connection = c;
        } else {
            System.out.println("Connection null...");
        }
    }

    public int insert(String name) {
        int reqId = -1;
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO sample.SampleTable(name, requestTime) values(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

            if(stmt.executeUpdate() > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if(rs.next())
                        reqId = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.connection = ConnectionManager.close();
        }
        return reqId;
    }
}
