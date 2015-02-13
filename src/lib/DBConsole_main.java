package lib;

import java.sql.ResultSet;
import java.sql.SQLException;

import lib.MySQL;

public class DBConsole_main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id, weight,lenth;
		String name;
		ResultSet rs;
		//[MySQLクラスのインスタンス生成]
		MySQL last_kadai =new MySQL();
		//[テーブルから情報を持ってくる]
		rs = last_kadai.selectAll();
		
		try {
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				weight= rs.getInt("weight");
				lenth=rs.getInt("lenth");
				System.out.println("学籍番号：" + id);
				System.out.println("名前：" + name);
				System.out.println("体重：" + weight);
				System.out.println("身長" + lenth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //try catchで囲む




	}

}


