interface UsersList {
	final int START_ARR_SIZE = 10;
	void	addUser(User newUser);
	User	getUserById(int id) throws UserNotFoundException;
	User	getUserByIndex(int index) throws UserNotFoundException, IndexOutOfBoundsException;
	int		getNumberOfUsers();
}
