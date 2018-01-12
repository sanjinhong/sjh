package com.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.beans.Depart;

public interface IDepartDAO {

	List<Depart> select();

	Map<String,String> select2();
	
}
