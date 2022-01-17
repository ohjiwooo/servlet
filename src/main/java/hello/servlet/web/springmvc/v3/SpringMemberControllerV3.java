package hello.servlet.web.springmvc.v3;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepo memberRepo = MemberRepo.getInstance();

    @RequestMapping(value = "/new-form",method = RequestMethod.GET)
    public String newForm(){
        return "new-form";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestParam("username")String username,
                        @RequestParam("age")int age,
                       Model model
    ){ //파라미터를 직접 받아옴

        Member member = new Member(username, age);
        memberRepo.save(member);

        model.addAttribute(member);
        return "save-result";
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String members(Model model){

        List<Member> members = memberRepo.findAll();
        model.addAttribute("members",members);

        return "members";
    }

}
