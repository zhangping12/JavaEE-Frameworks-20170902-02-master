package controller;

import model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.MyBatisSession;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

    @RequestMapping("signUp")
    private String signUp(User user) {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(true)) {
            sqlSession.insert("user.signUp", user);
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("signIn")
    private String signIn(User user) {
        try (SqlSession sqlSession = MyBatisSession.getSqlSession(false)) {
            user = sqlSession.selectOne("user.signIn", user);
        }
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/book/queryAll";
        } else {
            request.setAttribute("message", "Invalid username or password.");
            return "/index.jsp";
        }
    }

    @RequestMapping("signOut")
    private String signOut(){
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
