public class Program {

	public static void main(String[] args) {
		User a = new User("sender", 100);
		User b = new User("reciever", 0);
		System.out.println(a.getId());
		System.out.println(a.getName());
		System.out.println(a.getBalance());


		Transaction c = new Transaction(b, a, 500);
		System.out.println(c.getAmout());
		// if (c.getCategory() == Transaction.category.CREDIT)
			System.out.println(c.getCategory());
	}
}
