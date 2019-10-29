package reservationSpring.dao;

public class DaoCompagnieAerienneFactory {

	private static DaoCompagnieAerienne daoCompagnieAerienne = null;

	public static DaoCompagnieAerienne getInstance() {
		if (daoCompagnieAerienne == null) {
			daoCompagnieAerienne = new DaoCompagnieAerienneJpaImpl();
		}
		return daoCompagnieAerienne;

	}
}
