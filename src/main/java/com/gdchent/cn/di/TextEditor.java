package com.gdchent.cn.di;

public class TextEditor {

    private SpellChecker spellChecker;
    public TextEditor(){
        System.out.println("TextEditor无参数构造器");
    }
    public TextEditor(SpellChecker spellChecker){
        System.out.println("TextEditor有参数构造器");
        this.spellChecker=spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }

}
