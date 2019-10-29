package reservationSpring.dao;

public class DaoLoginFactory {
	private static DaoLogin daoLogin = null;
	
	
	public static DaoLogin getInstance() {
		if (daoLogin ==null) {
			daoLogin = new DaoLoginJpaImpl();
		}
		return daoLogin;
	}
}
