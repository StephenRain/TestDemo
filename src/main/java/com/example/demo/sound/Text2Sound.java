package com.example.demo.sound;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Text2Sound {


    public static void main(String[] args) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        Dispatch sapo = sap.getObject();
        try {
            // 音量 0-100  
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10  
            sap.setProperty("Rate", new Variant(2));
// 执行朗读  
            Dispatch.call(sapo, "Speak", new Variant("java,是世界上最好的语言！"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
    }

}
