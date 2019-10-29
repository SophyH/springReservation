package reservationSpring.dao;

public class DaoVolFactory {

	private static DaoVol daoVol = null;

	public static DaoVol getInstance() {
		if (daoVol == null) {
			daoVol = new DaoVolJpaImpl();
		}
		return daoVol;
	}

}
