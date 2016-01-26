package query.model.ValueReAssociate;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import database.connection.DBConnection;
import query.model.AbstractModelObject;
import query.model.ValueReAssociate.ValueReAssociate01Query;
/**
 * @version 1.0
 * @author swei
 * �^�y���p�d��PoReAssociate_model
 * 
 */
public class ValueReAssociate01Query extends AbstractModelObject {
	public final static int PoReQ01 = 1;   // �s�����d��[�D�e������]
	public final static int PoReQ02 = 2;   // �«����d��

	
	public List<HashMap<String, String>> getResultList(String New_policy, String Old_policy,String Anniv_date,int type) 
    {	
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;
		
		if (type == ValueReAssociate01Query.PoReQ01) //-----------------------<�D�d��> 171500041601  -- 3750335
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc161i('" + New_policy + "','" + Old_policy + "','" + Anniv_date + "')"));
	    }
		DBConnection.closeStatement(st);		
		return list;
    }
	
	public List<HashMap<String, String>> getResultList2(String policy_no , int type) //�s��O���X�¥�
    {	
		Statement st = DBConnection.createStatement();
		List<HashMap<String, String>> list = null;


		if (type == ValueReAssociate01Query.PoReQ02) //-----------------------<�D�d��> 171500041601  -- 3750335
		{
			list = DBConnection.getResultList(DBConnection.executeQuery(st,"execute procedure cc161i('" + policy_no + "','','')"));
	    }
		DBConnection.closeStatement(st);		
		return list;
    }

}
