package com.abc.dao;

import java.util.List;

import com.abc.model.ProgramModel;
import com.abc.model.SubjectModel;
import com.abc.model.UserDetailsModel;
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
	boolean insert(UserDetailsModel u);
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
	List VerifyUser(UserDetailsModel u);
	List<UserDetailsModel> getAllUsers();
	boolean disableAccount(int userid);
	boolean enableAccount(int userid);
	boolean deleteAccount(int userid);
	UserDetailsModel getUser(int userid);
	boolean updateUser(UserDetailsModel userDetails);
	boolean inserNewSubject(SubjectModel subject);
	List<SubjectModel> getAllSubjects();
	boolean deleteSubject(int id);
	boolean enableSubject(int id);
	boolean disableSubject(int id);
	SubjectModel getSubject(int id);
	boolean updateSubject(SubjectModel subject);
	List<ProgramModel> getAllPrograms();
	ProgramModel getProgram(int id);
	boolean inserNewProgram(ProgramModel program);
	boolean updateProgram(ProgramModel program);
	boolean deleteProgram(int id);
	boolean enableProgram(int id);
	boolean disableProgram(int id);

	
}
