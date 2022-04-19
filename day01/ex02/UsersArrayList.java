public class UsersArrayList implements UsersList {
	
	private	User[]	innerArr		= new User[START_ARR_SIZE];
	private	int		numberOfUsers	= 0;


	@Override
	public void addUser(User newUser) {
		if (innerArr.length == numberOfUsers) {
			updateArrayLength();
		}
		innerArr[numberOfUsers] = newUser;
		numberOfUsers++;
	}

	@Override
	public int	getNumberOfUsers() {
		return numberOfUsers;
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		for (int i = 0; i < numberOfUsers; i++) {
			if (innerArr[i].getId() == id) {
				return innerArr[i];
			}
		}
		throw new UserNotFoundException("User not found by id " + id);
	}

	@Override
	public User getUserByIndex(int index) throws UserNotFoundException, IndexOutOfBoundsException {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Negative index");
		}
		if (index > numberOfUsers) {
			throw new UserNotFoundException("User not found by index " + index);
		}
		return innerArr[index];
	}

	private void updateArrayLength() {
		User[] new_arr = new User[innerArr.length + innerArr.length / 2];
		for (int i = 0; i < innerArr.length; i++) {
			new_arr[i] = innerArr[i];
		}
		this.innerArr = new_arr;
	}


}
