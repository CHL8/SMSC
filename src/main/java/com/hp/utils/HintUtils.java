package com.hp.utils;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class HintUtils {
    public static void BackendPrompt(RedirectAttributes ra,String content,int value){
        if(value!=0)
            ra.addFlashAttribute("msg",content+"成功!");
        else
            ra.addFlashAttribute("msg",content+"失败!");
    }
}
