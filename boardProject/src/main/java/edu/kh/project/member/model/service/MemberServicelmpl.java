package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // ����Ͻ� ����(������ ����, DAO ȣ��, Ʈ����� ����)ó���ϴ� Ŭ���� ����
		// + Bean���� ����ϴ� ������̼�
public class MemberServicelmpl implements MemberService{

	// @Autowired : �ۼ��� �ʵ��
	// Bean���� ��ϵ� ��ü �� Ÿ���� ��ġ�ϴ� Bean�� 
	// �ش� �ʵ忡 �ڵ� ����(Injection) �ϴ� ������̼�.
	// ** DI(Dependency Injection, ������ ����)
	// -> ��ü�� ���� ������ �ʰ�, Spring�� ����� ������(Spring�� ����)
	
	
	@Autowired
	private MemberDAO dao;


	//dao �޼��� ȣ�� 
	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = dao.login(inputMember);
		
		
		return loginMember;
	}
	

	
}