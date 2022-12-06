package com.fcshop.study.controller;

import com.fcshop.study.entity.member.Member;
import com.fcshop.study.entity.member.SessionConstants;
import com.fcshop.study.entity.product.Product;
import com.fcshop.study.service.MemberService;
import com.fcshop.study.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    private final ProductService productService;

    /*
    public MemberController(MemberRepository member){
        this.member = member;
    }
*/
    @GetMapping("/login")
    public String viewLoginPage(){
        System.out.println("로그인 진입");
        return "login";
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        System.out.println("로그아웃");
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

        return "redirect:/";
    }
    @PostMapping("/loginMember")
    public String login(Model model, String id, String password, @RequestParam(defaultValue = "/")String reUrl, HttpServletRequest request){
        System.out.println("로그인 시도: " + id + "/" + password);

        Member loginMember = memberService.findByMember(id,password);
        List<Product> products = productService.findAll();


        System.out.println("member "+ loginMember);

        // 로그인 성공 시
        if (loginMember != null) {
            System.out.println("로그인 성공");

            HttpSession session = request.getSession();
            session.setAttribute(SessionConstants.Login_member, loginMember);
            System.out.println("sessionMember "+ session.getAttribute(SessionConstants.Login_member));
            model.addAttribute("memberName", loginMember.getName());
            model.addAttribute("products",products);
            return "loginAfter";
        } else {
            System.out.println("로그인 실패");
            return "login";
        }
    }


    @GetMapping("/join")
    public String viewJoinPage(){
        System.out.println("회원가입 진입");
        return "joinPage";
    }

    @GetMapping("/loginAfter")
    public String viewLoginAfterPage(){
        System.out.println("회원가입 진입");
        return "loginAfter";
    }



    @PostMapping("/insertMember")
    public String insertUs(Member member) throws Exception{

        System.out.println("입력 값: " + member);
        memberService.save(member);

        return "redirect: ";
    }





}
