package edu.kh.project.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@Controller // ��û/���� Ŭ���� + bean ���(Spring �����ϴ� ��ü)
@RequestMapping("/member") //����� �ּ� �պκ� �ۼ�, member�� �����ϴ� ��û�� �ش� ��Ʈ�ѷ����� ó��
public class MemberController {
	
	// ��ϵ� Bean �߿��� �ʵ�� Ÿ���� ��ġ�ϴ� Bean ����
	// -> MemberService�� ������ MemberServiceImpl�� Bean ����
	@Autowired
	private MemberService service;
	
	

	// �α��� : /member/login
	// �α׾ƿ� : /member/logout
	
	// /member/login
	
	// @RequestMapping : ��û �ּҿ� �´� Ŭ����/�޼��� ����
	// @RequestMapping("��û�ּ�") -> GET / POST ���� X, �ּҸ� ������ ���������� GET��û�� ���
	// @RequestMapping(value="/login", method=RequestMethod.GET/POST) -> GET / POST ����� ����

	
	
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
	
		// �Ķ���� ���� ��� 1 : HttpServletRequest�� �̿��ϴ� ���
		// -> Controller �޼��忡 �Ű������� HttpServletRequest�� �ۼ�
	
		// �Ű������� ������ ��� ������ ����
		// Spring �����ϴ� Argument Resolver(�Ű������ذ��)�� �ڵ�����
		// �������ְ� �ذ�����.
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// ***********redirect ���! *******************
		// "redirect:��û�ּ�"
		return "redirect:/";
	
}
	// @PostMapping : @RequestMapping �ڽ�����
	//				Post ��� ��û�� �����ϴ� ������̼�
	//@PostMapping("/login")
	public String login(/*@RequestParam("inputEmail")*/ String inputEmail,
						/*@RequestParam("inputPw")*/ String inputPw) {
						
		// �Ķ���� ���� ��� 2 : @RequestParam ������̼� �̿�(+�������)
		 
		// @RequestParam ������̼�
		// - request��ü�� �̿��� �Ķ���� ���� ������̼�
		// - �Ű����� ���� ������̼� �ۼ��ϸ�, �Ű������� ���� ���Ե�.
		
		// ** �Ķ������ name �Ӽ�����
		// 	�Ű��������� ������ @RequestParam ���� ����! **
		
		// @RequestParam(value="name", required="fasle", defaultValue="1")
		// [�Ӽ�]
		// value : ���� ���� input �±��� name �Ӽ���
		
		// required : �Էµ� name �Ӽ��� �Ķ���� �ʼ� ���� ����(�⺻�� true)
		// -> required = true�� �Ķ���Ͱ� �������� �ʴ´ٸ� 400 Bad Request ���� �߻�
		// -> required = true�� �Ķ���Ͱ� null�� ��쿡�� 400 Bad Request

		// defaultValue : �Ķ���� �� ��ġ�ϴ� name �Ӽ� ���� ���� ��쿡 ������ �� ����.
		// -> required = false�� ��� ���
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		
		
		return "redirect:/";
	}
	
	//@PostMapping("/login")
	public String login(@ModelAttribute Member inputMember) {
		
		// �Ķ���� ���� ��� 3 : @ModelAttribute �̿��� ���
		
		// - DTO(�Ǵ� VO)�� ���� ����ϴ� ������̼�
		
		// - ���� ���� �Ķ������ name �Ӽ� ����
		// 	 ���� ���Ǵ� DTO�� �ʵ���� ���ٸ�
		// 	 �ڵ����� setter�� ȣ���ؼ� �ʵ忡 ���� ���� 
		
		System.out.println(inputMember);

		// ** @ModelAttribute ��� �� ���� ���� **
		// - DTO�� �⺻ �����ڰ� �ʼ��� �����ؾ� �Ѵ�
		// - DTO�� setter�� �ʼ��� �����ؾ� �Ѵ�
		
		// ** @ModelAttribute ������̼��� ������ �����ϴ� ! **
		
		// ** @ModelAttribute�� �̿��� ���� �ʵ忡 ���õ� ��ü��
		// 	Ŀ��� ��ü ��� �θ���.
		
		
		// Member [memberEmail = user123, memberPw = pass123.. ]
		
		
		return "redirect:/";
		
	}
	
	
	/* �� �α��� �޼��� */
	
	@PostMapping("/login")
	public String login(Member inputMember, Model model) {
			
		//�α��� ���� ȣ��
		Member loginMember = service.login(inputMember);
		
		// DB ��ȸ ��� Ȯ��
		System.out.println(loginMember);
		
		return null;
	
	}
	
	
}