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
		//[MySQL�N���X�̃C���X�^���X����]
		MySQL last_kadai =new MySQL();
		//[�e�[�u��������������Ă���]
		rs = last_kadai.selectAll();
		
		try {
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				weight= rs.getInt("weight");
				lenth=rs.getInt("lenth");
				System.out.println("�w�Дԍ��F" + id);
				System.out.println("���O�F" + name);
				System.out.println("�̏d�F" + weight);
				System.out.println("�g��" + lenth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //try catch�ň͂�




	}

}


