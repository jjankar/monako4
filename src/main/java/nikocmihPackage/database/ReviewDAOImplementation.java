package nikocmihPackage.database;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import nikocmihPackage.domain.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolajs Cmihuns on 11/3/2015.
 */
public class ReviewDAOImplementation implements ReviewDAOInterface {


    private final DAO dao = new DAOImpl();


    @Override
    public void createReviewOnRoute(Review review) throws DBException {
        if (review == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into REVIEW (creatorID, routeID, title, body, imageURLvalues) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, review.getCreatorID());
            preparedStatement.setInt(2, review.getRouteID());
            preparedStatement.setString(3, review.getTitle());
            preparedStatement.setString(4, review.getBody());
            preparedStatement.setString(5, review.getImageURL());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                review.setReviewID(rs.getInt(1));
            }



        } catch (Throwable e) {
            System.out.println("Exception while execute ReviewDAOImplementation.createReviewOnRoute()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }


    public Connection getConnection() throws DBException {
        return dao.getConnection();
    }

    public void closeConnection(Connection connection) throws DBException {
        dao.closeConnection(connection);
    }


}