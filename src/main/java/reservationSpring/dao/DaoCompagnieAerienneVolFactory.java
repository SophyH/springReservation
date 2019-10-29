package reservationSpring.dao;

public class DaoCompagnieAerienneVolFactory {

	private static DaoCompagnieAerienneVol daoCompagnieAerienneVol = null;

	public static DaoCompagnieAerienneVol getInstance() {
		if (daoCompagnieAerienneVol == null) {
			daoCompagnieAerienneVol = new DaoCompagnieAerienneVolJpaImpl();
		}
		return daoCompagnieAerienneVol;
	}

}
