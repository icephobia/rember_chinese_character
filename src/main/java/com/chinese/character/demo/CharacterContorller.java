package com.chinese.character.demo;

import com.chinese.character.demo.characters.Characters;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping(value="character")
public class CharacterContorller {
  private static Random random = new Random();

  @GetMapping("/get")
  public String applyDocumentDownload(ServletRequest request, HashMap<String, Object> model) throws PinyinException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    int i ;

    boolean flag = true;

    for(int j = 0; j< Characters.getLength(); j++){
      if(StringUtils.isEmpty(session.getAttribute(j+""))){
        flag = false;
        break;
      }
    }

    if(flag){
      for(int j=0;j<Characters.getLength();j++){
        session.setAttribute(j+"","");
      }
      model.put("message", "学习完成！");
      return "welcome";
    }

    while(true){
      i = random.nextInt(Characters.getLength());
      if(StringUtils.isEmpty(session.getAttribute(i+""))){
        session.setAttribute(i+"","a");
        break;
      }
    }
    model.put("message", Characters.getCharacter(i));

    model.put("pinyin", PinyinHelper.convertToPinyinString(Characters.getCharacter(i),"", PinyinFormat.WITH_TONE_MARK));

    return "welcome";
  }
}
