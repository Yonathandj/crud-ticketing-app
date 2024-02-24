package implementations.repositories;

import java.sql.ResultSet;

public interface UserRepositoryImplementation {
    public String addNewUserService(String name, String phoneNumber, String email, String address);
    public ResultSet getAllUsersService();
    public ResultSet getUserByIdService(String id);
    public int updateUserByIdService(String id, String name, String phoneNumber, String email, String address);
    public int deleteUserByIdService(String id);
    public ResultSet checkExistenceUser(String id);
}
