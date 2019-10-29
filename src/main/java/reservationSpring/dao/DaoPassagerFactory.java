package reservationSpring.dao;

public class DaoPassagerFactory {

	private static DaoPassager daoPassager = null;

	public static DaoPassager getInstance() {
		if (daoPassager == null) {
			daoPassager = new DaoPassagerJpaImpl();
		}
		return daoPassager;
	}

}
