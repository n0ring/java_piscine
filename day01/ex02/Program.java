public class Program {
public static void main(String[] args) {
	UsersArrayList arr = new UsersArrayList();
		
		for (int i = 0; i < 20; i++) {
			User john = new User("John " + i, i * 100);
			arr.addUser(john);
		}
		System.out.println(arr.getNumberOfUsers());
		System.out.println(arr.getUserById(10));
		System.out.println(arr.getUserByIndex(10));
		
		
		try {
			System.out.println(arr.getUserByIndex(100).getBalance());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(arr.getUserById(100).getBalance());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println(arr.getUserByIndex(-100).getBalance());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
