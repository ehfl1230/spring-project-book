package org.ggyool.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private Date reg_date; // 가입일
	private Date recent_login_date; // 최근 접속일
	private List<AuthVO> authList;
}
