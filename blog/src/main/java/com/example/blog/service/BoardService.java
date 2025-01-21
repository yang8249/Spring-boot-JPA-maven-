package com.example.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.model.Board;
import com.example.blog.model.RoleType;
import com.example.blog.model.Users;
import com.example.blog.repository.BoardRepository;
import com.example.blog.repository.UserRepository;


/*
 * 트랜잭션 관리 때문에 서비스 단위를 사용한다.
 * 여러개 서비스(DML)를 동시에 처리할때 순차적으로 처리하기위해 트랜잭션관리가 필요하다.
*/
//service 어노테이션을 붙이면 컴포넌트 스캔을 통해 Bean에 등록을 해준다.
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	//이 트랜잭션 어노테이션으로 해당 서비스를 하나의 트랜잭션 단위로 묶었다.
	@Transactional
	public void saveContent(Board board, Users user) {
		try {
			board.setUser(user);
			boardRepository.save(board);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BoardService : 글쓰기() : "+e.getMessage());
		}
	}

	
	public Page<Board> selectAllBoard(Pageable pageable) {	
		return boardRepository.findAll(pageable);
	}

	
	
}
