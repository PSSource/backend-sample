package sample1.infrastructure;

import org.seedstack.business.Service;

@Service
public interface JPAUtilityInterface {
	
	  void saveUsingEM();
	  
	  void getUsingEM();
	  
	  void getUsingEMColumn();
	  void getUsingEMColumnQriteriaQuery();
	  void getUsingEMColumnQriteria();
	  void getUsingHQL();
	  void getUsingMultiSelectQriteria();
}
