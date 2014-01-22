package fr.iut2.sil4.data;

import java.util.List;
import org.apache.torque.criteria.Criteria;

public class EtudiantPeer
    extends fr.iut2.sil4.data.BaseEtudiantPeer
{
	public static List<Etudiant> doSelectAll() throws Exception {
		Criteria crit = new Criteria();
		return doSelect(crit);
	}
}
