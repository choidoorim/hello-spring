package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName()); //member 클래스 안에 name변수에 값을 저장한다.

        System.out.println("member = " + member.getName()); //member 클래스 안에 name변수에 있는 값을 꺼내와 출력.

        memberService.join(member);

        return "redirect:/"; //홈 화면으로 보내는 코드.
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();  //member에 있는 값을 모두 받아와 넘긴다.
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
/*
    1. 회원 가입에 들어가면 members/new 경로에 있는 파일로 들어간다. HTTP의 Get방식을 사용했다.
    2. Mapping이 되면 createForm 메소드가 실행되면서 members/createMemberForm.html으로 이동한다.
    3. <form> 태그: 값을 입력할 수 있는 태그 name="name"으로 지정해주면 name이 서버로 넘어올 때 키 값이 된다.
    4. 등록 버튼을 누르게 되면 <form action="/members/new" method="post"> 에서 action에 있는 URL 경로로 post방식으로 넘어온다.
    5. post방식으로 넘어오게 되면 Controller에 @PostMapping 이라고 지정해준곳에 넘어오게 된다.
    * post는 Data를 넘길 때, Data를 등록할 때 사용, get은 조회할 때 주로 사용한다.
    6. 등록 버튼으로 인해 넘어오게 된 값은 MemberForm 클래스 안에 있는 private String name에 값이 저장된다.
    * html 값이 name="name"으로 지정해주었기 때문에 MemberForm클래스 안에 name 변수안에 데이터가 들어가게 되는 것이다.
    7. member 클래스 안에 name변수에 값을 저장
 */