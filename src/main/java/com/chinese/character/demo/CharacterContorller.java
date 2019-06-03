package com.chinese.character.demo;

import com.chinese.character.demo.characters.Characters;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping(value="/character", produces="application/json; charset=UTF-8")
public class CharacterContorller {
  private static Random random = new Random();

  @GetMapping("/get")
  public String applyDocumentDownload(ServletRequest request){
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    int i ;

    boolean flag = true;

    for(int j=0;j<Characters.getLength();j++){
      if(StringUtils.isEmpty(session.getAttribute(j+""))){
        flag = false;
        break;
      }
    }

    if(flag){
      for(int j=0;j<Characters.getLength();j++){
        session.setAttribute(j+"","");
      }
      return "学习完成！";
    }

    while(true){
      i = random.nextInt(Characters.getLength());
      if(StringUtils.isEmpty(session.getAttribute(i+""))){
        session.setAttribute(i+"","a");
        break;
      }
    }

    return "<!DOCTYPE html><html><body><p style=\"font-size:45px;color:green\">"+Characters.getCharacter(i)+"</p></body></html>";
  }
}
