package com.abc.daoImpl;

import java.sql.CallableStatement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abc.dao.dao;
import com.abc.model.FacultySelectionDisplayModel;
import com.abc.model.FacultySelectionModel;
import com.abc.model.PriorityModel;
import com.abc.model.ProgramModel;
import com.abc.model.ProgramTimelineModel;
import com.abc.model.ScheduleModel;
import com.abc.model.SubjectModel;
import com.abc.model.SubjectTermModel;
import com.abc.model.TermModel;
import com.abc.model.UserDetailsModel;
import com.abc.model.childModel;
import com.abc.model.countryModel;
import com.abc.model.hobbieModel;
import com.abc.model.masterModel;
import com.abc.model.userModel;
import com.abc.util.util;

public class daoImpl implements dao {

	private boolean flag = false;
	private Connection con = null;
	util r = new util();
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private CallableStatement cs = null;

	@Override
	public boolean insert(hobbieModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("insert into web_hobbie(hname) values('" + u.getHname() + "')");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public boolean delete(int id) {

		try {
			// System.out.println("welcome");
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("delete from abc where user_id = '" + id + "'");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
				// System.out.println("flag is-"+flag);
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;

	}

	@Override
	public boolean deleted(int id) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				// System.out.println(id+"-qwert");
				int y = st.executeUpdate("update abc set active_flag= '0' where user_id = '" + id + "'");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public boolean deletee(int id) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("update abc set active_flag= '1' where user_id = '" + id + "'");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public boolean insert(userModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("insert into abc(fname,number,bdate,gender,hob,cid) values('" + u.getFname()
						+ "','" + u.getNumber() + "','" + u.getBdate() + "','" + u.getGender() + "','" + u.getHob()
						+ "','" + u.getCid() + "')");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public boolean update(userModel u, int id) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("update abc set fname = '" + u.getFname() + "',number = '" + u.getNumber()
						+ "',gender= '" + u.getGender() + "',hob= '" + u.getHob() + "',cid= '" + u.getCid()
						+ "' where user_id = '" + id + "'");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	/*
	 * @Override public boolean insert(countryModel u) {
	 * 
	 * try { con = r.getConnection(); if (con != null) { st =
	 * con.createStatement(); int y = st.executeUpdate(
	 * "insert into web_country(cname) values('" + u.getCname() + "')"); if (y >
	 * 0) { flag = true; } else { flag = false; } } else {
	 * System.out.println("connection null 6!!"); } } catch (SQLException e) {
	 * System.out.println(e); System.out.println("query ma bhul 6!!"); }
	 * 
	 * return flag; }
	 * 
	 * 
	 * @Override public boolean insert(countryModel u) {
	 * 
	 * try { con = r.getConnection(); if (con != null) { ps =
	 * con.prepareStatement("insert into web_country(cname) values(?)");
	 * ps.setString(1,u.getCname()); flag = ps.execute();
	 * 
	 * } else { System.out.println("connection null 6!!"); } } catch
	 * (SQLException e) { System.out.println(e);
	 * System.out.println("query ma bhul 6!!"); }
	 * 
	 * return flag; }
	 */
	@Override
	public boolean insert(countryModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				cs = con.prepareCall("{call country_insert(?)}");
				cs.setString(1, u.getCname());
				flag = cs.execute();

			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public int getId() {
		int id = 0;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select MAX(mid) AS id from master");
				if (rs != null) {

					if (rs.next()) {

						id = rs.getInt("id");

					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return id;
	}

	@Override
	public List<userModel> dis() {
		List<userModel> l = new ArrayList<>();
		userModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from abc");
				if (rs != null) {

					while (rs.next()) {
						m = new userModel(rs.getInt("user_id"), rs.getString("fname"), rs.getLong("number"),
								rs.getString("gender"), rs.getString("hob"), rs.getByte("active_flag"),
								rs.getInt("cid"), rs.getString("bdate"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public userModel dise(int id) {

		userModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from abc where user_id = '" + id + "'");
				if (rs != null) {

					if (rs.next()) {
						m = new userModel(rs.getInt("user_id"), rs.getString("fname"), rs.getLong("number"),
								rs.getString("gender"), rs.getString("hob"), rs.getByte("active_flag"),
								rs.getInt("cid"), rs.getString("bdate"));

					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return m;
	}

	@Override
	public List checkk(userModel md) {
		userModel m = null;
		List gv = new ArrayList();
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select user_id from abc where fname = '" + md.getFname() + "'");

				if (rs.next()) {
					rs = st.executeQuery("select user_id from abc where fname = '" + md.getFname() + "' and number = '"
							+ md.getNumber() + "'");

					if (rs.next()) {
						rs = st.executeQuery("select user_id,fname from abc where fname = '" + md.getFname()
								+ "' and number = '" + md.getNumber() + "' and active_flag = '0'");
						if (rs.next()) {
							m = new userModel(rs.getInt("user_id"), rs.getString("fname"));
							gv.add("sa");
							gv.add(m);

						}

						else {
							gv.add("wa");
						}
					}

					else {
						gv.add("wp");
					}
				}

				else {
					gv.add("wu");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return gv;
	}

	@Override
	public List<userModel> diss() {
		List<userModel> l = new ArrayList<>();
		userModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from abc where active_flag = '0'");
				if (rs != null) {

					while (rs.next()) {
						m = new userModel(rs.getInt("user_id"), rs.getString("fname"), rs.getLong("number"),
								rs.getString("gender"), rs.getString("hob"), rs.getByte("active_flag"),
								rs.getInt("cid"), rs.getString("bdate"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public List<hobbieModel> dish() {
		List<hobbieModel> l = new ArrayList<>();
		hobbieModel h = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from web_hobbie");
				if (rs != null) {
					while (rs.next()) {
						h = new hobbieModel(rs.getInt("hid"), rs.getString("hname"));
						l.add(h);
					}
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return l;
	}

	@Override
	public List<countryModel> disc() {
		List<countryModel> l = new ArrayList<>();
		countryModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from web_country");
				if (rs != null) {

					while (rs.next()) {
						m = new countryModel(rs.getInt("cid"), rs.getString("cname"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public boolean insert(masterModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("insert into master(fname,number,gender) values('" + u.getFname() + "','"
						+ u.getNumber() + "','" + u.getGender() + "')");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public boolean insert(childModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st
						.executeUpdate("insert into child(mid,hob) values('" + u.getMid() + "','" + u.getHob() + "')");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}

	@Override
	public boolean insert(UserDetailsModel u) {
		return customExecuteUpdate(
				"INSERT INTO users (userName,userEmail,userPassword,userContact,userCountry,createdDate,createdBy,gender) VALUES "
						+ "('" + u.getUserName() + "','" + u.getUserEmail() + "','" + u.getUserPassword() + "','"
						+ u.getUserContact() + "','" + u.getUserCountry() + "','" + u.getCreatedDate() + "','"
						+ u.getCreatedBy() + "','" + u.getGender() + "');");
	}

	@Override
	public List VerifyUser(UserDetailsModel u) {

		UserDetailsModel userDetails = null;
		List dataList = new ArrayList();
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from users where (userName = '" + u.getUserName() + "' COLLATE utf8mb4_0900_as_cs OR userEmail = '"
						+ u.getUserName() + "' COLLATE utf8mb4_0900_as_cs) AND userPassword = '" + u.getUserPassword() + "' COLLATE utf8mb4_0900_as_cs");

				if (rs.next()) {
					if (rs.getInt("active") == 1) {
						userDetails = new UserDetailsModel(rs.getInt("userID"), rs.getString("userName"),
								rs.getString("UserEmail"), rs.getString("userRole"));
						dataList.add("success");
						dataList.add(userDetails);
					} else {
						dataList.add("unauthorized");
					}
				} else {
					dataList.add("nouserfound");
				}

			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return dataList;
	}

	@Override
	public List<UserDetailsModel> getAllUsers() {
		List<UserDetailsModel> allUsers = new ArrayList<>();
		UserDetailsModel user = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from users");
				if (rs != null) {
					while (rs.next()) {
						user = new UserDetailsModel(rs.getInt("userID"), rs.getString("userName"),
								rs.getString("userEmail"), rs.getString("userPassword"), rs.getDate("userDob"),
								rs.getString("userContact"), rs.getString("userRole"), (byte) rs.getInt("active"),
								rs.getString("userCountry"), rs.getString("userAddress"), rs.getDate("lastUpdated"),
								rs.getString("updatedBy"), rs.getDate("createdDate"), rs.getString("createdBy"),
								rs.getString("userDepartment"), rs.getString("gender"));
						allUsers.add(user);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return allUsers;
	}

	private boolean customExecuteUpdate(String query) {
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate(query);
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}
		return flag;
	}

	@Override
	public boolean deleteAccount(int userid) {
		return customExecuteUpdate("delete from users where userID = '" + userid + "'");
	}

	@Override
	public boolean enableAccount(int userid) {
		return customExecuteUpdate("update users set active= '1' where userID = '" + userid + "'");
	}

	@Override
	public boolean disableAccount(int userid) {
		return customExecuteUpdate("update users set active= '0' where userID= '" + userid + "'");
	}

	@Override
	public UserDetailsModel getUser(int userid) {

		UserDetailsModel user = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from users where userID = '" + userid + "'");

				if (rs.next()) {
					user = new UserDetailsModel(rs.getInt("userID"), rs.getString("userName"),
							rs.getString("userEmail"), rs.getString("userPassword"), rs.getDate("userDob"),
							rs.getString("userContact"), rs.getString("userRole"), (byte) rs.getInt("active"),
							rs.getString("userCountry"), rs.getString("userAddress"), rs.getDate("lastUpdated"),
							rs.getString("updatedBy"), rs.getDate("createdDate"), rs.getString("createdBy"),
							rs.getString("userDepartment"), rs.getString("gender"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return user;
	}

	@Override
	public boolean updateUser(UserDetailsModel u) {
		return customExecuteUpdate("update users set userName = '" + u.getUserName() + "',userEmail = '"
				+ u.getUserEmail() + "',userContact= '" + u.getUserContact() + "',userRole= '" + u.getUserRole()
				+ "',updatedBy= '" + u.getUpdatedBy() + "',lastUpdated= '" + u.getLastUpdated() + "' where userID = '"
				+ u.getUserID() + "'");
	}

	@Override
	public boolean inserNewSubject(SubjectModel s) {
		return customExecuteUpdate(
				"INSERT INTO subjects (subjectCode,subjectName,subjectDescription,maxInstructor,createdBy,createdDate)"
						+ "VALUES ('" + s.getSubjectCode() + "','" + s.getSubjectName() + "','"
						+ s.getSubjectDescription() + "','" + s.getMaxInstructor() + "','" + s.getCreatedBy() + "','"
						+ s.getCreatedDate() + "')");
	}

	@Override
	public List<SubjectModel> getAllSubjects() {
		List<SubjectModel> l = new ArrayList<>();
		SubjectModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from subjects");
				if (rs != null) {
					while (rs.next()) {
						m = new SubjectModel(rs.getInt("subjectID"), rs.getString("subjectCode"),
								rs.getString("subjectName"), rs.getString("subjectDescription"),
								rs.getInt("maxInstructor"), rs.getString("createdBy"), rs.getDate("createdDate"),
								rs.getString("updatedBy"), rs.getDate("updatedDate"), rs.getInt("active_flag"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public SubjectModel getSubject(int id) {
		SubjectModel subject = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from subjects where subjectID = '" + id + "'");

				if (rs.next()) {
					subject = new SubjectModel(rs.getInt("subjectID"), rs.getString("subjectCode"),
							rs.getString("subjectName"), rs.getString("subjectDescription"), rs.getInt("maxInstructor"),
							rs.getString("createdBy"), rs.getDate("createdDate"), rs.getString("updatedBy"),
							rs.getDate("updatedDate"), rs.getInt("active_flag"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return subject;
	}

	@Override
	public boolean updateSubject(SubjectModel s) {
		return customExecuteUpdate("update subjects set subjectCode='" + s.getSubjectCode() + "',subjectName='"
				+ s.getSubjectName() + "',subjectDescription='" + s.getSubjectDescription() + "',maxInstructor='"
				+ s.getMaxInstructor() + "',updatedBy='" + s.getUpdatedBy() + "',updatedDate='" + s.getUpdatedDate()
				+ "' where subjectID = '" + s.getSubjectID() + "'");
	}

	@Override
	public boolean deleteSubject(int id) {
		return customExecuteUpdate("delete from subjects where subjectID = '" + id + "'");
	}

	@Override
	public boolean enableSubject(int id) {
		return customExecuteUpdate("update subjects set active_flag= '1' where subjectID = '" + id + "'");
	}

	@Override
	public boolean disableSubject(int id) {
		return customExecuteUpdate("update subjects set active_flag= '0' where subjectID = '" + id + "'");
	}

	// program CRUD

	@Override
	public boolean inserNewProgram(ProgramModel s) {
		return customExecuteUpdate(
				"INSERT INTO programs (programName,totalTerms,winter,summer,fall,createdBy,createdDate)" + "VALUES ('"
						+ s.getProgramName() + "','" + s.getTotalTerms() + "','" + s.getWinter() + "','" + s.getSummer()
						+ "','" + s.getFall() + "','" + s.getCreatedBy() + "','" + s.getCreatedDate() + "')");
	}

	@Override
	public List<ProgramModel> getAllPrograms() {
		List<ProgramModel> l = new ArrayList<>();
		ProgramModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from programs");
				if (rs != null) {
					while (rs.next()) {
						m = new ProgramModel(rs.getInt("programID"), rs.getString("programName"),
								rs.getInt("totalTerms"), rs.getInt("winter"), rs.getInt("summer"), rs.getInt("fall"),
								rs.getString("createdBy"), rs.getDate("createdDate"), rs.getString("updatedBy"),
								rs.getDate("updatedDate"), rs.getInt("active_flag"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;

	}

	@Override
	public ProgramModel getProgram(int id) {

		ProgramModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from programs where programID = '" + id + "'");
				if (rs != null) {
					if (rs.next()) {
						m = new ProgramModel(rs.getInt("programID"), rs.getString("programName"),
								rs.getInt("totalTerms"), rs.getInt("winter"), rs.getInt("summer"), rs.getInt("fall"),
								rs.getString("createdBy"), rs.getDate("createdDate"), rs.getString("updatedBy"),
								rs.getDate("updatedDate"), rs.getInt("active_flag"));
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return m;
	}

	@Override
	public boolean updateProgram(ProgramModel s) {
		return customExecuteUpdate("update programs set programName='" + s.getProgramName() + "',totalTerms='"
				+ s.getTotalTerms() + "',winter='" + s.getWinter() + "',summer='" + s.getSummer() + "',fall='"
				+ s.getFall() + "',updatedBy='" + s.getUpdatedBy() + "',updatedDate='" + s.getUpdatedDate()
				+ "' where programID = '" + s.getProgramID() + "'");
	}

	@Override
	public boolean deleteProgram(int id) {
		return customExecuteUpdate("delete from programs where programID = '" + id + "'");
	}

	@Override
	public boolean enableProgram(int id) {
		return customExecuteUpdate("update programs set active_flag= '1' where programID = '" + id + "'");
	}

	@Override
	public boolean disableProgram(int id) {
		return customExecuteUpdate("update programs set active_flag= '0' where programID = '" + id + "'");
	}

	@Override
	public List<ProgramTimelineModel> getAllProgramTimelines() {
		List<ProgramTimelineModel> l = new ArrayList<>();
		ProgramTimelineModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from program_timeline");
				if (rs != null) {
					while (rs.next()) {
						m = new ProgramTimelineModel(rs.getInt("ptID"), rs.getInt("programID"),
								rs.getString("startingTerm"), rs.getString("startingYear"), rs.getInt("active_flag"),
								rs.getString("createdBy"), rs.getDate("createdDate"), rs.getString("updatedBy"),
								rs.getDate("updatedDate"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;

	}

	@Override
	public boolean inserNewProgramTimeline(ProgramTimelineModel s) {
		return customExecuteUpdate(
				"INSERT INTO program_timeline (programID,startingTerm,startingYear,createdBy,createdDate)" + "VALUES ('"
						+ s.getProgramID() + "','" + s.getStartingTerm() + "','" + s.getStartingYear() + "','"
						+ s.getCreatedBy() + "','" + s.getCreatedDate() + "')");
	}

	@Override
	public ProgramTimelineModel getProgramTimeline(int id) {
		ProgramTimelineModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from program_timeline where ptID = '" + id + "'");
				if (rs != null) {
					if (rs.next()) {
						m = new ProgramTimelineModel(rs.getInt("ptID"), rs.getInt("programID"),
								rs.getString("startingTerm"), rs.getString("startingYear"), rs.getInt("active_flag"),
								rs.getString("createdBy"), rs.getDate("createdDate"), rs.getString("updatedBy"),
								rs.getDate("updatedDate"));
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return m;

	}

	@Override
	public boolean updateProgramTimeline(ProgramTimelineModel s) {
		return customExecuteUpdate("update program_timeline set programID='" + s.getProgramID() + "',startingTerm='"
				+ s.getStartingTerm() + "',startingYear='" + s.getStartingYear() + "',updatedBy='" + s.getUpdatedBy()
				+ "',updatedDate='" + s.getUpdatedDate() + "' where ptID = '" + s.getPtID() + "'");
	}

	public boolean deleteProgramTimeline(int id) {
		return customExecuteUpdate("delete from program_timeline where ptID = '" + id + "'");
	}

	@Override
	public boolean enableProgramTimeline(int id) {
		return customExecuteUpdate("update program_timeline set active_flag= '1' where ptID = '" + id + "'");
	}

	@Override
	public boolean disableProgramTimeline(int id) {
		return customExecuteUpdate("update program_timeline set active_flag= '0' where ptID = '" + id + "'");
	}

	@Override
	public boolean addSchedule(ScheduleModel s) {
		return customExecuteUpdate("insert into schedule_year(name, year) Values ('"+s.getName()+"','"+s.getYear()+"')");
	}

	@Override
	public List<ScheduleModel> getAllSchedules() {
		List<ScheduleModel> l = new ArrayList<>();
		ScheduleModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from schedule_year");
				if (rs != null) {
					while (rs.next()) {
						m = new ScheduleModel(rs.getInt("syID"), rs.getString("name"),
								rs.getString("year"), rs.getInt("active_flag"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;

	}

	@Override
	public List<TermModel> getAllTerms() {
		List<TermModel> l = new ArrayList<>();
		TermModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from web_terms where active_flag = '1'");
				if (rs != null) {
					while (rs.next()) {
						m = new TermModel(rs.getInt("web_termID"), rs.getString("name"),rs.getInt("active_flag"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public boolean addSubjectTerm(SubjectTermModel s) {
		return customExecuteUpdate("insert into subject_term(subjectID,web_termsID,syID,notes) Values ('"+s.getSubjectID()+"','"+s.getWeb_termsID()+"','"+s.getSyID()+"','"+s.getNotes()+"')");
	}

	@Override
	public List<SubjectTermModel> getSubjectTerms_scheduleID(int scheduleID) {
		List<SubjectTermModel> l = new ArrayList<>();
		SubjectTermModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from subject_term where syID = '"+scheduleID+"'");
				if (rs != null) {
					while (rs.next()) {
						m = new SubjectTermModel(
								rs.getInt("stID"),
								rs.getInt("subjectID"),
								rs.getInt("web_termsID"),
								rs.getInt("syID"),
								rs.getString("notes"),
								rs.getInt("active_flag"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
		
	}

	@Override
	public List<PriorityModel> getAllPriorities() {
		List<PriorityModel> l = new ArrayList<>();
		PriorityModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from web_priorities where active_flag='1'");
				if (rs != null) {
					while (rs.next()) {
						m = new PriorityModel(
								rs.getInt("priorityID"),
								rs.getString("description"),
								rs.getInt("active_flag"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public boolean addNewFacultySelection(FacultySelectionModel s) {
		return customExecuteUpdate("insert into faculty_selection(userID,syID,stID,priorityID) Values('"+s.getUserID()+"','"+s.getSyID()+"','"+s.getStID()+"','"+s.getPriorityID()+"')");
	}

	@Override
	public List<UserDetailsModel> getAllFaculties() {
		List<UserDetailsModel> allUsers = new ArrayList<>();
		UserDetailsModel user = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select * from users where userRole='faculty'");
				if (rs != null) {
					while (rs.next()) {
						user = new UserDetailsModel(rs.getInt("userID"), rs.getString("userName"),
								rs.getString("userEmail"), rs.getString("userPassword"), rs.getDate("userDob"),
								rs.getString("userContact"), rs.getString("userRole"), (byte) rs.getInt("active"),
								rs.getString("userCountry"), rs.getString("userAddress"), rs.getDate("lastUpdated"),
								rs.getString("updatedBy"), rs.getDate("createdDate"), rs.getString("createdBy"),
								rs.getString("userDepartment"), rs.getString("gender"));
						allUsers.add(user);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return allUsers;

	}

	@Override
	public List<FacultySelectionDisplayModel> getAllFacultySelection_scheduleID(int scheduleID) {
		List<FacultySelectionDisplayModel> l = new ArrayList<>();
		FacultySelectionDisplayModel m = null;
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select a.stID,a.userID,e.userName, b.subjectID, c.subjectName, c.subjectCode,b.web_termsID, d.priorityID, d.description "
						+ "from demo.faculty_selection as a "
						+ "left join demo.subject_term as b on b.stID = a.stID "
						+ "left join demo.subjects as c on c.subjectID = b.subjectID "
						+ "left join demo.web_priorities as d on d.priorityID=a.priorityID "
						+ "left join demo.users as e on e.userID = a.userID "
						+ "where a.syID='"+scheduleID+"' order by c.subjectCode");
				if (rs != null) {
					while (rs.next()) {
						m = new FacultySelectionDisplayModel(
								rs.getInt("stID"),
								rs.getInt("userID"),
								rs.getString("userName"),
								rs.getInt("subjectID"),
								rs.getString("subjectName"),
								rs.getString("subjectCode"),
								rs.getInt("web_termsID"),
								rs.getInt("priorityID"),
								rs.getString("description"));
						l.add(m);
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return l;
	}

	@Override
	public boolean deleteFacultySelection(int userID) {
		return customExecuteUpdate("delete from demo.faculty_selection where userID ='"+userID+"';");
	}

	@Override
	public void emptySchedule(int userID) {
		customExecuteUpdate("delete from demo.subject_term where syID ='"+userID+"';");
	}

	@Override
	public String getScheduleName(int scheduleID) {
		String scheduleName= "";
		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select name from schedule_year where syID='"+scheduleID+"'");
				if (rs != null) {
					while (rs.next()) {
						scheduleName = rs.getString("name");
					}

				} else {
					System.out.println("khali 6 pakit");
				}
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}
		return scheduleName;
	}

	


}
