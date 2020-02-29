package com.abc.dao;

import java.util.List;

import com.abc.model.childModel;
import com.abc.model.countryModel;
import com.abc.model.hobbieModel;
import com.abc.model.masterModel;
import com.abc.model.userModel;

public interface dao {

	boolean insert(userModel u);
	boolean update(userModel u,int id);
	boolean insert(countryModel u);
	boolean insert(childModel u);
	boolean insert(masterModel u);
	boolean delete(int id);
	boolean deleted(int id);
	boolean deletee(int id);
	List<userModel> dis();
	userModel dise(int id);
	List<userModel> diss();
	List<countryModel> disc();
	List<hobbieModel> dish();
	int getId();
	boolean insert(hobbieModel u);
	List checkk(userModel md);

	
}
