package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.model.RoleType;
import com.example.blog.model.Users;
import com.example.blog.repository.UserRepository;


/*
 * 트랜잭션 관리 때문에 서비스 단위를 사용한다.
 * 여러개 서비스(DML)를 동시에 처리할때 순차적으로 처리하기위해 트랜잭션관리가 필요하다.
*/
//service 어노테이션을 붙이면 컴포넌트 스캔을 통해 Bean에 등록을 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//이 트랜잭션 어노테이션으로 해당 서비스를 하나의 트랜잭션 단위로 묶었다.
	@Transactional
	public int join(Users user) {
		try {
			user.setRole(RoleType.USER);
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() : "+e.getMessage());
			return -1;
		}
	}

	
	
//	//아래 메서드는 select라 트랜잭션에 설정을 한다.
//	//readonly옵션은 : select 시 트랜잭션 시작, 서비스 종료시 트랜잭션 종료한다.
//	@Transactional(readOnly = true)
//	public Users login(Users user) {
//		return userRepository.findUsersNameAndPassword(user.getUsername(), user.getPassword());
//	}
}
