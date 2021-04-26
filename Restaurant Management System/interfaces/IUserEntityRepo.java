package interfaces;

import java.lang.*;
import entity.*;

public interface IUserEntityRepo
{
	UserEntity getUser(String userId, String password);
	void insertUser(UserEntity u);
	void updateUser(UserEntity u);
	void deleteUser(String userId);
}