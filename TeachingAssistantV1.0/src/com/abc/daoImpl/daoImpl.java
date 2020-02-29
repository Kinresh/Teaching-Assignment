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
				int y = st.executeUpdate(
						"insert into web_hobbie(hname) values('" + u.getHname() + "')");
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
			//System.out.println("welcome");
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate(
						"delete from abc where user_id = '"+id+"'");
				if (y > 0) {
					flag = true;
				} else {
					flag = false;
				}
				//System.out.println("flag is-"+flag);
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
				//System.out.println(id+"-qwert");
				int y = st.executeUpdate(
						"update abc set active_flag= '0' where user_id = '"+id+"'");
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
				int y = st.executeUpdate(
						"update abc set active_flag= '1' where user_id = '"+id+"'");
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
				int y = st.executeUpdate(
						"insert into abc(fname,number,bdate,gender,hob,cid) values('" + u.getFname() + "','" + u.getNumber() + "','"+u.getBdate()+"','" + u.getGender() + "','" + u.getHob() + "','" + u.getCid() + "')");
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
	public boolean update(userModel u,int id) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate("update abc set fname = '"+u.getFname()+"',number = '"+u.getNumber()+"',gender= '"+u.getGender()+"',hob= '"+u.getHob()+"',cid= '"+u.getCid()+"' where user_id = '"+id+"'");
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
	@Override
	public boolean insert(countryModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				st = con.createStatement();
				int y = st.executeUpdate(
						"insert into web_country(cname) values('" + u.getCname() + "')");
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
	public boolean insert(countryModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				ps = con.prepareStatement("insert into web_country(cname) values(?)");
				ps.setString(1,u.getCname());
				flag = ps.execute();
				
			} else {
				System.out.println("connection null 6!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("query ma bhul 6!!");
		}

		return flag;
	}*/
	@Override
	public boolean insert(countryModel u) {

		try {
			con = r.getConnection();
			if (con != null) {
				cs = con.prepareCall("{call country_insert(?)}");
				cs.setString(1,u.getCname());
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
				rs = st.executeQuery(
						"select MAX(mid) AS id from master");
				if (rs!=null) {
					
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
				rs = st.executeQuery(
						"select * from abc");
				if (rs!=null) {
					
					while (rs.next()) {
						m = new userModel(rs.getInt("user_id"),rs.getString("fname"),rs.getLong("number"),rs.getString("gender"),rs.getString("hob"),rs.getByte("active_flag"),rs.getInt("cid"),rs.getString("bdate"));
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
				rs = st.executeQuery(
						"select * from abc where user_id = '"+id+"'");
				if (rs!=null) {
					
					if (rs.next()) {
						m = new userModel(rs.getInt("user_id"),rs.getString("fname"),rs.getLong("number"),rs.getString("gender"),rs.getString("hob"),rs.getByte("active_flag"),rs.getInt("cid"),rs.getString("bdate"));
					  
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
				rs = st.executeQuery(
						"select user_id from abc where fname = '"+md.getFname()+"'");
				
					
					if (rs.next()) {
						rs = st.executeQuery(
								"select user_id from abc where fname = '"+md.getFname()+"' and number = '"+md.getNumber()+"'");
						
							
							if (rs.next()) {
								rs = st.executeQuery(
										"select user_id,fname from abc where fname = '"+md.getFname()+"' and number = '"+md.getNumber()+"' and active_flag = '0'");
								     if (rs.next()) {
										 m = new userModel(rs.getInt("user_id"),rs.getString("fname"));
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
				rs = st.executeQuery(
						"select * from abc where active_flag = '0'");
				if (rs!=null) {
					
					while (rs.next()) {
						m = new userModel(rs.getInt("user_id"),rs.getString("fname"),rs.getLong("number"),rs.getString("gender"),rs.getString("hob"),rs.getByte("active_flag"),rs.getInt("cid"),rs.getString("bdate"));
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
	public List<hobbieModel> dish()
	{
		List<hobbieModel> l =new ArrayList<>();
		hobbieModel h = null;
		try {
			con=r.getConnection();
			if(con!=null)
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from web_hobbie");
				if(rs!=null)
				{
					while(rs.next())
					{
						h= new hobbieModel(rs.getInt("hid"),rs.getString("hname"));
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
				rs = st.executeQuery(
						"select * from web_country");
				if (rs!=null) {
					
					while (rs.next()) {
						m = new countryModel(rs.getInt("cid"),rs.getString("cname"));
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
				int y = st.executeUpdate(
						"insert into master(fname,number,gender) values('" + u.getFname() + "','" + u.getNumber() + "','" + u.getGender() + "')");
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
				int y = st.executeUpdate(
						"insert into child(mid,hob) values('" + u.getMid()+ "','" + u.getHob() + "')");
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
}
