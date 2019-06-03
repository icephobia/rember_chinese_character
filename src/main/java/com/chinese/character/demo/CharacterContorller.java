package com.chinese.character.demo;

import com.chinese.character.demo.characters.Characters;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping(value="/character", produces="application/json; charset=UTF-8")
public class CharacterContorller {
  private static Random random = new Random();

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public String applyDocumentDownload(ServletRequest request){
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    int i = 0;

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

    return "<p style=\"font-size:45px;color:green\">"+Characters.getCharacter(i)+"</p>";
  }
}
