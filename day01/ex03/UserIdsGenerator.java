
public class UserIdsGenerator {
	private	int	lastGeneratedID;
	private static  UserIdsGenerator instance;

	UserIdsGenerator() {
	}

	public int generateId() {
		++lastGeneratedID;
		return lastGeneratedID;
	}

	public static UserIdsGenerator getInstance() {
		if (instance == null) {
			instance = new UserIdsGenerator();
		}
		return instance;
	}
}
